package com.atme8.activity.domain.dao;

import com.atme8.activity.domain.entity.ActStage;
import com.atme8.activity.domain.entity.Activity;
import com.atme8.activity.domain.entity.ActivityRegField;

import java.util.List;

/**
 * @author xuetianhua
 * @ClassName: ActivityDao
 * @Description:
 * @date 2015年9月7日 上午8:28:26
 */
public interface ActivityDao {

    boolean insert(Activity activity);

    int deleteByActId(String id);

    Activity selectActInfoByActId(String actId);

    int updateByActId(Activity activity);

    ActivityRegField selectRegFieldById(String fieldId);

    ActStage getCurrentStage(String actId);

}
