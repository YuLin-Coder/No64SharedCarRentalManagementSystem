package com.yjkj.framework.rbac.functionRoleInfo.service.inte;

import java.util.List;

import com.yjkj.framework.rbac.functionRoleInfo.model.FunctionRoleRel;



public interface FunctionRoleService {

public List<FunctionRoleRel> query();
	
public List<FunctionRoleRel> queryOne(String id);

	public void functionRoleAdd(String id,
								String functionId,
								String roleId,
								String createDate,
								String flag);
	
	public void roleIdDelete(String roleId);
	
}
