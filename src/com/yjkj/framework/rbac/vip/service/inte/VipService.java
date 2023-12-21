package com.yjkj.framework.rbac.vip.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.vip.model.Vip;

public interface VipService {

	public Pager informationLoad(Pager pager,Vip Vip,HttpSession session) throws Exception;
	
	public List<Vip> informationLoadAll(Vip Vip) throws Exception;
	
	public Integer count(Vip Vip) throws Exception;
	
	public Vip informationLoadOne(Vip Vip) throws Exception;
	
	public void informationDelete(Vip Vip) throws Exception;
	
	public void informationAdd(Vip Vip) throws Exception;
	
	public void informationUpade(Vip Vip) throws Exception;
	
}
