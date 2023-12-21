package com.yjkj.framework.rbac.about.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.about.model.About;

public interface AboutService {

	public Pager informationLoad(Pager pager,About About,HttpSession session) throws Exception;
	
	public Pager informationLoadFore(Pager pager,About About,HttpSession session) throws Exception;
	
	public List<About> informationLoadAll(About About) throws Exception;
	
	public Integer count(About About) throws Exception;
	
	public About informationLoadOne(About About) throws Exception;
	
	public void informationDelete(About About) throws Exception;
	
	public void informationAdd(About About) throws Exception;
	
	public void informationUpade(About About) throws Exception;
	
}
