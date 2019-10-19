package com.happymama.be.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.happymama.be.dao.KnowledgeDao;
import com.happymama.be.dao.TopicDao;
import com.happymama.be.model.KnowledgeDO;
import com.happymama.be.model.TopicDO;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.xpath.SourceTree;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    String cookie = "UM_distinctid=16dd529fffe6-01c23dd7c9d1de-1d3d6b53-13c680-16dd529ffff638; CNZZDATA1264539208=1583010950-1571234035-%7C1571234035; session=.eJyrVspMUbJSys8tcikvM4ooSSoNNo7PSCpIdQvIcUkOyAjwTlbSUcosjk9Myc3MU7JKS8wpTgULFCfmpBbnJqKKlRakFsWXFqcWwUVhyuJB9uSV5uTUAgAWcCke.EIjHSg.q-vsolxGNFP0nN36js-DsKRkln0";

    @RequestMapping("/test/get")
    public String getTest() throws IOException {

        int lastId = 0;

        while (true) {
            String res = postResponseByUrl("https://xindebaby.com/thrid/provider/571/nurses/", cookie, lastId);
            JSONObject jsonObject = JSON.parseObject(res);
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("nurses");
            if (jsonArray.isEmpty() || jsonArray.size() == 0) {
                return "success";
            }

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject nurse = jsonArray.getJSONObject(i);
                String hometown = nurse.getString("hometown");
                String name = nurse.getString("name");
                String price = nurse.getString("price");
                int id = nurse.getInteger("id");
                String NurseUrl = "https://xindebaby.com/thrid/provider/571/nurse/" + id + "/edit/";
                String nurseResponse = getResponseByUrl(NurseUrl, cookie);
                handleNurse(name, hometown, price, nurseResponse);
                lastId = id;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    @RequestMapping("/knowledge/get")
    public String getKnowledge() throws IOException {
        String res = getResponseByUrl("https://baike.putibaby.com", "");
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
                String subTitle = getResponseByUrl("http://baike.putibaby.com/" + a.attr("href"), "");
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

    private String postResponseByUrl(String url, String cookie, int lastId) {
        String agent = "Mozilla/5.0 (Linux; Android 7.1.1; MI MAX 2 Build/NMF26F; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044203 Mobile Safari/537.36 MicroMessenger/6.7.1321(0x26070030) NetType/WIFI Language/zh_CN";
        try {
            url = url.replace(" ", "");
            HttpPost post = new HttpPost(url);
            post.addHeader("cookie", cookie);

            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            paramList.add(new BasicNameValuePair("lastId", ""));
            //lastId=9348
            post.setEntity(new UrlEncodedFormEntity(paramList, "utf-8"));
//            get.addHeader("Host", "xindebaby.com");
//            get.setHeader("Referer", "http://mp.weixinbridge.com/mp/wapredirect?url=http%3A%2F%2Fxindebaby.com%2Fhospital%2F126%2F&action=appmsg_redirect&uin=777&biz=MzIyMDIyMjEwNg==&mid=402919222&idx=1&type=0&scene=0");
            CloseableHttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getResponseByUrl(String url, String cookie) {
        String agent = "Mozilla/5.0 (Linux; Android 7.1.1; MI MAX 2 Build/NMF26F; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044203 Mobile Safari/537.36 MicroMessenger/6.7.1321(0x26070030) NetType/WIFI Language/zh_CN";
        try {
            url = url.replace(" ", "");
            HttpGet get = new HttpGet(url);
            get.addHeader("cookie", cookie);
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

    private void handleNurse(String name, String hometown, String price, String res) {
        Document doc = Jsoup.parse(res);
        String birthday = doc.getElementsByClass("tech-birthday").get(0).attr("value");
        String introduce = doc.getElementsByClass("tech-introduce").get(0).text();
        System.out.println(name + ":" + birthday);
        System.out.println(introduce);

        Element photos = doc.getElementById("show-gr-box");
        Elements elements = photos.getElementsByClass("imgs-item-box");
        for (int i = 0; i < elements.size(); i++) {
            Element p = elements.get(i);
            String photoUrl = p.attr("data-url");
        }

        Element zhengShu = doc.getElementById("show-zs-box");
        Elements zsElements = zhengShu.getElementsByClass("imgs-item-box");
        for (int i = 0; i < zsElements.size(); i++) {
            Element p = zsElements.get(i);
            String photoUrl = p.attr("data-url");
        }

        Element tjShu = doc.getElementById("show-tj-box");
        Elements tjElements = tjShu.getElementsByClass("imgs-item-box");
        for (int i = 0; i < tjElements.size(); i++) {
            Element p = tjElements.get(i);
            String photoUrl = p.attr("data-url");
        }


    }

    private void handleArticle(String url, int type) throws IOException {
        String res = getResponseByUrl(url, "");

        Document doc = Jsoup.parse(res);

        Elements pagers = doc.getElementsByClass("pager");
        Elements pageas = pagers.get(0).getElementsByTag("a");
        for (Element pagea : pageas) {
            String pageres = getResponseByUrl("http://baike.putibaby.com/" + pagea.attr("href"), "");
            if (pageres == null) continue;
            doc = Jsoup.parse(pageres);
            Elements lis = doc.getElementsByClass("articleSubject");
            for (Element li : lis) {
                Elements as = li.getElementsByTag("a");
                if (as.size() == 0) continue;
                Element a = as.get(0);
                String aurl = "http://baike.putibaby.com/" + a.attr("href");
                System.out.println("aurl:" + aurl);
                String content = getResponseByUrl(aurl, "");
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
