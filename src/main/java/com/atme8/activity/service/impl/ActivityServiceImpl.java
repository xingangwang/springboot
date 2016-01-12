package com.atme8.activity.service.impl;

import com.atme8.activity.domain.dao.ActivityDao;
import com.atme8.activity.domain.entity.ActStage;
import com.atme8.activity.domain.entity.Activity;
import com.atme8.activity.domain.entity.ActivityRegField;
import com.atme8.activity.service.AbstractService;
import com.atme8.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActivityServiceImpl extends AbstractService implements
		ActivityService {

	@Autowired
	private ActivityDao activityDao;

	@Override
	public boolean insert(Activity activity) {
		return activityDao.insert(activity);
	}
	
	@Override
	public int deleteByActId(String id) {
		return activityDao.deleteByActId(id);
	}

	@Override
	public int updateByActId(Activity activity) {
		return activityDao.updateByActId(activity);
	}

	@Override
	public Activity selectActInfoByActId(String actId) {
		return activityDao.selectActInfoByActId(actId);
	}

	/*
	 * <p>Title: selectRegFieldById</p>
	 * <p>Description: </p>
	 * @param fieldId
	 * @return
	 * @see com.atme8.activity.service.ActivityService#selectRegFieldById(java.lang.String)
	 */
	@Override
	public ActivityRegField selectRegFieldById(String fieldId) {
		return activityDao.selectRegFieldById(fieldId);
	}

	@Override
	public ActStage getCurrentStage(String actId) {
		return activityDao.getCurrentStage(actId);
	}

}
