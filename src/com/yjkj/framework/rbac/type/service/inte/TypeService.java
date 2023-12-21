package com.yjkj.framework.rbac.type.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.type.model.Type;

public interface TypeService {

	public Pager informationLoad(Pager pager,Type Type,HttpSession session) throws Exception;
	
	public List<Type> informationLoadAll(Type Type) throws Exception;
	
	public Integer count(Type Type) throws Exception;
	
	public Type informationLoadOne(Type Type) throws Exception;
	
	public void informationDelete(Type Type) throws Exception;
	
	public void informationAdd(Type Type) throws Exception;
	
	public void informationUpade(Type Type) throws Exception;
	
}
