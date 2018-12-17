package com.happymama.be.service;

import com.happymama.be.dao.ActivityJoinDao;
import com.happymama.be.model.ActivityJoinDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yaoqiang on 2018/12/17.
 */
@Service
public class ActivityJoinService {

    @Resource
    private ActivityJoinDao activityJoinDao;

    public boolean addActivityJoin(ActivityJoinDO activityJoinDO) {
        return isActivityJoiner(activityJoinDO) || activityJoinDao.addActivityJoin(activityJoinDO);
    }

    public List<Integer> getActivityJoinerList(int activityId) {
        return activityJoinDao.getActivityJoinerList(activityId);
    }

    public boolean isActivityJoiner(ActivityJoinDO activityJoinDO) {
        return activityJoinDao.getActivityJoinerByUid(activityJoinDO) != null;
    }
}
