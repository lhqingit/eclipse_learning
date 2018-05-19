package com.lhq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 控制器，可以处理一个单一的请求动作
 * 
 * @author lhq_i
 *
 */
public class HelloController implements Controller {

	private static final Log logger = LogFactory.getLog(HelloController.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.info("helloController的handleRequest被调用");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Hello World!");
		modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
		
		return modelAndView;
	}

}
