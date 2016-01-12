/**
 * @Title: BaseTest.java
 * @Package com.atme8.activity.dao
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月21日 上午11:10:41
 * @version V1.0
 */

package com.atme8.activity;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.atme8.activity.Application;



/**
 * @ClassName: BaseTest
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月21日 上午11:10:41
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class BaseTest {
	
}
