package com.yaohoo.be.dao.mapper.write;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import entity.ClassDO;

public interface ClassMapper {
	
	@Insert("insert into class_subject(`subject`,`created`,`updated`) values(#{subject},#{created},#{created})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID() as cId", keyProperty = "cId", before = false, resultType = Integer.class)
	public void addClassSubject(ClassDO classDO);
	
	@Insert("insert into class_content(`c_id`,`content`) values(#{cId},#{content})")
	public void addClassContent(ClassDO classDO);

	@Delete("delete from class_subject where id = #{id}")
	public void delClassSubject(int id);
	
	@Delete("delete from class_content where c_id = #{cId}")
	public void delClassContent(int aId);
	
	@Update("update class_subject set subject = #{subject} where id = #{id}")
	public void updateClassSubject(@Param("subject")String subject,@Param("id")int id);
	
	@Update("update class_content set content = #{content} where c_id = #{cId}")
	public void updateClassContent(@Param("content")String content,@Param("cId")int cId);

	@Update("update class_subject set type = 1 where id = #{cId}")
	public void upClass(int cId);

	@Update("update class_subject set type = 0 where id = #{cId}")
	public void downClass(int cId);

	@Update("update class_subject set status = 0 where id = #{cId}")
	public void onlineClass(int cId);
	
	@Update("update class_subject set status = 1 where id = #{cId}")
	public void offlineClass(int cId);


}
