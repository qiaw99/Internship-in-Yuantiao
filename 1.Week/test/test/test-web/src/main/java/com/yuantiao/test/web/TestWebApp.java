package com.yuantiao.test.web;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.yuantiao.webplatform.base.core.WebpfSpringBootServletInitializer;
import com.yuantiao.webplatform.base.core.annotation.EnableWebpfSecurityAutoConfig;
import com.yuantiao.webplatform.core.annotation.EnableWebpfJDBCAutoConfig;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.yuantiao.webplatform.base.api.**","com.yuantiao.test.api.**"})
@EnableWebpfSecurityAutoConfig
@EnableWebpfJDBCAutoConfig
@Configuration
@EnableScheduling
@ComponentScan(basePackages={
	"com.yuantiao.test.impl.**",
	"com.yuantiao.test.web.**",
	"com.yuantiao.webplatform.scheduler.**",
	"com.yuantiao.webplatform.vs.**",
	"com.yuantiao.webplatform.gis.**",
	"com.yuantiao.data.engine.**"})
@ComponentScan(value = "com.yuantiao.test.web.controller")
public class TestWebApp extends WebpfSpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TestWebApp.class);
		Properties pro = WebpfSpringBootServletInitializer.start(TestWebApp.class);
		app.setDefaultProperties(pro);
		app.run(args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		Properties pro = WebpfSpringBootServletInitializer.start(TestWebApp.class);
		application.properties(pro);
		return application.sources(TestWebApp.class);
	}
}