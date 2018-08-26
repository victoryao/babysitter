package com.happymama.be.dao;

import com.happymama.be.model.TopicDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by yaoqiang on 2018/7/26.
 */
public interface TopicDao {

    @Insert("insert into topic(`name`,`img`, `parent_id`, `created`) " +
            "values(#{name},#{img},#{parentId}, now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addTopic(TopicDO topicDO);

    @Select("select * from topic where parent_id = #{parentId}")
    List<TopicDO> getTopicListByParentId(@Param("parentId") int parentId);

}
