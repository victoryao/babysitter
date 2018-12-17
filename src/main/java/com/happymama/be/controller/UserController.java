package com.happymama.be.controller;

import com.happymama.be.cache.impl.SimpleRedisClientImpl;
import com.happymama.be.model.CustomerDO;
import com.happymama.be.model.ShopActivityDO;
import com.happymama.be.service.CustomerService;
import com.happymama.be.service.ShopService;
import com.happymama.be.service.SmsService;
import com.happymama.be.utils.Utils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaoqiang on 2018/6/30.
 */
@Controller
public class UserController {

    @Resource
    private CustomerService customerService;
    @Resource
    private SmsService smsService;
    @Resource
    private SimpleRedisClientImpl simpleRedisClient;
    @Resource
    private ShopService shopService;

    private static final String OPENID_KEY = "openid_";

    @RequestMapping("/user/sso")
    public String sso(@RequestParam String mobile,
                      @RequestParam String capt,
                      @RequestParam(required = false, defaultValue = "") String openId,
                      @RequestParam(required = false, defaultValue = "") int sex,
                      @RequestParam(required = false, defaultValue = "") String nickName,
                      @RequestParam(required = false, defaultValue = "") String img,
                      @RequestParam(required = false, defaultValue = "") String redirectUrl,
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
        if (StringUtils.isBlank(openId)) openId = null;
        if (customerDO == null) { //注册
            customerDO = CustomerDO.builder().phone(mobile).name(mobile).address(StringUtils.EMPTY)
                    .sex(sex).nickName(nickName).img(img)
                    .openId(openId).token(token).build();
            customerService.addCustomer(customerDO);
        } else {
            customerService.updateCustomerTokenByPhone(mobile, token, openId, img, nickName, sex);
        }

        modelMap.addAttribute("userLevel", "user");
        List<ShopActivityDO> list = shopService.getShopActivityByMobile(mobile);
        if (CollectionUtils.isNotEmpty(list)) {
            modelMap.addAttribute("userLevel", "shop");
        }
        modelMap.addAttribute("login", "success");
        modelMap.addAttribute("token", token);
        modelMap.addAttribute("mobile", mobile);
        modelMap.addAttribute("customerDO", customerDO);
        modelMap.addAttribute("openId", openId);

        modelMap.addAttribute("redirectURL", "/app/" + redirectUrl);
        return "/my/myPage";
    }

}
