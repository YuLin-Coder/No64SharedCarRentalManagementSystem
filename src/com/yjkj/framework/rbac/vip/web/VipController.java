package com.yjkj.framework.rbac.vip.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.type.model.Type;
import com.yjkj.framework.rbac.type.service.impl.TypeServiceImpl;
import com.yjkj.framework.rbac.type.service.inte.TypeService;
import com.yjkj.framework.rbac.vip.model.Vip;
import com.yjkj.framework.rbac.vip.service.impl.VipServiceImpl;
import com.yjkj.framework.rbac.vip.service.inte.VipService;

@Controller
@RequestMapping("/vip")
public class VipController {
	
	@Autowired
	private VipService vipService = new VipServiceImpl();
	
	@Autowired
	private TypeService typeService = new TypeServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Vip Vip,HttpSession session) {
		try {
		pager = this.vipService.informationLoad(pager,Vip,session);
		model.addAttribute("vipList", pager);
		return "jsp/VipTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Vip Vip,Model model) {
		
		try {
			Vip = this.vipService.informationLoadOne(Vip);
			Type type = new Type();
			type.setTypee("2");
			model.addAttribute("vipTypeList", this.typeService.informationLoadAll(type));
			model.addAttribute("vip", Vip);
			return "jsp/Vip";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Vip Vip,Model model) {
		
		try {
			
			this.vipService.informationAdd(Vip);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Vip Vip,Model model) {
		
		try {
			this.vipService.informationDelete(Vip);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Vip Vip,Model model) {
		
		try {
			this.vipService.informationUpade(Vip);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
