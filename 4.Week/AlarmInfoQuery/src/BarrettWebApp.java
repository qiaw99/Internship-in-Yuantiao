package com.yuantiao.barrett.bus;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.yuantiao.webplatform.base.core.WebpfSpringBootServletInitializer;
import com.yuantiao.webplatform.base.core.annotation.EnableWebpfSecurityAutoConfig;
import com.yuantiao.webplatform.core.annotation.EnableWebpfJDBCAutoConfig;
import com.yuantiao.webplatform.core.utils.WarPathUtil;

@SpringBootApplication
@EnableEurekaClient
@ImportResource(locations={"classpath:kaptcha.xml"})
@EnableFeignClients(basePackages={"com.yuantiao.webplatform.gis","com.yuantiao.data.engine","com.yuantiao.webplatform.base.api.**","com.yuantiao.barrett.api.**"})
@EnableWebpfSecurityAutoConfig
@EnableWebpfJDBCAutoConfig
@EnableScheduling
@ComponentScan(basePackages={"com.yuantiao.barrett.bus.**","com.yuantiao.webplatform.vs.**","com.yuantiao.webplatform.gis.**","com.yuantiao.data.engine.**","com.yuantiao.webplatform.scheduler.**"})
@Configuration
public class BarrettWebApp extends WebpfSpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BarrettWebApp.class);
		Properties pro = WebpfSpringBootServletInitializer.start(BarrettWebApp.class);
		
		try {
			// 增加  es配置
			InputStream inglobal = BarrettWebApp.class.getClassLoader().getResourceAsStream("global.properties");
			Properties config = new Properties();
			InputStream inconfig = null;
			Properties global = new Properties();
			global.load(inglobal);
			String configPath = WarPathUtil.getPath(global.getProperty("config.location"));
			String filePath = configPath + "app.properties";
			inconfig = new FileInputStream(filePath);
			config.load(inconfig);

			String name = config.getProperty("spring.data.elasticsearch.cluster-name");
			pro.setProperty("spring.data.elasticsearch.cluster-name", name);
			System.out.println("name is "+name);
			
			
			String nodes = config.getProperty("spring.data.elasticsearch.cluster-nodes");
			System.out.println("nodes is "+nodes);
			pro.setProperty("spring.data.elasticsearch.cluster-nodes", nodes);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		app.setDefaultProperties(pro);
		app.run(args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		Properties pro = WebpfSpringBootServletInitializer.start(BarrettWebApp.class);
		application.properties(pro);
		return application.sources(BarrettWebApp.class);
	}
	@Bean
	public FilterRegistrationBean corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);   
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    source.registerCorsConfiguration("/**", config); // CORS 配置对所有接口都有效
	    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	    bean.setOrder(0);
	    return bean;
	}
}