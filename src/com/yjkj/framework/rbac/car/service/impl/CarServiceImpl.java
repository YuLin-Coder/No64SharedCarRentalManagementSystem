package com.yjkj.framework.rbac.car.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.base.regular.file.OperaFile;
import com.yjkj.framework.rbac.car.model.Car;
import com.yjkj.framework.rbac.car.service.inte.CarService;
@Service
public class CarServiceImpl extends BaseService implements CarService {

	
	@Override
	public Pager informationLoad(Pager pager,Car Car,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("car", Car);
		List<Car> list = this.carDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Car));
		return pager;
	}

	@Override
	public List<Car> informationLoadAll(Car Car) throws Exception {
		List<Car> list = this.carDao.informationLoadAll(Car);
		return list;
	}
	

	@Override
	public Integer count(Car Car) throws Exception {
		Integer count = this.carDao.count(Car);
		return count;
	}

	@Override
	public Car informationLoadOne(Car Car) throws Exception {
			Car = this.carDao.informationLoadOne(Car);
		return Car;
	}

	@Override
	public void informationDelete(Car Car) throws Exception {
			this.carDao.informationDelete(Car);

	}

	@Override
	public void informationAdd(Car Car,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception {
			Map<String, String> map = OperaFile.uploadFile(multipartFiles, null, request);
			String url = map.get("name");
			Car.setUrl(url);
			Car.setId(Regular.createId());
			Car.setCreatetime(CreatDate.getDate());
			this.carDao.informationAdd(Car);

	}

	@Override
	public void informationUpade(Car Car,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception {
		if(!multipartFiles[0].isEmpty()) {
			Map<String, String> map = OperaFile.uploadFile(multipartFiles, null, request);
			String url = map.get("name");
			Car.setUrl(url);
		}
			this.carDao.informationUpdate(Car);

	}

}
