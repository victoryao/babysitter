package com.happymama.be.dao;

import com.happymama.be.model.ShopActivityDO;
import com.happymama.be.model.ShopDO;
import com.happymama.be.model.ShopOrderDO;
import com.happymama.be.model.TopicDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yaoqiang on 2018/8/18.
 */
public interface ShopDao {

    @Select("select * from shop_activity where id = #{id}")
    ShopActivityDO getShopActivityById(@Param("id") int id);

    @Select("select * from shop_activity where parent_id = #{parentId}")
    List<ShopActivityDO> getShopActivityByParentId(@Param("parentId") int parentId);


    @Select("select * from shop_activity where mobile = #{mobile}")
    List<ShopActivityDO> getShopActivityByMobile(@Param("mobile") String mobile);

    @Select("select * from shop where id = #{id}")
    ShopDO getShopById(@Param("id") int id);

    @Insert("insert into shop_order(`activity_id`, `order_id`, `prepay_id`, `customer_id`, `mobile`, `price` , `real_price`, `code`, `status`, `created`, `updated`, `address`,  `name`, `idcard`, `co`) " +
            "values(#{activityId}, #{orderId}, #{prepayId}, #{customerId}, #{mobile}, #{price}, #{realPrice}, #{code}, #{status}, now() , now(), #{address}, #{name}, #{idcard}, 3)")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addShopOrder(ShopOrderDO shopOrderDO);

    @Select("select * from shop_order where order_id = #{orderId}")
    ShopOrderDO getShopOrderByOrderId(@Param("orderId") String orderId);

    @Update("update shop_order set status = #{status} where id = #{id}")
    boolean updateShopOrderStatus(@Param("id") int id, @Param("status") int status);

    @Update("update shop_order set status = #{status} where order_id = #{orderId}")
    boolean updateShopOrderStatusByOrderId(@Param("orderId") String orderId, @Param("status") int status);

    @Select("select * from shop_order where customer_id = #{customerId} order by id desc")
    List<ShopOrderDO> getShopOrderListByCustomerId(@Param("customerId") int customerId);

    @Select("select * from shop_order where activity_id in (#{activityIds}) order by id desc")
    List<ShopOrderDO> getShopOrderListByActivityIds(@Param("activityIds") String activityIds);

    @Select("select * from shop_order where mobile = #{mobile} and code = #{code}")
    ShopOrderDO verifyShopOrder(@Param("mobile") String mobile, @Param("code") String code);

    @Select("select img from shop_activity_img where activity_id = #{activityId} order by `order` asc")
    List<String> getActivityImgListByActivityId(@Param("activityId") int activityId);

    @Select("select * from shop_activity where type = #{type} order by created desc limit 10")
    List<ShopActivityDO> getActivityListByType(int type);
}
