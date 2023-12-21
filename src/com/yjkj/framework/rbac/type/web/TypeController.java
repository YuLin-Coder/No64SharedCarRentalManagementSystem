package com.yjkj.framework.rbac.type.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.type.model.Type;
import com.yjkj.framework.rbac.type.service.impl.TypeServiceImpl;
import com.yjkj.framework.rbac.type.service.inte.TypeService;

@Controller
@RequestMapping("/type")
public class TypeController {
	
	@Autowired
	private TypeService TypeService = new TypeServiceImpl();
	

	@RequestMapping("/informationLoadCar")
	public String informationLoad(Pager pager,Model model,Type Type,HttpSession session) {
		try {
			Type.setTypee("1");
		pager = this.TypeService.informationLoad(pager,Type,session);
		model.addAttribute("typeList", pager);
		return "jsp/CarTypeTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadVip")
	public String informationLoadVip(Pager pager,Model model,Type Type,HttpSession session) {
		try {
			Type.setTypee("2");
		pager = this.TypeService.informationLoad(pager,Type,session);
		model.addAttribute("typeList", pager);
		return "jsp/VipTypeTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOneVip")
	public String informationLoadOneVip(Type Type,Model model) {
		
		try {
			Type = this.TypeService.informationLoadOne(Type);
			model.addAttribute("type", Type);
			return "jsp/VipType";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	@RequestMapping("/informationLoadOneCar")
	public String informationLoadOneCar(Type Type,Model model) {
		
		try {
			Type = this.TypeService.informationLoadOne(Type);
			model.addAttribute("type", Type);
			return "jsp/CarType";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Type Type,Model model) {
		
		try {
			
			this.TypeService.informationAdd(Type);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Type Type,Model model) {
		
		try {
			this.TypeService.informationDelete(Type);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Type Type,Model model) {
		
		try {
			this.TypeService.informationUpade(Type);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
