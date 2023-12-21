package com.yjkj.framework.rbac.about.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.about.model.About;
import com.yjkj.framework.rbac.about.service.inte.AboutService;
@Service("AboutService")
public class AboutServiceImpl extends BaseService implements AboutService {

	
	@Override
	public Pager informationLoad(Pager pager,About About,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("about", About);
		List<About> list = this.aboutDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(About));
		return pager;
	}
	
	@Override
	public Pager informationLoadFore(Pager pager,About About,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("about", About);
		List<About> list = this.aboutDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(About));
		return pager;
	}

	@Override
	public List<About> informationLoadAll(About About) throws Exception {
		List<About> list = this.aboutDao.informationLoadAll(About);
		return list;
	}
	
	@Override
	public Integer count(About About) throws Exception {
		Integer count = this.aboutDao.count(About);
		return count;
	}

	@Override
	public About informationLoadOne(About About) throws Exception {
			About = this.aboutDao.informationLoadOne(About);
		return About;
	}

	@Override
	public void informationDelete(About About) throws Exception {
			this.aboutDao.informationDelete(About);

	}

	@Override
	public void informationAdd(About About) throws Exception {
			About.setId(Regular.createId());
			About.setCreatetime(CreatDate.getDate());
			this.aboutDao.informationAdd(About);

	}

	@Override
	public void informationUpade(About About) throws Exception {
			this.aboutDao.informationUpdate(About);

	}

}
