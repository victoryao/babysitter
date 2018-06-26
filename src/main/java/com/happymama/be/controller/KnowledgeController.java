package com.happymama.be.controller;

import com.happymama.be.constant.Constant;
import com.happymama.be.model.KnowledgeDO;
import com.happymama.be.service.KnowledgeService;
import com.happymama.be.utils.PageView;
import com.happymama.be.utils.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/6/24.
 */
@Controller
public class KnowledgeController {

    @Resource
    private KnowledgeService knowledgeService;

    @RequestMapping("/app/to/knowledge/list")
    public String toKnowledgeList(@RequestParam(required = false, defaultValue = "10") int limit,
                                  @RequestParam(required = false, defaultValue = "1") int page,
                                  ModelMap modelMap) {
        if (limit > 100) {
            limit = Constant.pageSize;
        }
        PageView<KnowledgeDO> pageView = new PageView<>(limit, page);
        QueryResult<KnowledgeDO> qr = knowledgeService.getKnowledgeList(pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);
        return "/knowledge/list";
    }

    @RequestMapping(value = "/app/{id}/knowledge/view", method = RequestMethod.GET)
    public String viewKnowledge(@PathVariable int id, ModelMap modelMap

    ) {
        KnowledgeDO knowledgeDO = knowledgeService.getKnowledgeById(id);
        modelMap.addAttribute("knowledgeDO", knowledgeDO);
        return "/knowledge/view";
    }

}
