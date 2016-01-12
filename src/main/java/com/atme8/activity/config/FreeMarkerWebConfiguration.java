/**
 * @Title: FreeMarkerWebConfiguration.java
 * @Package com.atme8.activity.conf
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月10日 下午4:43:14
 * @version V1.0
 */

package com.atme8.activity.config;

import com.atme8.activity.common.util.SystemSettingUtils;
import com.atme8.activity.web.util.RequestHolder;
import com.atme8.activity.web.util.SessionUtil;
import freemarker.cache.TemplateLoader;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.*;



/**
 * @ClassName: FreeMarkerWebConfiguration
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月10日 下午4:43:14
 *
 */
@Configuration
public class FreeMarkerWebConfiguration {
	
	@Autowired
	private FreeMarkerProperties properties;
	
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() throws TemplateModelException {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		applyProperties(configurer);
		applyVariables(configurer);
		configurer.setPreferFileSystemAccess(false);
		return configurer;
	}
	
	/**
	 * applyVariables(这里用一句话描述这个方法的作用)
	 *
	 * @Title: applyVariables
	 * @Description: 
	 * @param configurer  void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年9月10日 下午4:50:04
	 * 
	 */
	private void applyVariables(FreeMarkerConfigurer configurer) {
		Map<String, Object> variables = new HashMap<>();
		variables.put("SystemSetting", SystemSettingUtils.getInstance());
		variables.put("LoginUser", new TemplateMethodModelEx() {
			
			@Override
			public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
				return SessionUtil.getUser();
			}
		});
		variables.put("getRequest", new TemplateMethodModelEx() {
			@Override
			public Object exec(List arguments) throws TemplateModelException {
				return RequestHolder.getRequest();
			}
		});
		configurer.setFreemarkerVariables(variables);
		List<TemplateLoader> postTemplateLoaders = createCustomTemplateLoaders();
		configurer.setPostTemplateLoaders(postTemplateLoaders.toArray(new TemplateLoader[0]));
	}

	/**
	 * createCustomTemplateLoaders(这里用一句话描述这个方法的作用)
	 * <p>(这里描述这个方法适用条件 – 可选)
	 * <p>(这里描述这个方法的执行流程 – 可选)
	 * <p>(这里描述这个方法的使用方法 – 可选)
	 * <p>(这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: createCustomTemplateLoaders
	 * @Description: 
	 * @return  TemplateLoader    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年9月16日 下午3:30:39
	 * 
	 */
	private List<TemplateLoader> createCustomTemplateLoaders() {
		List<TemplateLoader> temlateLoaders = new ArrayList<>();
		if (properties.getTemplateLoaderPath() != null) {
			for (String path : properties.getTemplateLoaderPath()) {
				temlateLoaders.add(new SpringTemplateLoader(new ClassRelativeResourceLoader(this.getClass()) , path));
			}
		}
		return temlateLoaders;
	}

	private void applyProperties(FreeMarkerConfigurationFactory factory) {
		factory.setTemplateLoaderPaths(this.properties.getTemplateLoaderPath());
		factory.setDefaultEncoding(this.properties.getCharset());
		Properties settings = new Properties();
		settings.putAll(this.properties.getSettings());
		factory.setFreemarkerSettings(settings);
	}

}
