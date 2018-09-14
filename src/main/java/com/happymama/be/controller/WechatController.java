package com.happymama.be.controller;

import com.happymama.be.exception.AesException;
import com.happymama.be.service.WechatService;
import com.happymama.be.utils.WXPublicUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yaoqiang on 2018/9/14.
 */
@org.springframework.web.bind.annotation.RestController
public class WechatController {

    @Resource
    private WechatService wechatService;

    @RequestMapping("/user/send/message")
    public String sendMessage(
            HttpServletRequest request,
            @RequestParam(required = false, defaultValue = "") String openId,
            @RequestParam(required = false, defaultValue = "") String scene_id,
            ModelMap modelMap) throws AesException {
        String msgSignature = request.getParameter("signature");
        String msgTimestamp = request.getParameter("timestamp");
        String msgNonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if (WXPublicUtils.verifyUrl(msgSignature, msgTimestamp, msgNonce)) {
            return echostr;
        }
        wechatService.sendMessage(openId);
        return scene_id;
    }

    @RequestMapping("/user/qrcode")
    public String sendQRCode(
            @RequestParam(required = false, defaultValue = "") String openId,
            ModelMap modelMap) {
        return wechatService.getQRCode();
    }

}
