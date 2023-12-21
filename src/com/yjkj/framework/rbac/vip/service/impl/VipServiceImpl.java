package com.yjkj.framework.rbac.vip.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.vip.model.Vip;
import com.yjkj.framework.rbac.vip.service.inte.VipService;
@Service
public class VipServiceImpl extends BaseService implements VipService {

	
	@Override
	public Pager informationLoad(Pager pager,Vip Vip,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("vip", Vip);
		List<Vip> list = this.vipDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Vip));
		return pager;
	}

	@Override
	public List<Vip> informationLoadAll(Vip Vip) throws Exception {
		List<Vip> list = this.vipDao.informationLoadAll(Vip);
		return list;
	}
	

	@Override
	public Integer count(Vip Vip) throws Exception {
		Integer count = this.vipDao.count(Vip);
		return count;
	}

	@Override
	public Vip informationLoadOne(Vip Vip) throws Exception {
			Vip = this.vipDao.informationLoadOne(Vip);
		return Vip;
	}

	@Override
	public void informationDelete(Vip Vip) throws Exception {
			this.vipDao.informationDelete(Vip);

	}

	@Override
	public void informationAdd(Vip Vip) throws Exception {
			Vip.setId(Regular.createId());
			Vip.setCreatetime(CreatDate.getDate());
			this.vipDao.informationAdd(Vip);

	}

	@Override
	public void informationUpade(Vip Vip) throws Exception {
			this.vipDao.informationUpdate(Vip);

	}

}
