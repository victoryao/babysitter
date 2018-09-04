package com.happymama.be.dao;

import com.happymama.be.model.CustomerDO;
import org.apache.ibatis.annotations.*;

/**
 * Created by yaoqiang on 2018/3/31.
 */
public interface CustomerDao {

    @Insert("insert into `customer`(`name`,`phone`,`address`, `token`, `openid`, `created`,`updated`) " +
            "values(#{name}, #{phone}, #{address}, #{token}, #{openId}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addCustomer(CustomerDO customerDO);

    @Select("select * from `customer` where id = #{customerId}")
    CustomerDO getCustomerById(@Param("customerId") int customerId);

    @Select("select * from `customer` where phone = #{phone}")
    CustomerDO getCustomerByPhone(@Param("phone") String phone);

    @Select("select * from `customer` where token = #{token}")
    CustomerDO getCustomerByToken(@Param("token") String token);

    @Update("update `customer` set `name` = #{name}, phone = #{phone}, address = #{address}, `updated` = now() where id = #{id}")
    void updateCustomer(CustomerDO customerDO);

    @Update({"<script>", "update `customer` set `token` = #{token}, ",
            "<if test='openId != null'> `openId` = #{openId} ,</if> ",
            "`updated` = now() where phone = #{mobile}", "</script>"})
    void updateCustomerToken(@Param("mobile") String mobile, @Param("token") String token, @Param("openId") String openId);

    @Select("select * from `customer` where openId = #{openId}")
    CustomerDO getCustomerByOpenId(String openId);
}
