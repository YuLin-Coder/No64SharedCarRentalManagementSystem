package com.yjkj.framework.rbac.functionRoleInfo.model;

import com.yjkj.framework.rbac.functionInfo.model.FunctionInfo;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;

public class FunctionRoleRel {

	private String id;
	private String functionId;
	private String roleId;
	private String createDate;
	private String flag;
	private RoleInfo roleInfo;
	private FunctionInfo functionInfo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
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
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	public FunctionInfo getFunctionInfo() {
		return functionInfo;
	}
	public void setFunctionInfo(FunctionInfo functionInfo) {
		this.functionInfo = functionInfo;
	}
	
	
	
	
}
