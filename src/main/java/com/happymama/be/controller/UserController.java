package com.happymama.be.controller;

import com.happymama.be.cache.impl.SimpleRedisClientImpl;
import com.happymama.be.model.CustomerDO;
import com.happymama.be.service.CustomerService;
import com.happymama.be.service.SmsService;
import com.happymama.be.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/6/30.
 */
@Controller
public class UserController {

    @Resource
    private CustomerService customerService;
    @Resource
    private SmsService smsService;

    @RequestMapping("/user/sso")
    public String sso(@RequestParam String mobile,
                      @RequestParam String capt,
                      ModelMap modelMap) {
        if (!Utils.isNumberValidate(mobile)) {
            return "/my/login";
        }

        String code = smsService.getVerifyCode(mobile);

        if (code == null || !capt.equals(code)) {
            modelMap.addAttribute("login", "verifyCodeError");
            return "/my/login";
        }

        String token = Utils.genToken(mobile);
        CustomerDO customerDO = customerService.getCustomerByPhone(mobile);

        if (customerDO == null) { //注册
            customerDO = CustomerDO.builder().phone(mobile).name(mobile).address(StringUtils.EMPTY).token(token).build();
            customerService.addCustomer(customerDO);
        } else {
            customerService.updateCustomerTokenByPhone(mobile, token);
        }

        modelMap.addAttribute("login", "success");
        modelMap.addAttribute("token", token);
        modelMap.addAttribute("mobile", mobile);
        modelMap.addAttribute("customerDO", customerDO);

        return "my/myPage";
    }

}
