package com.happymama.be.dao;

import com.happymama.be.model.OrderDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

/**
 * Created by yaoqiang on 2018/3/18.
 */
public interface OrderDao {

    @Select("select count(1) from `order`")
    public long getOrderCount();


    @Insert("insert into `order`(`employee_id`,`customer_id`,`price`, `real_price`, `recommend_price` , `type`, `status`,`start_date` ,`end_date`,`memo`,`created`,`updated`) " +
            "values(#{employeeId}, #{customerId}, #{price}, #{realPrice}, #{recommendPrice}, #{type}, #{status}, #{startDate}, #{endDate}, #{memo}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addOrder(OrderDO orderDO);

}
