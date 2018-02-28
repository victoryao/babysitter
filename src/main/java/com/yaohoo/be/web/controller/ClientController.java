package com.yaohoo.be.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yaohoo.be.constant.Constant;
import entity.ActivityDO;
import entity.ClassDO;
import entity.InfoDO;
import com.yaohoo.be.service.ActivityManager;
import com.yaohoo.be.service.ClassManager;
import com.yaohoo.be.service.InfoManager;
import com.yaohoo.be.utils.PageView;

@RestController
public class ClientController {
	
	@Resource
	private InfoManager infoManager;
	@Resource
	private ClassManager classManager;
	@Resource
	private ActivityManager activityManager;
	
	private int pageSize = Constant.clientPageSize;
	
	@RequestMapping(value = "/api/info/subject/list", method = RequestMethod.POST)
	public List<InfoDO> getInfoSujectList(
			@RequestParam(required = false, defaultValue = "10") int limit,
			@RequestParam(required = false, defaultValue = "1") int page

	) {
		if (limit > 100) {
			limit = pageSize;
		}
		PageView<InfoDO> pageView = new PageView<InfoDO>(limit, page);
		List<InfoDO> infoList = infoManager.getClientInfoSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		return infoList;
	}
	
	@RequestMapping(value = "/api/class/subject/list", method = RequestMethod.POST)
	public List<ClassDO> getClassSujectList(
			@RequestParam(required = false, defaultValue = "10") int limit,
			@RequestParam(required = false, defaultValue = "1") int page

	) {
		if (limit > 100) {
			limit = pageSize;
		}
		PageView<InfoDO> pageView = new PageView<InfoDO>(limit, page);
		List<ClassDO> classList = classManager.getClientClassSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		return classList;
	}
	
	@RequestMapping(value = "/api/activity/subject/list", method = RequestMethod.POST)
	public List<ActivityDO> getActivitySujectList(
			@RequestParam(required = false, defaultValue = "10") int limit,
			@RequestParam(required = false, defaultValue = "1") int page

	) {
		if (limit > 100) {
			limit = pageSize;
		}
		PageView<InfoDO> pageView = new PageView<InfoDO>(limit, page);
		List<ActivityDO> activityList = activityManager.getActivitySujectList(pageView.getFirstResult(),pageView.getMaxresult());
		return activityList;
	}
	
	

}
