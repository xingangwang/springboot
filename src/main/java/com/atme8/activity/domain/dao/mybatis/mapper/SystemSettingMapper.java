package com.atme8.activity.domain.dao.mybatis.mapper;

import com.atme8.activity.domain.dao.mybatis.BaseMapper;
import com.atme8.activity.domain.entity.SystemSetting;
import com.atme8.activity.domain.entity.SystemSettingExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SystemSettingMapper extends BaseMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_system_setting
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	int countByExample(SystemSettingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_system_setting
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	int deleteByExample(SystemSettingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_system_setting
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_system_setting
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	int insert(SystemSetting record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_system_setting
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	int insertSelective(SystemSetting record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_system_setting
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	List<SystemSetting> selectByExample(SystemSettingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_system_setting
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	SystemSetting selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_system_setting
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	int updateByExampleSelective(@Param("record") SystemSetting record,
			@Param("example") SystemSettingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_system_setting
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	int updateByExample(@Param("record") SystemSetting record,
			@Param("example") SystemSettingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_system_setting
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	int updateByPrimaryKeySelective(SystemSetting record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_system_setting
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	int updateByPrimaryKey(SystemSetting record);
}