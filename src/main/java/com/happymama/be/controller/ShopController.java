package com.happymama.be.controller;

import com.happymama.be.model.ShopActivityDO;
import com.happymama.be.model.ShopDO;
import com.happymama.be.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/8/18.
 */
@Controller
public class ShopController {

    @Resource
    private ShopService shopService;

    @RequestMapping("/shop/activity/detail")
    public String getShopActivityDetail(
            @RequestParam(required = false, defaultValue = "0") int id,
            ModelMap modelMap) {
        ShopActivityDO shopActivityDO = shopService.getShopActivityById(id);
        if (shopActivityDO != null) {
            shopActivityDO.setDiscount(shopActivityDO.getDiscount() * 10);
            ShopDO shopDO = shopService.getShopById(shopActivityDO.getShopId());
            modelMap.addAttribute("shopDO", shopDO);
        }
        modelMap.addAttribute("shopActivityDO", shopActivityDO);
        return "/shop/detail";
    }

}
