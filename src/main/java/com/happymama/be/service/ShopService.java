package com.happymama.be.service;

import com.happymama.be.dao.ShopDao;
import com.happymama.be.model.ShopActivityDO;
import com.happymama.be.model.ShopDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    public ShopDO getShopById(int id) {
        return shopDao.getShopById(id);
    }

}
