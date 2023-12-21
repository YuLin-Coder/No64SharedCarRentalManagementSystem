package com.yjkj.framework.rbac.bargain.web;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.rbac.bargain.model.Count;
import com.yjkj.framework.rbac.bargain.service.impl.CountServiceImpl;
import com.yjkj.framework.rbac.bargain.service.inte.CountService;

@Controller
@RequestMapping("/count")
public class CountController {
	
	@Autowired
	private CountService countService = new CountServiceImpl();
	
	@RequestMapping("/informationLoadNum")
	public String informationLoadNum(Model model,Count Count,HttpSession session) {
		try {
			List<Count> list = this.countService.informationLoadNum(Count);
		model.addAttribute("countList", list);
		return "jsp/CountNumTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadPrice")
	public String informationLoadPrice(Model model,Count Count,HttpSession session) {
		try {
			List<Count> list = this.countService.informationLoadPrice(Count);
		model.addAttribute("countList", list);
		return "jsp/CountPriceTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	
}
