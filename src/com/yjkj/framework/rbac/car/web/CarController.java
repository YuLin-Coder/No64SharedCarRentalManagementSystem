package com.yjkj.framework.rbac.car.web;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.car.model.Car;
import com.yjkj.framework.rbac.car.service.impl.CarServiceImpl;
import com.yjkj.framework.rbac.car.service.inte.CarService;
import com.yjkj.framework.rbac.type.model.Type;
import com.yjkj.framework.rbac.type.service.impl.TypeServiceImpl;
import com.yjkj.framework.rbac.type.service.inte.TypeService;

@Controller
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService carService = new CarServiceImpl();
	
	@Autowired
	private TypeService ts = new TypeServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Car Car,HttpSession session) {
		try {
		pager = this.carService.informationLoad(pager,Car,session);
		model.addAttribute("carList", pager);
		model.addAttribute("car", Car);
		return "jsp/CarTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			model.addAttribute("car", Car);
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadFore")
	public String informationLoadFore(Pager pager,Model model,Car Car,HttpSession session) {
		try {
		Car.setStatus("1");
		pager = this.carService.informationLoad(pager,Car,session);
		model.addAttribute("carList", pager);
		model.addAttribute("car", Car);
		return "jsp/foreground/CarTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			model.addAttribute("car", Car);
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Car Car,Model model) {
		
		try {
			Car = this.carService.informationLoadOne(Car);
			Type type = new Type();
			type.setTypee("1");
			model.addAttribute("typeList", this.ts.informationLoadAll(type));
			model.addAttribute("car", Car);
			return "jsp/Car";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadOneFore")
	public String informationLoadOneFore(Car Car,Model model) {
		
		try {
			Car = this.carService.informationLoadOne(Car);
			model.addAttribute("car", Car);
			return "jsp/foreground/Car";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Car Car,Model model,MultipartFile[] file,HttpSession session,HttpServletRequest request) {
		
		try {
			
			this.carService.informationAdd(Car,file,session,request);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Car Car,Model model) {
		
		try {
			this.carService.informationDelete(Car);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Car Car,Model model,MultipartFile[] file,HttpSession session,HttpServletRequest request) {
		
		try {
			this.carService.informationUpade(Car,file,session,request);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
