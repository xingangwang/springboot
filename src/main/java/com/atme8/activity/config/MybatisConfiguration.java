/**
 * @Title: MybatisConfiguration.java
 * @Package com.atme8.activity.conf
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月3日 上午12:13:11
 * @version V1.0
 */

package com.atme8.activity.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @ClassName: MybatisConfiguration
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月3日 上午12:13:11
 *
 */
@Configuration
@MapperScan(basePackages="com.atme8.activity.domain.dao.mybatis.mapper")
public class MybatisConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix="mybatis")
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean ;
	}
	
}
