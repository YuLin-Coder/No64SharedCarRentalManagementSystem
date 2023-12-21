package com.yjkj.framework.base.basemodel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjkj.framework.rbac.about.dao.AboutDao;
import com.yjkj.framework.rbac.bargain.dao.BargainDao;
import com.yjkj.framework.rbac.bargain.dao.CountDao;
import com.yjkj.framework.rbac.car.dao.CarDao;
import com.yjkj.framework.rbac.custom.dao.CustomDao;
import com.yjkj.framework.rbac.introduce.dao.IntroduceDao;
import com.yjkj.framework.rbac.notice.dao.NoticeDao;
import com.yjkj.framework.rbac.type.dao.TypeDao;
import com.yjkj.framework.rbac.vip.dao.VipDao;
@Service
public class BaseService {
	
	@Autowired
	public BargainDao bargainDao;
	
	@Autowired
	public CarDao carDao;
	
	@Autowired
	public AboutDao aboutDao;
	
	@Autowired
	public NoticeDao noticeDao;
	
	@Autowired
	public IntroduceDao introduceDao;
	
	@Autowired
	public CountDao countDao;
	
	@Autowired
	public TypeDao typeDao;
	
	@Autowired
	public CustomDao customDao;
	
	@Autowired
	public VipDao vipDao;
	
	
	

}
