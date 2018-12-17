package com.happymama.be.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.happymama.be.model.ActivityJoinDO;
import com.happymama.be.model.CustomerDO;
import com.happymama.be.service.ActivityJoinService;
import com.happymama.be.service.CustomerService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/12/17.
 */
@org.springframework.web.bind.annotation.RestController
public class ActivityController {

    @Resource
    private ActivityJoinService activityJoinService;
    @Resource
    private CustomerService customerService;

    @RequestMapping("/activity/join/list")
    public String getActivityJoinerByAid(@RequestParam int activityId) {
        List<CustomerDO> customerDOS = Lists.newArrayList();
        List<Integer> list = activityJoinService.getActivityJoinerList(activityId);
        if (CollectionUtils.isNotEmpty(list)) {
            for (int uid : list) {
                customerDOS.add(customerService.getCustomerById(uid));
            }
        }
        return JSON.toJSONString(customerDOS);
    }

    @RequestMapping("/activity/is/join")
    public boolean getActivityJoinerByAid(@RequestParam String accessToken, @RequestParam int activityId) {
        CustomerDO customerDO = customerService.getCustomerByToken(accessToken);
        return customerDO != null && activityJoinService.isActivityJoiner(ActivityJoinDO.builder().activityId(activityId).userId(customerDO.getId()).build());
    }

}
