package com.yaohoo.be.dao.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaohoo.be.dao.entity.ClassDO;
import com.yaohoo.be.dao.mapper.read.ClassReadMapper;
import com.yaohoo.be.dao.mapper.write.ClassMapper;
import com.yaohoo.be.utils.QueryResult;

@Service
public class ClassManager {
	
	@Resource
	private ClassMapper classMappper;
	@Resource
	private ClassReadMapper classReadMapper;
	
	@Transactional
	public void addClass(ClassDO classDO){
		classMappper.addClassSubject(classDO);
		classMappper.addClassContent(classDO);
	}
	
	@Transactional
	public QueryResult<ClassDO> getClassSubjectList(int offset,int limit){
		QueryResult<ClassDO> qr = new QueryResult<ClassDO>();
		List<ClassDO> list = classReadMapper.getClassSubjectList(offset,limit);
		long totalrecord = countClass();
		qr.setResultlist(list);
		qr.setTotalrecord(totalrecord);
		return qr;
	}
	
	public List<ClassDO> getClientClassSubjectList(int offset,int limit) {
		List<ClassDO> list = classReadMapper.getClientClassSubjectList(offset,limit);
		return list;
	}
	
	public long countClass(){
		return classReadMapper.countClass();
	}
	
	@Transactional
	public void delClass(int cId){
		classMappper.delClassSubject(cId);
		classMappper.delClassContent(cId);
	}
	
	@Transactional
	public void updateClass(int cId,String subject,String content){
		classMappper.updateClassSubject(subject,cId);
		classMappper.updateClassContent(content,cId);
	}

	public ClassDO getClassContent(int cId) {
		return classReadMapper.getClassContent(cId);
		
	}

	public void upClass(int cId) {
		classMappper.upClass(cId);
		
	}

	public void downClass(int aId) {
		classMappper.downClass(aId);
		
	}

	public void onlineClass(int aId) {
		classMappper.onlineClass(aId);
		
	}
	
	public void offlineClass(int aId) {
		classMappper.offlineClass(aId);
		
	}

	

}
