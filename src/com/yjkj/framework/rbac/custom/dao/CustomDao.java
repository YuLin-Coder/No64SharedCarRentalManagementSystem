package com.yjkj.framework.rbac.custom.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.custom.model.Custom;

public interface CustomDao {

	public List<Custom> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Custom> informationLoadAll(Custom Custom) throws Exception;
	
	public Integer count(Custom Custom) throws Exception;
	
	public Custom informationLoadOne(Custom Custom) throws Exception;
	
	public Custom informationLoadOneUser(Custom Custom) throws Exception;
	
	public void informationDelete(Custom Custom) throws Exception;
	
	public void informationAdd(Custom Custom) throws Exception;
	
	public void informationUpdate(Custom Custom) throws Exception;
	
}
