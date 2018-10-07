package com.happymama.be.controller;

import com.happymama.be.exception.AesException;
import com.happymama.be.service.WechatService;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by yaoqiang on 2018/9/14.
 */
@org.springframework.web.bind.annotation.RestController
public class WechatController {

    @Resource
    private WechatService wechatService;

    @RequestMapping("/user/send/message")
    public String sendMessage(
            @RequestBody(required = false) String body,
            HttpServletRequest request,
            ModelMap modelMap) throws AesException, UnsupportedEncodingException, DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document;
        String msgSignature = request.getParameter("signature");
        String msgTimestamp = request.getParameter("timestamp");
        String msgNonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println("body:" + body);
        System.out.println("echostr:" + echostr);
        if (StringUtils.isNotBlank(body)) {
            document = saxReader.read(new ByteArrayInputStream(body.getBytes("UTF-8")));
            Element rootElt = document.getRootElement();
            String openId = rootElt.elementText("FromUserName");
            String eventKey = rootElt.elementText("EventKey");
            System.out.println("FromUserName===" + openId);
            System.out.println("eventKey===" + eventKey);
            if ("123".equals(eventKey) || ("qrscene_123".equals(eventKey))) {
                wechatService.sendMessage(openId);
            }
        }

        wechatService.menuCreate();

//        if (WXPublicUtils.verifyUrl(msgSignature, msgTimestamp, msgNonce)) {
        return echostr;
//        }


    }

    @RequestMapping("/user/qrcode")
    public String sendQRCode(
            @RequestParam(required = false, defaultValue = "") String openId,
            ModelMap modelMap) {
        return wechatService.getQRCode();
    }

}
