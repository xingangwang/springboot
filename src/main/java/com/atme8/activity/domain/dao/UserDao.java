/**
 * @Title: UserDao.java
 * @Package com.atme8.activity.dao
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年9月2日 下午4:29:57
 * @version V1.0
 */

package com.atme8.activity.domain.dao;

import java.util.List;

import com.atme8.activity.domain.entity.User;

/**
 * @ClassName: UserDao
 * @Description:
 * @author JeremyWang
 * @date 2015年9月2日 下午4:29:57
 * 
 */

public interface UserDao {

	int insert(User user);

	int updateByExampleSelective(User user);

	List<User> selectByExample(User user);

	int updateByPrimaryKeySelective(User user);

	boolean updateByPrimaryKey(User user);

	int countAll();
}
