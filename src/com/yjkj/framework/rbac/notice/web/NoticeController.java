package com.yjkj.framework.rbac.notice.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.notice.model.Notice;
import com.yjkj.framework.rbac.notice.service.inte.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService NoticeService;
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Notice Notice,HttpSession session) {
		try {
		pager = this.NoticeService.informationLoad(pager,Notice,session);
		model.addAttribute("noticeList", pager);
		model.addAttribute("notice", Notice);
		return "jsp/NoticeTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Notice Notice,Model model) {
		
		try {
			Notice = this.NoticeService.informationLoadOne(Notice);
			model.addAttribute("notice", Notice);
			return "jsp/Notice";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Notice Notice,Model model) {
		
		try {
			
			this.NoticeService.informationAdd(Notice);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	@RequestMapping("/informationDelete")
	public String informationDelete(Notice Notice,Model model) {
		
		try {
			this.NoticeService.informationDelete(Notice);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Notice Notice,Model model) {
		
		try {
			this.NoticeService.informationUpade(Notice);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
