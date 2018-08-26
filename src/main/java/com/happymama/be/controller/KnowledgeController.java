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
    public String toKnowledgeList(
            @RequestParam(required = false, defaultValue = "0") int parentId,
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam String loc,
            ModelMap modelMap) {
        if (limit > 100) {
            limit = Constant.pageSize;
        }
        PageView<KnowledgeDO> pageView = new PageView<>(limit, page);
        QueryResult<KnowledgeDO> qr = knowledgeService.getKnowledgeListByParentId(parentId, pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);
        modelMap.addAttribute("loc", loc);
        modelMap.addAttribute("parentId", parentId);
        return "/knowledge/list";
    }

    @RequestMapping(value = "/app/{id}/knowledge/view", method = RequestMethod.GET)
    public String viewKnowledge(@RequestParam(required = false, defaultValue = "") String loc,
                                @PathVariable int id, ModelMap modelMap

    ) {
        KnowledgeDO knowledgeDO = knowledgeService.getKnowledgeById(id);
        modelMap.addAttribute("knowledgeDO", knowledgeDO);
        modelMap.addAttribute("loc", loc);
        return "/knowledge/view";
    }

}
