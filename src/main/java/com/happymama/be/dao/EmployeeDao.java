package com.happymama.be.dao;

import com.happymama.be.model.EmployeeDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yaoqiang on 2018/3/18.
 */
public interface EmployeeDao {


    @Select("select * from employee where id = #{id}")
    public EmployeeDO getEmployeeById(@Param("id") int id);

    @Select("select * from employee where co = 3 and  name like CONCAT(#{name}, '%')")
    public List<EmployeeDO> getEmployeeByName(@Param("name") String name);


    @Select({"<script>", "select * from employee where co=3  ",
            "<if test='name != null'> and name like CONCAT(#{name}, '%')</if>",
            "<if test='phone != null'> and phone = #{phone}</if> ",
            "<if test='types != null'> and id in (select employee_id from employee_position where position in (#{types}))</if> ",
            " order by score desc, comment desc, id desc limit #{offset},#{limit}", "</script>"})
    public List<EmployeeDO> getEmployeeList(@Param("name") String name, @Param("phone") String phone, @Param("types") String types,
                                            @Param("offset") int offset, @Param("limit") int limit);

    @Select({"<script>", "select count(1) from employee where co=3 ",
            "<if test='name != null'> and name like CONCAT(#{name}, '%')</if>",
            "<if test='phone != null'> and phone = #{phone}</if> ",
            "<if test='types != null'> and id in (select employee_id from employee_position where position in (#{types}))</if> ",
            "</script>"})
    public long getEmployeeCount(@Param("name") String name, @Param("phone") String phone, @Param("types") String types);

    @Update("update employee set score = #{score}, comment = comment + 1 where id = #{employeeId} ")
    void updateEmployeeScore(@Param("score") float score, @Param("employeeId") int employeeId);
}
