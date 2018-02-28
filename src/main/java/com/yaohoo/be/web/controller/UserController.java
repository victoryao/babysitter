package com.yaohoo.be.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaohoo.be.constant.Constant;
import entity.User;
import com.yaohoo.be.service.UserManager;
import com.yaohoo.be.utils.MD5Utils;
@Controller
public class UserController {
	
	@Resource
	private UserManager userManager;
	
	@RequestMapping("/user/register")
	public String addUser(@RequestParam(required = false) String name,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) String phone){
		User user = new User(name,password,phone);
		userManager.addUser(user);
		return "ok";
	}
	
	@RequestMapping("/user/login")
	public String addUser(@RequestParam(required = true) String userName,
			@RequestParam(required = true) String password,HttpSession httpSession){
		password = MD5Utils.getMD5(password);
		User user = userManager.getUserByName(userName, password);
		if(user != null){
			httpSession.setAttribute(Constant.sessionCheckKey, user.getName());
			return "main";
		}
		return "login";
	}
	
	@RequestMapping("/world")
    public String helloworld (HttpServletRequest request,
            HttpServletResponse response, ModelMap modelMap) {
		modelMap.addAttribute("username","李四");
        return "world";
    }

}
