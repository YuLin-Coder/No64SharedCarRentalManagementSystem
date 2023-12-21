package com.yjkj.framework.rbac.custom.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.custom.model.Custom;
import com.yjkj.framework.rbac.custom.service.inte.CustomService;
@Service
public class CustomServiceImpl extends BaseService implements CustomService {

	
	@Override
	public Pager informationLoad(Pager pager,Custom Custom,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("custom", Custom);
		List<Custom> list = this.customDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Custom));
		return pager;
	}

	@Override
	public List<Custom> informationLoadAll(Custom Custom) throws Exception {
		List<Custom> list = this.customDao.informationLoadAll(Custom);
		return list;
	}
	

	@Override
	public Integer count(Custom Custom) throws Exception {
		Integer count = this.customDao.count(Custom);
		return count;
	}

	@Override
	public Custom informationLoadOne(Custom Custom) throws Exception {
			Custom = this.customDao.informationLoadOne(Custom);
		return Custom;
	}

	@Override
	public Custom informationLoadOneUser(Custom Custom) throws Exception {
			Custom = this.customDao.informationLoadOneUser(Custom);
		return Custom;
	}

	@Override
	public void informationDelete(Custom Custom) throws Exception {
			this.customDao.informationDelete(Custom);

	}

	@Override
	public void informationAdd(Custom Custom) throws Exception {
			Custom.setId(Regular.createId());
			Custom.setCreatetime(CreatDate.getDate());
			this.customDao.informationAdd(Custom);

	}

	@Override
	public void informationUpade(Custom Custom) throws Exception {
			this.customDao.informationUpdate(Custom);

	}

}
