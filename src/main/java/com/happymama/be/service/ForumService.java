package com.happymama.be.service;

import com.happymama.be.dao.ForumDao;
import com.happymama.be.model.CustomerDO;
import com.happymama.be.model.ForumCommentDO;
import com.happymama.be.model.ForumDO;
import com.happymama.be.utils.QueryResult;
import com.happymama.be.utils.Utils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/7/4.
 */
@Service
public class ForumService {

    @Resource
    private ForumDao forumDao;
    @Resource
    private CustomerService customerService;

    public QueryResult<ForumDO> getForumListByTopicId(int topicId, int firstResult, int maxresult) {
        QueryResult<ForumDO> qr = new QueryResult<>();
        List<ForumDO> list = forumDao.getForumListByTopicId(topicId, firstResult, maxresult);
        long count = getForumCountByTopicId(topicId);
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }

    public QueryResult<ForumCommentDO> getCommentListByForumId(int forumId, int firstResult, int maxresult) {
        QueryResult<ForumCommentDO> qr = new QueryResult<>();
        List<ForumCommentDO> list = forumDao.getCommentListByForumId(forumId, firstResult, maxresult);
        if (CollectionUtils.isNotEmpty(list)) {
            for (ForumCommentDO forumCommentDO : list) {
                CustomerDO customerDO = customerService.getCustomerById(forumCommentDO.getUserId());
                if (customerDO != null) {
                    forumCommentDO.setUserName(Utils.secureName(customerDO.getName()));
                }
            }
        }
        long count = getCommentCountByForumId(forumId);
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }

    private long getCommentCountByForumId(int forumId) {
        return forumDao.getCommentCountByForumId(forumId);
    }

    private long getForumCountByTopicId(int topicId) {
        return forumDao.getForumCountByTopicId(topicId);
    }

    public boolean addForum(ForumDO forumDO) {
        return forumDao.addForum(forumDO);
    }


    public ForumDO getForumById(int id) {
        return forumDao.getForumById(id);
    }

    public boolean addForumComment(ForumCommentDO build) {
        return forumDao.addForumComment(build);
    }
}
