/**
 * @Title: SystemSettingService.java
 * @Package com.atme8.activity.service
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月11日 下午3:15:21
 * @version V1.0
 */

package com.atme8.activity.service;

import java.util.List;

import com.atme8.activity.domain.entity.SystemSetting;



/**
 * @ClassName: SystemSettingService
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月11日 下午3:15:21
 *
 */

public interface SystemSettingService {
	List<SystemSetting>	getSystemSettings();
}
