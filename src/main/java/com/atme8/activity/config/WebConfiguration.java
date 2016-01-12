/**
 * @Title: WebConfiguration.java
 * @Package com.atme8.activity.conf
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月8日 下午9:48:09
 * @version V1.0
 */

package com.atme8.activity.config;

import java.util.ArrayList;
import java.util.List;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.authentication.AuthenticationRedirectStrategy;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.atme8.activity.common.util.SystemSettingUtils;
import com.atme8.activity.web.filter.CasValidationFilter;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;


/**
 * @ClassName: WebConfiguration
 * @Description: Servlet环境相关配置 
 * @author JeremyWang
 * @date 2015年9月8日 下午9:48:09
 *
 */
@EnableFeignClients(basePackages = "com.atme8.activity.service.client")
@Configuration
public class WebConfiguration {

	private static final String ENCODING = "UTF-8";

	private String casServerUrl = "http://" + SystemSettingUtils.getInstance().getCasServerUrl();

	private String casClientUrl = SystemSettingUtils.getInstance().getDomain();

	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;

	@PostConstruct
	public void init() {
		ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
		if (initializer.getConversionService() != null) {
			GenericConversionService genericConversionService = (GenericConversionService) initializer.getConversionService();
			genericConversionService.addConverter(new StringToDateConverter());
		}
	}
	/**
	 * singleSignOutFilter(CAS单点登出用Filter)
	 *
	 * @Title: singleSignOutFilter
	 * @Description: 
	 * @return  FilterRegistrationBean    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年9月9日 下午1:54:45
	 * 
	 */
	@Bean
	public FilterRegistrationBean singleSignOutFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setName("SingleSignOutFilter");
		bean.setFilter(new SingleSignOutFilter());
		bean.addUrlPatterns("/*");
		return bean ;
	}
	
	@Bean
	public FilterRegistrationBean authenticationFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setName("AuthenticationFilter");
		bean.setFilter(new AuthenticationFilter());
		bean.addInitParameter("casServerLoginUrl", SystemSettingUtils.getInstance().getDomain() + "/login");
		bean.addInitParameter("serverName", casClientUrl);
		bean.addInitParameter("authenticationRedirectStrategyClass", "com.atme8.activity.config.AjaxAuthenticationRedirectStrategy");
		bean.addUrlPatterns("/act/*");
		bean.addUrlPatterns("/user/*");
		bean.addUrlPatterns("/works/doComment");
		return bean ;
	}
	
	@Bean
	public FilterRegistrationBean registerCasValidationFilter(CasValidationFilter filter) {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setName("CasValidationFilter");
		bean.setFilter(filter);
		bean.addInitParameter("casServerUrlPrefix", casServerUrl);
		bean.addInitParameter("serverName", casClientUrl);
		bean.addInitParameter("encoding", ENCODING);
		bean.addInitParameter("redirectAfterValidation", "true");
		return bean ;
	}
	
	@Bean
	public CasValidationFilter casValidationFilter() {
		return new CasValidationFilter();
	}
	
	@Bean
	public HttpMessageConverter<Object> myConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(MediaType.TEXT_HTML);
		supportedMediaTypes.add(MediaType.TEXT_PLAIN);
		converter.setSupportedMediaTypes(supportedMediaTypes );
		return converter ;
	}
}
