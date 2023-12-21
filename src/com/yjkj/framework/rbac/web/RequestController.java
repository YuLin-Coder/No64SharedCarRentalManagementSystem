package com.yjkj.framework.rbac.web;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.rbac.about.model.About;
import com.yjkj.framework.rbac.about.service.inte.AboutService;
import com.yjkj.framework.rbac.car.service.impl.CarServiceImpl;
import com.yjkj.framework.rbac.car.service.inte.CarService;
import com.yjkj.framework.rbac.custom.service.impl.CustomServiceImpl;
import com.yjkj.framework.rbac.custom.service.inte.CustomService;
import com.yjkj.framework.rbac.functionInfo.service.impl.FunctionServiceImpl;
import com.yjkj.framework.rbac.functionInfo.service.inte.FunctionService;
import com.yjkj.framework.rbac.introduce.model.Introduce;
import com.yjkj.framework.rbac.introduce.service.inte.IntroduceService;
import com.yjkj.framework.rbac.notice.model.Notice;
import com.yjkj.framework.rbac.notice.service.inte.NoticeService;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;
import com.yjkj.framework.rbac.roleInfo.service.impl.RoleInfoServiceImpl;
import com.yjkj.framework.rbac.roleInfo.service.inte.RoleInfoService;
import com.yjkj.framework.rbac.type.model.Type;
import com.yjkj.framework.rbac.type.service.impl.TypeServiceImpl;
import com.yjkj.framework.rbac.type.service.inte.TypeService;
import com.yjkj.framework.rbac.vip.service.impl.VipServiceImpl;
import com.yjkj.framework.rbac.vip.service.inte.VipService;


@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private RoleInfoService ris = new RoleInfoServiceImpl();

	@Autowired
	private FunctionService fs = new FunctionServiceImpl();
	
	@Autowired
	private TypeService ts = new TypeServiceImpl();
	
	
	@Autowired
	private VipService vipService = new VipServiceImpl();
	
	@Autowired
	private CustomService customService = new CustomServiceImpl();
	
	@Autowired
	private CarService carService = new CarServiceImpl();
	
	@Autowired
	private AboutService aboutService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private IntroduceService introduceService;
	

	
	@RequestMapping("/login")
	public String login() throws IOException {
		return "jsp/Login";
		
	}
	@RequestMapping("/welcome")
	public String welcome(Model model) throws IOException {
		try {
			Introduce introduce = new Introduce();
			Notice notice = new Notice();
			About about = new About();
			introduce.setId("1");
			notice.setId("1");
			about.setId("1");
			model.addAttribute("introduce", this.introduceService.informationLoadOne(introduce));
			model.addAttribute("about", this.aboutService.informationLoadOne(about));
			model.addAttribute("notice", this.noticeService.informationLoadOne(notice));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/foreground/Welcome";
		
	}
	@RequestMapping("/index")
	public String main() {
		return "jsp/iframemain";
	}
	
	@RequestMapping("/passUpdate")
	public String passUpdate(String id,Model model) {
		model.addAttribute("id", id);
		return "jsp/PassUpdate";
	}
	@RequestMapping("/right")
	public String index() {
		return "jsp/index";
	}
	
	@RequestMapping("/top")
	public String top() {
		return "jsp/top";
	}
	
	
	@RequestMapping("/customAdd")
	public String customAdd() {
		return "jsp/CustomAdd";
	}
	
	@RequestMapping("/vipAdd")
	public String vipAdd(Model model) {
		try {
			Type type = new Type();
			type.setTypee("2");
			model.addAttribute("vipTypeList", this.ts.informationLoadAll(type));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/VipAdd";
	}
	
	@RequestMapping("/typeAddCar")
	public String typeAddCar() {
		return "jsp/CarTypeAdd";
	}
	
	@RequestMapping("/typeAddVip")
	public String typeAddVip() {
		return "jsp/VipTypeAdd";
	}
	
	@RequestMapping("/userAdd")
	public String userAdd(Model model){
		try{
		List<RoleInfo> list = this.ris.query();
		model.addAttribute("role", list);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/UserAdd";
	}
	
	@RequestMapping("/functionAdd")
	public String functionAdd(){
		return "jsp/FunctionAdd";
	}
	@RequestMapping("/roleAdd")
	public String roleAdd(Model model){
		model.addAttribute("function", this.fs.query());
		return "jsp/RoleAdd";
	}
	
	@RequestMapping("/sign")
	public String sign(Model model){
		return "jsp/foreground/sign";
	}
	
	@RequestMapping("/bargainAddCustom")
	public String bargainAddCustom(Model model){
		try {
			model.addAttribute("customList", this.customService.informationLoadAll(null));
			model.addAttribute("carList", this.carService.informationLoadAll(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/CustomBargainAdd";
	}
	
	@RequestMapping("/bargainAddVip")
	public String bargainAddVip(Model model){
		try {
			model.addAttribute("vipList", this.vipService.informationLoadAll(null));
			model.addAttribute("carList", this.carService.informationLoadAll(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/VipBargainAdd";
	}
	
	@RequestMapping("/carAdd")
	public String carAdd(Model model){
		try {
			Type type = new Type();
			type.setTypee("1");
			model.addAttribute("typeList", this.ts.informationLoadAll(type));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/CarAdd";
	}
	
	
	
	
	
	
}
