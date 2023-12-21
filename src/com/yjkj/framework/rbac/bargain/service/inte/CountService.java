package com.yjkj.framework.rbac.bargain.service.inte;


import java.util.List;

import com.yjkj.framework.rbac.bargain.model.Count;

public interface CountService {

	
	public List<Count> informationLoadNum(Count Count) throws Exception;
	
	public List<Count> informationLoadPrice(Count Count) throws Exception;
	
	
}
