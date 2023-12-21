package com.yjkj.framework.rbac.bargain.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.base.regular.date.OperaDate;
import com.yjkj.framework.rbac.bargain.model.Bargain;
import com.yjkj.framework.rbac.bargain.service.inte.BargainService;
import com.yjkj.framework.rbac.car.model.Car;
@Service
public class BargainServiceImpl extends BaseService implements BargainService {

	
	@Override
	public Pager informationLoad(Pager pager,Bargain Bargain,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("bargain", Bargain);
		List<Bargain> list = this.bargainDao.informationLoad(map);
		List<Bargain> result = new ArrayList<>();
		for (Bargain bargain2 : list) {
				Integer day = OperaDate.daysBetween(bargain2.getCreatetime(), CreatDate.getDate())+1;
				bargain2.setPrice(bargain2.getCar().getPrice()*day);
				result.add(bargain2);
		}
		pager.setDatas(result);
		pager.setTotalCount(this.count(Bargain));
		return pager;
	}

	@Override
	public List<Bargain> informationLoadAll(Bargain Bargain) throws Exception {
		List<Bargain> list = this.bargainDao.informationLoadAll(Bargain);
		return list;
	}
	

	@Override
	public Integer count(Bargain Bargain) throws Exception {
		Integer count = this.bargainDao.count(Bargain);
		return count;
	}

	@Override
	public Bargain informationLoadOne(Bargain Bargain) throws Exception {
			Bargain = this.bargainDao.informationLoadOne(Bargain);
		return Bargain;
	}

	@Override
	public void informationDelete(Bargain Bargain) throws Exception {
			this.bargainDao.informationDelete(Bargain);

	}

	
	@Override
	public void informationAdd(Bargain Bargain) throws Exception {
			Bargain.setId(Regular.createId());
			Bargain.setCreatetime(CreatDate.getDate());
			Bargain.setCode(Regular.createId());
			Car car = new Car();
			car.setId(Bargain.getCar_id());
			car = this.carDao.informationLoadOne(car);
			car.setStatus("2");
			this.carDao.informationUpdate(car);
			this.bargainDao.informationAdd(Bargain);

	}

	@Override
	public void informationUpade(Bargain Bargain) throws Exception {
			this.bargainDao.informationUpdate(Bargain);

	}
	
	@Override
	public void back(Bargain Bargain) throws Exception {
			Bargain = this.bargainDao.informationLoadOne(Bargain);
			Car car = new Car();
			car.setId(Bargain.getCar().getId());
			car = this.carDao.informationLoadOne(car);
			car.setStatus("1");
			Bargain.setReturn_time(CreatDate.getDate());
			Integer day = OperaDate.daysBetween(Bargain.getCreatetime(), CreatDate.getDate())+1;
			Bargain.setPrice(Bargain.getCar().getPrice()*day);
			Bargain.setStatus("1");
			this.carDao.informationUpdate(car);
			this.bargainDao.informationUpdate(Bargain);

	}

	@Override
	public void export(Bargain Bargain,HttpServletRequest request) throws Exception {
		Bargain = this.bargainDao.informationLoadOne(Bargain);
		String name = "";
			name = Bargain.getUserInfo().getUserName();
		File file = new File(request.getServletContext().getRealPath("/WEB-INF/doc/"+name+"于"+CreatDate.getDateTime()+"的合同信息.txt"));
		FileOutputStream fs = new FileOutputStream(file);
		PrintStream p = new PrintStream(fs);
		p.println("合同信息\r\n");
		System.out.println();
			p.println("租方姓名:"+Bargain.getUserInfo().getUserName()+"\r\n");
		p.println("租赁车辆"+Bargain.getCar().getName()+"\r\n");
		p.println("每日价格"+Bargain.getPrice()+"\r\n");
		p.println("下单日期"+Bargain.getCreatetime()+"\r\n");
		p.println("归还日期"+OperaDate.addDate(7, Bargain.getCreatetime())+"\r\n");
		p.println("详情描述"+Bargain.getRemark()+"\r\n");
		p.println("授权方:小型车辆租赁系统"+"\r\n");
		p.println("授权日期:"+CreatDate.getDate()+"\r\n");
		p.close();
		
		
	}

}
