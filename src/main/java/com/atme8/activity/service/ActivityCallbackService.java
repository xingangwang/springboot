/**
 * @Title: RegisterCallbackService.java
 * @Package com.atme8.activity.service
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月21日 下午4:04:18
 * @version V1.0
 */

package com.atme8.activity.service;

import com.atme8.activity.domain.entity.Registration;
import com.atme8.activity.domain.entity.User;


/**
 * @ClassName: ActivityCallbackService
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月21日 下午4:04:18
 *
 */

public interface ActivityCallbackService {
	
	/**
	 * onActivityRegisterSuccess(用户报名活动成功以后的回调函数)
	 *
	 * @Title: onUserCreatSuccess
	 * @Description: 
	 * @param Registration
	 * @return  boolean    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年9月21日 下午6:17:43
	 * 
	 */
	boolean onActivityRegisterSuccess(Registration Registration);


	void onAfterLoginSuccess(User user);
}
