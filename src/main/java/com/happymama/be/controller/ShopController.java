package com.happymama.be.controller;

import com.happymama.be.model.CustomerDO;
import com.happymama.be.model.ShopActivityDO;
import com.happymama.be.model.ShopDO;
import com.happymama.be.model.ShopOrderDO;
import com.happymama.be.service.CustomerService;
import com.happymama.be.service.ShopService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/8/18.
 */
@Controller
public class ShopController {

    @Resource
    private ShopService shopService;
    @Resource
    private CustomerService customerService;

    @RequestMapping("/shop/mobile/activity/list")
    public String getShopActivityByMobile(
            @RequestParam(required = false, defaultValue = "0") String mobile,
            ModelMap modelMap) {
        List<ShopOrderDO> list = shopService.getShopOrderListByMobile(mobile);
        CustomerDO customerDO = customerService.getCustomerByPhone(mobile);
        modelMap.addAttribute("shopOrderDOs", list);
        modelMap.addAttribute("customerDO", customerDO);
        return "/shop/activity_order_list";
    }

    @RequestMapping("/shop/to/exchange")
    public String shopExchange(
            @RequestParam(required = false, defaultValue = "0") int id,
            ModelMap modelMap) {
        CustomerDO customerDO = customerService.getCustomerById(id);
        modelMap.addAttribute("customerDO", customerDO);
        return "/shop/exchange";
    }

    @RequestMapping("/shop/activity/detail")
    public String getShopActivityDetail(
            @RequestParam(required = false, defaultValue = "0") int id,
            ModelMap modelMap) {
        ShopActivityDO shopActivityDO = shopService.getShopActivityById(id);
        if (shopActivityDO != null) {
            shopActivityDO.setDiscount(shopActivityDO.getDiscount() * 10);
            shopActivityDO.setRealPrice(shopActivityDO.getRealPrice());
            ShopDO shopDO = shopService.getShopById(shopActivityDO.getShopId());
            modelMap.addAttribute("shopDO", shopDO);
        }
        List<String> images = shopService.getActivityImgListByActivityId(id);
        modelMap.addAttribute("shopActivityDO", shopActivityDO);
        modelMap.addAttribute("images", images);
        return "/shop/detail";
    }

    @RequestMapping("/shop/order/list")
    public String getShopOrderList(
            @RequestParam(required = false, defaultValue = "") String accessToken,
            @RequestParam(required = false, defaultValue = "") String openId,
            ModelMap modelMap) {
        if (StringUtils.isBlank(accessToken) && StringUtils.isBlank(openId)) {
            return "/my/login";
        }

        CustomerDO customerDO = null;
        if (StringUtils.isNotBlank(accessToken)) {
            customerDO = customerService.getCustomerByToken(accessToken);
        }

        if (StringUtils.isNotBlank(openId)) {
            customerDO = customerService.getCustomerByOpenId(openId);
        }

        if (customerDO == null) {
            return "/my/login";
        }

        List<ShopOrderDO> list = shopService.getShopOrderListByCustomerId(customerDO.getId());
        if (CollectionUtils.isNotEmpty(list)) {
            for (ShopOrderDO shopOrderDO : list) {
                ShopActivityDO shopActivityDO = shopService.getShopActivityById(shopOrderDO.getActivityId());
                ShopDO shopDO = shopService.getShopById(shopActivityDO.getShopId());
                shopActivityDO.setShopDO(shopDO);
                shopOrderDO.setShopActivityDO(shopActivityDO);
            }
        }

        modelMap.addAttribute("shopOrderDOs", list);
        return "/order/list";
    }


}
