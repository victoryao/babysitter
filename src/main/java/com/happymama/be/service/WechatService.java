package com.happymama.be.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.happymama.be.pay.WXPayConfig;
import com.happymama.be.pay.WXPayConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by yaoqiang on 2018/9/14.
 */
@Service
@Slf4j
public class WechatService {

    @Resource
    private CloseableHttpClient httpClient;


    public String getAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + WXPayConfig.getAppID() + "&secret=" + WXPayConfig.getAPPKey();
        HttpGet get = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            String res = EntityUtils.toString(entity, Charset.forName("UTF-8"));
            JSONObject jsonObject = JSON.parseObject(res);
            return jsonObject.getString("access_token");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void menuCreate() {
        String accessToken = getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken;
        HttpPost httpPost = new HttpPost(url);

        String data = "{" +
                "\"button\": [{" +
                "\"type\": \"view\"," +
                "\"name\": \"预约服务\"," +
                "\"url\": \"http://klmami.cn/app\"" +
                "}," +
                "{" +
                "\"name\": \"月嫂服务\"," +
                "\"sub_button\": [{" +
                "\"type\": \"view\"," +
                "\"name\": \"月嫂推荐\"," +
                "\"url\": \"http://klmami.cn/app/employee/list.do\"" +
                "}," +
                "{" +
                "\"type\": \"view\"," +
                "\"name\": \"月嫂课堂\"," +
                "\"url\": \"http://www.klmami.cn/app/app/topic/list.do?loc=knowledge\"" +
                "}," +
                "{" +
                "\"type\": \"view\"," +
                "\"name\": \"快乐社区\"," +
                "\"url\": \"http://klmami.cn/app/forum/0/list.do?loc=forum\"" +
                "}" +
                "]" +
                "}," +
                "{" +
                "\"name\": \"了解更多\"," +
                "\"sub_button\": [{" +
                "\"type\": \"view\"," +
                "\"name\": \"课程培训\"," +
                "\"url\": \"http://klmami.cn/app/app/to/course.do\"" +
                "}," +
                "{" +
                "\"type\": \"view\"," +
                "\"name\": \"关于我们\"," +
                "\"url\": \"http://klmami.cn/app/app/to/about-us.do\"" +
                "}," +
                "{" +
                "\"type\": \"view\"," +
                "\"name\": \"联系我们\"," +
                "\"url\": \"http://klmami.cn/app/app/to/contact-us.do\"" +
                "}" +
                "]" +
                "}" +
                "]" +
                "}";
        System.out.println(data);
        StringEntity postEntity = new StringEntity(data, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.addHeader("User-Agent", WXPayConstants.USER_AGENT);
        httpPost.setEntity(postEntity);

        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            String res = EntityUtils.toString(entity, Charset.forName("UTF-8"));
            System.out.println("res:" + res);
        } catch (IOException e) {
            log.error("menuCreate", e);
        }

    }

    public void sendMessage(String openId) {
        String accessToken = getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;
        HttpPost httpPost = new HttpPost(url);
        String data = "{\"touser\":\"" + openId + "\",\"msgtype\":\"news\",\"news\":{\"articles\":[" +
                "{" +
                "\"title\":\"Happy Day\"," +
                "\"description\":\"Is Really A Happy Day\"," +
                "\"url\":\"http://www.klmami.cn/about-us.do\"," +
                "\"picurl\":\"http://www.klmami.cn/extra-images/brander.jpeg\"" +
                "}," +
                "{" +
                "\"title\":\"Happy Day\"," +
                "\"description\":\"Is Really A Happy Day\"," +
                "\"url\":\"http://www.klmami.cn/employee.do\"," +
                "\"picurl\":\"http://www.klmami.cn/extra-images/e3.jpeg\"" +
                "}" +
                "]}}";
        System.out.println(data);
        StringEntity postEntity = new StringEntity(data, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.addHeader("User-Agent", WXPayConstants.USER_AGENT);
        httpPost.setEntity(postEntity);

        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            String res = EntityUtils.toString(entity, Charset.forName("UTF-8"));
            System.out.println("res:" + res);
        } catch (IOException e) {
            log.error("sendMessage", e);
        }
    }

    public String getQRCode() {
        String accessToken = getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + accessToken;
        System.out.println("url:" + url);
        String data = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 123}}}";
        StringEntity postEntity = new StringEntity(data, "UTF-8");
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.addHeader("User-Agent", WXPayConstants.USER_AGENT);
        httpPost.setEntity(postEntity);
        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            return EntityUtils.toString(entity, Charset.forName("UTF-8"));
        } catch (IOException e) {
            log.error("getQRCode", e);
        }
        return null;
    }


}
