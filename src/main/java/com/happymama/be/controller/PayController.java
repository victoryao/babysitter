package com.happymama.be.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.happymama.be.model.PayModel;
import com.happymama.be.pay.WXPay;
import com.happymama.be.pay.WXPayConfig;
import com.happymama.be.utils.MD5Utils;
import com.happymama.be.utils.Utils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by yaoqiang on 2018/8/18.
 */
@Controller
public class PayController {

    @Resource
    private CloseableHttpClient httpClient;

    @RequestMapping("/pay/confirm")
    public String getTopicListByParentId(
            ModelMap modelMap) {
        return "/pay/pay_confirm";
    }


    @RequestMapping("/shop/pay")
    public String shopPay(
            @RequestParam(required = false, defaultValue = "0") String code,
            HttpServletRequest request,
            ModelMap modelMap) throws IOException {

        WXPayConfig wxPayConfig = new WXPayConfig();


        String openId = getOpenIdByCode(code);

        String ip = Utils.getIpAddr(request);

        WXPay wxPay = null;
        try {
            wxPay = new WXPay(wxPayConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String nonce = String.valueOf(System.currentTimeMillis());
        String orderId = "123";
        Map<String, String> reqData = Maps.newHashMap();
        reqData.put("appid", WXPayConfig.getAppID());
        reqData.put("mch_id", WXPayConfig.getMchID());
        reqData.put("device_info", "WEB");
        reqData.put("nonce_str", nonce);
        reqData.put("sign_type", "MD5");
        reqData.put("body", "test");
        reqData.put("out_trade_no", orderId);
        reqData.put("total_fee", "1");
        reqData.put("spbill_create_ip", ip);
        reqData.put("trade_type", "JSAPI");
        reqData.put("notify_url", "notify_url");
        reqData.put("openid", openId);
        Map map = Maps.newHashMap();
        try {
            map = wxPay.unifiedOrder(reqData);
            System.out.println(map);
            modelMap.addAttribute("maps", JSON.toJSON(map));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String ts = String.valueOf(System.currentTimeMillis());
        String prepayId = map.get("prepay_id").toString();
        String sign = MD5Utils.getMD5("appId=" + WXPayConfig.getAppID() + "&nonceStr=" + nonce + "&package=prepay_id="
                + prepayId + "&signType=MD5" + "&timeStamp=" + ts + "&key=" + WXPayConfig.getKey());

        PayModel pay = PayModel.builder().appId(WXPayConfig.getAppID()).timeStamp(ts).packages("prepay_id=" + prepayId)
                .nonceStr(nonce).signType("MD5").paySign(sign).build();

        modelMap.addAttribute("pay", pay);
        return "/shop/result";
    }


    private String getOpenIdByCode(String code) throws IOException {
        HttpGet get = new HttpGet("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WXPayConfig.getAppID() + "&secret=" +
                WXPayConfig.getAPPKey() + "&code=" + code + "&grant_type=authorization_code");
        System.out.println("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WXPayConfig.getAppID() + "&secret=" +
                WXPayConfig.getAPPKey() + "&code=" + code + "&grant_type=authorization_code");
        CloseableHttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity, Charset.forName("UTF-8"));
        System.out.println(res);
        JSONObject jsonObject = JSON.parseObject(res);
        return jsonObject.getString("openid");
    }

}
