package com.happymama.be.controller;

import com.happymama.be.model.CustomerDO;
import com.happymama.be.model.OrderDO;
import com.happymama.be.model.RecommendDO;
import com.happymama.be.service.CustomerService;
import com.happymama.be.service.OrderService;
import com.happymama.be.service.RecommendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/5/27.
 */
@Controller
public class ReserveController {

    @Resource
    private OrderService orderService;
    @Resource
    private RecommendService recommendService;
    @Resource
    private CustomerService customerService;

    @RequestMapping("/user/reserve")
    public String doReserve(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam(required = false, defaultValue = "0") int type,
            @RequestParam(required = false, defaultValue = "") String address,
            @RequestParam(required = false, defaultValue = "") String memo,
            @RequestParam(required = false, defaultValue = "") String recommendMobile,
            ModelMap modelMap) {
        OrderDO orderDO = orderService.addOrder(name, phone, address, type, memo, recommendMobile);

        if (org.apache.commons.lang.StringUtils.isNotBlank(recommendMobile)) {
            CustomerDO recommendCustomer = CustomerDO.builder().name(recommendMobile).phone(recommendMobile).address(org.apache.commons.lang.StringUtils.EMPTY).build();
            recommendCustomer = customerService.addCustomer(recommendCustomer);
            RecommendDO recommendDO = RecommendDO.builder().orderId(orderDO.getId()).price(0).customerId(recommendCustomer.getId()).build();
            recommendService.addRecommend(recommendDO);
        }
        return "/common/success";
    }

}
