package com.atme8.activity.service;

import java.util.List;

import com.atme8.activity.domain.entity.ActStage;
import com.atme8.activity.domain.entity.Activity;
import com.atme8.activity.domain.entity.ActivityRegField;

/**
 * @ClassName: ActivityService
 * @Description: 
 * @author xuetianhua
 * @date 2015年9月7日 上午10:56:39
 *
 */
public interface ActivityService {
	
	/**
	 * @Title: insert
	 * @Description: 创建活动
	 * @param activity
	 * @return  boolean    返回类型
	 * @throws
	 * @author xuetianhua
	 * @date 2015年9月7日 上午8:34:34
	 * 
	 */
	boolean insert(Activity activity);
	
	/**
	 * @Title: deleteByExampleSelective
	 * @Description: 根据ID 删除活动 (改Valid为false)
	 * @param id
	 * @return  int    返回类型
	 * @throws
	 * @author xuetianhua
	 * @date 2015年9月7日 下午5:34:59
	 * 
	 */
	int deleteByActId(String id);

	/**
	 * @Title: updateByActId
	 * @Description: 修改活动
	 * @param user
	 * @return  int    返回类型
	 * @throws
	 * @author xuetianhua
	 * @date 2015年9月8日 下午2:35:55
	 * 
	 */
	int updateByActId(Activity activity);
	
	/**
	 * @Title: selectActinfoByActId
	 * @Description: 根据ActId 查询reginfos
	 * @param actId
	 * @return  Activity    返回类型
	 * @throws
	 * @author xuetianhua
	 * @date 2015年9月9日 下午1:45:14
	 * 
	 */
	Activity selectActInfoByActId(String actId);

	/**
	 * selectRegFieldById()
	 *
	 * @Title: selectRegFieldById
	 * @Description: 
	 * @param fieldId
	 * @return  ActivityRegField   
	 * @throws
	 * @author JeremyWang
	 * @date 2015年9月29日 下午8:34:29
	 * 
	 */
	ActivityRegField selectRegFieldById(String fieldId);

	ActStage getCurrentStage(String actId);
}
