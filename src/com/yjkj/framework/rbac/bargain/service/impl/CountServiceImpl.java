package com.yjkj.framework.rbac.bargain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.rbac.bargain.model.Count;
import com.yjkj.framework.rbac.bargain.service.inte.CountService;
@Service
public class CountServiceImpl extends BaseService implements CountService {

	

	@Override
	public List<Count> informationLoadNum(Count Count) throws Exception {
		List<Count> list = this.countDao.informationLoadNum(Count);
		return list;
	}
	
	@Override
	public List<Count> informationLoadPrice(Count Count) throws Exception {
		List<Count> list = this.countDao.informationLoadPrice(Count);
		return list;
	}
	

}
