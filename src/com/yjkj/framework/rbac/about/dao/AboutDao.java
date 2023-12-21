package com.yjkj.framework.rbac.about.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.about.model.About;

public interface AboutDao {

	public List<About> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<About> informationLoadAll(About About) throws Exception;
	
	public Integer count(About About) throws Exception;
	
	public About informationLoadOne(About About) throws Exception;
	
	public void informationDelete(About About) throws Exception;
	
	public void informationAdd(About About) throws Exception;
	
	public void informationUpdate(About About) throws Exception;
	
}
