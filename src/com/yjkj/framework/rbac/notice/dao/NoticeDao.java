package com.yjkj.framework.rbac.notice.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.notice.model.Notice;

public interface NoticeDao {

	public List<Notice> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Notice> informationLoadAll(Notice Notice) throws Exception;
	
	public Integer count(Notice Notice) throws Exception;
	
	public Notice informationLoadOne(Notice Notice) throws Exception;
	
	public void informationDelete(Notice Notice) throws Exception;
	
	public void informationAdd(Notice Notice) throws Exception;
	
	public void informationUpdate(Notice Notice) throws Exception;
	
}
