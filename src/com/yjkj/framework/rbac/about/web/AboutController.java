package com.yjkj.framework.rbac.about.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.about.model.About;
import com.yjkj.framework.rbac.about.service.inte.AboutService;

@Controller
@RequestMapping("/about")
public class AboutController {
	
	@Autowired
	private AboutService aboutService;
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,About About,HttpSession session) {
		try {
		pager = this.aboutService.informationLoad(pager,About,session);
		model.addAttribute("aboutList", pager);
		model.addAttribute("about", About);
		return "jsp/AboutTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(About About,Model model) {
		
		try {
			About = this.aboutService.informationLoadOne(About);
			model.addAttribute("about", About);
			return "jsp/About";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(About About,Model model) {
		
		try {
			
			this.aboutService.informationAdd(About);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	@RequestMapping("/informationDelete")
	public String informationDelete(About About,Model model) {
		
		try {
			this.aboutService.informationDelete(About);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(About About,Model model) {
		
		try {
			this.aboutService.informationUpade(About);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
