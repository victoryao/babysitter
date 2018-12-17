package com.happymama.be.controller;

import com.happymama.be.dao.KnowledgeDao;
import com.happymama.be.dao.TopicDao;
import com.happymama.be.model.KnowledgeDO;
import com.happymama.be.model.TopicDO;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.jsoup.select.Elements;

/**
 * Created by yaoqiang on 2018/7/26.
 */
@Controller
public class TestController {

    @Resource
    private CloseableHttpClient httpClient;
    @Resource
    private KnowledgeDao knowledgeDao;
    @Resource
    private TopicDao topicDao;


    @RequestMapping("/test/get")
    public String getTest() throws IOException {
        String res = getResponseByUrl("https://xindebaby.com/hospital/126/");
        System.out.println("-----" + res);
        return "ok";
    }


    @RequestMapping("/knowledge/get")
    public String getKnowledge() throws IOException {
        String res = getResponseByUrl("https://baike.putibaby.com");
//        System.out.println(res);
        Document doc = Jsoup.parse(res);
        Elements elements = doc.getElementsByClass("firstmenuTable");
        for (Element element : elements) {
            Elements tds = element.getElementsByTag("td");
            for (Element td : tds) {
                Elements a = td.getElementsByTag("a");
                if (a.size() == 0) continue;
                String t = a.get(0).text();
//                System.out.println(t);
                TopicDO topicDO = TopicDO.builder().name(t).parentId(0).build();
                topicDao.addTopic(topicDO);
                String subTitle = getResponseByUrl("http://baike.putibaby.com/" + a.attr("href"));
                if (subTitle == null) continue;
                doc = Jsoup.parse(subTitle);
                Elements secondtables = doc.getElementsByClass("secondtable");
                for (Element secondtable : secondtables) {

                    Elements secondTds = secondtable.getElementsByTag("td");
                    for (Element secondTd : secondTds) {
                        Elements secondAs = secondTd.getElementsByTag("a");
                        if (secondAs.size() == 0) continue;
                        for (Element secondA : secondAs) {
                            TopicDO subtopicDO = TopicDO.builder().name(secondA.text()).parentId(topicDO.getId()).build();
                            topicDao.addTopic(subtopicDO);
                            handleArticle("http://baike.putibaby.com" + secondA.attr("href"), subtopicDO.getId());
//                            System.out.println(secondA.text());
                        }
                    }
                }

            }
        }

        return "ok";
    }

    private String getResponseByUrl(String url) {
        String agent = "Mozilla/5.0 (Linux; Android 7.1.1; MI MAX 2 Build/NMF26F; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044203 Mobile Safari/537.36 MicroMessenger/6.7.1321(0x26070030) NetType/WIFI Language/zh_CN";
        try {
            url = url.replace(" ", "");
            HttpGet get = new HttpGet(url);
//            get.addHeader("User-Agent", agent);
//            get.addHeader("Host", "xindebaby.com");
//            get.setHeader("Referer", "http://mp.weixinbridge.com/mp/wapredirect?url=http%3A%2F%2Fxindebaby.com%2Fhospital%2F126%2F&action=appmsg_redirect&uin=777&biz=MzIyMDIyMjEwNg==&mid=402919222&idx=1&type=0&scene=0");
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void handleArticle(String url, int type) throws IOException {
        String res = getResponseByUrl(url);

        Document doc = Jsoup.parse(res);

        Elements pagers = doc.getElementsByClass("pager");
        Elements pageas = pagers.get(0).getElementsByTag("a");
        for (Element pagea : pageas) {
            String pageres = getResponseByUrl("http://baike.putibaby.com/" + pagea.attr("href"));
            if (pageres == null) continue;
            doc = Jsoup.parse(pageres);
            Elements lis = doc.getElementsByClass("articleSubject");
            for (Element li : lis) {
                Elements as = li.getElementsByTag("a");
                if (as.size() == 0) continue;
                Element a = as.get(0);
                String aurl = "http://baike.putibaby.com/" + a.attr("href");
                System.out.println("aurl:" + aurl);
                String content = getResponseByUrl(aurl);
                if (content == null) continue;
                doc = Jsoup.parse(content);
                Elements articles = doc.getElementsByClass("articleContent");
                if (articles.size() == 0) continue;
                Elements ps = li.parent().getElementsByTag("p");
                if (ps.size() == 0) continue;
                Element p = ps.get(0);
                KnowledgeDO knowledgeDO = KnowledgeDO.builder().title(a.text())
                        .content(articles.get(0).html()).summary(p.text()).type(type).build();
                knowledgeDao.addKnowledge(knowledgeDO);
            }
        }


    }

}
