package com.yaohoo.be.dao.mapper.write;

import entity.BabySitterDO;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by yaoqiang on 2018/2/27.
 */
public interface BabySitterMapper {

    @Insert("insert into `order`(`name`, `phone`, `baby_age`, `address`, `memo`, `created`,`updated`) values(#{name}, #{phone}, #{babyAge}, #{address}, #{memo}, now(), now())")
    public void addOrder(BabySitterDO babySitterDO);

}
