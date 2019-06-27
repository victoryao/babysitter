package com.happymama.be.controller;

import com.google.common.collect.Lists;
import com.happymama.be.cache.impl.SimpleRedisClientImpl;
import com.happymama.be.enums.ActivityParentEnum;
import com.happymama.be.enums.ActivityTypEnum;
import com.happymama.be.exception.AesException;
import com.happymama.be.model.*;
import com.happymama.be.pay.WXPayConfig;
import com.happymama.be.pay.WXPayUtil;
import com.happymama.be.service.*;
import com.happymama.be.utils.SHA1;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaoqiang on 2018/8/18.
 */
@Controller
public class ShopController {

    @Resource
    private ShopService shopService;
    @Resource
    private CustomerService customerService;
    @Resource
    private CouponService couponService;
    @Resource
    private SimpleRedisClientImpl simpleRedisClient;
    @Resource
    private WechatService wechatService;
    @Resource
    private UtilService utilService;
    @Resource
    private ActivityJoinService activityJoinService;

    private static final String OPENID_KEY = "openid_";


    @RequestMapping("/activity/list")
    public String getActivityList(
            @RequestParam(required = false, defaultValue = "0") int type,
            ModelMap modelMap) {
        List<ShopActivityDO> list = shopService.getActivityListByType(type);
        modelMap.addAttribute("activities", list);
        return "/activity/list";
    }

    @RequestMapping("/activity/join")
    public String activityJoin(
            @RequestParam(required = false, defaultValue = "0") String code,
            HttpServletRequest request,
            @RequestParam(required = false, defaultValue = "") String state,
            ModelMap modelMap) throws IOException, AesException {

        String ts = String.valueOf(System.currentTimeMillis() / 1000);
        String nonce = String.valueOf(System.currentTimeMillis());
        String url = request.getScheme() + "://newmami.cn" +
                "/app/activity/join.do?code=" + code + "&state=" + state;
        String jsApiTicket = wechatService.getJsapiTicket(wechatService.getAccessToken());
        String sign = SHA1.getSHA1("jsapi_ticket=" + jsApiTicket + "&noncestr=" + nonce + "&timestamp=" + ts + "&url=" + url);
        PayModel pay = PayModel.builder().appId(WXPayConfig.getAppID()).timeStamp(ts)
                .nonceStr(nonce).paySign(sign).build();
        modelMap.addAttribute("pay", pay);

        String redirectUrl = "/shop/activity/detail.do?id=" + state;
        int id = Integer.parseInt(state);
        ShopActivityDO shopActivityDO = shopService.getShopActivityById(id);
        if (shopActivityDO != null) {
            shopActivityDO.setDiscount(shopActivityDO.getDiscount() * 10);
            shopActivityDO.setRealPrice(shopActivityDO.getRealPrice());
            ShopDO shopDO = shopService.getShopById(shopActivityDO.getShopId());
            modelMap.addAttribute("shopDO", shopDO);
            modelMap.addAttribute("transferType", ActivityTypEnum.getTransferType(shopActivityDO.getType()));
            System.out.println("transferType =============" + ActivityTypEnum.getTransferType(shopActivityDO.getType()));
        }
        WeChatModel weChatModel = utilService.getOpenIdByCode(code, "snsapi_userinfo");
        String openId = weChatModel.getOpenId();
        modelMap.addAttribute("openId", openId);
        CustomerDO customerDO = customerService.getCustomerByOpenId(openId);

        if (customerDO == null) {
            modelMap.addAttribute("redirectUrl", redirectUrl);
            modelMap.addAttribute("weChatModel", weChatModel);
            return "/my/login";
        }

        customerService.updateCustomer(CustomerDO.builder().id(customerDO.getId()).img(weChatModel.getHeadImgUrl()).nickName(weChatModel.getNickName())
        .sex(weChatModel.getSex()).build());

        ActivityJoinDO activityJoinDO = ActivityJoinDO.builder().activityId(id).userId(customerDO.getId()).build();
        activityJoinService.addActivityJoin(activityJoinDO);
        modelMap.addAttribute("token", customerDO.getToken());
        modelMap.addAttribute("shopActivityDO", shopActivityDO);
        modelMap.addAttribute("phone", customerDO.getPhone());
        List<String> images = shopService.getActivityImgListByActivityId(id);
        modelMap.addAttribute("images", images);
        return "/shop/detail";
    }

    @RequestMapping("/shop/mobile/activity/list")
    public String getShopActivityByMobile(
            @RequestParam(required = false, defaultValue = "0") String mobile,
            ModelMap modelMap) {
        List<ShopOrderDO> list = shopService.getShopOrderListByMobile(mobile);
        CustomerDO customerDO = customerService.getCustomerByPhone(mobile);
        modelMap.addAttribute("shopOrderDOs", list);
        modelMap.addAttribute("customerDO", customerDO);
        return "/shop/activity_order_list";
    }

    @RequestMapping("/shop/to/exchange")
    public String shopExchange(
            @RequestParam(required = false, defaultValue = "0") int id,
            ModelMap modelMap) {
        CustomerDO customerDO = customerService.getCustomerById(id);
        modelMap.addAttribute("customerDO", customerDO);
        return "/shop/exchange";
    }


