package com.yaohoo.be.dao.mapper.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yaohoo.be.dao.entity.InfoDO;

public interface InfoReadMapper {
	
	@Select("select id,subject,status,type,updated,created from info_subject  order by updated desc limit #{offset},#{limit}")
	public List<InfoDO> getInfoSubjectList(@Param("offset") int offset,@Param("limit") int limit);
	
	@Select("select id,subject,status,type,updated,created from info_subject where status=0 order by type desc, updated desc limit #{offset},#{limit}")
	public List<InfoDO> getClientInfoSubjectList(@Param("offset") int offset,@Param("limit") int limit);
	
	@Select("select i_id,content from info_content where i_id = #{iId}")
	public InfoDO getInfoContent(@Param("iId") int iId);

	@Select("select count(1) from info_content")
	public long countInfo();

}
