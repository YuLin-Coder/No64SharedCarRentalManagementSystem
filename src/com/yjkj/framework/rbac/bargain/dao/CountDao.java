package com.yjkj.framework.rbac.bargain.dao;

import java.util.List;

import com.yjkj.framework.rbac.bargain.model.Count;

public interface CountDao {

	
	public List<Count> informationLoadNum(Count Count) throws Exception;

	public List<Count> informationLoadPrice(Count Count) throws Exception;

	
}
