package com.yjkj.framework.rbac.notice.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.notice.model.Notice;

public interface NoticeService {

	public Pager informationLoad(Pager pager,Notice Notice,HttpSession session) throws Exception;
	
	public Pager informationLoadFore(Pager pager,Notice Notice,HttpSession session) throws Exception;
	
	public List<Notice> informationLoadAll(Notice Notice) throws Exception;
	
	public Integer count(Notice Notice) throws Exception;
	
	public Notice informationLoadOne(Notice Notice) throws Exception;
	
	public void informationDelete(Notice Notice) throws Exception;
	
	public void informationAdd(Notice Notice) throws Exception;
	
	public void informationUpade(Notice Notice) throws Exception;
	
}
