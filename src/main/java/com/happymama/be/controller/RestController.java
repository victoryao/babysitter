package com.happymama.be.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.happymama.be.cache.impl.SimpleRedisClientImpl;
import com.happymama.be.model.PayModel;
import com.happymama.be.pay.WXPay;
import com.happymama.be.pay.WXPayConfig;
import com.happymama.be.service.SmsService;
import com.happymama.be.sms.TencentSmsChannel;
import com.happymama.be.utils.MD5Utils;
import com.happymama.be.utils.Utils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by yaoqiang on 2018/7/15.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Resource
    private SimpleRedisClientImpl simpleRedisClient;
    @Resource
    private TencentSmsChannel tencentSmsChannel;
    @Resource
    private SmsService smsService;



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



}
