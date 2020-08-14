package com.yuantiao.test.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@Value("${feign.compression.request.mime-types}")
	private String types;
	
	@RequestMapping("/test")
	public String printString(){
		return "Hello World! " + types;
	}
}