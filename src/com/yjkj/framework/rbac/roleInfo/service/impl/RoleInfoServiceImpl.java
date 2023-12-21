package com.yjkj.framework.rbac.roleInfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.roleInfo.dao.RoleInfoDao;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;
import com.yjkj.framework.rbac.roleInfo.service.inte.RoleInfoService;
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

	@Autowired
	private RoleInfoDao roleInfoDao;
	@Override
	public List<RoleInfo> query() {
		try{
			List<RoleInfo> list = this.roleInfoDao.query();
			return list;
		}catch (Exception e) {
			throw new RuntimeException("暂时没有角色");
		}
	}
	@Override
	public Pager QueryAll(Pager pager) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		List<RoleInfo> list = this.roleInfoDao.QueryAll(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有角色");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount());
		return pager;
	}
	@Override
	public Integer queryCount() {
		Integer count = this.roleInfoDao.queryCount();
		return count;
	}
	@Override
	public RoleInfo queryOne(String id) {
		RoleInfo roleInfo = new RoleInfo();
		try{
			roleInfo = this.roleInfoDao.queryOne(id);
		}catch (Exception e) {
			throw new RuntimeException("并没有该角色");
		}
		return roleInfo;
	}
	@Override
	public void roleAdd(String id, String title, String name, String createDate, String remark, String flag) {
		try{
			this.roleInfoDao.roleAdd(id, title,name,createDate,remark,flag);
		}catch (Exception e) {
			throw new RuntimeException("添加失败,原因为:"+e.getMessage());
		}
		
	}
	@Override
	public void roleUpdate(String id, String title, String name, String createDate, String remark, String flag) {
		try{
			this.roleInfoDao.roleUpdate(id, title,name,createDate,remark,flag);
		}catch (Exception e) {
			throw new RuntimeException("修改失败,原因为:"+e.getMessage());
		}
		
	}
	@Override
	public void roleDelete(String id) {
		try{
			this.roleInfoDao.roleDelete(id);
		}catch (Exception e) {
			throw new RuntimeException("删除失败,原因为:"+e.getMessage());
		}
		
	}

}
