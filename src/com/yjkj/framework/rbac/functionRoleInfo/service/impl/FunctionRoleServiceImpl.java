package com.yjkj.framework.rbac.functionRoleInfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjkj.framework.rbac.functionRoleInfo.dao.FunctionRoleRelDao;
import com.yjkj.framework.rbac.functionRoleInfo.model.FunctionRoleRel;
import com.yjkj.framework.rbac.functionRoleInfo.service.inte.FunctionRoleService;

@Service
public class FunctionRoleServiceImpl implements FunctionRoleService {

	@Autowired
	private FunctionRoleRelDao functionRoleRelDao;
	@Override
	public List<FunctionRoleRel> query() {
		try{
			List<FunctionRoleRel> list = this.functionRoleRelDao.query();
			return list;
		}catch (Exception e) {
			throw new RuntimeException("查询为空");
		}
	}

	@Override
	public void functionRoleAdd(String id, String functionId, String roleId, String createDate, String flag) {
		try{
			this.functionRoleRelDao.functionRoleAdd(id, functionId, roleId, createDate, flag);
		}catch (Exception e) {
			throw new RuntimeException("添加失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void roleIdDelete(String roleId) {
		try{
			this.functionRoleRelDao.roleIdDelete(roleId);
		}catch (Exception e) {
			throw new RuntimeException("删除失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public List<FunctionRoleRel> queryOne(String id) {
		List<FunctionRoleRel> list = new ArrayList<>();
		try{
			list = this.functionRoleRelDao.queryOne(id);
		}catch (Exception e) {
			throw new RuntimeException("并没有该权限");
		}
		return list;
	}

}
