package com.yaohoo.be.dao.mapper.write;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	@Insert("insert into user(`name`,`password`,`phone`) values(#{name}, #{password}, #{phone})")
	public void addUser(@Param("name") String name,@Param("password") String password,@Param("phone") String phone);

}
