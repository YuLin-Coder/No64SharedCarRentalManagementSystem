package com.yjkj.framework.rbac.vip.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.vip.model.Vip;

public interface VipDao {

	public List<Vip> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Vip> informationLoadAll(Vip Vip) throws Exception;
	
	public Integer count(Vip Vip) throws Exception;
	
	public Vip informationLoadOne(Vip Vip) throws Exception;
	
	public void informationDelete(Vip Vip) throws Exception;
	
	public void informationAdd(Vip Vip) throws Exception;
	
	public void informationUpdate(Vip Vip) throws Exception;
	
}
