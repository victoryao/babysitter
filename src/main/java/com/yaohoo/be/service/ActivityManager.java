package com.yaohoo.be.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.ActivityDO;
import com.yaohoo.be.dao.mapper.read.ActivityReadMapper;
import com.yaohoo.be.dao.mapper.write.ActivityMapper;
import com.yaohoo.be.utils.QueryResult;

@Service
public class ActivityManager {
	
	@Resource
	private ActivityMapper activityMappper;
	@Resource
	private ActivityReadMapper activityReadMapper;
	
	@Transactional
	public void addActivity(ActivityDO activityDO){
		activityMappper.addActivitySubject(activityDO);
		activityMappper.addActivityContent(activityDO);
	}
	
	@Transactional
	public QueryResult<ActivityDO> getActivitySubjectList(int offset,int limit){
		QueryResult<ActivityDO> qr = new QueryResult<ActivityDO>();
		List<ActivityDO> list = activityReadMapper.getActivitySubjectList(offset,limit);
		long totalrecord = countActivity();
		qr.setResultlist(list);
		qr.setTotalrecord(totalrecord);
		return qr;
	}
	
	public List<ActivityDO> getActivitySujectList(int offset,int limit) {
		List<ActivityDO> list = activityReadMapper.getClientActivitySubjectList(offset,limit);
		return list;
	}
	
	public long countActivity(){
		return activityReadMapper.countActivity();
	}
	
	@Transactional
	public void delActivity(int aId){
		activityMappper.delActivitySubject(aId);
		activityMappper.delActivityContent(aId);
	}
	
	@Transactional
	public void updateActivity(int aId,String subject,String content){
		activityMappper.updateActivitySubject(subject,aId);
		activityMappper.updateActivityContent(content,aId);
	}

	public ActivityDO getActivityContent(int aId) {
		return activityReadMapper.getActivityContent(aId);
		
	}

	public void upActivity(int aId) {
		activityMappper.upActivity(aId);
		
	}

	public void downActivity(int aId) {
		activityMappper.downActivity(aId);
		
	}

	public void onlineActivity(int aId) {
		activityMappper.onlineActivity(aId);
		
	}
	
	public void offlineActivity(int aId) {
		activityMappper.offlineActivity(aId);
		
	}

	

}
