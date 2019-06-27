package com.happymama.be.service;

import com.google.common.collect.Lists;
import com.happymama.be.dao.KnowledgeDao;
import com.happymama.be.model.KnowledgeDO;
import com.happymama.be.utils.QueryResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yaoqiang on 2018/6/22.
 */
@Service
public class KnowledgeService {

    @Resource
    private KnowledgeDao knowledgeDao;

    public QueryResult<KnowledgeDO> getKnowledgeListByParentId(int parentId, int firstResult, int maxresult) {
        QueryResult<KnowledgeDO> qr = new QueryResult<>();
        List<KnowledgeDO> list = knowledgeDao.getKnowledgeListByParentId(parentId, firstResult, maxresult);
        long count = getKnowledgeCountByParentId(parentId);
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }


    private long getKnowledgeCountByParentId(int parentId) {
        return knowledgeDao.getKnowledgeCount(parentId);
    }


    public List<Integer> queryKnowledgeByTitle(String text) {
        return knowledgeDao.queryKnowledgeByTitle(text);
    }

    public List<Integer> queryKnowledgeByContent(String text) {
        return knowledgeDao.queryKnowledgeByContent(text);
    }

    public QueryResult<KnowledgeDO> queryKnowledge(String text) {
        QueryResult<KnowledgeDO> qr = new QueryResult<>();
        List<KnowledgeDO> knowledgeDOList = Lists.newArrayList();
        List<Integer> list = queryKnowledgeByTitle(text);
        list.addAll(queryKnowledgeByContent(text));
        Set<Integer> set = new HashSet<>(list);
        for (int id : set) {
            knowledgeDOList.add(knowledgeDao.getKnowledgeById(id));
        }
        qr.setResultlist(knowledgeDOList);
        qr.setTotalrecord(set.size());
        return qr;
    }

    public KnowledgeDO getKnowledgeById(int id) {
        return knowledgeDao.getKnowledgeById(id);
    }
}
