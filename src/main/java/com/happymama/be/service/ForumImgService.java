package com.happymama.be.service;

import com.happymama.be.dao.ForumImgDao;
import com.happymama.be.model.ForumImgDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/8/3.
 */
@Service
public class ForumImgService {

    @Resource
    private ForumImgDao forumImgDao;

    public boolean addForumCommentImg(ForumImgDO forumImgDO) {
        return forumImgDao.addForumCommentImg(forumImgDO);
    }

    public List<String> getForumImgByForumId(String forumId) {
        return forumImgDao.getForumImgByForumId(forumId);
    }

}
