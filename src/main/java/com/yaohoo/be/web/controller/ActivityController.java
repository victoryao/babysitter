package com.yaohoo.be.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaohoo.be.constant.Constant;
import entity.ActivityDO;
import com.yaohoo.be.service.ActivityManager;
import com.yaohoo.be.utils.PageView;
import com.yaohoo.be.utils.QueryResult;

@Controller
public class ActivityController extends BaseController{

	@Resource
	private ActivityManager activityManager;
	
	private int pageSize = Constant.pageSize;

	@RequestMapping(value = "/activity/add", method = RequestMethod.POST)
	public Object getActivity(@RequestParam(required = true) String subject,
			@RequestParam(required = true) String content

	) {
		ActivityDO ad = new ActivityDO(subject, content);
		activityManager.addActivity(ad);
		return "/activity/addActivity";

	}

	@RequestMapping(value = "/activity/subject/list", method = RequestMethod.GET)
	public Object getActivitySujectList(
			@RequestParam(required = false, defaultValue = "10") int limit,
			@RequestParam(required = false, defaultValue = "1") int page,
			ModelMap modelMap

	) {
		if (limit > 100) {
			limit = pageSize;
		}
		PageView<ActivityDO> pageView = new PageView<ActivityDO>(limit, page);
		QueryResult<ActivityDO> qr = activityManager.getActivitySubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView", pageView);	
		modelMap.addAttribute("highLightDiv", "activity");
		return "/activity/activityList";

	}

	@RequestMapping(value = "/activity/{aId}/del", method = RequestMethod.GET)
	public String delActivity(@PathVariable int aId, ModelMap modelMap

	) {
		activityManager.delActivity(aId);
		PageView<ActivityDO> pageView = new PageView<ActivityDO>(pageSize, 1);
		QueryResult<ActivityDO> qr = activityManager.getActivitySubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/activity/activityList";
	}
	
	/**
	 * 置顶
	 * @param aId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/activity/{aId}/up", method = RequestMethod.GET)
	public String upActivity(@PathVariable int aId, ModelMap modelMap

	) {
		activityManager.upActivity(aId);
		PageView<ActivityDO> pageView = new PageView<ActivityDO>(pageSize, 1);
		QueryResult<ActivityDO> qr = activityManager.getActivitySubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/activity/activityList";
	}
	
	/**
	 * 取消置顶
	 * @param aId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/activity/{aId}/down", method = RequestMethod.GET)
	public String downActivity(@PathVariable int aId, ModelMap modelMap

	) {
		activityManager.downActivity(aId);
		PageView<ActivityDO> pageView = new PageView<ActivityDO>(pageSize, 1);
		QueryResult<ActivityDO> qr = activityManager.getActivitySubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/activity/activityList";
	}
	
	/**
	 * 上线
	 * @param aId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/activity/{aId}/online", method = RequestMethod.GET)
	public String onlineActivity(@PathVariable int aId, ModelMap modelMap

	) {
		activityManager.onlineActivity(aId);
		PageView<ActivityDO> pageView = new PageView<ActivityDO>(pageSize, 1);
		QueryResult<ActivityDO> qr = activityManager.getActivitySubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/activity/activityList";
	}
	
	/**
	 * 下线
	 * @param aId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/activity/{aId}/offline", method = RequestMethod.GET)
	public String offlineActivity(@PathVariable int aId, ModelMap modelMap

	) {
		activityManager.offlineActivity(aId);
		PageView<ActivityDO> pageView = new PageView<ActivityDO>(pageSize, 1);
		QueryResult<ActivityDO> qr = activityManager.getActivitySubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/activity/activityList";
	}

	@RequestMapping(value = "/activity/update", method = RequestMethod.POST)
	public String updateActivity(
			@RequestParam(required = true) int aId,
			@RequestParam(required = true) String subject,
			@RequestParam(required = false, defaultValue = "") String content, 
			ModelMap modelMap

	) {
		activityManager.updateActivity(aId, subject, content);
		PageView<ActivityDO> pageView = new PageView<ActivityDO>(pageSize, 1);
		QueryResult<ActivityDO> qr = activityManager.getActivitySubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/activity/activityList";
	}

}
