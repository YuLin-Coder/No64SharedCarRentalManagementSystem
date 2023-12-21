package com.yjkj.framework.rbac.introduce.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.introduce.model.Introduce;

public interface IntroduceDao {

	public List<Introduce> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Introduce> informationLoadAll(Introduce Introduce) throws Exception;
	
	public Integer count(Introduce Introduce) throws Exception;
	
	public Introduce informationLoadOne(Introduce Introduce) throws Exception;
	
	public void informationDelete(Introduce Introduce) throws Exception;
	
	public void informationAdd(Introduce Introduce) throws Exception;
	
	public void informationUpdate(Introduce Introduce) throws Exception;
	
}
