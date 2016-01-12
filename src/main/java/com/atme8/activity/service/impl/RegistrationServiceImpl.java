package com.atme8.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atme8.activity.common.util.DateFormatUtils;
import com.atme8.activity.domain.dao.ActivityDao;
import com.atme8.activity.domain.dao.RegistrationDao;
import com.atme8.activity.domain.entity.Registration;
import com.atme8.activity.domain.entity.User;
import com.atme8.activity.service.AbstractService;
import com.atme8.activity.service.ActivityCallbackService;
import com.atme8.activity.service.RegistrationService;
import com.atme8.activity.service.client.CasClient;
import com.atme8.activity.web.util.SessionUtil;

@Service
public  class RegistrationServiceImpl extends AbstractService implements
		RegistrationService {
	
	@Autowired
	private RegistrationDao registrationDao;
	
	@Autowired
	private ActivityDao activityDao;

	@Autowired(required=false)
	private ActivityCallbackService callbackService;

	@Autowired
	private CasClient casClient;

	@Override
	public List<User> selectRegUsersByActId(String actId) {
		return registrationDao.selectRegUsersByActId(actId);
	}
	
	@Override
	public int deleteByExample(Registration registration) {
		return registrationDao.deleteByExample(registration);
	}

	@Override
	public int insert(Registration registration) {
		registration.setCreateDate(DateFormatUtils.getSystemDate());
		registration.setCreateUserId(SessionUtil.getUserId());
		registration.setUserId(SessionUtil.getUserId());
		int i = registrationDao.insert(registration);
		if (callbackService != null) {
			callbackService.onActivityRegisterSuccess(registration);
		}
		return i;  
	}

	/*
	 * <p>Title: selectRegistration</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param activityId
	 * @return
	 * @see com.atme8.activity.service.RegistrationService#selectRegistration(java.lang.String, java.lang.String)
	 */
	@Override
	public Registration selectRegistration(String userId, String activityId) {
		return registrationDao.selectRegistration(userId, activityId);
	}

	@Override
	public int countAll(String actId) {
		return registrationDao.countAll(actId);
	}

}
