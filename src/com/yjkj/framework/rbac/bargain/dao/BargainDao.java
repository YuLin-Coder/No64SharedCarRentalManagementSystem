package com.yjkj.framework.rbac.bargain.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.bargain.model.Bargain;

public interface BargainDao {

	public List<Bargain> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Bargain> informationLoadAll(Bargain Bargain) throws Exception;
	
	public Integer count(Bargain Bargain) throws Exception;
	
	public Bargain informationLoadOne(Bargain Bargain) throws Exception;
	
	public void informationDelete(Bargain Bargain) throws Exception;
	
	public void informationAdd(Bargain Bargain) throws Exception;
	
	public void informationUpdate(Bargain Bargain) throws Exception;
	
}
