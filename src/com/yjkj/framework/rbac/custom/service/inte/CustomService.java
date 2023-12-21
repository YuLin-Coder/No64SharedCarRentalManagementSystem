package com.yjkj.framework.rbac.custom.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.custom.model.Custom;

public interface CustomService {

	public Pager informationLoad(Pager pager,Custom Custom,HttpSession session) throws Exception;
	
	public List<Custom> informationLoadAll(Custom Custom) throws Exception;
	
	public Integer count(Custom Custom) throws Exception;
	
	public Custom informationLoadOne(Custom Custom) throws Exception;
	
	public Custom informationLoadOneUser(Custom Custom) throws Exception;
	
	public void informationDelete(Custom Custom) throws Exception;
	
	public void informationAdd(Custom Custom) throws Exception;
	
	public void informationUpade(Custom Custom) throws Exception;
	
}
