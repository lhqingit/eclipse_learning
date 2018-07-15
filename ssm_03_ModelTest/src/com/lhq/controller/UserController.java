package com.lhq.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhq.domain.User;

@Controller
public class UserController {

	private static final Log logger = LogFactory.getLog(UserController.class);

	@ModelAttribute
	public void userModel(String loginname, String password, Model model) {
		logger.info("userModel方法执行了");
		model.addAttribute("user", new User(loginname, password, null));
	}

	@RequestMapping(value = "/login1")
	public String login1(Model model) {
		logger.info("login1方法执行了");
		User user = (User) model.asMap().get("user");
		System.out.println(user);
		user.setUsername("测试用户名(login1)");
		return "result";
	}
	
	@RequestMapping("/login2")
	public String login2(ModelMap modelMap) {
		logger.info("login2方法执行了");
		User user = (User) modelMap.get("user");
		user.setUsername("测试用户名(login2)");
		System.out.println(user);
		return "result";
	}

}
