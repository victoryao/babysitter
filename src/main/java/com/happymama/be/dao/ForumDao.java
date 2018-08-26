package com.happymama.be.dao;

import com.happymama.be.model.ForumCommentDO;
import com.happymama.be.model.ForumDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by yaoqiang on 2018/7/4.
 */
public interface ForumDao {

    @Insert("insert into `forum`(`forum_id`, `title`,`content`, `user_id`, `created`, `updated`) " +
            "values(#{forumId} , #{title}, #{content}, #{userId}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addForum(ForumDO forumDO);

    @Select("select * from forum where topic_id = #{topicId} order by id desc limit #{offset},#{limit}")
    List<ForumDO> getForumListByTopicId(@Param("topicId") int topicId, @Param("offset") int offset, @Param("limit") int limit);

    @Select("select count(1) from forum where topic_id = #{topicId}")
    long getForumCountByTopicId(@Param("topicId") int topicId);

    @Select("select * from forum where id = #{id}")
    ForumDO getForumById(int id);

    @Insert("insert into `forum_comment`(`forum_id`, `user_id`, `content`, `created`, `updated`) " +
            "values (#{forumId}, #{userId}, #{content} , now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addForumComment(ForumCommentDO build);


    @Select("select * from forum_comment where forum_id = #{forumId} order by created desc limit #{offset},#{limit}")
    List<ForumCommentDO> getCommentListByForumId(@Param("forumId") int forumId, @Param("offset") int offset, @Param("limit") int limit);

    @Select("select count(1) from forum_comment where forum_id = #{forumId}")
    long getCommentCountByForumId(@Param("forumId") int forumId);
}
