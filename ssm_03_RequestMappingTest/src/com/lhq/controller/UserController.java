package com.lhq.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lhq.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {

	private static List<User> userList;

	public UserController() {
		userList = new ArrayList<User>();
	}

	// 打印 七月 28, 2018 6:51:09 下午 com.lhq.controller.UserController registerForm
	private static final Log logger = LogFactory.getLog(UserController.class);
	// 打印 七月 28, 2018 6:53:01 下午 UserController日志 registerForm
	// private static final Log logger = LogFactory.getLog("UserController日志");

//	@RequestMapping(value = "")可通过.../user/和.../user访问
//	@RequestMapping(value = "/")可通过.../user/访问
	@RequestMapping(value = "/register")
	public String registerForm() {
		logger.info("registerForm() 执行啦");
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("loginname") String loginname, @RequestParam("password") String password,
			@RequestParam("username") String username) {
		logger.info("register POST 方法被调用啦");
		User user = new User(loginname, password, username);
		userList.add(user);
		return "loginForm";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("loginname") String loginname, @RequestParam("password") String password,
			Model model) {
		logger.info("login方法执行啦，登录名：" + loginname + "密码：" + password);
		for (User user : userList) {
			if (user.getLoginname().equals(loginname) && user.getPassword().equals(password)) {
				model.addAttribute("user", user);
				return "welcome";
			}
		}
		return "loginForm";
	}
}
