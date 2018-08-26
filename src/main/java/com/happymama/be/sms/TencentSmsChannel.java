package com.happymama.be.sms;

import com.github.qcloudsms.httpclient.HTTPException;
import com.google.common.collect.Lists;
import com.happymama.be.enums.OperatorEnum;
import com.happymama.be.model.TencentRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.springframework.stereotype.Service;


/**
 * Created by yaoqiang on 2018/6/30.
 */
@Service
@Slf4j
public class TencentSmsChannel implements ISmsChannel {

    private int appId = 1400105911;

    private String appKey = "a07263a2ba31a93bc139669fc1de249e";

    private String smsTemplate = "您的验证码是%s。30分钟内有效，请在页面中提交验证码完成验证。";
    /**
     * 普通短信
     */
    private static final int SMS_TYPE_NORMAL = 0;

    @Resource
    private CloseableHttpClient httpClient;

    @Override
    public OperatorEnum type() {
        return OperatorEnum.TENCENT;
    }

    @Override
    public boolean send(String mobile, String code) {

        SmsSingleSenderResult result = null;
        SmsSingleSender sender = new SmsSingleSender(appId, appKey);
        try {
            result = sender.send(SMS_TYPE_NORMAL, "86", mobile,
                    String.format(smsTemplate, code), "", "");
        } catch (Exception e) {
            log.error("tencent send message error:{}", e);
        }

        if (result != null) {
            log.info("mobile:" + mobile + ", content: " + code + ", result: " + result);
        }
        return true;
    }
}
