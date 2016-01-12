/**
 * @Title: UserServiceTest.java
 * @Package com.atme8.activity.service
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月22日 上午9:48:43
 * @version V1.0
 */

package com.atme8.activity.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atme8.activity.BaseTest;
import com.atme8.activity.domain.entity.User;
import org.springframework.cache.annotation.Cacheable;


/**
 * @ClassName: UserServiceTest
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月22日 上午9:48:43
 *
 */

public class UserServiceTest extends BaseTest{
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		User user = new User();
		user.setNickname("隔壁小王");
		user.setRealname("小王");
		user.setEmail("desire4k@gmail.com");
		user.setPhone("18800093211");
		user.setCasOpenId("openid");
		Assert.assertEquals(1, userService.insert(user));
	}
}
