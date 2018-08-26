package com.happymama.be.dao;

import com.happymama.be.model.EmployeeCommentImgDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by yaoqiang on 2018/8/3.
 */
public interface EmployeeCommentImgDao {

    @Insert("insert into `employee_comment_img`(`comment_id`,`img`, `created`) " +
            "values(#{commentId}, #{img}, now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addEmployeeCommentImg(EmployeeCommentImgDO employeeCommentImgDO);


    @Select("select img from `employee_comment_img` where comment_id = #{commentId}")
    List<String> getEmployeeCommentImgByCommentId(String commentId);


}
