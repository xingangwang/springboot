/**
 * @Title: SystemSetting.java
 * @Package com.atme8.activity.conf
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月10日 下午5:06:58
 * @version V1.0
 */

package com.atme8.activity.common.util;

import ch.qos.logback.core.pattern.ConverterUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SystemSetting
 * @Description: 系统设置
 * @author JeremyWang
 * @date 2015年9月10日 下午5:06:58
 * 
 */
public class SystemSettingUtils {

	static {
		ConvertUtils.register(new Converter() {
			@SuppressWarnings("unchecked")
			@Override
			public <T> T convert(Class<T> type, Object value) {
				if (value instanceof String) {
					String p = (String) value;
					if (p == null || p.trim().length() == 0) {
						return null;
					}
					try {
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						return (T) df.parse(p.trim());
					} catch (Exception e) {
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						try {
							return (T) df.parse(p.trim());
						} catch (ParseException e1) {
							return null;
						}
					}
				} else if (value instanceof java.util.Date) {
					return (T) new Date(((Date) value).getTime());
				} else {
					throw new IllegalArgumentException("Unsupported value type: " + value.getClass());
				}

			}
		}, java.util.Date.class);


	}

	private static SystemSettingUtils instance;

	/**
	 * init(系统配置项初始化)
	 * 
	 * @Title: init
	 * @Description:
	 * @param properties
	 *            void 返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年9月11日 下午3:55:23
	 * 
	 */
	public static void init(Map<String, String> properties) throws IllegalAccessException,
			InvocationTargetException {
		BeanUtils.populate(getInstance(), properties);
		getInstance().setProps(properties);
	}

	public static SystemSettingUtils getInstance() {
		if (instance == null) {
			synchronized (SystemSettingUtils.class) {
				if (instance == null) {
					instance = new SystemSettingUtils();
				}
			}
		}
		return instance;
	}

	public String getCustomDomain() {
		return customDomain;
	}

	public void setCustomDomain(String customDomain) {
		this.customDomain = customDomain;
	}

	private String customDomain;

	private Map<String, String> props = new HashMap<>();

	private String domain;

	private String casServerUrl;

	private String casPartnerId;

	private String casChanelId;

	private Date uploadbegintime;

	/**
	 * casPartnerId getter method
	 * 
	 * @return the casPartnerId
	 */
	public String getCasPartnerId() {
		return casPartnerId;
	}

	/**
	 * casPartnerId setter method
	 * 
	 * @param casPartnerId
	 *            the casPartnerId to set
	 */
	public void setCasPartnerId(String casPartnerId) {
		this.casPartnerId = casPartnerId;
	}

	/**
	 * casSecretKey getter method
	 * 
	 * @return the casSecretKey
	 */
	public String getCasSecretKey() {
		return casSecretKey;
	}

	/**
	 * casSecretKey setter method
	 * 
	 * @param casSecretKey
	 *            the casSecretKey to set
	 */
	public void setCasSecretKey(String casSecretKey) {
		this.casSecretKey = casSecretKey;
	}

	private String casSecretKey;

	public String get(String key) {
		return props.get(key);
	}

	/**
	 * domain getter method
	 * 
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * domain setter method
	 * 
	 * @param domain
	 *            the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * casServerUrl getter method
	 * 
	 * @return the casServerUrl
	 */
	public String getCasServerUrl() {
		return casServerUrl;
	}

	/**
	 * casServerUrl setter method
	 * 
	 * @param casServerUrl
	 *            the casServerUrl to set
	 */
	public void setCasServerUrl(String casServerUrl) {
		this.casServerUrl = casServerUrl;
	}

	/**
	 * props setter method
	 * 
	 * @param props
	 *            the props to set
	 */
	private void setProps(Map<String, String> props) {
		this.props = props;
	}

	/**
	 * casChanelId getter method
	 * 
	 * @return the casChanelId
	 */
	public String getCasChanelId() {
		return casChanelId;
	}

	/**
	 * casChanelId setter method
	 * 
	 * @param casChanelId
	 *            the casChanelId to set
	 */
	public void setCasChanelId(String casChanelId) {
		this.casChanelId = casChanelId;
	}

	/**
	 * uploadbegintime getter method
	 * 
	 * @return the uploadbegintime
	 */
	public Date getUploadbegintime() {
		return uploadbegintime;
	}

	/**
	 * uploadbegintime setter method
	 * 
	 * @param uploadbegintime
	 *            the uploadbegintime to set
	 */
	public void setUploadbegintime(Date uploadbegintime) {
		this.uploadbegintime = uploadbegintime;
	}

}
