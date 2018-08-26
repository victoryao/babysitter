package com.happymama.be.controller;

import com.happymama.be.constant.Constant;
import com.happymama.be.dao.CustomerDao;
import com.happymama.be.model.CustomerDO;
import com.happymama.be.model.ForumCommentDO;
import com.happymama.be.model.ForumDO;
import com.happymama.be.model.KnowledgeDO;
import com.happymama.be.service.CustomerService;
import com.happymama.be.service.ForumImgService;
import com.happymama.be.service.ForumService;
import com.happymama.be.utils.PageView;
import com.happymama.be.utils.QueryResult;
import com.happymama.be.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.title;

/**
 * Created by yaoqiang on 2018/7/4.
 */
@Controller
public class ForumController {

    @Resource
    private ForumService forumService;
    @Resource
    private CustomerService customerService;
    @Resource
    private ForumImgService forumImgService;

    @RequestMapping("/forum/add")
    public String addForum(
            @RequestParam String commentId,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String accessToken,
            ModelMap modelMap) {
        if (StringUtils.isBlank(accessToken)) {
            return "/my/login";
        }

        CustomerDO customerDO = customerService.getCustomerByToken(accessToken);
        if (customerDO == null) {
            return "/my/login";
        }

        forumService.addForum(ForumDO.builder().forumId(commentId).title(title).content(content).userId(String.valueOf(customerDO.getId())).build());

        PageView<ForumDO> pageView = new PageView<>(10, 1);
        QueryResult<ForumDO> qr = forumService.getForumListByTopicId(0, pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);

        return "/forum/list";
    }

    @RequestMapping("/forum/{forumId}/addComment")
    public String addForumComment(
            @RequestParam(required = false, defaultValue = "") String loc,
            @PathVariable int forumId,
            @RequestParam String content,
            @RequestParam String accessToken,
            ModelMap modelMap) {

        if (StringUtils.isBlank(accessToken)) {
            return "/my/login";
        }

        CustomerDO customerDO = customerService.getCustomerByToken(accessToken);
        if (customerDO == null) {
            return "/my/login";
        }

        forumService.addForumComment(ForumCommentDO.builder().forumId(forumId).content(content).userId(customerDO.getId()).build());

        ForumDO forumDO = forumService.getForumById(forumId);
        modelMap.addAttribute("forumDO", forumDO);
        customerDO = customerService.getCustomerById(Integer.parseInt(forumDO.getUserId()));
        customerDO.setName(Utils.secureName(customerDO.getName()));
        modelMap.addAttribute("customerDO", customerDO);

        PageView<ForumCommentDO> pageView = new PageView<>(10, 1);
        QueryResult<ForumCommentDO> qr = forumService.getCommentListByForumId(forumId, pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("loc", loc);
        modelMap.addAttribute("pageView", pageView);
        modelMap.addAttribute("hasComment", pageView.getTotalrecord() > 0);
        List<String> list = forumImgService.getForumImgByForumId(forumDO.getForumId());
        modelMap.addAttribute("images", list);
        return "/forum/detail";
    }

    @RequestMapping("/forum/{topicId}/list")
    public String getForumList(@RequestParam(required = false, defaultValue = "10") int limit,
                               @RequestParam(required = false, defaultValue = "1") int page,
                               @RequestParam(required = false, defaultValue = "") String loc,
                               @PathVariable int topicId,
                               ModelMap modelMap) {
        if (limit > 100) {
            limit = Constant.pageSize;
        }
        PageView<ForumDO> pageView = new PageView<>(limit, page);
        QueryResult<ForumDO> qr = forumService.getForumListByTopicId(0, pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);
        modelMap.addAttribute("loc", loc);
        return "/forum/list";
    }


    @RequestMapping("/forum/{id}/detail")
    public String getForumById(@PathVariable int id,
                               @RequestParam(required = false, defaultValue = "") String loc,
                               @RequestParam(required = false, defaultValue = "10") int limit,
                               @RequestParam(required = false, defaultValue = "1") int page,
                               ModelMap modelMap) {
        ForumDO forumDO = forumService.getForumById(id);
        CustomerDO customerDO = customerService.getCustomerById(Integer.parseInt(forumDO.getUserId()));
        customerDO.setName(Utils.secureName(customerDO.getName()));
        modelMap.addAttribute("forumDO", forumDO);
        modelMap.addAttribute("customerDO", customerDO);
        PageView<ForumCommentDO> pageView = new PageView<>(limit, page);
        QueryResult<ForumCommentDO> qr = forumService.getCommentListByForumId(id, pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);
        modelMap.addAttribute("loc", loc);
        modelMap.addAttribute("hasComment", pageView.getTotalrecord() > 0);

        List<String> list = forumImgService.getForumImgByForumId(forumDO.getForumId());
        modelMap.addAttribute("images", list);
        return "/forum/detail";
    }


    @RequestMapping("/app/to/forum/{forumId}/comment/add")
    public String toAddForumCommentPage(@PathVariable int forumId, @RequestParam String accessToken, ModelMap modelMap) {
        if (StringUtils.isBlank(accessToken)) {
            return "/my/login";
        }
        CustomerDO customerDO = customerService.getCustomerByToken(accessToken);
        if (customerDO == null) {
            return "/my/login";
        }
        modelMap.addAttribute("forumId", forumId);
        return "/forum/addComment";
    }

    @RequestMapping("/app/to/{topicId}/forum/add")
    public String toAddForumPage(@PathVariable int topicId,
                                 @RequestParam String accessToken,
                                 HttpServletRequest request,
                                 ModelMap modelMap) {
        if (StringUtils.isBlank(accessToken)) {
            return "/my/login";
        }

        CustomerDO customerDO = customerService.getCustomerByToken(accessToken);
        if (customerDO == null) {
            return "/my/login";
        }

        modelMap.addAttribute("forumId", Utils.getId());
        modelMap.addAttribute("contextPath", request.getContextPath());

        return "/forum/add";
    }

}
