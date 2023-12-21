package com.yjkj.framework.rbac.userInfo.model;

import java.util.List;

import com.yjkj.framework.rbac.functionRoleInfo.model.FunctionRoleRel;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;



public class UserInfo {

	private String id;
	private String loginName;
	private String loginPassword;
	private String userName;
	private String roleId;
	private String phoneNo;
	private String selfId;
	private String recommendId;
	private String remark;
	private String createDate;
	private String flag;
	private RoleInfo roleInfo;
	private List<FunctionRoleRel> functionRoleRel;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getSelfId() {
		return selfId;
	}
	public void setSelfId(String selfId) {
		this.selfId = selfId;
	}
	public String getRecommendId() {
		return recommendId;
	}
	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public List<FunctionRoleRel> getFunctionRoleRel() {
		return functionRoleRel;
	}
	public void setFunctionRoleRel(List<FunctionRoleRel> functionRoleRel) {
		this.functionRoleRel = functionRoleRel;
	}
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	
	
	
}