    @RequestMapping("shop/to/pay")
    public String toPay(
            @RequestParam(required = false, defaultValue = "0") String code,
            HttpServletRequest request,
            @RequestParam String state,
            @RequestParam(required = false, defaultValue = "") String redirectUrl,
            @RequestParam(required = false, defaultValue = "") String scope,
            ModelMap modelMap) throws Exception {

        WeChatModel weChatModel = utilService.getOpenIdByCode(code, scope);
        String openId = weChatModel.getOpenId();
        CustomerDO customerDO = customerService.getCustomerByOpenId(openId);
        modelMap.addAttribute("openId", openId);
        if (customerDO == null) {
            modelMap.addAttribute("redirectUrl", redirectUrl);
            return "/my/login";
        }

        ShopActivityDO shopActivityDO = shopService.getShopActivityById(Integer.parseInt(state));

        if (shopActivityDO != null) {
            int realPrice = shopActivityDO.getRealPrice();
            shopActivityDO.setRealPrice(shopActivityDO.getRealPrice());
            ShopDO shopDO = shopService.getShopById(shopActivityDO.getShopId());
            modelMap.addAttribute("shopDO", shopDO);

            modelMap.addAttribute("coupon", 0);

            List<CouponDO> couponDOS = couponService.getCouponByMobileActivityId(customerDO.getPhone(), shopActivityDO.getId());
            if (CollectionUtils.isNotEmpty(couponDOS)) {
                realPrice = shopActivityDO.getRealPrice() - couponDOS.get(0).getPrice();
                modelMap.addAttribute("coupon", couponDOS.get(0).getPrice());

            }

            modelMap.addAttribute("realPrice", realPrice);
            modelMap.addAttribute("price", shopActivityDO.getRealPrice());
        }


        modelMap.addAttribute("shopActivityDO", shopActivityDO);

        modelMap.addAttribute("phone", customerDO.getPhone());
        return "/shop/toPay";
    }

    @RequestMapping("/shop/activity/detail")
    public String getShopActivityDetail(HttpServletRequest request,
                                        @RequestParam(required = false, defaultValue = "15") int id,
                                        @RequestParam(required = false, defaultValue = "") String from,
                                        ModelMap modelMap) throws Exception {

        String ts = String.valueOf(System.currentTimeMillis() / 1000);
        String nonce = String.valueOf(System.currentTimeMillis());

        String jsApiTicket = wechatService.getJsapiTicket(wechatService.getAccessToken());

        String url = request.getScheme() + "://newmami.cn" +
                "/app/shop/activity/detail.do?id=" + id;
        if (StringUtils.isNotBlank(from)) {
            url += "&from=" + from;
        }

        String sign = SHA1.getSHA1("jsapi_ticket=" + jsApiTicket + "&noncestr=" + nonce + "&timestamp=" + ts + "&url=" + url);

        PayModel pay = PayModel.builder().appId(WXPayConfig.getAppID()).timeStamp(ts)
                .nonceStr(nonce).paySign(sign).build();

        modelMap.addAttribute("pay", pay);

        ShopActivityDO shopActivityDO = shopService.getShopActivityById(id);
        List<ShopActivityDO> shopActivityDOS = Lists.newArrayList();
        if (shopActivityDO != null) {
            shopActivityDO.setDiscount(shopActivityDO.getDiscount() * 10);
            shopActivityDO.setRealPrice(shopActivityDO.getRealPrice());
            ShopDO shopDO = shopService.getShopById(shopActivityDO.getShopId());
            modelMap.addAttribute("shopDO", shopDO);
            modelMap.addAttribute("transferType", ActivityTypEnum.getTransferType(shopActivityDO.getType()));
            int index = 0;
            if (shopActivityDO.getIsParent() == ActivityParentEnum.PARENT.getType()) {
                shopActivityDOS = shopService.getShopActivityByParentId(shopActivityDO.getId());
                if (CollectionUtils.isNotEmpty(shopActivityDOS)) {
                    for (ShopActivityDO s : shopActivityDOS) {
                        s.setImages(shopService.getActivityImgListByActivityId(s.getId()));
                        s.setTab("tabs-" + (++index));
                    }
                }

            }
        }
        modelMap.addAttribute("children", shopActivityDOS);
        List<String> images = shopService.getActivityImgListByActivityId(id);
        modelMap.addAttribute("shopActivityDO", shopActivityDO);
        modelMap.addAttribute("images", images);
        return "/shop/detail";
    }

    @RequestMapping("/shop/order/list")
    public String getShopOrderList(
            @RequestParam(required = false, defaultValue = "") String accessToken,
            @RequestParam(required = false, defaultValue = "") String openId,
            ModelMap modelMap) {
        if (StringUtils.isBlank(accessToken) && StringUtils.isBlank(openId)) {
            return "/my/login";
        }

        CustomerDO customerDO = null;
        if (StringUtils.isNotBlank(accessToken)) {
            customerDO = customerService.getCustomerByToken(accessToken);
        }

        if (StringUtils.isNotBlank(openId)) {
            customerDO = customerService.getCustomerByOpenId(openId);
        }

        if (customerDO == null) {
            return "/my/login";
        }

        List<ShopOrderDO> list = shopService.getShopOrderListByCustomerId(customerDO.getId());
        if (CollectionUtils.isNotEmpty(list)) {
            for (ShopOrderDO shopOrderDO : list) {
                ShopActivityDO shopActivityDO = shopService.getShopActivityById(shopOrderDO.getActivityId());
                ShopDO shopDO = shopService.getShopById(shopActivityDO.getShopId());
                shopActivityDO.setShopDO(shopDO);
                shopOrderDO.setShopActivityDO(shopActivityDO);
            }
        }

        modelMap.addAttribute("shopOrderDOs", list);
        return "/order/list";
    }


}
