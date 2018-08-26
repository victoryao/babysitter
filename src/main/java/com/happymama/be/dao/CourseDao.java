package com.happymama.be.dao;


import com.happymama.be.model.CourseDO;
import com.happymama.be.model.CourseOrderDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yaoqiang on 2018/5/15.
 */
public interface CourseDao {

    @Select("select * from `course`")
    List<CourseDO> getCourseList();

    @Select("select * from `course_order` where employee_id = #{employeeId}")
    List<CourseOrderDO> getCourseOrderListByEmployeeId(@Param("employeeId") int employeeId);

    @Select("select * from `course` where id = #{id}")
    CourseDO getCourseById(@Param("id") int id);

}
