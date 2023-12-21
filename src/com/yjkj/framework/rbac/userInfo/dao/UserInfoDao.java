package com.yjkj.framework.rbac.userInfo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjkj.framework.rbac.userInfo.model.UserInfo;



public interface UserInfoDao {

	public UserInfo loginUser(@Param("loginName")String loginName,@Param("loginPassword")String loginPassword);
	
	public UserInfo queryOne(@Param("id")String id);
	
	public List<UserInfo> queryAll();
	
	public UserInfo queryRole(@Param("roleId")String roleId);
	
	public List<UserInfo> Query(Map<String,Object> map);
	
	public void userDelete(@Param("id")String id);
	
	public Integer queryCount();
	
	public void userAdd(
					@Param("id")String id,
					@Param("loginName")String loginName,
					@Param("loginPassword")String loginPassword,
					@Param("userName")String userName,
					@Param("roleId")String roleId,
					@Param("phoneNo")String phoneNo,
					@Param("selfId")String selfId,
					@Param("recommendId")String recommendId,
					@Param("remark")String remark,
					@Param("createDate")String createDate,
					@Param("flag")String flag);
	public void userUpdate(
					@Param("id")String id,
					@Param("loginName")String loginName,
					@Param("loginPassword")String loginPassword,
					@Param("userName")String userName,
					@Param("roleId")String roleId,
					@Param("phoneNo")String phoneNo,
					@Param("selfId")String selfId,
					@Param("recommendId")String recommendId,
					@Param("remark")String remark,
					@Param("createDate")String createDate,
					@Param("flag")String flag);
	
}
