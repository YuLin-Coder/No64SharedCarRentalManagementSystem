package com.yjkj.framework.rbac.bargain.web;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.bargain.model.Bargain;
import com.yjkj.framework.rbac.bargain.service.impl.BargainServiceImpl;
import com.yjkj.framework.rbac.bargain.service.inte.BargainService;
import com.yjkj.framework.rbac.car.service.impl.CarServiceImpl;
import com.yjkj.framework.rbac.car.service.inte.CarService;
import com.yjkj.framework.rbac.custom.service.impl.CustomServiceImpl;
import com.yjkj.framework.rbac.custom.service.inte.CustomService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;
import com.yjkj.framework.rbac.vip.service.impl.VipServiceImpl;
import com.yjkj.framework.rbac.vip.service.inte.VipService;

@Controller
@RequestMapping("/bargain")
public class BargainController {
	
	@Autowired
	private BargainService bargainService = new BargainServiceImpl();
	
	@Autowired
	private VipService vipService = new VipServiceImpl();
	
	@Autowired
	private CustomService customService = new CustomServiceImpl();
	
	@Autowired
	private CarService carService = new CarServiceImpl();
	@RequestMapping("/informationLoadCustom")
	public String informationLoadCustom(Pager pager,Model model,Bargain Bargain,HttpSession session) {
		try {
			Bargain.setType("1");
		pager = this.bargainService.informationLoad(pager,Bargain,session);
		model.addAttribute("bargainList", pager);
		return "jsp/CustomBargainTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadFore")
	public String informationLoadFore(Pager pager,Model model,Bargain Bargain,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			Bargain.setUser_id(userInfo.getId());
		pager = this.bargainService.informationLoad(pager,Bargain,session);
		model.addAttribute("bargainList", pager);
		return "jsp/foreground/BargainTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadVip")
	public String informationLoadVip(Pager pager,Model model,Bargain Bargain,HttpSession session) {
		try {
			Bargain.setType("2");
		pager = this.bargainService.informationLoad(pager,Bargain,session);
		model.addAttribute("bargainList", pager);
		return "jsp/VipBargainTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadCustomOne")
	public String informationLoadOne(Bargain Bargain,Model model) {
		
		try {
			model.addAttribute("customList", this.customService.informationLoadAll(null));
			model.addAttribute("carList", this.carService.informationLoadAll(null));
			Bargain = this.bargainService.informationLoadOne(Bargain);
			model.addAttribute("bargain", Bargain);
			return "jsp/CustomBargain";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadVipOne")
	public String informationLoadVipOne(Bargain Bargain,Model model) {
		
		try {
			model.addAttribute("vipList", this.vipService.informationLoadAll(null));
			model.addAttribute("carList", this.carService.informationLoadAll(null));
			Bargain = this.bargainService.informationLoadOne(Bargain);
			model.addAttribute("bargain", Bargain);
			return "jsp/VipBargain";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAddIn(Bargain Bargain,Model model) {
		
		try {
			
			this.bargainService.informationAdd(Bargain);
			return "jsp/Success";
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAddFore")
	public String informationAddFore(Bargain Bargain,Model model) {
		
		try {
			
			this.bargainService.informationAdd(Bargain);
			return "redirect:informationLoadFore";
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Bargain Bargain,Model model) {
		
		try {
			this.bargainService.informationDelete(Bargain);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Bargain Bargain,Model model) {
		
		try {
			this.bargainService.informationUpade(Bargain);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdateFore")
	public String informationUpdateFore(Bargain Bargain,Model model) {
		
		try {
			this.bargainService.back(Bargain);
			return "redirect:informationLoadFore";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/back")
	public String back(Bargain Bargain,Model model) {
		
		try {
			this.bargainService.back(Bargain);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/backFore")
	public String backFore(Bargain Bargain,Model model) {
		
		try {
			this.bargainService.back(Bargain);
			return "redirect:informationLoadFore";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/export")
	public String export(Bargain Bargain,HttpServletRequest request,Model model) {
		
		try {
			this.bargainService.export(Bargain,request);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
