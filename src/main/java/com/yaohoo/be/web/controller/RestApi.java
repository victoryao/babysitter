package com.yaohoo.be.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaohoo.be.dao.entity.User;

@RestController
public class RestApi {

	@RequestMapping("/get")
	public User getUser() {
		return new User("1", "3", "4");
	}

}
