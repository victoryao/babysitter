package com.happymama.be.dao;

import com.happymama.be.model.KnowledgeDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yaoqiang on 2018/6/22.
 */
public interface KnowledgeDao {

    @Insert("insert into knowledge(`title`,`content`,`img`, `type`, `created`, `updated`) " +
            "values(#{title},#{content},#{img}, #{type}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addKnowledge(KnowledgeDO knowledgeDO);

    @Update("update knowledge set count = count +1 where id = #{id}")
    boolean addKnowledgeCount(int id);

    @Select("select * from knowledge where type=#{type}  limit #{offset},#{limit}")
    List<KnowledgeDO> getKnowledgeListByParentId(@Param("type") int type, @Param("offset") int offset, @Param("limit") int limit);

    @Select("select count(1) from knowledge where type = #{parentId}")
    long getKnowledgeCount(@Param("parentId") int parentId);

    @Delete("delete from knowledge where id = #{id}")
    void deleteKnowledgeById(int id);

    @Select("select * from knowledge  where id = #{id}")
    KnowledgeDO getKnowledgeById(int id);
}
