package com.lhq.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 控制器，可以处理一个单一的请求动作
 * 
 * @author lhq_i
 *
 */
@Controller
public class HelloController {

	private static final Log logger = LogFactory.getLog(HelloController.class);


	@RequestMapping(value="/hello")
	public ModelAndView hello() {

		logger.info("helloController的handleRequest被调用");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Hello World!");
		modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
		
		return modelAndView;
	}

}
