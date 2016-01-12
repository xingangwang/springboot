/**
 * @Title: CasClientTest.java
 * @Package com.atme8.activity.service.client
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月30日 下午2:26:50
 * @version V1.0
 */

package com.atme8.activity.service.client;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atme8.activity.BaseTest;
import com.atme8.activity.domain.entity.User;
import com.atme8.apiSDK.token.TokenGenerator;



/**
 * @ClassName: CasClientTest
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月30日 下午2:26:50
 *
 */

public class CasClientTest extends BaseTest{
	
	@Autowired
	private CasClient casClient;
	
	@Test
	public void testUpdate(){
		String openId = "fda65389-b6b3-49d1-9098-6df93f4b2234";
		String token = TokenGenerator.userGen(openId, null);
		String phone = "18504253335";
		casClient.updateAccount(openId, false, token, phone);
		User user = casClient.getUser(openId, token);
		Assert.assertEquals(phone, user.getPhone());
		
	}

}
