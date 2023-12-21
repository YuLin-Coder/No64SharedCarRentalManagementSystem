package com.yjkj.framework.rbac.functionInfo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.rbac.functionInfo.model.FunctionInfo;
import com.yjkj.framework.rbac.functionInfo.service.impl.FunctionServiceImpl;
import com.yjkj.framework.rbac.functionInfo.service.inte.FunctionService;


@Controller
@RequestMapping("/function")
public class FunctionInfoController {

	@Autowired
	private FunctionService fs = new FunctionServiceImpl();
	
	@RequestMapping("/queryAll")
	public String query(Pager pager,Model model){
		try{
		model.addAttribute("pager", this.fs.QueryAll(pager));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/FunctionTable";
	}
	
	@RequestMapping("/queryOne")
	public String queryOne(String id,Model model){
		try{
			model.addAttribute("function", this.fs.queryOne(id));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/Function";
	}
	
	
	@RequestMapping("/functionAdd")
	public String functionAdd(FunctionInfo functionInfo,Model model){
		try{
			this.fs.functionAdd(Regular.createId(), functionInfo.getTitle(), functionInfo.getName(), functionInfo.getUrl(), functionInfo.getRemark(), functionInfo.getFlag());
			return "jsp/Success";
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/functionUpdate")
	public String functionUpdate(FunctionInfo functionInfo,Model model){
		try{
			this.fs.functionUpdate(functionInfo.getId(), functionInfo.getTitle(), functionInfo.getName(), functionInfo.getUrl(), functionInfo.getRemark(), functionInfo.getFlag());
			return "jsp/Success";
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/functionDelete")
	public String functionDelete(String id,Model model){
		try{
			this.fs.functionDelete(id);
			return "jsp/Success";
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
}
