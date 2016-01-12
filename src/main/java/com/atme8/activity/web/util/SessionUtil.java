/**
 * @Title: SessionUtil.java
 * @Package com.atme8.activity.common.util
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月9日 下午3:26:17
 * @version V1.0
 */

package com.atme8.activity.web.util;

import com.atme8.activity.common.Constants;
import com.atme8.activity.domain.entity.User;
import com.atme8.activity.domain.entity.extension.UserExt;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;


/**
 * @ClassName: SessionUtil
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月9日 下午3:26:17
 *
 */

public class SessionUtil {
	
	public static final User getUser() {
		return (User) RequestHolder.getSession().getAttribute(Constants.SESSION_USER_KEY);
	}
	
	public static void setUser(User user) {
		if (user == null) {
			RequestHolder.getSession().setAttribute(Constants.SESSION_USER_KEY, null);
			return;
		}

		if (user instanceof UserExt) {
			RequestHolder.getSession().setAttribute(Constants.SESSION_USER_KEY, user);
			return;
		}

		if (user instanceof User) {
			UserExt userExt = new UserExt();
			try {
				BeanUtils.copyProperties(userExt, user);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			RequestHolder.getSession().setAttribute(Constants.SESSION_USER_KEY, userExt);
		}
	}
	
	public static void removeUser() {
		setUser(null);
	}
	
	public static final String getUserId() {
		return getUser().getId();
	}
}
