package com.yjkj.framework.rbac.functionRoleInfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yjkj.framework.rbac.functionRoleInfo.model.FunctionRoleRel;



public interface FunctionRoleRelDao {

	public List<FunctionRoleRel> query();
	
	public void functionRoleAdd(@Param("id")String id,
			@Param("functionId")String functionId,
			@Param("roleId")String roleId,
			@Param("createDate")String createDate,
			@Param("flag")String flag);
	
	public void roleIdDelete(@Param("roleId")String roleId);
	
	public List<FunctionRoleRel> queryOne(@Param("roleId")String roleId);
}
