package com.happymama.be.service;


import com.happymama.be.dao.RecommendDao;
import com.happymama.be.model.RecommendDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yaoqiang on 2018/5/13.
 */
@Service
public class RecommendService {

    @Resource
    private RecommendDao recommendDao;

    public void addRecommend(RecommendDO recommendDO) {
        recommendDao.addRecommend(recommendDO);
    }


}
