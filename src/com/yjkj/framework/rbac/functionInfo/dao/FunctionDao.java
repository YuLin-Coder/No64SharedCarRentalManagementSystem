package com.yjkj.framework.rbac.functionInfo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjkj.framework.rbac.functionInfo.model.FunctionInfo;



public interface FunctionDao {

	public List<FunctionInfo> QueryAll(Map<String,Object> map);
	
	public List<FunctionInfo> query();
	
	public Integer queryCount();
	
	public FunctionInfo queryOne(@Param("id")String id);
	
	public void functionAdd(@Param("id")String id,
							@Param("title")String title,
							@Param("name")String name,
							@Param("url")String url,
							@Param("remark")String remark,
							@Param("flag")String flag);
	
	public void functionUpdate(@Param("id")String id,
								@Param("title")String title,
								@Param("name")String name,
								@Param("url")String url,
								@Param("remark")String remark,
								@Param("flag")String flag);
	
	public void functionDelete(@Param("id")String id);
	
}
