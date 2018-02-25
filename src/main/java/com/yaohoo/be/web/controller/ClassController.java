package com.yaohoo.be.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaohoo.be.constant.Constant;
import com.yaohoo.be.dao.entity.ClassDO;
import com.yaohoo.be.dao.service.ClassManager;
import com.yaohoo.be.utils.PageView;
import com.yaohoo.be.utils.QueryResult;

@Controller
public class ClassController extends BaseController{

	@Resource
	private ClassManager classManager;
	
	private int pageSize = Constant.pageSize;

	@RequestMapping(value = "/class/add", method = RequestMethod.POST)
	public Object getClass(@RequestParam(required = true) String subject,
			@RequestParam(required = true) String content

	) {
		ClassDO ad = new ClassDO(subject, content);
		classManager.addClass(ad);
		return "/class/addClass";

	}

	@RequestMapping(value = "/class/subject/list", method = RequestMethod.GET)
	public Object getClassSujectList(
			@RequestParam(required = false, defaultValue = "10") int limit,
			@RequestParam(required = false, defaultValue = "1") int page,
			ModelMap modelMap

	) {
		if (limit > 100) {
			limit = pageSize;
		}
		PageView<ClassDO> pageView = new PageView<ClassDO>(limit, page);
		QueryResult<ClassDO> qr = classManager.getClassSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView", pageView);	
		modelMap.addAttribute("highLightDiv", "class");
		return "/class/classList";

	}

	@RequestMapping(value = "/class/{cId}/del", method = RequestMethod.GET)
	public String delClass(@PathVariable int cId, ModelMap modelMap

	) {
		classManager.delClass(cId);
		PageView<ClassDO> pageView = new PageView<ClassDO>(pageSize, 1);
		QueryResult<ClassDO> qr = classManager.getClassSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/class/classList";
	}
	
	/**
	 * 置顶
	 * @param cId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/class/{cId}/up", method = RequestMethod.GET)
	public String upClass(@PathVariable int cId, ModelMap modelMap

	) {
		classManager.upClass(cId);
		PageView<ClassDO> pageView = new PageView<ClassDO>(pageSize, 1);
		QueryResult<ClassDO> qr = classManager.getClassSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/class/classList";
	}
	
	/**
	 * 取消置顶
	 * @param cId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/class/{cId}/down", method = RequestMethod.GET)
	public String downClass(@PathVariable int cId, ModelMap modelMap

	) {
		classManager.downClass(cId);
		PageView<ClassDO> pageView = new PageView<ClassDO>(pageSize, 1);
		QueryResult<ClassDO> qr = classManager.getClassSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/class/classList";
	}
	
	/**
	 * 上线
	 * @param cId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/class/{cId}/online", method = RequestMethod.GET)
	public String onlineClass(@PathVariable int cId, ModelMap modelMap

	) {
		classManager.onlineClass(cId);
		PageView<ClassDO> pageView = new PageView<ClassDO>(pageSize, 1);
		QueryResult<ClassDO> qr = classManager.getClassSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/class/classList";
	}
	
	/**
	 * 下线
	 * @param cId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/class/{cId}/offline", method = RequestMethod.GET)
	public String offlineClass(@PathVariable int cId, ModelMap modelMap

	) {
		classManager.offlineClass(cId);
		PageView<ClassDO> pageView = new PageView<ClassDO>(pageSize, 1);
		QueryResult<ClassDO> qr = classManager.getClassSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/class/classList";
	}

	@RequestMapping(value = "/class/update", method = RequestMethod.POST)
	public String updateClass(
			@RequestParam(required = true) int cId,
			@RequestParam(required = true) String subject,
			@RequestParam(required = false, defaultValue = "") String content, 
			ModelMap modelMap

	) {
		classManager.updateClass(cId, subject, content);
		PageView<ClassDO> pageView = new PageView<ClassDO>(pageSize, 1);
		QueryResult<ClassDO> qr = classManager.getClassSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/class/classList";
	}

}
