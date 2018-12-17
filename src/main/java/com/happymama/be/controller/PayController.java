package com.happymama.be.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.happymama.be.cache.impl.SimpleRedisClientImpl;
import com.happymama.be.model.*;
import com.happymama.be.pay.WXPay;
import com.happymama.be.pay.WXPayConfig;
import com.happymama.be.pay.WXPayUtil;
import com.happymama.be.service.CouponService;
import com.happymama.be.service.CustomerService;
import com.happymama.be.service.ShopService;
import com.happymama.be.service.UtilService;
import com.happymama.be.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by yaoqiang on 2018/8/18.
 */
@Controller
@Slf4j
public class PayController {


    @Resource
    private CustomerService customerService;
    @Resource
    private SimpleRedisClientImpl simpleRedisClient;
    @Resource
    private ShopService shopService;
    @Resource
    private CouponService couponService;
    @Resource
    private UtilService utilService;

    private static final String OPENID_KEY = "openid_";

    @RequestMapping("/pay/confirm")
    public String getTopicListByParentId(
            ModelMap modelMap) {
        return "/pay/pay_confirm";
    }


    @RequestMapping("/shop/pay")
    public String shopPay(
            @RequestParam(required = false, defaultValue = "0") String code,
            HttpServletRequest request,
            @RequestParam String state,
            @RequestParam(required = false, defaultValue = "") String redirectUrl,
            @RequestParam(required = false, defaultValue = "") String scope,
            @RequestParam(required = false, defaultValue = "") String phone,
            @RequestParam(required = false, defaultValue = "") String address,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String idcard,
            ModelMap modelMap) throws Exception {

        System.out.println("redirectUrl=" + redirectUrl);
        WeChatModel weChatModel = utilService.getOpenIdByCode(code, scope);

        String openId = weChatModel.getOpenId();
        modelMap.addAttribute("openId", openId);
        CustomerDO customerDO = customerService.getCustomerByOpenId(openId);

        if (customerDO == null) {
//            simpleRedisClient.set(OPENID_KEY + openId, "/shop/activity/detail.do?id=" + state, 1800, TimeUnit.SECONDS);
            modelMap.addAttribute("redirectUrl", redirectUrl);
            modelMap.addAttribute("weChatModel", weChatModel);
            return "/my/login";
        }

        ShopActivityDO shopActivityDO = shopService.getShopActivityById(Integer.parseInt(state));
        if (shopActivityDO == null) {
            return "home";
        }

        WXPayConfig wxPayConfig = new WXPayConfig();

        String ip = Utils.getIpAddr(request);

        WXPay wxPay = null;
        try {
            wxPay = new WXPay(wxPayConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String orderId = Utils.getId();

        String nonce = String.valueOf(System.currentTimeMillis());
        int totalFee = shopActivityDO.getRealPrice();
        List<CouponDO> couponDOS = couponService.getCouponByMobileActivityId(customerDO.getPhone(), shopActivityDO.getId());
        if (CollectionUtils.isNotEmpty(couponDOS)) {
            totalFee = shopActivityDO.getRealPrice() - couponDOS.get(0).getPrice();
        }

        Map<String, String> reqData = Maps.newHashMap();
        reqData.put("appid", WXPayConfig.getAppID());
        reqData.put("mch_id", WXPayConfig.getMchID());
        reqData.put("device_info", "WEB");
        reqData.put("nonce_str", nonce);
        reqData.put("sign_type", "MD5");
        reqData.put("body", shopActivityDO.getName());
        reqData.put("out_trade_no", orderId);
        reqData.put("total_fee", String.valueOf(totalFee));
        reqData.put("spbill_create_ip", ip);
        reqData.put("trade_type", "JSAPI");
        reqData.put("notify_url", "http://www.newmami.cn/app/pay/wx/callback.do");
        reqData.put("openid", openId);
        Map map = Maps.newHashMap();

        try {
            System.out.println("req: {}" + reqData);
            map = wxPay.unifiedOrder(reqData);
            System.out.println("res: {}" + reqData);
            modelMap.addAttribute("maps", JSON.toJSON(map));
        } catch (Exception e) {
            log.error("shopPay", e);
        }

        String ts = String.valueOf(System.currentTimeMillis());
        String prepayId = map.get("prepay_id").toString();

        shopService.addShopOrder(ShopOrderDO.builder().activityId(shopActivityDO.getId()).customerId(customerDO.getId())
                .mobile(StringUtils.isBlank(phone) ? customerDO.getPhone() : phone).address(address).price(totalFee).orderId(orderId).realPrice(totalFee)
                .code(shopActivityDO.getId() + "-" + Utils.generateCode(6)).prepayId(prepayId)
                .name(name).idcard(idcard).build());

        String sign = WXPayUtil.MD5("appId=" + WXPayConfig.getAppID() + "&nonceStr=" + nonce + "&package=prepay_id="
                + prepayId + "&signType=MD5" + "&timeStamp=" + ts + "&key=" + WXPayConfig.getKey()).toUpperCase();

        PayModel pay = PayModel.builder().appId(WXPayConfig.getAppID()).timeStamp(ts).packages("prepay_id=" + prepayId)
                .nonceStr(nonce).signType("MD5").paySign(sign).openId(openId).build();

        modelMap.addAttribute("pay", pay);
        modelMap.addAttribute("redirectUrl", redirectUrl);
        return "/shop/result";
    }


}
