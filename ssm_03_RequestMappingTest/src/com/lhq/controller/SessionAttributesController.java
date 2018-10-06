package com.lhq.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lhq.domain.User;

@Controller
@SessionAttributes("user")
//@SessionAttributes(types= {随便一个类.class,User.class},value= "user")
public class SessionAttributesController {
	private static final Log logger = LogFactory.getLog(SessionAttributesController.class);

	@RequestMapping("/{formName}")
	public String loginForm(@PathVariable String formName) {
		logger.info("loginForm方法执行啦，跳转到视图：" + formName);
		return formName;
	}

	@RequestMapping("/loginBySession")
	public String sessionLogin(@RequestParam String loginname, String password, Model model) {
		logger.info("sessionLogin方法执行啦");
		User user = new User(loginname, password, "admin");
		model.addAttribute("user", user);
//		model.addAttribute(user);
		return "welcomeBySession";
	}
}
