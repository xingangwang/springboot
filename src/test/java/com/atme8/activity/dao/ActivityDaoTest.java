/**
 * @Title: ActivityDaoTest.java
 * @Package com.atme8.activity.dao
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月21日 上午11:10:17
 * @version V1.0
 */

package com.atme8.activity.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.atme8.activity.BaseTest;
import com.atme8.activity.common.util.DateFormatUtils;
import com.atme8.activity.domain.dao.ActivityDao;
import com.atme8.activity.domain.entity.ActStage;
import com.atme8.activity.domain.entity.Activity;
import com.atme8.activity.domain.entity.ActivityRegField;



/**
 * @ClassName: ActivityDaoTest
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月21日 上午11:10:17
 *
 */

public class ActivityDaoTest extends BaseTest {
	
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ActivityDaoTest.class);
	
	private static final String USER_ID = "1";

	private static final Date CREAT_DATE = new Date();
	
	private static String ACTIVITY_ID = "5";
	
	@Autowired
	private ActivityDao dao;

	@Test
//	@Ignore
	public void Test() {
		Activity act = new Activity();
		act.setTitle("百强师资评选");
		Date regDeadline = new Date();
		DateUtils.setYears(regDeadline, 2015);
		DateUtils.setMonths(regDeadline, 10);
		DateUtils.setDays(regDeadline, 20);
		act.setRegDeadline(regDeadline);
		act.setAddress("大连税务高等专科学校");
		act.setUpperLimit(500);
		act.setIsFree(true);
		act.setCreateDate(new Date());
		act.setIsValid(true);
		act.setCreateUserId(USER_ID);
		
		List<ActivityRegField> actRegFields = new ArrayList<ActivityRegField>();
		ActivityRegField companyName = new ActivityRegField();
		companyName.setName("公司名称");
		companyName.setCreateUserId(USER_ID);
		companyName.setCreateDate(CREAT_DATE);
		actRegFields.add(companyName);
		ActivityRegField email = new ActivityRegField();
		email.setName("电子邮件地址");
		email.setCreateUserId(USER_ID);
		email.setCreateDate(CREAT_DATE);
		actRegFields.add(email);
		act.setRegFields(actRegFields);
		
		List<ActStage> stages = new ArrayList<>();
		ActStage firstStage = new ActStage();
		firstStage.setName("第一阶段");
		firstStage.setBegin(DateFormatUtils.parseISO_DATETIME_FORMAT("2015-10-10 08:00:00"));
		firstStage.setEnd(DateFormatUtils.parseISO_DATETIME_FORMAT("2015-10-15 08:00:00"));
		firstStage.setOrder1(1);
		stages.add(firstStage);
		ActStage secondStage = new ActStage();
		secondStage.setName("第二阶段");
		secondStage.setBegin(DateFormatUtils.parseISO_DATETIME_FORMAT("2015-10-16 08:00:00"));
		secondStage.setEnd(DateFormatUtils.parseISO_DATETIME_FORMAT("2015-10-18 08:00:00"));
		secondStage.setOrder1(2);
		stages.add(secondStage);
		act.setStages(stages);
		Assert.assertEquals(true, dao.insert(act));
		ACTIVITY_ID = act.getId();
	}
	
	@Test
	public void testSelectByID() {
		Activity act = dao.selectActInfoByActId(ACTIVITY_ID);
		Assert.assertEquals(ACTIVITY_ID, act.getId());
	}
}
