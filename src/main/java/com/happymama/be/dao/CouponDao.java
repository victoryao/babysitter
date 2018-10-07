package com.happymama.be.dao;

import com.happymama.be.model.CouponDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yaoqiang on 2018/9/26.
 */
public interface CouponDao {

    @Select("select * from `coupon` where mobile = #{mobile} and activity_id =  #{activityId} and status = 0")
    List<CouponDO> getCouponByMobileActivityId(@Param("mobile") String mobile, @Param("activityId") int activityId);

    @Select("update `coupon` set status = 1 where id = #{id}")
    void useCoupon(@Param("id") int id);

}
