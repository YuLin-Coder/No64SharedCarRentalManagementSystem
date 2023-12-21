package com.yjkj.framework.rbac.roleInfo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;


public interface RoleInfoDao {

	public RoleInfo queryOne(@Param("id")String id);
	
	public List<RoleInfo> query();
	
	public List<RoleInfo> QueryAll(Map<String,Object> map);
	
	public Integer queryCount();
	
	public void roleAdd(@Param("id")String id,
							@Param("title")String title,
							@Param("name")String name,
							@Param("createDate")String createDate,
							@Param("remark")String remark,
							@Param("flag")String flag);
	
	public void roleUpdate(@Param("id")String id,
								@Param("title")String title,
								@Param("name")String name,
								@Param("createDate")String createDate,
								@Param("remark")String remark,
								@Param("flag")String flag);
	
	public void roleDelete(@Param("id")String id);
	
}
