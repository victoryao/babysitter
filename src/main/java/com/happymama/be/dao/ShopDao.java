package com.happymama.be.dao;

import com.happymama.be.model.ShopActivityDO;
import com.happymama.be.model.ShopDO;
import com.happymama.be.model.ShopOrderDO;
import com.happymama.be.model.TopicDO;
import org.apache.ibatis.annotations.*;

/**
 * Created by yaoqiang on 2018/8/18.
 */
public interface ShopDao {

    @Select("select * from shop_activity where id = #{id}")
    ShopActivityDO getShopActivityById(@Param("id") int id);

    @Select("select * from shop where id = #{id}")
    ShopDO getShopById(@Param("id") int id);

    @Insert("insert into shop_order(`activity_id`,`customer_id`, `mobile`, `price` , `real_price`, `code`, `status`, `created`, `updated`) " +
            "values(#{activityId}, #{customerId}, #{mobile}, #{price}, #{realPrice}, #{code}, #{status}, now() , now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addShopOrder(ShopOrderDO shopOrderDO);

    @Update("update shop_order set status = #{status} where id = #{id}")
    boolean updateShopOrderStatus(@Param("id") int id, @Param("status") int status);


}
