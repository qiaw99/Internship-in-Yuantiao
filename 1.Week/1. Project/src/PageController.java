package com.yuantiao.test.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yuantiao.webplatform.base.api.power.IAppService;
import com.yuantiao.webplatform.base.api.power.IUserService;
import com.yuantiao.webplatform.base.api.power.bo.AppBo;
import com.yuantiao.webplatform.base.api.power.bo.UserBo;
import com.yuantiao.webplatform.base.api.security.Authentication;
import com.yuantiao.webplatform.base.api.support.menu.MenuBo;
import com.yuantiao.webplatform.base.api.support.menu.MenuUtil;
import com.yuantiao.webplatform.base.api.support.sysparam.ISysParamService;
import com.yuantiao.webplatform.base.core.scan.ServiceUtil;
import com.yuantiao.webplatform.core.utils.JsonUtils;


@Controller
@RequestMapping("/page")
@PermitAll
public class PageController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IAppService appService;
	@Autowired
	private Authentication authentication;
	@Autowired
	private ServiceUtil serviceUtil;
	@Autowired
	private ISysParamService sysParamService;
	
	@RequestMapping(value = "/index2.html")
	public String upMenu2(Model m, HttpSession session) {
		UserBo userBo = authentication.getCurrentUser();
		
		String appId = (String) session.getAttribute("appId");
		List<AppBo> apps = appService.getAll();
		if (appId==null && apps != null) {
			appId = apps.get(0).getAppId();
		}
		AppBo appBo = appService.view(appId);
		if (appBo != null) {
			m.addAttribute("url", appBo.getAppHomepage());
			m.addAttribute("title", appBo.getAppTitle());
		}
		
		String nav = sysParamService.getSysParamValueByFlag("theme", null, "nav");	
		String antd = sysParamService.getSysParamValueByFlag("theme", null, "antd");	
		if(nav==null){
			nav="top";
		}
		m.addAttribute("nav",nav );
		m.addAttribute("antd",antd );
		
		String smallIcon = sysParamService.getSysParamValueByFlag("icon", null, "small");
		String bigIcon = sysParamService.getSysParamValueByFlag("icon", null, "big");
		m.addAttribute("smallIcon",smallIcon );
		if(bigIcon==null){
			bigIcon = "/base/img/logo.png";
		}
		m.addAttribute("bigIcon",bigIcon );
		try {
			List<MenuBo> menus = userService.getMenusByUserAndApp(userBo.getName(), appId);
			Map<String,String> services = serviceUtil.getService();
			List<Map<String, Object>> menusResult = MenuUtil.convertMenuData(menus, services);
			m.addAttribute("menu",JsonUtils.objectToJson(menusResult));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		return "page/index2";
	}
}