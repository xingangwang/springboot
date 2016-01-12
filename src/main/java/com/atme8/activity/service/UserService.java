package com.atme8.activity.service;

import java.util.List;

import com.atme8.activity.domain.entity.User;

/**
 * @author xuetianhua
 * @ClassName: UserService
 * @Description:
 * @date 2015年9月6日 下午6:01:20
 */

public interface UserService {

    /**
     * getUserByCasOpenId
     *
     * @param openId
     * @return User    返回类型
     * @throws
     * @Title: getUserByCasOpenId
     * @Description: 根据casOpenId获取User
     * @author JeremyWang
     * @date 2015年9月9日 下午3:41:58
     */
    User getUserByCasOpenId(String openId);

    /**
     * @param user
     * @return int 返回类型
     * @throws
     * @Title: insert
     * @Description: 添加User
     * @author xuetianhua
     * @date 2015年9月7日 上午10:57:18
     */
    int insert(User user);

    /**
     * @param id
     * @return int 返回类型
     * @throws
     * @Title: updateByExample
     * @Description: 根据Id删除User (改Valid为false)
     * @author xuetianhua
     * @date 2015年9月7日 下午5:38:45
     */
    int updateByExampleSelective(User user);

    /**
     * @param user
     * @return List<User> 返回类型
     * @throws
     * @Title: selectByExample
     * @Description: 根据想选择的类型查User
     * @author xuetianhua
     * @date 2015年9月6日 下午6:32:45
     */

    List<User> selectByExample(User user);

    /**
     * @param user
     * @return int 返回类型
     * @throws
     * @Title: updateByPrimaryKeySelective
     * @Description: 通过id删除User
     * @author xuetianhua
     * @date 2015年9月8日 下午2:00:54
     */
    int updateByPrimaryKeySelective(User user);


    User getUserByPrimaryKey(String id);


    /**
     * updateById(根据主键更新)
     * <p>(这里描述这个方法的注意事项 – 该方法将进行全部字段更新，更新时忘记给字段赋值将导致将该字段更新为null)
     *
     * @param localUser
     * @return boolean    返回类型
     * @throws
     * @Title: updateById
     * @Description:
     * @author JeremyWang
     * @date 2015年9月22日 下午2:34:01
     */
    boolean updateById(User localUser);

}
