package com.happymama.be.service;

import com.happymama.be.dao.TopicDao;
import com.happymama.be.model.TopicDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/7/27.
 */
@Service
public class TopicService {

    @Resource
    private TopicDao topicDao;

    public List<TopicDO> getTopicListByParentId(int parentId) {
        return topicDao.getTopicListByParentId(parentId);
    }
}
