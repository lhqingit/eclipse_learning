package com.lhq.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试@RequestMapping特殊情况可以映射的请求路径
 * @author lhq_i
 *
 */
@Controller
public class QTestController {

	@ResponseBody
	@RequestMapping(value = "")
	public Map<String,String> testEmptyStrMapping() {
		System.out.println("testEmptyStrMapping方法执行了");
		Map<String,String> map = new HashMap<>();
		map.put("msg", "该请求路径可以被@RequestMapping(value = \"\")映射到");
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/")
	public Map<String,String> testSlashStrMapping() {
		System.out.println("testSlashStrMapping方法执行了");
		Map<String,String> map = new HashMap<String,String>();
		map.put("msg", "该请求路径可以被@RequestMapping(value = \"/\")映射到");
		return map;
	}
	
	/**
	 * 测试value String[]
	 */
	@ResponseBody
	@RequestMapping(value= {"/valuetest1","/valuetest2"})
	public Map<String,String> testRequestMappingValues(){
		System.out.println("testRequestMappingValues方法执行了");
		Map<String,String> map = new HashMap<String,String>();
		map.put("msg", "该请求路径可以同时接受两个值的映射到");
		return map;
	}
	
	
	
}
