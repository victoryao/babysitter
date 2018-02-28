package com.yaohoo.be.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaohoo.be.constant.Constant;
import entity.InfoDO;
import com.yaohoo.be.service.InfoManager;
import com.yaohoo.be.utils.PageView;
import com.yaohoo.be.utils.QueryResult;

@Controller
public class InfoController extends BaseController{

	@Resource
	private InfoManager infoManager;
	
	private int pageSize = Constant.pageSize;

	@RequestMapping(value = "/info/add", method = RequestMethod.POST)
	public Object getInfo(@RequestParam(required = true) String subject,
			@RequestParam(required = true) String content

	) {
		InfoDO id = new InfoDO(subject, content);
		infoManager.addInfo(id);
		return "/info/addInfo";

	}

	@RequestMapping(value = "/info/subject/list", method = RequestMethod.GET)
	public Object getInfoSujectList(
			@RequestParam(required = false, defaultValue = "10") int limit,
			@RequestParam(required = false, defaultValue = "1") int page,
			ModelMap modelMap

	) {
		if (limit > 100) {
			limit = pageSize;
		}
		PageView<InfoDO> pageView = new PageView<InfoDO>(limit, page);
		QueryResult<InfoDO> qr = infoManager.getInfoSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView", pageView);	
		modelMap.addAttribute("highLightDiv", "info");
		return "/info/infoList";

	}

	@RequestMapping(value = "/info/{aId}/del", method = RequestMethod.GET)
	public String delInfo(@PathVariable int aId, ModelMap modelMap

	) {
		infoManager.delInfo(aId);
		PageView<InfoDO> pageView = new PageView<InfoDO>(pageSize, 1);
		QueryResult<InfoDO> qr = infoManager.getInfoSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/info/infoList";
	}
	
	/**
	 * 置顶
	 * @param aId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/info/{iId}/up", method = RequestMethod.GET)
	public String upInfo(@PathVariable int iId, ModelMap modelMap

	) {
		infoManager.upInfo(iId);
		PageView<InfoDO> pageView = new PageView<InfoDO>(pageSize, 1);
		QueryResult<InfoDO> qr = infoManager.getInfoSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/info/infoList";
	}
	
	/**
	 * 取消置顶
	 * @param aId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/info/{aId}/down", method = RequestMethod.GET)
	public String downInfo(@PathVariable int aId, ModelMap modelMap

	) {
		infoManager.downInfo(aId);
		PageView<InfoDO> pageView = new PageView<InfoDO>(pageSize, 1);
		QueryResult<InfoDO> qr = infoManager.getInfoSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/info/infoList";
	}
	
	/**
	 * 上线
	 * @param aId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/info/{iId}/online", method = RequestMethod.GET)
	public String onlineInfo(@PathVariable int iId, ModelMap modelMap

	) {
		infoManager.onlineInfo(iId);
		PageView<InfoDO> pageView = new PageView<InfoDO>(pageSize, 1);
		QueryResult<InfoDO> qr = infoManager.getInfoSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/info/infoList";
	}
	
	/**
	 * 下线
	 * @param aId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/info/{iId}/offline", method = RequestMethod.GET)
	public String offlineInfo(@PathVariable int iId, ModelMap modelMap

	) {
		infoManager.offlineInfo(iId);
		PageView<InfoDO> pageView = new PageView<InfoDO>(pageSize, 1);
		QueryResult<InfoDO> qr = infoManager.getInfoSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/info/infoList";
	}

	@RequestMapping(value = "/info/update", method = RequestMethod.POST)
	public String updateInfo(
			@RequestParam(required = true) int iId,
			@RequestParam(required = true) String subject,
			@RequestParam(required = false, defaultValue = "") String content, 
			ModelMap modelMap

	) {
		infoManager.updateInfo(iId, subject, content);
		PageView<InfoDO> pageView = new PageView<InfoDO>(pageSize, 1);
		QueryResult<InfoDO> qr = infoManager.getInfoSubjectList(pageView.getFirstResult(),pageView.getMaxresult());
		pageView.setQueryResult(qr);
		modelMap.addAttribute("pageView",pageView);
		return "/info/infoList";
	}

}
