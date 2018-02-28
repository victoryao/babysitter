package com.yaohoo.be.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.InfoDO;
import com.yaohoo.be.dao.mapper.read.InfoReadMapper;
import com.yaohoo.be.dao.mapper.write.InfoMapper;
import com.yaohoo.be.utils.QueryResult;

@Service
public class InfoManager {
	
	@Resource
	private InfoMapper infoMappper;
	@Resource
	private InfoReadMapper infoReadMapper;
	
	@Transactional
	public void addInfo(InfoDO InfoDO){
		infoMappper.addInfoSubject(InfoDO);
		infoMappper.addInfoContent(InfoDO);
	}
	
	@Transactional
	public QueryResult<InfoDO> getInfoSubjectList(int offset,int limit){
		QueryResult<InfoDO> qr = new QueryResult<InfoDO>();
		List<InfoDO> list = infoReadMapper.getInfoSubjectList(offset,limit);
		long totalrecord = countInfo();
		qr.setResultlist(list);
		qr.setTotalrecord(totalrecord);
		return qr;
	}
	

	public List<InfoDO> getClientInfoSubjectList(int offset,int limit){
		return infoReadMapper.getClientInfoSubjectList(offset,limit);
	}
	
	public long countInfo(){
		return infoReadMapper.countInfo();
	}
	
	@Transactional
	public void delInfo(int aId){
		infoMappper.delInfoSubject(aId);
		infoMappper.delInfoContent(aId);
	}
	
	@Transactional
	public void updateInfo(int iId,String subject,String content){
		infoMappper.updateInfoSubject(subject,iId);
		infoMappper.updateInfoContent(content,iId);
	}

	public InfoDO getInfoContent(int aId) {
		return infoReadMapper.getInfoContent(aId);
		
	}

	public void upInfo(int aId) {
		infoMappper.upInfo(aId);
		
	}

	public void downInfo(int aId) {
		infoMappper.downInfo(aId);
		
	}

	public void onlineInfo(int aId) {
		infoMappper.onlineInfo(aId);
		
	}
	
	public void offlineInfo(int aId) {
		infoMappper.offlineInfo(aId);
		
	}

}
