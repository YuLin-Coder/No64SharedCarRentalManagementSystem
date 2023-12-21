package com.yjkj.framework.rbac.functionInfo.service.inte;


import java.util.List;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.functionInfo.model.FunctionInfo;

public interface FunctionService {

	public Pager QueryAll(Pager pager);
	
	public List<FunctionInfo> query();
	
	public Integer queryCount();
	
	public FunctionInfo queryOne(String id);
	
	public void functionAdd(String id,
							String title,
							String name,
							String url,
							String remark,
							String flag);
	
	public void functionUpdate(String id,
								String title,
								String name,
								String url,
								String remark,
								String flag);
	
	public void functionDelete(String id);
	
}
