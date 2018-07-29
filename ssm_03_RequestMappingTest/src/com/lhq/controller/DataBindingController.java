package com.lhq.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataBindingController {
	
	private static final Log logger = LogFactory.getLog(DataBindingController.class);
	
	@RequestMapping("/pathVariableTest/{userId}")
	public String pathVariableTest(@PathVariable Integer userId) {
		logger.info("pathVariableTest方法执行啦，获得数据：" + userId);
		return "redirect:/dataBindingTest.jsp";
	}
	
	@RequestMapping(value = "/requestHeaderTest")
	public String requestHeaderTest(
			@RequestHeader(value = "User-Agent") String userAgent,
			@RequestHeader(name = "Accept") String acceptsStr) {
		logger.info("requestHeaderTest方法执行啦！获得数据：");
		logger.info("userAgent：" + userAgent);
		logger.info("agents：");
		for (String accept : acceptsStr.split(";")) {
			logger.info(accept);
		}
		
		return "redirect:/dataBindingTest.jsp";
	}
	
	@RequestMapping(value = "/cookieValueTest")
	public String cookieValueTest(
			@CookieValue(value="JSESSIONID", defaultValue="") String sessionId) {
		
		logger.info("cookieValueTest方法执行啦，获得数据：" + sessionId);
		
		return "redirect:/dataBindingTest.jsp";
	}
}
