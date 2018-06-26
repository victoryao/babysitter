package com.happymama.be.controller;

import com.happymama.be.constant.Constant;
import com.happymama.be.model.KnowledgeDO;
import com.happymama.be.service.KnowledgeService;
import com.happymama.be.service.OrderService;
import com.happymama.be.utils.PageView;
import com.happymama.be.utils.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class NavController {

    @Resource
    private OrderService orderService;


    @RequestMapping("/toMain")
    public String toMainPage() {
        return "home";
    }

    @RequestMapping("/app/to/babysitter")
    public String toLoginPage(ModelMap modelMap) {
        modelMap.addAttribute("count", orderService.getOrderCount() + 12300);
        return "babysitter_form";
    }

    @RequestMapping("/app/to/train")
    public String toTrain(ModelMap modelMap) {
        modelMap.addAttribute("count", orderService.getOrderCount() + 5306);
        return "training";
    }

    @RequestMapping("/app/to/detail")
    public String toDetail() {
        return "detail";
    }

    @RequestMapping("/app/to/home")
    public String toHome() {
        return "home";
    }


    @RequestMapping("/app/to/about-us")
    public String toAboutUs() {
        return "about-us";
    }

    @RequestMapping("/app/to/contact-us")
    public String toContactUs() {
        return "contact-us";
    }

    @RequestMapping("/app/to/employee")
    public String toEmployee() {
        return "employee";
    }

    @RequestMapping("/app/to/course")
    public String toCourse() {
        return "course-list";
    }


    @RequestMapping("/app/to/my")
    public String toMyPage() {
        return "/my/myPage";
    }

    @RequestMapping("/app/to/login")
    public String toLoginPage() {
        return "/my/login";
    }

}
