package com.yjkj.framework.rbac.car.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.car.model.Car;

public interface CarDao {

	public List<Car> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Car> informationLoadAll(Car Car) throws Exception;
	
	public Integer count(Car Car) throws Exception;
	
	public Car informationLoadOne(Car Car) throws Exception;
	
	public void informationDelete(Car Car) throws Exception;
	
	public void informationAdd(Car Car) throws Exception;
	
	public void informationUpdate(Car Car) throws Exception;
	
}
