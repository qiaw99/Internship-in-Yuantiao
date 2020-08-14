package com.yuantiao.test.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yuantiao.webplatform.core.database.Datasource;

@Configuration
@PropertySource(value = "{classpath:db.properties}")
public class JdbcTemplateConfiguration {
	@Value("$(jdbcDriverClassName)")
	private String jdbcDriverClassName;
	
	@Value("$(jdbcUrl)")
	private String jdbcUrl;
	
	@Value("$(jdbcUserName)")
	private String jdbcUserName;
	
	@Value("$(jdbcPassword)")
	private String jdbcPassword;
	
	@Bean
	public Datasource datasource(){
		Datasource datasource = new Datasource();
		datasource.setDriverClassName(jdbcDriverClassName);
		datasource.setUrl(jdbcUrl);
		datasource.setPassword(jdbcPassword);
		datasource.setUsername(jdbcUserName);
		return datasource;  
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource((DataSource) datasource());
		return jdbcTemplate;
	}
}