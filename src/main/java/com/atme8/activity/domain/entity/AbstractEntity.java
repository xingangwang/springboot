/**
 * @Title: AbstractEntity.java
 * @Package net.jeeshop.core.model.base
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月1日 下午8:34:19
 * @version V1.0
 */

package com.atme8.activity.domain.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;



public abstract class AbstractEntity implements Serializable {
	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = -2148183045377380916L;

	/**
	 * @Fields id : 主键
	 */
	protected String id;

	/**
	 * @Fields createUserId : 创建者ID
	 */
	protected String createUserId;

	/**
	 * @Fields createUser : 创建者
	 */
	protected User createUser;

	/**
	 * @Fields createTime : 创建时间
	 */
	protected Date createDate;

	/**
	 * @Fields updateUserId : 更新者ID
	 */
	protected String updateUserId;

	/**
	 * @Fields updateUser : 更新者
	 */
	protected User updateUser;

	/**
	 * @Fields updateTime : 更新时间
	 */
	protected Date updateDate;

	/**
	 * @Fields valid : 数据有效标识
	 */
	protected Boolean isValid = true;

	/**
	 * 创建一个新的实例 BaseModel.
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public AbstractEntity() {
	}

	/*
	 * <p>Title: equals</p> <p>Description: </p>
	 * 
	 * @param obj
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (this.getId() == null) {
			return other.getId() == null;
		} else {
			return this.getId().equals(other.getId());
		}
	}
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * isValid getter method
	 * @return the isValid
	 */
	public Boolean getIsValid() {
		return isValid;
	}

	/**
	 * isValid setter method
	 * @param isValid the isValid to set
	 */
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
}
