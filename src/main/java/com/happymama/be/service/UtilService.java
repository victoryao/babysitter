package com.happymama.be.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.happymama.be.model.WeChatModel;
import com.happymama.be.pay.WXPayConfig;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by yaoqiang on 2018/11/1.
 */
@Service
@Slf4j
public class UtilService {

    @Resource
    private CloseableHttpClient httpClient;

    public WeChatModel getOpenIdByCode(String code, String scope) throws IOException {
        HttpGet get = new HttpGet("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WXPayConfig.getAppID() + "&secret=" +
                WXPayConfig.getAPPKey() + "&code=" + code + "&grant_type=authorization_code");
        CloseableHttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity, Charset.forName("UTF-8"));
        JSONObject jsonObject = JSON.parseObject(res);
        String openId = jsonObject.getString("openid");
        String accessToken = jsonObject.getString("access_token");
        WeChatModel.WeChatModelBuilder builder = WeChatModel.builder().openId(openId).accessToken(accessToken);

        if ("snsapi_userinfo".equals(scope)) {
            get = new HttpGet("https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId + "&lang=zh_CN");
            response = httpClient.execute(get);
            entity = response.getEntity();
            res = EntityUtils.toString(entity, Charset.forName("UTF-8"));
            jsonObject = JSON.parseObject(res);
            builder.sex(jsonObject.getInteger("sex"));
            builder.nickName(jsonObject.getString("nickname"));
            builder.headImgUrl(jsonObject.getString("headimgurl"));
        }

        return builder.build();
    }

}
