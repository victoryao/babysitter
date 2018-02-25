package com.yaohoo.be.dao.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaohoo.be.dao.entity.User;
import com.yaohoo.be.dao.mapper.read.UserReadMapper;
import com.yaohoo.be.dao.mapper.write.UserMapper;

import javax.annotation.Resource;

@Service
public class UserManager {

	@Resource
	private UserMapper userMapper;
	@Resource
	private UserReadMapper userReadMapper;
	
	@Transactional
	public void addUser(User user){
		userMapper.addUser(user.getName(), user.getPassword(), user.getPhone());
	}
	
	public User getUserById(int id){
		return userReadMapper.getUserById(id);
	}

	public User getUserByName(String userName,String password) {
		return userReadMapper.getUserByName(userName,password);
	}
}
