package com.happymama.be.controller;

import com.happymama.be.service.OrderService;
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

    @RequestMapping("/user/reserve")
    public String doReserve(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam(required = false, defaultValue = "0") int type,
            @RequestParam(required = false, defaultValue = "") String address,
            @RequestParam(required = false, defaultValue = "") String memo,
            ModelMap modelMap) {
        orderService.addOrder(name, phone, address, type, memo);
        return "/common/success";
    }

}
