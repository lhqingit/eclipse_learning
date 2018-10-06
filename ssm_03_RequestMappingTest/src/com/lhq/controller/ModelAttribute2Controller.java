package com.lhq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttribute2Controller {

	@ModelAttribute
	public void userModel1(String loginname,String password, Model model) {
		model.addAttribute("loginname", loginname);
		model.addAttribute("password", password);
	}

	@RequestMapping("/login2")
	public String login2() {
		return "result";
	}
}
