package com.yjkj.framework.rbac.bargain.service.inte;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.bargain.model.Bargain;

public interface BargainService {

	public Pager informationLoad(Pager pager,Bargain Bargain,HttpSession session) throws Exception;
	
	public List<Bargain> informationLoadAll(Bargain Bargain) throws Exception;
	
	public Integer count(Bargain Bargain) throws Exception;
	
	public Bargain informationLoadOne(Bargain Bargain) throws Exception;
	
	public void informationDelete(Bargain Bargain) throws Exception;
	
	public void informationAdd(Bargain Bargain) throws Exception;
	
	public void informationUpade(Bargain Bargain) throws Exception;
	
	public void back(Bargain Bargain) throws Exception;
	
	public void export(Bargain Bargain,HttpServletRequest request) throws Exception;
	
}
