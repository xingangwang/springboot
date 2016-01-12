package com.atme8.activity.service;

import java.util.List;

import com.atme8.activity.domain.entity.Registration;
import com.atme8.activity.domain.entity.User;

/**
 * @ClassName: RegistrationService
 * @Description: 
 * @author xuetianhua
 * @date 2015年9月7日 下午5:58:37
 *
 */
public interface RegistrationService {
	
	/**
	 * @Title: selectUsersByactId
	 * @Description: 根据actId 查询报名User的信息
	 * @param actId
	 * @return  List<User>    返回类型
	 * @throws
	 * @author xuetianhua
	 * @date 2015年9月8日 下午3:25:12
	 * 
	 */
	List<User> selectRegUsersByActId(String actId);
	
	/**
	 * @Title: deleteByExample
	 * @Description:  根据id delete (改Valid为false)
	 * @param registration
	 * @return  int    返回类型
	 * @throws
	 * @author xuetianhua
	 * @date 2015年9月8日 下午4:20:44
	 * 
	 */
	int deleteByExample(Registration registration);
	
	/**
	 * @Title: insert
	 * @Description: 向t_registration表添加信息
	 * @param registration
	 * @return  int    返回类型
	 * @throws
	 * @author xuetianhua
	 * @date 2015年9月8日 下午4:27:39
	 * 
	 */
	int insert(Registration registration);


	/**
	 * selectRegistration(查询指定用户的指定活动的报名信息)
	 *
	 * @Title: selectRegistration
	 * @Description: 
	 * @param userId	
	 * @param activityId
	 * @return  Registration   
	 * @throws
	 * @author JeremyWang
	 * @date 2015年9月29日 下午4:39:42
	 * 
	 */
	Registration selectRegistration(String userId, String activityId);

	int countAll(String actId);
	
}
