package com.yjkj.framework.rbac.roleInfo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.functionInfo.service.impl.FunctionServiceImpl;
import com.yjkj.framework.rbac.functionInfo.service.inte.FunctionService;
import com.yjkj.framework.rbac.functionRoleInfo.service.impl.FunctionRoleServiceImpl;
import com.yjkj.framework.rbac.functionRoleInfo.service.inte.FunctionRoleService;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;
import com.yjkj.framework.rbac.roleInfo.service.impl.RoleInfoServiceImpl;
import com.yjkj.framework.rbac.roleInfo.service.inte.RoleInfoService;

@Controller
@RequestMapping("/role")
public class RoleInfoController {

	@Autowired
	private RoleInfoService rs = new RoleInfoServiceImpl();
	
	@Autowired
	private FunctionService fs = new FunctionServiceImpl();
	
	@Autowired
	private FunctionRoleService frs = new FunctionRoleServiceImpl();
	
	@RequestMapping("/queryAll")
	public String query(Pager pager,Model model){
		try{
		model.addAttribute("pager", this.rs.QueryAll(pager));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/RoleTable";
	}
	
	@RequestMapping("/queryOne")
	public String queryOne(String id,Model model){
		try{
			model.addAttribute("function", this.fs.query());
			model.addAttribute("functionRole", this.frs.queryOne(id));
			model.addAttribute("role", this.rs.queryOne(id));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/Role";
	}
	
	
	@RequestMapping("/roleAdd")
	public String roleAdd(RoleInfo roleInfo,String functionId[],Model model){
		String id = Regular.createId();
		try{
			this.rs.roleAdd(id, roleInfo.getTitle(), roleInfo.getName(), CreatDate.getDateTime(), roleInfo.getRemark(), roleInfo.getFlag());
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		try{
			for(int i=0;i<functionId.length;i++){
			this.frs.functionRoleAdd(Regular.createId(), functionId[i], id, CreatDate.getDateTime(), "0");
			}
			return "jsp/Success";
		}catch (RuntimeException e) {
			model.addAttribute("functionRole", e.getMessage());
		}
		return "jsp/Failed";
	}
	
	@RequestMapping("/roleUpdate")
	public String roleUpdate(RoleInfo roleInfo,String functionId[],Model model){
		try{
			this.frs.roleIdDelete(roleInfo.getId());
			this.rs.roleUpdate(roleInfo.getId(), roleInfo.getTitle(), roleInfo.getName(), CreatDate.getDateTime(), roleInfo.getRemark(), roleInfo.getFlag());
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		try{
			for(int i=0;i<functionId.length;i++){
			this.frs.functionRoleAdd(Regular.createId(), functionId[i], roleInfo.getId(), CreatDate.getDateTime(), "0");
			}
			return "jsp/Success";
		}catch (RuntimeException e) {
			model.addAttribute("functionRole", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/roleDelete")
	public String roleDelete(String id,Model model){
		try{
			this.rs.roleDelete(id);
			return "jsp/Success";
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
}
