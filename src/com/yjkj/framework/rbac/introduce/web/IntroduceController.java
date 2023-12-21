package com.yjkj.framework.rbac.introduce.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.introduce.model.Introduce;
import com.yjkj.framework.rbac.introduce.service.inte.IntroduceService;

@Controller
@RequestMapping("/introduce")
public class IntroduceController {
	
	@Autowired
	private IntroduceService introduceService;
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Introduce Introduce,HttpSession session) {
		try {
		pager = this.introduceService.informationLoad(pager,Introduce,session);
		model.addAttribute("IntroduceList", pager);
		model.addAttribute("introduce", Introduce);
		return "jsp/IntroduceTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Introduce Introduce,Model model) {
		
		try {
			Introduce = this.introduceService.informationLoadOne(Introduce);
			model.addAttribute("introduce", Introduce);
			return "jsp/Introduce";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Introduce Introduce,Model model) {
		
		try {
			
			this.introduceService.informationAdd(Introduce);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	@RequestMapping("/informationDelete")
	public String informationDelete(Introduce Introduce,Model model) {
		
		try {
			this.introduceService.informationDelete(Introduce);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Introduce Introduce,Model model) {
		
		try {
			this.introduceService.informationUpade(Introduce);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
