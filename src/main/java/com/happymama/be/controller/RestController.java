package com.happymama.be.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.happymama.be.cache.impl.SimpleRedisClientImpl;
import com.happymama.be.enums.PayStatusEnum;
import com.happymama.be.model.CouponDO;
import com.happymama.be.model.PayModel;
import com.happymama.be.model.ShopOrderDO;
import com.happymama.be.pay.WXPay;
import com.happymama.be.pay.WXPayConfig;
import com.happymama.be.service.CouponService;
import com.happymama.be.service.PayService;
import com.happymama.be.service.ShopService;
import com.happymama.be.service.SmsService;
import com.happymama.be.sms.TencentSmsChannel;
import com.happymama.be.utils.MD5Utils;
import com.happymama.be.utils.Utils;
import com.happymama.be.utils.XMLUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * Created by yaoqiang on 2018/7/15.
 */
@org.springframework.web.bind.annotation.RestController
@Slf4j
public class RestController {

    @Resource
    private SimpleRedisClientImpl simpleRedisClient;
    @Resource
    private TencentSmsChannel tencentSmsChannel;
    @Resource
    private SmsService smsService;
    @Resource
    private ShopService shopService;
    @Resource
    private PayService payService;
    @Resource
    private CouponService couponService;

    @RequestMapping(value = "shop/order/verify", method = RequestMethod.POST, produces = "text/html;charset=UTF-8;")
    public String orderVerify(@RequestParam String mobile, @RequestParam String code) {
        ShopOrderDO shopOrderDO = shopService.verifyShopOrder(mobile, code);

        if (shopOrderDO == null)
            return "手机号或验证码输入有误，请检查！";

        if (shopOrderDO.getStatus() == PayStatusEnum.NOTPAY.getValue()) {
            return "此订单未支付，请先支付！";
        }

        if (shopOrderDO.getStatus() == PayStatusEnum.CONSUMED.getValue()) {
            return "此订单已验证，请勿重复验证！";
        }

        if (shopService.updateShopOrderStatusByOrderId(shopOrderDO.getOrderId(), PayStatusEnum.CONSUMED.getValue())) {
            return "验证成功！";
        }
        return "验证失败或已验证！";
    }

    @RequestMapping("/user/verifyCode")
    public String getVerifyCode(@RequestParam String mobile) {
        if (!Utils.isNumberValidate(mobile)) {
            return "illegal number";
        }

        String code = smsService.getVerifyCode(mobile);
        if (code != null) {
            return "ok";
        }

        code = Utils.generateCode(4);
        tencentSmsChannel.send(mobile, code);
        smsService.setVerifyCode(mobile, code);
        return "ok";
    }

    @RequestMapping("/get/id")
    public String getId() {
        return Utils.getId();
    }

    @RequestMapping("/get/pay/config")
    public String getPayConfig() {
        String ts = String.valueOf(System.currentTimeMillis());
        String ns = Utils.generateCode(32);
        String orderId = Utils.getId();
        String sign = MD5Utils.getMD5("appId=" + WXPayConfig.getAppID() + "&nonceStr=" + ns + "&package=prepay_id="
                + orderId + "&signType=MD5" + "&timeStamp=" + ts + "&key=" + WXPayConfig.getKey());
        PayModel pay = PayModel.builder().appId(WXPayConfig.getAppID()).timeStamp(ts).packages("prepay_id=" + orderId)
                .nonceStr(ns).signType("MD5").paySign(sign).build();
        return JSON.toJSONString(pay);
    }


    @RequestMapping(value = "/pay/wx/callback.do", produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> callBackWx(@RequestBody String eventStr) throws Exception {
        System.out.println("pay wechat callback begin,callBackWx respCharge {}" + eventStr);
        log.info("pay wechat callback begin,callBackWx respCharge {}", eventStr);

        if (StringUtils.isEmpty(eventStr)) {
            log.info("pay wechat callback end,callBackWx event is null");
            return WXResponse.wxPayFail();
        }
        try {

            Map<String, String> map = XMLUtil.doXMLParse(eventStr);
            String outTradeNo = map.get("out_trade_no");
            System.out.println("outTradeNo " + outTradeNo);
            String return_code = map.get("return_code");
            System.out.println("return_code " + return_code);

            if (payService.process(map)) {
                shopService.updateShopOrderStatusByOrderId(outTradeNo, PayStatusEnum.PAIED.getValue());
                ShopOrderDO shopOrderDO = shopService.getShopOrderByOrderId(outTradeNo);
                List<CouponDO> couponDOS = couponService.getCouponByMobileActivityId(shopOrderDO.getMobile(), shopOrderDO.getActivityId());
                if (CollectionUtils.isNotEmpty(couponDOS)) {
                    couponService.useCoupon(couponDOS.get(0).getId());
                }
                return WXResponse.wxPaySuccess();
            }

        } catch (Exception e) {
            log.error("api wechat pay callBackWx end ", e);
        }
        return WXResponse.wxPayFail();
    }

    interface WXResponse {

        static ResponseEntity<String> wxPayFail() {
            return ResponseEntity.ok().body("<xml>" +
                    "<return_code><![CDATA[FAIL]]></return_code>" +
                    "<return_msg><![CDATA[NO]]></return_msg>" + "</xml>"
            );
        }

        static ResponseEntity<String> wxPaySuccess() {
            return ResponseEntity.ok().body("<xml>" +
                    "<return_code><![CDATA[SUCCESS]]></return_code>" +
                    "<return_msg><![CDATA[OK]]></return_msg>" + "</xml>");
        }

    }
}
