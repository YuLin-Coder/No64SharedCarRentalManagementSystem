package com.yjkj.framework.rbac.car.service.inte;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.car.model.Car;

public interface CarService {

	public Pager informationLoad(Pager pager,Car Car,HttpSession session) throws Exception;
	
	public List<Car> informationLoadAll(Car Car) throws Exception;
	
	public Integer count(Car Car) throws Exception;
	
	public Car informationLoadOne(Car Car) throws Exception;
	
	public void informationDelete(Car Car) throws Exception;
	
	public void informationAdd(Car Car,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception;
	
	public void informationUpade(Car Car,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception;
	
}
