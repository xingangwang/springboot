package com.atme8.activity.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atme8.activity.common.util.DateFormatUtils;
import com.atme8.activity.domain.dao.UserDao;
import com.atme8.activity.domain.entity.User;
import com.atme8.activity.service.AbstractService;
import com.atme8.activity.service.UserService;

@Service
public class UserServiceImpl extends AbstractService implements UserService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public int insert(User user) {
		user.setCreateDate(DateFormatUtils.getSystemDate());
		user.setIsValid(true);
		if (user.getNickname() == null) {
			user.setNickname(user.getRealname());
		}
		return userDao.insert(user);
	}

	@Override
	public List<User> selectByExample(User user) {
		return userDao.selectByExample(user);
	}

	@Override
	public int updateByExampleSelective(User user) {
		return userDao.updateByExampleSelective(user);
	}

	@Override
	public int updateByPrimaryKeySelective(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}

	/*
	 * <p>Title: getUserByCasOpenId</p>
	 * <p>Description: </p>
	 * @param openId
	 * @return
	 * @see com.atme8.activity.service.UserService#getUserByCasOpenId(java.lang.String)
	 */
	@Override
	public User getUserByCasOpenId(String openId) {
		User user = new User();
		user.setCasOpenId(openId);
		List<User> users = userDao.selectByExample(user);
		if (CollectionUtils.isEmpty(users)) {
			return null;
		}
		return users.get(0);
	}

	/*
	 * <p>Title: getUserByPrimaryKey</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.atme8.activity.service.UserService#getUserByPrimaryKey(java.lang.String)
	 */
	@Override
	public User getUserByPrimaryKey(String id) {
		User user = new User();
		user.setId(id);
		List<User> users = userDao.selectByExample(user);
		if (CollectionUtils.isEmpty(users)) {
			return null;
		}
		return users.get(0);
	}

	/*
	 * <p>Title: updateById</p>
	 * <p>Description: </p>
	 * @param localUser
	 * @return
	 * @see com.atme8.activity.service.UserService#updateById(com.atme8.activity.domain.entity.User)
	 */
	@Override
	public boolean updateById(User user) {
		return userDao.updateByPrimaryKey(user);
	}
}
