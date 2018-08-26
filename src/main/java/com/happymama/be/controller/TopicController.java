package com.happymama.be.controller;

import com.happymama.be.constant.Constant;
import com.happymama.be.model.KnowledgeDO;
import com.happymama.be.model.TopicDO;
import com.happymama.be.service.KnowledgeService;
import com.happymama.be.service.TopicService;
import com.happymama.be.utils.PageView;
import com.happymama.be.utils.QueryResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/7/27.
 */
@Controller
public class TopicController {

    @Resource
    private TopicService topicService;
    @Resource
    private KnowledgeService knowledgeService;

    @RequestMapping("/app/topic/list")
    public String getTopicListByParentId(@RequestParam(required = false, defaultValue = "0") int parentId,
                                         @RequestParam String loc,
                                         ModelMap modelMap) {
        List<TopicDO> topics = topicService.getTopicListByParentId(parentId);
        modelMap.addAttribute("loc", loc);
        if (CollectionUtils.isNotEmpty(topics)) {
            modelMap.addAttribute("topics", topics);
            return "topic/list";
        }

        PageView<KnowledgeDO> pageView = new PageView<>(10, 1);

        QueryResult<KnowledgeDO> qr = knowledgeService.getKnowledgeListByParentId(parentId, pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);
        modelMap.addAttribute("parentId", parentId);
        return "/knowledge/list";

    }
}
