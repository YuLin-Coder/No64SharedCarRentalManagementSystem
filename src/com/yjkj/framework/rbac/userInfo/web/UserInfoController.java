package com.yjkj.framework.rbac.userInfo.web;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;
import com.yjkj.framework.rbac.roleInfo.service.impl.RoleInfoServiceImpl;
import com.yjkj.framework.rbac.roleInfo.service.inte.RoleInfoService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;
import com.yjkj.framework.rbac.userInfo.service.impl.UserInfoServiceImpl;
import com.yjkj.framework.rbac.userInfo.service.inte.UserInfoService;


@Controller
@RequestMapping("/user")
public class UserInfoController {
	@Autowired
	private UserInfoService uis = new UserInfoServiceImpl();
	
	@Autowired
	private RoleInfoService ris = new RoleInfoServiceImpl();
	
	@RequestMapping("/login")
	public String login(String loginName,String loginPassword,String controller,String code,Model model,HttpSession session){
		try{	
			UserInfo userInfo = this.uis.login(loginName, loginPassword);
			session.setAttribute("Admin", userInfo);
			return "redirect:../request/index";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			model.addAttribute("loginName", loginName);
			model.addAttribute("loginPassword", loginPassword);
			return "jsp/Login";
		}
		
	}
	@RequestMapping("/loginF")
	public String loginF(String loginName,String loginPassword,String controller,String code,Model model,HttpSession session){
		try{	
			
			UserInfo userInfo = this.uis.login(loginName, loginPassword);
			session.setAttribute("User", userInfo);
			return "redirect:../request/welcome";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			model.addAttribute("loginName", loginName);
			model.addAttribute("loginPassword", loginPassword);
			return "jsp/foreground/Welcome";
		}
		
	}
	@RequestMapping("/logoutF")
	public String logoutF(HttpSession session){
			session.removeAttribute("User");
			return "redirect:../request/welcome";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
			session.removeAttribute("Admin");
			return "jsp/Login";
	}
	@RequestMapping("/logoutAdmin")
	public String logoutAdmin(HttpSession session){
			session.removeAttribute("Admin");
			return "jsp/LoginAdmin";
	}
	@RequestMapping("/userAdd")
	public String userAdd(UserInfo user,Model model){
			try{
				this.uis.userAdd(Regular.createId(),user.getLoginName(), user.getLoginPassword(), user.getUserName(), user.getRoleId(), user.getPhoneNo(), "1", "1", user.getRemark(), CreatDate.getDateTime(), user.getFlag());
				return "jsp/Success";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/userAddF")
	public String userAddF(UserInfo user,Model model){
			try{
				this.uis.userAdd(Regular.createId(),user.getLoginName(), user.getLoginPassword(), user.getUserName(), user.getRoleId(), user.getPhoneNo(), "1", "1", user.getRemark(), CreatDate.getDateTime(), user.getFlag());
				return "jsp/foreground/Welcome";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/userUpdate")
	public String userUpdate(UserInfo user,Model model){
			try{
				this.uis.userUpdate(user.getId(),user.getLoginName(), user.getLoginPassword(), user.getUserName(), user.getRoleId(), user.getPhoneNo(), null, "1", user.getRemark(), null, user.getFlag());
				return "jsp/Success";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/userUpdateF")
	public String userUpdateF(UserInfo user,Model model){
			try{
				this.uis.userUpdate(user.getId(),user.getLoginName(), user.getLoginPassword(), user.getUserName(), user.getRoleId(), user.getPhoneNo(), null, "1", user.getRemark(), null, user.getFlag());
				return "jsp/foreground/Welcome";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/userDelete")
	public String userDelete(String id,Model model){
			try{
				this.uis.userDelete(id);
				return "jsp/Success";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/status")
	public String status(UserInfo user,String c,Model model){
			try{
				if(c.equals("1")) {
					
					this.uis.userUpdate(user.getId(),user.getLoginName(), user.getLoginPassword(), user.getUserName(), user.getRoleId(), user.getPhoneNo(), "2", null, user.getRemark(), null, user.getFlag());
				}
				else if(c.equals("2")) {
					
					this.uis.userUpdate(user.getId(),user.getLoginName(), user.getLoginPassword(), user.getUserName(), user.getRoleId(), user.getPhoneNo(), "1", null, user.getRemark(), null, user.getFlag());
				}
				return "jsp/Success";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/queryOneFore")
	public String queryOneFore(String id,Model model){
		try{
			UserInfo user = this.uis.queryOne(id);
			List<RoleInfo> list = this.ris.query();
			model.addAttribute("role", list);
			model.addAttribute("user", user);
			return "jsp/foreground/information";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:query";
		}
	}
	
	@RequestMapping("/queryOne")
	public String queryOne(String id,Model model){
		try{
			UserInfo user = this.uis.queryOne(id);
			List<RoleInfo> list = this.ris.query();
			model.addAttribute("role", list);
			model.addAttribute("user", user);
			return "jsp/User";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:query";
		}
	}
	
	@RequestMapping("/queryOwn")
	public String queryOwn(String id,Model model,HttpSession session){
		try{
			
			UserInfo user = (UserInfo) session.getAttribute("User");
			List<RoleInfo> list = this.ris.query();
			model.addAttribute("role", list);
			model.addAttribute("user", user);
			return "jsp/User";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:query";
		}
	}
	
	@RequestMapping("/query")
	public String query(Pager pager,UserInfo user,Model model){
		try{
		model.addAttribute("pager", this.uis.Query(pager, user));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/UserTable";
	}
}
