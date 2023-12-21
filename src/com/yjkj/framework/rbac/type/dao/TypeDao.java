package com.yjkj.framework.rbac.type.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.type.model.Type;

public interface TypeDao {

	public List<Type> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Type> informationLoadAll(Type Type) throws Exception;
	
	public Integer count(Type Type) throws Exception;
	
	public Type informationLoadOne(Type Type) throws Exception;
	
	public void informationDelete(Type Type) throws Exception;
	
	public void informationAdd(Type Type) throws Exception;
	
	public void informationUpdate(Type Type) throws Exception;
	
}
