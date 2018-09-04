package com.happymama.be.service;

import com.google.common.collect.Lists;
import com.happymama.be.dao.ShopDao;
import com.happymama.be.model.ShopActivityDO;
import com.happymama.be.model.ShopDO;
import com.happymama.be.model.ShopOrderDO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/8/18.
 */
@Service
public class ShopService {

    @Resource
    private ShopDao shopDao;

    public ShopActivityDO getShopActivityById(int id) {
        return shopDao.getShopActivityById(id);
    }

    public List<ShopActivityDO> getShopActivityByMobile(String mobile) {
        return shopDao.getShopActivityByMobile(mobile);
    }

    public boolean updateShopOrderStatusByOrderId(String orderId, int status) {
        return shopDao.updateShopOrderStatusByOrderId(orderId, status);
    }

    public ShopOrderDO verifyShopOrder(String mobile, String code) {
        return shopDao.verifyShopOrder(mobile, code);
    }

    public List<String> getActivityImgListByActivityId(int activityId) {
        return shopDao.getActivityImgListByActivityId(activityId);
    }

    public ShopDO getShopById(int id) {
        return shopDao.getShopById(id);
    }

    public void addShopOrder(ShopOrderDO shopOrderDO) {
        shopDao.addShopOrder(shopOrderDO);
    }

    public List<ShopOrderDO> getShopOrderListByCustomerId(int customerId) {
        return shopDao.getShopOrderListByCustomerId(customerId);
    }

    public List<ShopOrderDO> getShopOrderListByMobile(String mobile) {
        List<ShopActivityDO> list = getShopActivityByMobile(mobile);
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        List<Integer> activityIdList = Lists.newArrayList();
        for (ShopActivityDO shopActivityDO : list) {
            activityIdList.add(shopActivityDO.getId());
        }
        String ids = StringUtils.join(activityIdList, "','");
        return shopDao.getShopOrderListByActivityIds(ids);
    }

}
