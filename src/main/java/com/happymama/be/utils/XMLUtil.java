package com.happymama.be.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by yaoqiang on 2018/8/30.
 */
@Slf4j
public class XMLUtil {

    /**
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, String> doXMLParse(String strxml) throws JDOMException, IOException {
        if (StringUtils.isEmpty(strxml)) {
            return new HashMap<>();
        }
        //logger.info("strxml=" + strxml);
        Map<String, String> m = new HashMap<>();
        InputStream in = new ByteArrayInputStream(strxml.getBytes());
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            String k = e.getName();
            String v;
            List children = e.getChildren();
            if (children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = XMLUtil.getChildrenText(children);
            }
            m.put(k, v);
        }
        try {
            in.close();
        } catch (Exception e) {
            log.error("doXMLParse error", e);
        }
        return m;
    }

    /**
     * getChildrenText
     *
     * @param children
     * @return String
     */
    @SuppressWarnings("rawtypes")
    public static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if (!children.isEmpty()) {
            Iterator it = children.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if (!list.isEmpty()) {
                    sb.append(XMLUtil.getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }
        return sb.toString();
    }


    /**
     * 将map拼装成xml格式字符串
     *
     * @param map
     * @return
     */
    public static String convertMap2Xml(Map<String, String> map) {

        if (map == null || map.size() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        builder.append("<xml>");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (StringUtils.isNotBlank(entry.getValue())) {
                builder.append("<").append(entry.getKey()).append(">").append(entry.getValue())
                        .append("</").append(entry.getKey()).append(">");
            }
        }
        builder.append("</xml>");

        return builder.toString();
    }

}
