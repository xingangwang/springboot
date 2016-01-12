/**
 * @Title: Application.java
 * @Package com.atme8.activity
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月2日 下午9:53:54
 * @version V1.0
 */

package com.atme8.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;



/**
 * @ClassName: Application
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月2日 下午9:53:54
 *
 */
@EnableFeignClients(basePackages = "com.atme8.activity.service.client")
@SpringBootApplication
//@EnableConfigurationProperties()
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
