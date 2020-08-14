package com.yuantiao.test.impl.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.yuantiao.webplatform.core.database.YtBaseMapperConfig;

/**
 * database config
 * @author 
 *
 */
@Configuration
@MapperScan(basePackages = {"com.yuantiao.test.impl.dao",
"com.yuantiao.webplatform.scheduler.dao",
"com.yuantiao.webplatform.vs.dao",
"com.yuantiao.webplatform.base.api.overlay.dao",
"com.yuantiao.webplatform.gis.dao",
"com.yuantiao.data.engine.dao",
"com.yuantiao.data.engine.dcdao"}, sqlSessionTemplateRef = "testSqlSessionTemplate")
public class TestMapperConfig extends YtBaseMapperConfig {
	
	
	@Bean(name = "testDataSource")
    @Primary //second mapper should not add
    public DataSource testDataSource() {
		return this.dataSource("test");
    }
    
    @Bean("testSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource) throws Exception {
        return this.sqlSessionFactory(dataSource, "classpath*:com/yuantiao/test/impl/dao/*.xml"
        	+",classpath*:com/yuantiao/webplatform/scheduler/dao/*.xml"
        	+",classpath*:com/yuantiao/webplatform/vs/dao/*.xml"
        	+",classpath*:com/yuantiao/webplatform/gis/dao/*.xml"
        	+",classpath*:com/yuantiao/engine/dao/*.xml"
        	+",classpath*:com/yuantiao/engine/dcdao/*.xml"
        	+ "classpath*:com/yuantiao/webplatform/base/api/overlay/dao/*.xml,"
        	);
    }
    
    @Bean("testSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return this.sqlSessionTemplate(sqlSessionFactory);
    }
}
