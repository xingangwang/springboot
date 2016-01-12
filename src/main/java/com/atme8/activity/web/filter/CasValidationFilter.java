/**
 * @Title: CasValidationFilter.java
 * @Package com.atme8.activity.web.filter
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月9日 下午3:06:19
 * @version V1.0
 */

package com.atme8.activity.web.filter;

import com.atme8.activity.common.util.DateFormatUtils;
import com.atme8.activity.domain.entity.User;
import com.atme8.activity.service.ActivityCallbackService;
import com.atme8.activity.service.UserService;
import com.atme8.activity.web.util.SessionUtil;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;



/**
 * @ClassName: CasValidationFilter
 * @Description: 
 * @author JeremyWang
 * @date 2015年9月9日 下午3:06:19
 *
 */
public class CasValidationFilter extends Cas20ProxyReceivingTicketValidationFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(CasValidationFilter.class);
	
	@Autowired
	private UserService userService;

	@Autowired(required = false)
	private ActivityCallbackService activityCallbackService;
	/*
	 * <p>Title: onSuccessfulValidation</p>
	 * <p>Description: </p>
	 * @param request
	 * @param response
	 * @param assertion
	 * @see org.jasig.cas.client.validation.AbstractTicketValidationFilter#onSuccessfulValidation(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.jasig.cas.client.validation.Assertion)
	 */
	@Override
	protected void onSuccessfulValidation(HttpServletRequest request, HttpServletResponse response,
			Assertion assertion) {
		String openId = (String) assertion.getPrincipal().getAttributes().get("openId");
		String realname = (String) assertion.getPrincipal().getAttributes().get("realname");
		String email = (String) assertion.getPrincipal().getAttributes().get("email");
		String phone = (String) assertion.getPrincipal().getAttributes().get("phone");
		String avatarStr = (String) assertion.getPrincipal().getAttributes().get("avatar");
		User localUser = userService.getUserByCasOpenId(openId);
		if (localUser == null) {
			localUser = new User();
			localUser.setEmail(email);
			localUser.setRealname(realname);
			localUser.setNickname(realname);
			localUser.setPhone(phone);
			localUser.setAvatar(avatarStr);
			localUser.setCasOpenId(openId);
        	localUser.setIsValid(true);
        	localUser.setCreateDate(new Date());
			userService.insert(localUser);
			logger.info("cas validation filter create local user : {}", localUser);
			localUser = userService.getUserByCasOpenId(openId);
        } else {
			localUser.setEmail(email);
			localUser.setRealname(realname);
			localUser.setNickname(realname);
			localUser.setPhone(phone);
			localUser.setAvatar(avatarStr);
			localUser.setUpdateDate(DateFormatUtils.getSystemDate());
			localUser.setUpdateUserId(localUser.getId());
        	logger.info("cas validation filter update local user : {}", localUser);
        	userService.updateById(localUser);
        }
        SessionUtil.setUser(localUser);
		if (activityCallbackService != null) {
			activityCallbackService.onAfterLoginSuccess(localUser);
		}
	}
	
	
	
}
