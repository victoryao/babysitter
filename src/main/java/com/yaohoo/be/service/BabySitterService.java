package com.yaohoo.be.service;

import com.yaohoo.be.dao.mapper.write.BabySitterMapper;
import entity.BabySitterDO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/2/27.
 */
@Service
public class BabySitterService {

    @Resource
    private BabySitterMapper babySitterMapper;

    @Transactional
    public void addOrder(BabySitterDO babySitterDO){
        babySitterMapper.addOrder(babySitterDO);
    }


}
