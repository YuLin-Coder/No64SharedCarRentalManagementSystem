package com.yjkj.framework.rbac.notice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.notice.model.Notice;
import com.yjkj.framework.rbac.notice.service.inte.NoticeService;
@Service("NoticeService")
public class NoticeServiceImpl extends BaseService implements NoticeService {

	
	@Override
	public Pager informationLoad(Pager pager,Notice Notice,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("notice", Notice);
		List<Notice> list = this.noticeDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Notice));
		return pager;
	}
	
	@Override
	public Pager informationLoadFore(Pager pager,Notice Notice,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("notice", Notice);
		List<Notice> list = this.noticeDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Notice));
		return pager;
	}

	@Override
	public List<Notice> informationLoadAll(Notice Notice) throws Exception {
		List<Notice> list = this.noticeDao.informationLoadAll(Notice);
		return list;
	}
	
	@Override
	public Integer count(Notice Notice) throws Exception {
		Integer count = this.noticeDao.count(Notice);
		return count;
	}

	@Override
	public Notice informationLoadOne(Notice Notice) throws Exception {
			Notice = this.noticeDao.informationLoadOne(Notice);
		return Notice;
	}

	@Override
	public void informationDelete(Notice Notice) throws Exception {
			this.noticeDao.informationDelete(Notice);

	}

	@Override
	public void informationAdd(Notice Notice) throws Exception {
			Notice.setId(Regular.createId());
			Notice.setCreatetime(CreatDate.getDate());
			this.noticeDao.informationAdd(Notice);

	}

	@Override
	public void informationUpade(Notice Notice) throws Exception {
			this.noticeDao.informationUpdate(Notice);

	}

}
