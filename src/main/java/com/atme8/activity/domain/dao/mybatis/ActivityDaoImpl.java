package com.atme8.activity.domain.dao.mybatis;

import java.util.List;

import com.atme8.activity.common.util.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atme8.activity.domain.dao.ActivityDao;
import com.atme8.activity.domain.dao.mybatis.mapper.ActStageMapper;
import com.atme8.activity.domain.dao.mybatis.mapper.ActivityMapper;
import com.atme8.activity.domain.dao.mybatis.mapper.ActivityRegFieldMapper;
import com.atme8.activity.domain.entity.ActStage;
import com.atme8.activity.domain.entity.ActStageExample;
import com.atme8.activity.domain.entity.Activity;
import com.atme8.activity.domain.entity.ActivityExample;
import com.atme8.activity.domain.entity.ActivityExample.Criteria;
import com.atme8.activity.domain.entity.ActivityRegField;
import com.atme8.activity.domain.entity.ActivityRegFieldExample;

/**
 * @author xuetianhua
 * @ClassName: ActivityDaoImpl
 * @Description:
 * @date 2015年9月7日 上午8:27:29
 */
@Repository
public class ActivityDaoImpl implements ActivityDao {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ActivityRegFieldMapper activityRegFieldMapper;

    @Autowired
    private ActStageMapper activityStageMapper;

    /*
     * <p>Title: insert</p> <p>Description: 创建一个活动同时创建活动信息表 </p>
     *
     * @param activity
     *
     * @return boolean
     *
     * @see
     * com.atme8.activity.domain.dao.ActivityDao#insert(com.atme8.activity.domain
     * .entity.Activity)
     */
    @Override
    public boolean insert(Activity activity) {
        if (activityMapper.insert(activity) != 1) {
            return false;
        }
        List<ActivityRegField> actReginfos = activity.getRegFields();
        int insertinfo = 0;
        for (int i = 0; i < actReginfos.size(); i++) {
            ActivityRegField actReginfo = actReginfos.get(i);
            actReginfo.setActId(activity.getId());
            insertinfo = activityRegFieldMapper.insert(actReginfo);
            if (insertinfo != 1) {
                return false;
            }
        }

        for (ActStage stage : activity.getStages()) {
            stage.setActId(activity.getId());
            if (activityStageMapper.insert(stage) != 1) {
                return false;
            }
        }
        return true;
    }

    /*
     * <p>Title: deleteByExampleSelective</p> <p>Description: 通过活动Id 逻辑删除活动
     * 同时删除相关活动信息表</p>
     *
     * @param activity
     *
     * @return int
     *
     * @see
     * com.atme8.activity.domain.dao.ActivityDao#deleteByExampleSelective(com
     * .atme8.activity.domain.entity.Activity)
     */
    @Override
    public int deleteByActId(String id) {
        // 通过Id查询活动的全信息
        Activity activity = new Activity();
        ActivityExample example = new ActivityExample();
        if (id != null) {
            example.createCriteria().andIdEqualTo(id);
        }
        activity.setIsValid(false);
        // 删除活动的同时删除actReginfo表中相关信息
        ActivityRegFieldExample RegExample = new ActivityRegFieldExample();
        ActivityRegField actReginfo = new ActivityRegField();
        RegExample.createCriteria().andActIdEqualTo(id).andIsValidEqualTo(true);
        actReginfo.setIsValid(false);
        activityRegFieldMapper.updateByExampleSelective(actReginfo, RegExample);
        return activityMapper.updateByExampleSelective(activity, example);
    }

    /*
     * <p>Title: updateByExampleSelective</p> <p>Description: 修改活动By ActId</p>
     *
     * @param activity
     *
     * @return int
     *
     * @see
     * com.atme8.activity.domain.dao.ActivityDao#updateByExampleSelective(com
     * .atme8.activity.domain.entity.Activity)
     */
    @Override
    public int updateByActId(Activity activity) {
        return activityMapper.updateByPrimaryKeySelective(activity);
    }

    /*
     * <p>Title: selectreginfosByActId</p> <p>Description:
     * 根据活动Id查询所有相关此活动的信息</p>
     *
     * @param actId
     *
     * @return Activity
     *
     * @see
     * com.atme8.activity.domain.dao.ActivityDao#selectreginfosByActId(java.
     * lang.String)
     */
    @Override
    public Activity selectActInfoByActId(String actId) {
        Activity activity = activityMapper.selectByPrimaryKey(actId);
        if (activity == null) {
            throw new IllegalArgumentException();
        }
        ActivityRegFieldExample regExample = new ActivityRegFieldExample();
        regExample.setOrderByClause("order_");
        com.atme8.activity.domain.entity.ActivityRegFieldExample.Criteria creteria = regExample.createCriteria();
        creteria.andIsValidEqualTo(true);
        // 根据id查
        if (actId != null) {
            creteria.andActIdEqualTo(actId);
        }
        // 查询actReginfo表信息
        List<ActivityRegField> reginfos = activityRegFieldMapper
                .selectByExample(regExample);
        activity.setRegFields(reginfos);
        // 查询actStage表信息
        ActStageExample stageExample = new ActStageExample();
        stageExample.createCriteria().andActIdEqualTo(actId);
        stageExample.setOrderByClause(" order1 asc");
        List<ActStage> stages = activityStageMapper.selectByExample(stageExample);
        activity.setStages(stages);
        return activity;
    }

    /*
     * <p>Title: selectRegFieldById</p>
     * <p>Description: </p>
     * @param fieldId
     * @return
     * @see com.atme8.activity.domain.dao.ActivityDao#selectRegFieldById(java.lang.String)
     */
    @Override
    public ActivityRegField selectRegFieldById(String fieldId) {
        return activityRegFieldMapper.selectByPrimaryKey(fieldId);
    }

    @Override
    public ActStage getCurrentStage(String actId) {
        ActStageExample example = new ActStageExample();
        example.createCriteria().andActIdEqualTo(actId)
                .andBeginLessThanOrEqualTo(DateFormatUtils.getSystemDate())
                .andEndGreaterThanOrEqualTo(DateFormatUtils.getSystemDate());
        ActStage stage = activityStageMapper.selectByExample(example).get(0);
        return stage;
    }
}
