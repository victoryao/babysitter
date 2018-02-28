package com.yaohoo.be.web.controller;

import com.yaohoo.be.service.BabySitterService;
import entity.BabySitterDO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/2/27.
 */
@Controller
public class BabySitterController {

    @Resource
    private BabySitterService babySitterService;

    @RequestMapping(value = "/app/baby/sitter/add", method = RequestMethod.POST)
    public Object addOrder(@RequestParam String name,
                           @RequestParam String phone,
                           @RequestParam(required = false) String address,
                           @RequestParam String babyage,
                           @RequestParam String memo

    ) {
        BabySitterDO babySitterDO = BabySitterDO.builder().name(name).phone(phone).address(address)
                .babyAge(Integer.parseInt(babyage)).memo(memo).build();
        babySitterService.addOrder(babySitterDO);
        return "main";

    }
}
