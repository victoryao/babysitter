package com.happymama.be.service;

import com.happymama.be.dao.CouponDao;
import com.happymama.be.model.CouponDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/9/26.
 */
@Service
public class CouponService {

    @Resource
    private CouponDao couponDao;

    public List<CouponDO> getCouponByMobileActivityId(String mobile, int activityId) {
        return couponDao.getCouponByMobileActivityId(mobile, activityId);
    }

    public void useCoupon(int id) {
        couponDao.useCoupon(id);
    }

}
