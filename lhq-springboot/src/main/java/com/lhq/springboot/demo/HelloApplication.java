package com.lhq.springboot.demo;

import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication(exclude= {SolrAutoConfiguration.class})
//@Configuration
public class HelloApplication {
	
	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		return "hello~第一个springBoot程序~";
	}
	
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("ISO_8859_1"));
//		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return converter;
	}

	public static void main(String[] args) {
//		SpringApplication.run(HelloApplication.class, args);
		SpringApplication app = new SpringApplication(HelloApplication.class);
//		app.setBannerMode(Mode.OFF);
		app.run(args);
		
	}
}
