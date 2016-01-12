/**
 * @Title: SystemSettingDaoImpl.java
 * @Package com.atme8.activity.domain.dao.mybatis
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月11日 下午3:23:38
 * @version V1.0
 */

package com.atme8.activity.domain.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atme8.activity.domain.dao.SystemSettingDao;
import com.atme8.activity.domain.dao.mybatis.mapper.SystemSettingMapper;
import com.atme8.activity.domain.entity.SystemSetting;
import com.atme8.activity.domain.entity.SystemSettingExample;



/**
 * @ClassName: SystemSettingDaoImpl
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月11日 下午3:23:38
 *
 */
@Repository
public class SystemSettingDaoImpl implements SystemSettingDao{
	
	@Autowired
	private SystemSettingMapper systemSettingMapper;

	/*
	 * <p>Title: getSystemSettings</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.atme8.activity.domain.dao.SystemSettingDao#getSystemSettings()
	 */
	@Override
	public List<SystemSetting> getSystemSettings() {
		SystemSettingExample example = new SystemSettingExample();
		example.createCriteria().andIsValidEqualTo(true);
		return systemSettingMapper.selectByExample(example );
	}
	
	
}
