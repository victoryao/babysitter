package com.yaohoo.be.dao.mapper.read;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import entity.User;

public interface UserReadMapper {
	
	@Select("select id,name,password,phone from user where id = #{id}")
	public User getUserById(@Param("id") int id);

	@Select("select id,name,password,phone from user where name = #{name} and password = #{password}")
	public User getUserByName(@Param("name") String name,@Param("password") String password);

}
