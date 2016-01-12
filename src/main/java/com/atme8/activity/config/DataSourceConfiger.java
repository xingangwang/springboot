/**
 * @Title: DataSource.java
 * @Package com.atme8.activity.db
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月2日 下午6:30:11
 * @version V1.0
 */

package com.atme8.activity.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @ClassName: DataSource
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月2日 下午6:30:11
 *
 */
@Configuration
@ImportResource("classpath:/spring/applicationContext-transaction.xml")
public class DataSourceConfiger {
	
	@Bean
	@ConfigurationProperties(prefix="db")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource(HikariConfig configuration) {
		return new HikariDataSource(configuration);
	}

}
