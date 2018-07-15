package com.lhq.controller;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lhq.domain.User;

@Controller
public class UserMVController {

	private static final Log logger = LogFactory.getLog(UserMVController.class);

	@ModelAttribute
	public void userModel3(String loginname, String password, ModelAndView mv) {
		mv.addObject("user", new User(loginname, password, null));
	}

	@RequestMapping("/login3")
	public ModelAndView login3(ModelAndView mv) {
		logger.info("login3方法执行了");
		Map<String, Object> testModel = mv.getModel();
		User user = (User) mv.getModel().get("user");
		System.out.println(user);
		user.setUsername("测试用户名(login3)");
		mv.setViewName("result");
		return mv;
	}
}
