package com.atme8.activity.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	protected Integer limitStart;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	protected Integer limitEnd;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public ActivityExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public void setLimitStart(Integer limitStart) {
		this.limitStart = limitStart - 1;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public Integer getLimitStart() {
		return limitStart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public void setLimitEnd(Integer limitEnd) {
		this.limitEnd = limitEnd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public Integer getLimitEnd() {
		return limitEnd;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineIsNull() {
			addCriterion("reg_deadline is null");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineIsNotNull() {
			addCriterion("reg_deadline is not null");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineEqualTo(Date value) {
			addCriterion("reg_deadline =", value, "regDeadline");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineNotEqualTo(Date value) {
			addCriterion("reg_deadline <>", value, "regDeadline");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineGreaterThan(Date value) {
			addCriterion("reg_deadline >", value, "regDeadline");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineGreaterThanOrEqualTo(Date value) {
			addCriterion("reg_deadline >=", value, "regDeadline");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineLessThan(Date value) {
			addCriterion("reg_deadline <", value, "regDeadline");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineLessThanOrEqualTo(Date value) {
			addCriterion("reg_deadline <=", value, "regDeadline");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineIn(List<Date> values) {
			addCriterion("reg_deadline in", values, "regDeadline");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineNotIn(List<Date> values) {
			addCriterion("reg_deadline not in", values, "regDeadline");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineBetween(Date value1, Date value2) {
			addCriterion("reg_deadline between", value1, value2, "regDeadline");
			return (Criteria) this;
		}

		public Criteria andRegDeadlineNotBetween(Date value1, Date value2) {
			addCriterion("reg_deadline not between", value1, value2, "regDeadline");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("address is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andUpperLimitIsNull() {
			addCriterion("upper_limit is null");
			return (Criteria) this;
		}

		public Criteria andUpperLimitIsNotNull() {
			addCriterion("upper_limit is not null");
			return (Criteria) this;
		}

		public Criteria andUpperLimitEqualTo(Integer value) {
			addCriterion("upper_limit =", value, "upperLimit");
			return (Criteria) this;
		}

		public Criteria andUpperLimitNotEqualTo(Integer value) {
			addCriterion("upper_limit <>", value, "upperLimit");
			return (Criteria) this;
		}

		public Criteria andUpperLimitGreaterThan(Integer value) {
			addCriterion("upper_limit >", value, "upperLimit");
			return (Criteria) this;
		}

		public Criteria andUpperLimitGreaterThanOrEqualTo(Integer value) {
			addCriterion("upper_limit >=", value, "upperLimit");
			return (Criteria) this;
		}

		public Criteria andUpperLimitLessThan(Integer value) {
			addCriterion("upper_limit <", value, "upperLimit");
			return (Criteria) this;
		}

		public Criteria andUpperLimitLessThanOrEqualTo(Integer value) {
			addCriterion("upper_limit <=", value, "upperLimit");
			return (Criteria) this;
		}

		public Criteria andUpperLimitIn(List<Integer> values) {
			addCriterion("upper_limit in", values, "upperLimit");
			return (Criteria) this;
		}

		public Criteria andUpperLimitNotIn(List<Integer> values) {
			addCriterion("upper_limit not in", values, "upperLimit");
			return (Criteria) this;
		}

		public Criteria andUpperLimitBetween(Integer value1, Integer value2) {
			addCriterion("upper_limit between", value1, value2, "upperLimit");
			return (Criteria) this;
		}

		public Criteria andUpperLimitNotBetween(Integer value1, Integer value2) {
			addCriterion("upper_limit not between", value1, value2, "upperLimit");
			return (Criteria) this;
		}

		public Criteria andIsFreeIsNull() {
			addCriterion("is_free is null");
			return (Criteria) this;
		}

		public Criteria andIsFreeIsNotNull() {
			addCriterion("is_free is not null");
			return (Criteria) this;
		}

		public Criteria andIsFreeEqualTo(Boolean value) {
			addCriterion("is_free =", value, "isFree");
			return (Criteria) this;
		}

		public Criteria andIsFreeNotEqualTo(Boolean value) {
			addCriterion("is_free <>", value, "isFree");
			return (Criteria) this;
		}

		public Criteria andIsFreeGreaterThan(Boolean value) {
			addCriterion("is_free >", value, "isFree");
			return (Criteria) this;
		}

		public Criteria andIsFreeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_free >=", value, "isFree");
			return (Criteria) this;
		}

		public Criteria andIsFreeLessThan(Boolean value) {
			addCriterion("is_free <", value, "isFree");
			return (Criteria) this;
		}

		public Criteria andIsFreeLessThanOrEqualTo(Boolean value) {
			addCriterion("is_free <=", value, "isFree");
			return (Criteria) this;
		}

		public Criteria andIsFreeLike(Boolean value) {
			addCriterion("is_free like", value, "isFree");
			return (Criteria) this;
		}

		public Criteria andIsFreeNotLike(Boolean value) {
			addCriterion("is_free not like", value, "isFree");
			return (Criteria) this;
		}

		public Criteria andIsFreeIn(List<Boolean> values) {
			addCriterion("is_free in", values, "isFree");
			return (Criteria) this;
		}

		public Criteria andIsFreeNotIn(List<Boolean> values) {
			addCriterion("is_free not in", values, "isFree");
			return (Criteria) this;
		}

		public Criteria andIsFreeBetween(Boolean value1, Boolean value2) {
			addCriterion("is_free between", value1, value2, "isFree");
			return (Criteria) this;
		}

		public Criteria andIsFreeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_free not between", value1, value2, "isFree");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNull() {
			addCriterion("create_user_id is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNotNull() {
			addCriterion("create_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdEqualTo(String value) {
			addCriterion("create_user_id =", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotEqualTo(String value) {
			addCriterion("create_user_id <>", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThan(String value) {
			addCriterion("create_user_id >", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("create_user_id >=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThan(String value) {
			addCriterion("create_user_id <", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
			addCriterion("create_user_id <=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLike(String value) {
			addCriterion("create_user_id like", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotLike(String value) {
			addCriterion("create_user_id not like", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIn(List<String> values) {
			addCriterion("create_user_id in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotIn(List<String> values) {
			addCriterion("create_user_id not in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdBetween(String value1, String value2) {
			addCriterion("create_user_id between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotBetween(String value1, String value2) {
			addCriterion("create_user_id not between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNull() {
			addCriterion("create_date is null");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNotNull() {
			addCriterion("create_date is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDateEqualTo(Date value) {
			addCriterion("create_date =", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotEqualTo(Date value) {
			addCriterion("create_date <>", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThan(Date value) {
			addCriterion("create_date >", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("create_date >=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThan(Date value) {
			addCriterion("create_date <", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThanOrEqualTo(Date value) {
			addCriterion("create_date <=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIn(List<Date> values) {
			addCriterion("create_date in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotIn(List<Date> values) {
			addCriterion("create_date not in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateBetween(Date value1, Date value2) {
			addCriterion("create_date between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotBetween(Date value1, Date value2) {
			addCriterion("create_date not between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdIsNull() {
			addCriterion("update_user_id is null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdIsNotNull() {
			addCriterion("update_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdEqualTo(String value) {
			addCriterion("update_user_id =", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdNotEqualTo(String value) {
			addCriterion("update_user_id <>", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdGreaterThan(String value) {
			addCriterion("update_user_id >", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("update_user_id >=", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdLessThan(String value) {
			addCriterion("update_user_id <", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
			addCriterion("update_user_id <=", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdLike(String value) {
			addCriterion("update_user_id like", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdNotLike(String value) {
			addCriterion("update_user_id not like", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdIn(List<String> values) {
			addCriterion("update_user_id in", values, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdNotIn(List<String> values) {
			addCriterion("update_user_id not in", values, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdBetween(String value1, String value2) {
			addCriterion("update_user_id between", value1, value2, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
			addCriterion("update_user_id not between", value1, value2, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNull() {
			addCriterion("update_date is null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNotNull() {
			addCriterion("update_date is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateEqualTo(Date value) {
			addCriterion("update_date =", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotEqualTo(Date value) {
			addCriterion("update_date <>", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThan(Date value) {
			addCriterion("update_date >", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("update_date >=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThan(Date value) {
			addCriterion("update_date <", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
			addCriterion("update_date <=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIn(List<Date> values) {
			addCriterion("update_date in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotIn(List<Date> values) {
			addCriterion("update_date not in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateBetween(Date value1, Date value2) {
			addCriterion("update_date between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
			addCriterion("update_date not between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andIsValidIsNull() {
			addCriterion("is_valid is null");
			return (Criteria) this;
		}

		public Criteria andIsValidIsNotNull() {
			addCriterion("is_valid is not null");
			return (Criteria) this;
		}

		public Criteria andIsValidEqualTo(Boolean value) {
			addCriterion("is_valid =", value, "isValid");
			return (Criteria) this;
		}

		public Criteria andIsValidNotEqualTo(Boolean value) {
			addCriterion("is_valid <>", value, "isValid");
			return (Criteria) this;
		}

		public Criteria andIsValidGreaterThan(Boolean value) {
			addCriterion("is_valid >", value, "isValid");
			return (Criteria) this;
		}

		public Criteria andIsValidGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_valid >=", value, "isValid");
			return (Criteria) this;
		}

		public Criteria andIsValidLessThan(Boolean value) {
			addCriterion("is_valid <", value, "isValid");
			return (Criteria) this;
		}

		public Criteria andIsValidLessThanOrEqualTo(Boolean value) {
			addCriterion("is_valid <=", value, "isValid");
			return (Criteria) this;
		}

		public Criteria andIsValidLike(Boolean value) {
			addCriterion("is_valid like", value, "isValid");
			return (Criteria) this;
		}

		public Criteria andIsValidNotLike(Boolean value) {
			addCriterion("is_valid not like", value, "isValid");
			return (Criteria) this;
		}

		public Criteria andIsValidIn(List<Boolean> values) {
			addCriterion("is_valid in", values, "isValid");
			return (Criteria) this;
		}

		public Criteria andIsValidNotIn(List<Boolean> values) {
			addCriterion("is_valid not in", values, "isValid");
			return (Criteria) this;
		}

		public Criteria andIsValidBetween(Boolean value1, Boolean value2) {
			addCriterion("is_valid between", value1, value2, "isValid");
			return (Criteria) this;
		}

		public Criteria andIsValidNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_valid not between", value1, value2, "isValid");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_activity
	 * @mbggenerated  Mon Nov 09 16:48:16 CST 2015
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_activity
     *
     * @mbggenerated do_not_delete_during_merge Mon Sep 07 08:18:48 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}