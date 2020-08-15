package com.yuantiao.test.impl;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

import com.yuantiao.webplatform.base.core.WebpfSpringBootServletInitializer;
import com.yuantiao.webplatform.core.annotation.EnableWebpfJDBCAutoConfig;


//@EnableEurekaClient
//@SpringBootApplication
//@EnableWebpfJDBCAutoConfig
//@Configuration
public class TestImplApp extends WebpfSpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TestImplApp.class);
		Properties pro = WebpfSpringBootServletInitializer.start(TestImplApp.class);
		app.setDefaultProperties(pro);
		app.run(args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		Properties pro = WebpfSpringBootServletInitializer.start(TestImplApp.class);
		application.properties(pro);
		return application.sources(TestImplApp.class);
	}
}