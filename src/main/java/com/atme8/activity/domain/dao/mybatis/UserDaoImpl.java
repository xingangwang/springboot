/**
 * @Title: UserDaoImpl.java
 * @Package com.atme8.activity.dao.mybatis.mapper
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月2日 下午4:30:27
 * @version V1.0
 */

package com.atme8.activity.domain.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.atme8.activity.domain.dao.UserDao;
import com.atme8.activity.domain.dao.mybatis.mapper.UserMapper;
import com.atme8.activity.domain.entity.User;
import com.atme8.activity.domain.entity.UserExample;
import com.atme8.activity.domain.entity.UserExample.Criteria;

/**
 * @ClassName: UserDaoImpl
 * @Description:
 * @author JeremyWang
 * @date 2015年9月2日 下午4:30:27
 * 
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserMapper userMapper;

	public int insert(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int updateByExampleSelective(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(user.getId())
			.andIsValidEqualTo(true);
		return userMapper.updateByExampleSelective(user, example);
	}

	@Override
	public List<User> selectByExample(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (user.getId() != null) {
			criteria.andIdEqualTo(user.getId());
		}
		if (!StringUtils.isEmpty(user.getCasOpenId())) {
			criteria.andCasOpenIdEqualTo(user.getCasOpenId());
		}
		if (!StringUtils.isEmpty(user.getRealname())) {
			criteria.andRealnameLike(user.getRealname());
		}
		criteria.andIsValidEqualTo(true);
		return userMapper.selectByExample(example);
	}

	@Override
	public int updateByPrimaryKeySelective(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	/*
	 * <p>Title: updateByPrimaryKey</p>
	 * <p>Description: </p>
	 * @param user
	 * @return
	 * @see com.atme8.activity.domain.dao.UserDao#updateByPrimaryKey(com.atme8.activity.domain.entity.User)
	 */
	@Override
	public boolean updateByPrimaryKey(User user) {
		return userMapper.updateByPrimaryKey(user) == 1;
	}

	@Override
	public int countAll() {
		UserExample example = new UserExample();
		example.createCriteria().andIsValidEqualTo(true);
		return userMapper.countByExample(example);
	}

}
