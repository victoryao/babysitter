package com.happymama.be.controller;

import com.happymama.be.constant.Constant;
import com.happymama.be.model.CustomerDO;
import com.happymama.be.model.EmployeeDO;
import com.happymama.be.model.KnowledgeDO;
import com.happymama.be.model.ShopActivityDO;
import com.happymama.be.service.*;
import com.happymama.be.utils.PageView;
import com.happymama.be.utils.QueryResult;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class NavController {

    @Resource
    private OrderService orderService;
    @Resource
    private CustomerService customerService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private ShopService shopService;


    @RequestMapping("/toMain")
    public String toMainPage(@RequestParam(required = false, defaultValue = "") String loc, ModelMap modelMap) {
        PageView<EmployeeDO> pageView = new PageView<>(4, 1);
        QueryResult<EmployeeDO> qr = employeeService.getEmployeeList(null, null, null, pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);
        modelMap.addAttribute("loc", loc);
        return "home";
    }

    @RequestMapping("/app/to/babysitter")
    public String toLoginPage(
            @RequestParam(required = false, defaultValue = "") String loc,
            @RequestParam(required = false, defaultValue = "0") int eId,
            ModelMap modelMap) {
        modelMap.addAttribute("count", orderService.getOrderCount() + 12300);
        modelMap.addAttribute("loc", loc);
        modelMap.addAttribute("eId", eId);
        return "babysitter_form";
    }

    @RequestMapping("/app/to/train")
    public String toTrain(@RequestParam(required = false, defaultValue = "") String loc, ModelMap modelMap) {
        modelMap.addAttribute("count", orderService.getOrderCount() + 5306);
        modelMap.addAttribute("loc", loc);
        return "training";
    }

    @RequestMapping("/app/to/detail")
    public String toDetail(@RequestParam(required = false, defaultValue = "") String loc, ModelMap modelMap) {
        modelMap.addAttribute("loc", loc);
        return "detail";
    }

    @RequestMapping("/app/to/home")
    public String toHome(@RequestParam(required = false, defaultValue = "") String loc, ModelMap modelMap) {
        modelMap.addAttribute("loc", loc);
        return "home";
    }


    @RequestMapping("/app/to/about-us")
    public String toAboutUs(@RequestParam(required = false, defaultValue = "") String loc, ModelMap modelMap) {
        modelMap.addAttribute("loc", loc);
        return "about-us";
    }

    @RequestMapping("/app/to/contact-us")
    public String toContactUs(@RequestParam(required = false, defaultValue = "") String loc, ModelMap modelMap) {
        modelMap.addAttribute("loc", loc);
        return "contact-us";
    }

    @RequestMapping("/app/to/employee")
    public String toEmployee(@RequestParam(required = false, defaultValue = "") String loc, ModelMap modelMap) {
        modelMap.addAttribute("loc", loc);
        return "employee";
    }

    @RequestMapping("/app/to/course")
    public String toCourse(@RequestParam(required = false, defaultValue = "") String loc, ModelMap modelMap) {
        modelMap.addAttribute("loc", loc);
        return "course-list";
    }


    @RequestMapping("/app/to/my")
    public String toMyPage(
            @RequestParam String token,
            @RequestParam String loc,
            ModelMap modelMap) {
        modelMap.addAttribute("loc", loc);
        if (StringUtils.isNotBlank(token)) {
            CustomerDO customerDO = customerService.getCustomerByToken(token);
            if (customerDO != null) {
                modelMap.addAttribute("userLevel", "user");
                List<ShopActivityDO> list = shopService.getShopActivityByMobile(customerDO.getPhone());
                if (CollectionUtils.isNotEmpty(list)) {
                    modelMap.addAttribute("userLevel", "shop");
                }
                modelMap.addAttribute("token", token);
                modelMap.addAttribute("customerDO", customerDO);
                return "/my/myPage";
            }
        }
        return "/my/noLogin";
    }

    @RequestMapping("/app/to/login")
    public String toLoginPage() {
        return "/my/login";
    }

    @RequestMapping("/app/to/user/notice")
    public String toUserNoticePage() {
        return "user-notice";
    }

    @RequestMapping("/app/to/forum/list")
    public String toForumListPage() {
        return "/forum/list";
    }


    @RequestMapping("/order/list")
    public String toOrderListPage() {
        return "/order/list";
    }

    @RequestMapping("/to/yuesao/detail")
    public String toYueSaoDetailPage() {
        return "/shop/yuesao_detail";
    }

    @RequestMapping("/to/yuersao/detail")
    public String toYuErSaoDetailPage() {
        return "/shop/yuersao_detail";
    }

}
