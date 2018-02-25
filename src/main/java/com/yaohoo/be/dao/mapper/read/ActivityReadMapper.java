package com.yaohoo.be.dao.mapper.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yaohoo.be.dao.entity.ActivityDO;

public interface ActivityReadMapper {
	
	@Select("select id,subject,status,type,updated,created from activity_subject  order by updated desc limit #{offset},#{limit}")
	public List<ActivityDO> getActivitySubjectList(@Param("offset") int offset,@Param("limit") int limit);
	
	@Select("select a_id,content from activity_content where a_id = #{aId}")
	public ActivityDO getActivityContent(@Param("aId") int aId);

	@Select("select count(1) from activity_content")
	public long countActivity();

	@Select("select id,subject,status,type,updated,created from activity_subject where status=0 order by type desc, updated desc limit #{offset},#{limit}")
	public List<ActivityDO> getClientActivitySubjectList(@Param("offset") int offset,@Param("limit") int limit);

	

}
