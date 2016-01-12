/**
 * @Title: ServletContextInitListener.java
 * @Package com.atme8.activity.web.listener
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月11日 上午10:32:43
 * @version V1.0
 */

package com.atme8.activity.web.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.atme8.activity.common.util.SystemSettingUtils;
import com.atme8.activity.domain.entity.SystemSetting;
import com.atme8.activity.service.SystemSettingService;
import com.atme8.activity.web.exception.SystemInitalizationException;
import com.atme8.apiSDK.util.SDKInit;



/**
 * @ClassName: ServletContextInitListener
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月11日 上午10:32:43
 *
 */
@Component
@ConfigurationProperties
public class SystemInitliazer implements ServletContextInitializer, InitializingBean{
	
	private static final Logger logger = LoggerFactory.getLogger(SystemInitliazer.class);
	
	@Autowired
	private SystemSettingService systemSettingService;

	private String customDomain;

	/*
	 * <p>Title: onStartup</p>
	 * <p>Description: </p>
	 * @param servletContext
	 * @throws ServletException
	 * @see org.springframework.boot.context.embedded.ServletContextInitializer#onStartup(javax.servlet.ServletContext)
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//do nothing
	}

	public String getCustomDomain() {
		return customDomain;
	}

	public void setCustomDomain(String customDomain) {
		this.customDomain = customDomain;
	}

	/*
         * <p>Title: afterPropertiesSet</p>
         * <p>Description: </p>
         * @throws Exception
         * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
         */
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("Start init SystemSettingUtils ");
		List<SystemSetting> systemSettings = systemSettingService.getSystemSettings();
		Map<String, String> properties = new HashMap<String, String>();
		for (SystemSetting systemSetting : systemSettings) {
			properties.put(systemSetting.getName(), systemSetting.getValue());
		}
		if (customDomain != null) {
			logger.info("custom domain:" + customDomain);
			properties.put("domain", customDomain);
		}
		try {
			SystemSettingUtils.init(properties);
			SystemSettingUtils sysSettingUtil = SystemSettingUtils.getInstance();
			SDKInit.init(sysSettingUtil.getCasPartnerId(), sysSettingUtil.getCasSecretKey(), sysSettingUtil.getCasServerUrl());
		} catch (Exception e) {
			throw new SystemInitalizationException("An exception occurred when init SystemSettingUtils", e); 
		}
		
	}

}
