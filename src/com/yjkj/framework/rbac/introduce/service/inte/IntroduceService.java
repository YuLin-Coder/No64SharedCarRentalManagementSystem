package com.yjkj.framework.rbac.introduce.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.introduce.model.Introduce;

public interface IntroduceService {

	public Pager informationLoad(Pager pager,Introduce Introduce,HttpSession session) throws Exception;
	
	public Pager informationLoadFore(Pager pager,Introduce Introduce,HttpSession session) throws Exception;
	
	public List<Introduce> informationLoadAll(Introduce Introduce) throws Exception;
	
	public Integer count(Introduce Introduce) throws Exception;
	
	public Introduce informationLoadOne(Introduce Introduce) throws Exception;
	
	public void informationDelete(Introduce Introduce) throws Exception;
	
	public void informationAdd(Introduce Introduce) throws Exception;
	
	public void informationUpade(Introduce Introduce) throws Exception;
	
}
