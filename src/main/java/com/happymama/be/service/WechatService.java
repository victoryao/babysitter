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
            return httpGet(get, "access_token");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    public String getJsapiTicket(String accessToken) {
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi";
        HttpGet get = new HttpGet(url);
        try {
            return httpGet(get, "ticket");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private String httpGet(HttpGet get, String access_token) throws IOException {
        CloseableHttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity, Charset.forName("UTF-8"));
        JSONObject jsonObject = JSON.parseObject(res);
        return jsonObject.getString(access_token);
    }

    public void menuCreate() {
        String accessToken = getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken;
        HttpPost httpPost = new HttpPost(url);

        String data = "{" +
                "\"button\": [{" +
                "\"type\": \"view\"," +
                "\"name\": \"预约服务\"," +
                "\"url\": \"http://newmami.cn/app\"" +
                "}," +
                "{" +
                "\"name\": \"月嫂服务\"," +
                "\"sub_button\": [{" +
                "\"type\": \"view\"," +
                "\"name\": \"月嫂推荐\"," +
                "\"url\": \"http://newmami.cn/app/employee/list.do\"" +
                "}," +
                "{" +
                "\"type\": \"view\"," +
                "\"name\": \"母婴百科\"," +
                "\"url\": \"http://www.newmami.cn/app/app/topic/list.do?loc=knowledge\"" +
                "}," +
                "{" +
                "\"type\": \"view\"," +
                "\"name\": \"新新社区\"," +
                "\"url\": \"http://newmami.cn/app/forum/0/list.do?loc=forum\"" +
                "}" +
                "]" +
                "}," +
                "{" +
                "\"name\": \"了解更多\"," +
                "\"sub_button\": [" +
                "{" +
                "\"type\": \"view\"," +
                "\"name\": \"我要加群\"," +
                "\"url\": \"http://newmami.cn/app/to/join.do\"" +
                "}," +
                "{" +
                "\"type\": \"view\"," +
                "\"name\": \"课程培训\"," +
                "\"url\": \"http://www.newmami.cn/course.do\"" +
                "}," +
                "{" +
                "\"type\": \"view\"," +
                "\"name\": \"关于我们\"," +
                "\"url\": \"http://newmami.cn/about-us.do\"" +
                "}," +
                "{" +
                "\"type\": \"view\"," +
                "\"name\": \"联系我们\"," +
                "\"url\": \"http://www.newmami.cn/contact-us.do\"" +
                "} " +
                "]" +
                "}" +
                "]" +
                "}";

        /*String data = "{" +
                "\"button\": [{" +
                "\"type\": \"view\"," +
                "\"name\": \"母婴百科\"," +
                "\"url\": \"http://www.newmami.cn/app/app/topic/list.do?loc=knowledge\"" +
                "}," +
                "{" +
                "\"name\": \"孕产服务\"," +
                "\"sub_button\": [" +
                "{" +
                "\"type\": \"view\"," +
                "\"name\": \"活动\"," +
                "\"url\": \"http://www.newmami.cn/app//activity/list.do?type=9\"" +
                "}" +
                "]" +
                "}," +
                "{" +
                "\"name\": \"我的社群\"," +
                "\"sub_button\": [{" +
                "\"type\": \"view\"," +
                "\"name\": \"我要加群\"," +
                "\"url\": \"http://newmami.cn/app/to/join.do\"" +
                "}" +
                "]" +
                "}" +
                "]" +
                "}";*/
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

    public void sendMessage(String openId, String key) {
        String accessToken = getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;
        HttpPost httpPost = new HttpPost(url);
        String data = getMiniWeiYangClass(openId, key);
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

    private String getMiniWeiYangClass(String openId, String key) {

        switch (key) {
            case "123":
                return "{\"touser\":\"" + openId + "\",\"msgtype\":\"news\",\"news\":{\"articles\":[" +
                        "{" +
                        "\"title\":\"【点击直接听课】新生儿喂养,听我来支招\"," +
                        "\"url\":\"https://mp.weixin.qq.com/s/mUIy4jF6O2DjwoxKeXDPqw\"," +
                        "\"picurl\":\"http://www.newmami.cn/app/images/miniclass.jpeg\"" +
                        "}" +
                        "]}}";
            case "124":
                return "{\"touser\":\"" + openId + "\",\"msgtype\":\"news\",\"news\":{\"articles\":[" +
                        "{" +
                        "\"title\":\"【点击进入交流群】新新妈咪孕期交流群\"," +
                        "\"url\":\"http://newmami.cn/app/to/join.do\"," +
                        "\"picurl\":\"https://happymama.oss-cn-beijing.aliyuncs.com/1545316897750.jpg\"" +
                        "}" +
                        "]}}";
            case "125":
                return "{\"touser\":\"" + openId + "\",\"msgtype\":\"news\",\"news\":{\"articles\":[" +
                        "{" +
                        "\"title\":\"【点击进入培训群】月嫂面试技巧培训群\"," +
                        "\"url\":\"http://newmami.cn/app/to/join.do\"," +
                        "\"picurl\":\"https://happymama.oss-cn-beijing.aliyuncs.com/1545316897750.jpg\"" +
                        "}" +
                        "]}}";
        }

        return "{\"touser\":\"" + openId + "\",\"msgtype\":\"text\",\"text\":{\"content\": \"" + key + "\"}}";
    }

    public String getQRCode(String sceneId) {
        String accessToken = getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + accessToken;
        System.out.println("url:" + url);
        String data = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": " + sceneId + "}}}";
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
