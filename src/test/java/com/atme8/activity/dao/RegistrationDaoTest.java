/**
 * @Title: RegistrationDaoTest.java
 * @Package com.atme8.activity
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月21日 下午1:38:09
 * @version V1.0
 */

package com.atme8.activity.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atme8.activity.BaseTest;
import com.atme8.activity.domain.dao.ActivityDao;
import com.atme8.activity.domain.dao.RegistrationDao;
import com.atme8.activity.domain.entity.Registration;
import com.atme8.activity.domain.entity.RegistrationInfo;



/**
 * @ClassName: RegistrationDaoTest
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月21日 下午1:38:09
 *
 */

public class RegistrationDaoTest extends BaseTest {
	
	public static String ACTIVITY_ID = "14";
	
	public static String USER_ID = "2";
	
	public static String COMPANY_NAME_FIELD_ID = "21";
	
	public static String ADDRESS_FIELD_ID = "22";
	
	@Autowired
	private RegistrationDao dao;
	
	@Autowired
	private ActivityDao activityDao;
	
	
	
	@Test
	public void test() {
		Registration reg = new Registration();
		reg.setUserId(USER_ID);
		reg.setActId(ACTIVITY_ID);
		reg.setCreateUserId(USER_ID);
		reg.setCreateDate(new Date());
		List<RegistrationInfo> values = new ArrayList<>();
		RegistrationInfo companyName = new RegistrationInfo();
		companyName.setFieldId(COMPANY_NAME_FIELD_ID);
		companyName.setValue("艾特密股份有限公司");
		values.add(companyName);
		RegistrationInfo address = new RegistrationInfo();
		address.setFieldId(ADDRESS_FIELD_ID);
		address.setValue("大连市沙河口区西连街8号");
		values.add(address);
		reg.setValues(values);
		Assert.assertEquals(1, dao.insert(reg));
	}
}
