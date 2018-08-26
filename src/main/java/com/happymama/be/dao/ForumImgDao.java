package com.happymama.be.dao;

import com.happymama.be.model.EmployeeCommentImgDO;
import com.happymama.be.model.ForumImgDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by yaoqiang on 2018/8/3.
 */
public interface ForumImgDao {

    @Insert("insert into `forum_img`(`forum_id`,`img`, `created`) " +
            "values(#{forumId}, #{img}, now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addForumCommentImg(ForumImgDO employeeCommentImgDO);


    @Select("select img from `forum_img` where forum_id = #{forumId}")
    List<String> getForumImgByForumId(String forumId);


}
