package com.happymama.be.dao;

import com.happymama.be.model.ActivityJoinDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by yaoqiang on 2018/12/17.
 */
public interface ActivityJoinDao {

    @Insert("insert into `activity_join`(`activity_id`,`user_id` ,`created`) " +
            "values(#{activityId}, #{userId},  now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addActivityJoin(ActivityJoinDO customerDO);

    @Select("select user_id from `activity_join` where activity_id = #{activityId}")
    List<Integer> getActivityJoinerList(@Param("activityId") int activityId);

    @Select("select user_id from `activity_join` where activity_id = #{activityId} and user_id = #{userId}")
    Integer getActivityJoinerByUid(ActivityJoinDO activityJoinDO);
}
