package com.yjkj.framework.rbac.type.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.type.model.Type;
import com.yjkj.framework.rbac.type.service.inte.TypeService;
@Service
public class TypeServiceImpl extends BaseService implements TypeService {

	
	@Override
	public Pager informationLoad(Pager pager,Type Type,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("type", Type);
		List<Type> list = this.typeDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Type));
		return pager;
	}

	@Override
	public List<Type> informationLoadAll(Type Type) throws Exception {
		List<Type> list = this.typeDao.informationLoadAll(Type);
		return list;
	}
	

	@Override
	public Integer count(Type Type) throws Exception {
		Integer count = this.typeDao.count(Type);
		return count;
	}

	@Override
	public Type informationLoadOne(Type Type) throws Exception {
			Type = this.typeDao.informationLoadOne(Type);
		return Type;
	}

	@Override
	public void informationDelete(Type Type) throws Exception {
			this.typeDao.informationDelete(Type);

	}

	@Override
	public void informationAdd(Type Type) throws Exception {
			Type.setId(Regular.createId());
			Type.setCreatetime(CreatDate.getDate());
			this.typeDao.informationAdd(Type);

	}

	@Override
	public void informationUpade(Type Type) throws Exception {
			this.typeDao.informationUpdate(Type);

	}

}
