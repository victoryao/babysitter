package com.yaohoo.be.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.ActivityDO;
import entity.ClassDO;
import entity.InfoDO;
import com.yaohoo.be.service.ActivityManager;
import com.yaohoo.be.service.ClassManager;
import com.yaohoo.be.service.InfoManager;

@Controller
public class NavController {

	@Resource
	private ActivityManager activityManager;
	@Resource
	private InfoManager infoManager;
	@Resource
	private ClassManager classManager;

	@RequestMapping("/toMain")
	public String toMainPage() {
		return "main";
	}

	@RequestMapping("/app/to/babysitter")
	public String toLoginPage() {
		return "babysitter_form";
	}

	@RequestMapping("/toAddActivity")
	public String toAddActivityPage(ModelMap modelMap) {
		modelMap.addAttribute("highLightDiv", "activity");
		return "/activity/addActivity";
	}

	@RequestMapping("/toAddInfo")
	public String toAddInfoPage(ModelMap modelMap) {
		modelMap.addAttribute("highLightDiv", "info");
		return "/info/addInfo";
	}

	@RequestMapping("/toAddClass")
	public String toAddClassPage(ModelMap modelMap) {
		modelMap.addAttribute("highLightDiv", "class");
		return "/class/addClass";
	}

	@RequestMapping("/toManageActivity")
	public String toManageActivityPage() {
		return "/activity/activityList";
	}

	@RequestMapping("/toManageInfo")
	public String toManageInfoPage() {
		return "/info/infoList";
	}

	@RequestMapping("/toManageClass")
	public String toManageClassPage() {
		return "/class/classList";
	}

	@RequestMapping("/client/main")
	public String toClientMainPage() {
		return "/client/index";
	}

	@RequestMapping("/client/intro")
	public String toClientIntroPage() {
		return "/client/intro";
	}

	@RequestMapping("/client/infos")
	public String toClientInfosPage() {
		return "/client/infos";
	}

	@RequestMapping("/client/classes")
	public String toClientClassesPage() {
		return "/client/classes";
	}

	@RequestMapping("/client/activities")
	public String toClientActivitiesPage() {
		return "/client/activities";
	}

	@RequestMapping("/client/info/content")
	public String toClientInfoContentPage(
			@RequestParam(required = true) int id,
			@RequestParam(required = true) String subject, ModelMap modelMap) {
		InfoDO infoDO = infoManager.getInfoContent(id);
		infoDO.setSubject(subject);
		modelMap.addAttribute("infoDO", infoDO);
		return "/client/info";
	}

	@RequestMapping("/client/class/content")
	public String toClientClassContentPage(
			@RequestParam(required = true) int id,
			@RequestParam(required = true) String subject, ModelMap modelMap) {
		ClassDO classDO = classManager.getClassContent(id);
		classDO.setSubject(subject);
		modelMap.addAttribute("classDO", classDO);
		return "/client/class";
	}

	@RequestMapping("/client/activity/content")
	public String toClientActivityContentPage(
			@RequestParam(required = true) int id,
			@RequestParam(required = true) String subject, ModelMap modelMap) {
		ActivityDO activityDO = activityManager.getActivityContent(id);
		activityDO.setSubject(subject);
		modelMap.addAttribute("activityDO", activityDO);
		return "/client/activity";
	}

	@RequestMapping("/toEditActivity")
	public String toEditActivityPage(@RequestParam(required = true) int aId,
			@RequestParam(required = true) String subject, ModelMap modelMap) {
		ActivityDO activityDO = activityManager.getActivityContent(aId);
		activityDO.setSubject(subject);
		modelMap.addAttribute("activityDO", activityDO);
		return "/activity/editActivity";
	}

	@RequestMapping("/toEditInfo")
	public String toEditInfoPage(@RequestParam(required = true) int iId,
			@RequestParam(required = true) String subject, ModelMap modelMap) {
		InfoDO infoDO = infoManager.getInfoContent(iId);
		infoDO.setSubject(subject);
		modelMap.addAttribute("infoDO", infoDO);
		return "/info/editInfo";
	}

	@RequestMapping("/toEditClass")
	public String toEditClassPage(@RequestParam(required = true) int cId,
			@RequestParam(required = true) String subject, ModelMap modelMap) {
		ClassDO classDO = classManager.getClassContent(cId);
		classDO.setSubject(subject);
		modelMap.addAttribute("classDO", classDO);
		return "/class/editClass";
	}

}
