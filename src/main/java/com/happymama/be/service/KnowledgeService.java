package com.happymama.be.service;

import com.happymama.be.dao.KnowledgeDao;
import com.happymama.be.model.KnowledgeDO;
import com.happymama.be.utils.QueryResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/6/22.
 */
@Service
public class KnowledgeService {

    @Resource
    private KnowledgeDao knowledgeDao;

    public QueryResult<KnowledgeDO> getKnowledgeList(int firstResult, int maxresult) {
        QueryResult<KnowledgeDO> qr = new QueryResult<>();
        List<KnowledgeDO> list = knowledgeDao.getKnowledgeList(firstResult, maxresult);
        long count = getKnowledgeCount();
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }


    private long getKnowledgeCount() {
        return knowledgeDao.getKnowledgeCount();
    }


    public KnowledgeDO getKnowledgeById(int id) {
        return knowledgeDao.getKnowledgeById(id);
    }
}
