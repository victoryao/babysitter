package com.yaohoo.be.dao.mapper.write;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import entity.InfoDO;

public interface InfoMapper {
	
	@Insert("insert into info_subject(`subject`,`created`,`updated`) values(#{subject},#{created},#{created})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID() as iId", keyProperty = "iId", before = false, resultType = Integer.class)
	public void addInfoSubject(InfoDO infoDO);
	
	@Insert("insert into info_content(`i_id`,`content`) values(#{iId},#{content})")
	public void addInfoContent(InfoDO infoDO);

	@Delete("delete from info_subject where id = #{id}")
	public void delInfoSubject(int id);
	
	@Delete("delete from info_content where i_id = #{iId}")
	public void delInfoContent(int iId);
	
	@Update("update info_subject set subject = #{subject} where id = #{id}")
	public void updateInfoSubject(@Param("subject")String subject,@Param("id")int id);
	
	@Update("update info_content set content = #{content} where i_id = #{iId}")
	public void updateInfoContent(@Param("content")String content,@Param("iId")int iId);

	@Update("update info_subject set type = 1 where id = #{iId}")
	public void upInfo(int iId);

	@Update("update info_subject set type = 0 where id = #{iId}")
	public void downInfo(int iId);

	@Update("update info_subject set status = 0 where id = #{iId}")
	public void onlineInfo(int iId);
	
	@Update("update info_subject set status = 1 where id = #{iId}")
	public void offlineInfo(int iId);


}
