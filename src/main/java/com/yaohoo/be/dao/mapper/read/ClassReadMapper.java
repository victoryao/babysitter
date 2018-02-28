package com.yaohoo.be.dao.mapper.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import entity.ClassDO;

public interface ClassReadMapper {
	
	@Select("select id,subject,status,type,updated,created from class_subject  order by updated desc limit #{offset},#{limit}")
	public List<ClassDO> getClassSubjectList(@Param("offset") int offset,@Param("limit") int limit);
	
	@Select("select c_id,content from class_content where c_id = #{cId}")
	public ClassDO getClassContent(@Param("cId") int cId);

	@Select("select count(1) from class_content")
	public long countClass();

	@Select("select id,subject,status,type,updated,created from class_subject where status=0 order by type desc, updated desc limit #{offset},#{limit}")
	public List<ClassDO> getClientClassSubjectList(@Param("offset") int offset,@Param("limit") int limit);

	

}
