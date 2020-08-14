package com.yuantiao.test.web.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.yuantiao.webplatform.core.database.Datasource;

@TestComponent
public class JdbcTemplateJavaConfigTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JdbcTemplateConfiguration.class);
		JdbcTemplate jdbcTemplate = annotationConfigApplicationContext.getBean(JdbcTemplate.class);
		jdbcTemplate.query("SELECT * FROM webpf_datasource;", new RowMapper<Datasource>() {
			public Datasource mapRow(ResultSet rs, int num) throws SQLException{
				Datasource datasource = new Datasource();
				datasource.setDriverClassName(rs.getNString("driver_class_name"));
				return datasource;
			}
		});
	}
}