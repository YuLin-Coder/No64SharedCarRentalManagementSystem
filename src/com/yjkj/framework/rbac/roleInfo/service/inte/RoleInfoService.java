package com.yjkj.framework.rbac.roleInfo.service.inte;

import java.util.List;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;

public interface RoleInfoService {

	public List<RoleInfo> query();
	
	public Pager QueryAll(Pager pager);
	
	public Integer queryCount();
	
	public RoleInfo queryOne(String id);
	
	public void roleAdd(String id,
							String title,
							String name,
							String createDate,
							String remark,
							String flag);
	
	public void roleUpdate(String id,
								String title,
								String name,
								String createDate,
								String remark,
								String flag);
	
	public void roleDelete(String id);
	
}
