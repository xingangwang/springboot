/**
 * @Title: SystemSettingDao.java
 * @Package com.atme8.activity.domain.dao
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月11日 下午3:20:20
 * @version V1.0
 */

package com.atme8.activity.domain.dao;

import java.util.List;

import com.atme8.activity.domain.entity.SystemSetting;



/**
 * @ClassName: SystemSettingDao
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月11日 下午3:20:20
 *
 */

public interface SystemSettingDao {
	
	List<SystemSetting>	getSystemSettings();
}
