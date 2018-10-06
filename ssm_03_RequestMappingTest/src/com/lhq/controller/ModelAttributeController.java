package com.lhq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelAttributeController {

	@ModelAttribute("loginname")
	public String userModel1(String loginname) {
		return loginname;
	}
	
	@RequestMapping("/login1")
	public String login1() {
		return "result";
	}
}
