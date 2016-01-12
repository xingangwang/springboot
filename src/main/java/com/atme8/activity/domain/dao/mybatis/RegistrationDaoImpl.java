package com.atme8.activity.domain.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import com.atme8.activity.common.Constants;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atme8.activity.domain.dao.ActivityDao;
import com.atme8.activity.domain.dao.RegistrationDao;
import com.atme8.activity.domain.dao.mybatis.mapper.ActivityRegFieldMapper;
import com.atme8.activity.domain.dao.mybatis.mapper.RegistrationInfoMapper;
import com.atme8.activity.domain.dao.mybatis.mapper.RegistrationMapper;
import com.atme8.activity.domain.dao.mybatis.mapper.UserMapper;
import com.atme8.activity.domain.entity.Registration;
import com.atme8.activity.domain.entity.RegistrationExample;
import com.atme8.activity.domain.entity.RegistrationExample.Criteria;
import com.atme8.activity.domain.entity.RegistrationInfo;
import com.atme8.activity.domain.entity.RegistrationInfoExample;
import com.atme8.activity.domain.entity.User;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	private RegistrationMapper registrationMapper;
	
	@Autowired
	private ActivityDao activityDao;

	@Autowired
	private ActivityRegFieldMapper actRegFieldMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RegistrationInfoMapper registrationInfoMapper;
	
	@Autowired
	private ActivityDaoImpl activityDaoImpl;
	
	/*
	 * <p>Title: selectRegActivitysByUserId</p>
	 * <p>Description: 根据UserId 查询所报名信息 </p>
	 * @param userId
	 * @return List<Activity>
	 * @see com.atme8.activity.domain.dao.RegistrationDao#selectRegActivitysByUserId(int)
	 */
	@Override
	public List<Registration> selectRegsByUserId(String userId) {
		RegistrationExample registrationExample = new RegistrationExample();
		registrationExample.createCriteria().andUserIdEqualTo(userId)
			.andIsValidEqualTo(true); 
		List<Registration> regs = registrationMapper.selectByExample(registrationExample);
		for (Registration registration : regs) {
			registration.setValues(getValuesByRegId(registration.getId()));
		}
		return regs;
	}

	/**
	 * getValuesByRegId(获取报名详细信息)
	 *
	 * @Title: getValuesByRegId
	 * @Description: 
	 * @param id
	 * @return  List<RegistrationInfo>   
	 * @throws
	 * @author JeremyWang
	 * @date 2015年9月29日 下午4:44:53
	 * 
	 */
	private List<RegistrationInfo> getValuesByRegId(String id) {
		RegistrationInfoExample infoExample = new RegistrationInfoExample();
		infoExample.createCriteria().andRegIdEqualTo(id)
			.andIsValidEqualTo(true);
		return registrationInfoMapper.selectByExample(infoExample);
	}

	
	/*
	 * <p>Title: selectRegUsersByactId</p>
	 * <p>Description: 根据actId 查询报名User的信息 </p>
	 * @param actId
	 * @return List<User>
	 * @see com.atme8.activity.domain.dao.RegistrationDao#selectRegUsersByactId(int)
	 */
	@Override
	public List<User> selectRegUsersByActId(String actId) {
		RegistrationExample registrationExample = new RegistrationExample();
		registrationExample.createCriteria().andActIdEqualTo(actId)
			.andIsValidEqualTo(true);
		List<Registration> regs = registrationMapper.selectByExample(registrationExample);
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < regs.size(); i++) {
			User user = userMapper.selectByPrimaryKey(regs.get(i).getUserId());
			users.add(user);
		}
		return users;
	}

	/*
	 * <p>Title: deleteByExample</p>
	 * <p>Description: 根据条件删除报名信息</p>
	 * @param registration
	 * @return int
	 * @see com.atme8.activity.domain.dao.RegistrationDao#deleteByExample(com.atme8.activity.domain.entity.Registration)
	 */
	@Override
	public int deleteByExample(Registration registration) {
		RegistrationExample example = new RegistrationExample();
		Criteria criteria = example.createCriteria().andIsValidEqualTo(true);
		//条件不为空
		if (registration.getId() != null) {
			criteria.andIdEqualTo(registration.getId());
		}
		if (registration.getActId() != null) {
			criteria.andActIdEqualTo(registration.getActId());
		}
		if (registration.getUserId() != null) {
			criteria.andUserIdEqualTo(registration.getUserId());
		}
		registration.setIsValid(false);
		return registrationMapper.updateByExample(registration, example);
	}

	/*
	 * <p>Title: insert</p>
	 * <p>Description: 报名 </p>
	 * @param registration
	 * @return
	 * @see com.atme8.activity.domain.dao.RegistrationDao#insert(com.atme8.activity.domain.entity.Registration)
	 */
	@Override
	public int insert(Registration registration) {
		int i = registrationMapper.insert(registration);
		for (RegistrationInfo value : registration.getValues()) {
			value.setRegId(registration.getId());
			registrationInfoMapper.insert(value);
		}
		return i;
	}

	/*
	 * <p>Title: selectRegistration</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param activityId
	 * @return
	 * @see com.atme8.activity.domain.dao.RegistrationDao#selectRegistration(java.lang.String, java.lang.String)
	 */
	@Override
	public Registration selectRegistration(String userId, String activityId) {
		RegistrationExample example = new RegistrationExample();
		example.createCriteria().andIsValidEqualTo(true)
			.andActIdEqualTo(activityId)
			.andCreateUserIdEqualTo(userId);
		List<Registration> list = registrationMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int countAll(String actId) {
		RegistrationExample example = new RegistrationExample();
		example.createCriteria().andIsValidEqualTo(true)
				.andActIdEqualTo(actId);
		int count = registrationMapper.countByExample(example);
		return count;
	}

}
