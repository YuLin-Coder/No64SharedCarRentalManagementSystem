package com.yjkj.framework.rbac.functionInfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.functionInfo.dao.FunctionDao;
import com.yjkj.framework.rbac.functionInfo.model.FunctionInfo;
import com.yjkj.framework.rbac.functionInfo.service.inte.FunctionService;

@Service
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	private FunctionDao functionDao;
	@Override
	public FunctionInfo queryOne(String id) {
		FunctionInfo functionInfo = new FunctionInfo();
		try{
			functionInfo = this.functionDao.queryOne(id);
		}catch (Exception e) {
			throw new RuntimeException("并没有该权限");
		}
		return functionInfo;
	}

	@Override
	public void functionAdd(String id, String title, String name, String url, String remark, String flag) {
		try{
			this.functionDao.functionAdd(id, title,name,url,remark,flag);
		}catch (Exception e) {
			throw new RuntimeException("添加失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void functionUpdate(String id, String title, String name, String url, String remark, String flag) {
		try{
			this.functionDao.functionUpdate(id, title,name,url,remark,flag);
		}catch (Exception e) {
			throw new RuntimeException("修改失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void functionDelete(String id) {
		try{
			this.functionDao.functionDelete(id);
		}catch (Exception e) {
			throw new RuntimeException("删除失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public Pager QueryAll(Pager pager) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		List<FunctionInfo> list = this.functionDao.QueryAll(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有权限");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount());
		return pager;
	}

	@Override
	public Integer queryCount() {
		Integer count = this.functionDao.queryCount();
		return count;
	}

	@Override
	public List<FunctionInfo> query() {
		try{
			List<FunctionInfo> list = this.functionDao.query();
			return list;
		}catch (Exception e) {
			throw new RuntimeException("暂时没有权限");
		}
	}

}
