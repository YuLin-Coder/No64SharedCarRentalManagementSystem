package com.yjkj.framework.rbac.introduce.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.introduce.model.Introduce;
import com.yjkj.framework.rbac.introduce.service.inte.IntroduceService;
@Service("IntroduceService")
public class IntroduceServiceImpl extends BaseService implements IntroduceService {

	
	@Override
	public Pager informationLoad(Pager pager,Introduce Introduce,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("introduce", Introduce);
		List<Introduce> list = this.introduceDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Introduce));
		return pager;
	}
	
	@Override
	public Pager informationLoadFore(Pager pager,Introduce Introduce,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("introduce", Introduce);
		List<Introduce> list = this.introduceDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Introduce));
		return pager;
	}

	@Override
	public List<Introduce> informationLoadAll(Introduce Introduce) throws Exception {
		List<Introduce> list = this.introduceDao.informationLoadAll(Introduce);
		return list;
	}
	
	@Override
	public Integer count(Introduce Introduce) throws Exception {
		Integer count = this.introduceDao.count(Introduce);
		return count;
	}

	@Override
	public Introduce informationLoadOne(Introduce Introduce) throws Exception {
			Introduce = this.introduceDao.informationLoadOne(Introduce);
		return Introduce;
	}

	@Override
	public void informationDelete(Introduce Introduce) throws Exception {
			this.introduceDao.informationDelete(Introduce);

	}

	@Override
	public void informationAdd(Introduce Introduce) throws Exception {
			Introduce.setId(Regular.createId());
			Introduce.setCreatetime(CreatDate.getDate());
			this.introduceDao.informationAdd(Introduce);

	}

	@Override
	public void informationUpade(Introduce Introduce) throws Exception {
			this.introduceDao.informationUpdate(Introduce);

	}

}
