/**
 * @Title: SystemSettingServiceImpl.java
 * @Package com.atme8.activity.service.impl
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月11日 下午3:15:44
 * @version V1.0
 */

package com.atme8.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atme8.activity.domain.dao.SystemSettingDao;
import com.atme8.activity.domain.entity.SystemSetting;
import com.atme8.activity.service.SystemSettingService;



/**
 * @ClassName: SystemSettingServiceImpl
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月11日 下午3:15:44
 *
 */
@Service
public class SystemSettingServiceImpl implements SystemSettingService{
	
	@Autowired
	private SystemSettingDao systemSettingDao;
	
	/*
	 * <p>Title: getSystemSettings</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.atme8.activity.service.SystemSettingService#getSystemSettings()
	 */
	@Override
	public List<SystemSetting> getSystemSettings() {
		return systemSettingDao.getSystemSettings();
	}

}
