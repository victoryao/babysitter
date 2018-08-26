package com.happymama.be.dao;

import com.happymama.be.model.EmployeeCommentDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by yaoqiang on 2018/7/31.
 */
public interface EmployeeCommentDao {

    @Insert("insert into `employee_comment`(`comment_id`,`score`,`comment`, `employee_id`, `user_id`, `created`, `ip`) " +
            "values(#{commentId}, #{score}, #{comment}, #{employeeId}, #{userId}, now(), #{ip})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addEmployeeComment(EmployeeCommentDO employeeCommentDO);


    @Select("select * from employee_comment where employee_id = #{employeeId} order by id desc limit #{offset},#{limit}")
    List<EmployeeCommentDO> getCommentListByEmployeeId(@Param("employeeId") int employeeId, @Param("offset") int offset, @Param("limit") int limit);

    @Select("select count(1) from employee_comment where employee_id = #{employeeId}")
    long getCommentCountByEmployeeId(@Param("employeeId") int employeeId);

    @Select("select sum(score)/ count(1) from employee_comment where employee_id = #{employeeId}")
    float getEmployeeScoreByEmployeeId(int employeeId);

}
