package com.atme8.activity.domain.dao;

import java.util.List;

import com.atme8.activity.domain.entity.Registration;
import com.atme8.activity.domain.entity.User;

public interface RegistrationDao {
	
	List<Registration> selectRegsByUserId(String userId);
	
	List<User> selectRegUsersByActId(String actId);
	
	int deleteByExample(Registration registration);
	
	int insert(Registration registration);

	Registration selectRegistration(String userId, String activityId);

	int countAll(String actId);
}
