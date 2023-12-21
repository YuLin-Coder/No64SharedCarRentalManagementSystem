package com.yjkj.framework.rbac.userInfo.service.inte;

import java.util.List;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

public interface UserInfoService {

	public UserInfo login(String loginName,String loginPassword);
	
	public UserInfo queryOne(String id);
	
	public List<UserInfo> queryAll();

	public UserInfo queryRole(String roleId);
	
	public Pager Query(Pager pager,UserInfo user);
	
	public void userDelete(String id);
	
	public Integer queryCount();
	
	public void userAdd(
				String id,
				String loginName,
				String loginPassword,
				String userName,
				String roleId,
				String phoneNo,
				String selfId,
				String recommendId,
				String remark,
				String createDate,
				String flag);
	
	public void userUpdate(
			String id,
			String loginName,
			String loginPassword,
			String userName,
			String roleId,
			String phoneNo,
			String selfId,
			String recommendId,
			String remark,
			String createDate,
			String flag);
	
}
