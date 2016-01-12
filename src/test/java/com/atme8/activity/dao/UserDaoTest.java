/**
 * @Title: UserDaoTest.java
 * @Package com.atme8.activity.dao
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月3日 下午11:50:00
 * @version V1.0
 */

package com.atme8.activity.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.atme8.activity.Application;
import com.atme8.activity.domain.dao.UserDao;
import com.atme8.activity.domain.entity.User;



/**
 * @ClassName: UserDaoTest
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月3日 下午11:50:00
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserDaoTest {
	@Autowired
	public UserDao userDao;
	
	@Test
	public void test() {
		User user = new User();
		user.setCasOpenId("casid");
		user.setCreateDate(new Date());
		userDao.insert(user);
	}
}
