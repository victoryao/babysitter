package com.happymama.be.controller;

import com.happymama.be.exception.AesException;
import com.happymama.be.model.KnowledgeDO;
import com.happymama.be.service.KnowledgeService;
import com.happymama.be.service.WechatService;
import com.happymama.be.utils.QueryResult;
import org.apache.commons.collections.CollectionUtils;
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
import java.util.List;

/**
 * Created by yaoqiang on 2018/9/14.
 */
@org.springframework.web.bind.annotation.RestController
public class WechatController {

    @Resource
    private WechatService wechatService;
    @Resource
    private KnowledgeService knowledgeService;

    String knowledgeUrl = "http://www.newmami.cn/app/app/%s/knowledge/view.do";

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
        body = new String(body.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("body:" + body);
        System.out.println("echostr:" + echostr);
        if (StringUtils.isNotBlank(body)) {
            document = saxReader.read(new ByteArrayInputStream(body.getBytes("UTF-8")));
            Element rootElt = document.getRootElement();
            String openId = rootElt.elementText("FromUserName");
            String eventKey = rootElt.elementText("EventKey");
            String content = rootElt.elementText("Content");
            System.out.println("FromUserName===" + openId);
            System.out.println("eventKey===" + eventKey);
            System.out.println("content===" + content);
            if ("123".equals(eventKey) || ("qrscene_123".equals(eventKey))) {
                wechatService.sendMessage(openId, "123");
            }
            if ("124".equals(eventKey) || ("qrscene_124".equals(eventKey))) {
                wechatService.sendMessage(openId, "124");
            }
            if ("125".equals(eventKey) || ("qrscene_125".equals(eventKey))) {
                wechatService.sendMessage(openId, "125");
            }
            if (StringUtils.isNotBlank(content)) {
                QueryResult<KnowledgeDO> qr = knowledgeService.queryKnowledge(content);
                List<KnowledgeDO> list = qr.getResultlist();
                if (CollectionUtils.isNotEmpty(list)) {
                    StringBuilder sb = new StringBuilder("新新妈咪为您推荐：\n");
                    for (KnowledgeDO knowledgeDO : list) {
                        sb.append(knowledgeDO.getTitle()).append(":").append(String.format(knowledgeUrl, knowledgeDO.getId())).append("\n");
                    }
                    wechatService.sendMessage(openId, sb.toString());
                } else {
                    wechatService.sendMessage(openId, "欢迎来到新新妈咪百科");
                }
            }
        }

        wechatService.menuCreate();

//        if (WXPublicUtils.verifyUrl(msgSignature, msgTimestamp, msgNonce)) {
        return echostr;
//        }


    }

    @RequestMapping("/user/qrcode")
    public String sendQRCode(
            @RequestParam(required = false, defaultValue = "") String sceneId,
            ModelMap modelMap) {
        return wechatService.getQRCode(sceneId);
    }

}
