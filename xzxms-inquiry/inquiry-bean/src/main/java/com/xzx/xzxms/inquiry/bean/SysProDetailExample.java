package com.xzx.xzxms.inquiry.bean;

import java.util.ArrayList;
import java.util.List;

public class SysProDetailExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public SysProDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andProTypeIdIsNull() {
            addCriterion("pro_type_id is null");
            return (Criteria) this;
        }

        public Criteria andProTypeIdIsNotNull() {
            addCriterion("pro_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andProTypeIdEqualTo(Long value) {
            addCriterion("pro_type_id =", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdNotEqualTo(Long value) {
            addCriterion("pro_type_id <>", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdGreaterThan(Long value) {
            addCriterion("pro_type_id >", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_type_id >=", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdLessThan(Long value) {
            addCriterion("pro_type_id <", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("pro_type_id <=", value, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdIn(List<Long> values) {
            addCriterion("pro_type_id in", values, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdNotIn(List<Long> values) {
            addCriterion("pro_type_id not in", values, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdBetween(Long value1, Long value2) {
            addCriterion("pro_type_id between", value1, value2, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("pro_type_id not between", value1, value2, "proTypeId");
            return (Criteria) this;
        }

        public Criteria andProOriginIdIsNull() {
            addCriterion("pro_origin_id is null");
            return (Criteria) this;
        }

        public Criteria andProOriginIdIsNotNull() {
            addCriterion("pro_origin_id is not null");
            return (Criteria) this;
        }

        public Criteria andProOriginIdEqualTo(Long value) {
            addCriterion("pro_origin_id =", value, "proOriginId");
            return (Criteria) this;
        }

        public Criteria andProOriginIdNotEqualTo(Long value) {
            addCriterion("pro_origin_id <>", value, "proOriginId");
            return (Criteria) this;
        }

        public Criteria andProOriginIdGreaterThan(Long value) {
            addCriterion("pro_origin_id >", value, "proOriginId");
            return (Criteria) this;
        }

        public Criteria andProOriginIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_origin_id >=", value, "proOriginId");
            return (Criteria) this;
        }

        public Criteria andProOriginIdLessThan(Long value) {
            addCriterion("pro_origin_id <", value, "proOriginId");
            return (Criteria) this;
        }

        public Criteria andProOriginIdLessThanOrEqualTo(Long value) {
            addCriterion("pro_origin_id <=", value, "proOriginId");
            return (Criteria) this;
        }

        public Criteria andProOriginIdIn(List<Long> values) {
            addCriterion("pro_origin_id in", values, "proOriginId");
            return (Criteria) this;
        }

        public Criteria andProOriginIdNotIn(List<Long> values) {
            addCriterion("pro_origin_id not in", values, "proOriginId");
            return (Criteria) this;
        }

        public Criteria andProOriginIdBetween(Long value1, Long value2) {
            addCriterion("pro_origin_id between", value1, value2, "proOriginId");
            return (Criteria) this;
        }

        public Criteria andProOriginIdNotBetween(Long value1, Long value2) {
            addCriterion("pro_origin_id not between", value1, value2, "proOriginId");
            return (Criteria) this;
        }

        public Criteria andProNoIsNull() {
            addCriterion("pro_no is null");
            return (Criteria) this;
        }

        public Criteria andProNoIsNotNull() {
            addCriterion("pro_no is not null");
            return (Criteria) this;
        }

        public Criteria andProNoEqualTo(String value) {
            addCriterion("pro_no =", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotEqualTo(String value) {
            addCriterion("pro_no <>", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoGreaterThan(String value) {
            addCriterion("pro_no >", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoGreaterThanOrEqualTo(String value) {
            addCriterion("pro_no >=", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoLessThan(String value) {
            addCriterion("pro_no <", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoLessThanOrEqualTo(String value) {
            addCriterion("pro_no <=", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoLike(String value) {
            addCriterion("pro_no like", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotLike(String value) {
            addCriterion("pro_no not like", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoIn(List<String> values) {
            addCriterion("pro_no in", values, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotIn(List<String> values) {
            addCriterion("pro_no not in", values, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoBetween(String value1, String value2) {
            addCriterion("pro_no between", value1, value2, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotBetween(String value1, String value2) {
            addCriterion("pro_no not between", value1, value2, "proNo");
            return (Criteria) this;
        }

        public Criteria andProRateIsNull() {
            addCriterion("pro_rate is null");
            return (Criteria) this;
        }

        public Criteria andProRateIsNotNull() {
            addCriterion("pro_rate is not null");
            return (Criteria) this;
        }

        public Criteria andProRateEqualTo(Integer value) {
            addCriterion("pro_rate =", value, "proRate");
            return (Criteria) this;
        }

        public Criteria andProRateNotEqualTo(Integer value) {
            addCriterion("pro_rate <>", value, "proRate");
            return (Criteria) this;
        }

        public Criteria andProRateGreaterThan(Integer value) {
            addCriterion("pro_rate >", value, "proRate");
            return (Criteria) this;
        }

        public Criteria andProRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_rate >=", value, "proRate");
            return (Criteria) this;
        }

        public Criteria andProRateLessThan(Integer value) {
            addCriterion("pro_rate <", value, "proRate");
            return (Criteria) this;
        }

        public Criteria andProRateLessThanOrEqualTo(Integer value) {
            addCriterion("pro_rate <=", value, "proRate");
            return (Criteria) this;
        }

        public Criteria andProRateIn(List<Integer> values) {
            addCriterion("pro_rate in", values, "proRate");
            return (Criteria) this;
        }

        public Criteria andProRateNotIn(List<Integer> values) {
            addCriterion("pro_rate not in", values, "proRate");
            return (Criteria) this;
        }

        public Criteria andProRateBetween(Integer value1, Integer value2) {
            addCriterion("pro_rate between", value1, value2, "proRate");
            return (Criteria) this;
        }

        public Criteria andProRateNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_rate not between", value1, value2, "proRate");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNull() {
            addCriterion("is_active is null");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNotNull() {
            addCriterion("is_active is not null");
            return (Criteria) this;
        }

        public Criteria andIsActiveEqualTo(Integer value) {
            addCriterion("is_active =", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotEqualTo(Integer value) {
            addCriterion("is_active <>", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThan(Integer value) {
            addCriterion("is_active >", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_active >=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThan(Integer value) {
            addCriterion("is_active <", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThanOrEqualTo(Integer value) {
            addCriterion("is_active <=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveIn(List<Integer> values) {
            addCriterion("is_active in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotIn(List<Integer> values) {
            addCriterion("is_active not in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveBetween(Integer value1, Integer value2) {
            addCriterion("is_active between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("is_active not between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsUsefulIsNull() {
            addCriterion("is_useful is null");
            return (Criteria) this;
        }

        public Criteria andIsUsefulIsNotNull() {
            addCriterion("is_useful is not null");
            return (Criteria) this;
        }

        public Criteria andIsUsefulEqualTo(Integer value) {
            addCriterion("is_useful =", value, "isUseful");
            return (Criteria) this;
        }

        public Criteria andIsUsefulNotEqualTo(Integer value) {
            addCriterion("is_useful <>", value, "isUseful");
            return (Criteria) this;
        }

        public Criteria andIsUsefulGreaterThan(Integer value) {
            addCriterion("is_useful >", value, "isUseful");
            return (Criteria) this;
        }

        public Criteria andIsUsefulGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_useful >=", value, "isUseful");
            return (Criteria) this;
        }

        public Criteria andIsUsefulLessThan(Integer value) {
            addCriterion("is_useful <", value, "isUseful");
            return (Criteria) this;
        }

        public Criteria andIsUsefulLessThanOrEqualTo(Integer value) {
            addCriterion("is_useful <=", value, "isUseful");
            return (Criteria) this;
        }

        public Criteria andIsUsefulIn(List<Integer> values) {
            addCriterion("is_useful in", values, "isUseful");
            return (Criteria) this;
        }

        public Criteria andIsUsefulNotIn(List<Integer> values) {
            addCriterion("is_useful not in", values, "isUseful");
            return (Criteria) this;
        }

        public Criteria andIsUsefulBetween(Integer value1, Integer value2) {
            addCriterion("is_useful between", value1, value2, "isUseful");
            return (Criteria) this;
        }

        public Criteria andIsUsefulNotBetween(Integer value1, Integer value2) {
            addCriterion("is_useful not between", value1, value2, "isUseful");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(Long value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(Long value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(Long value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(Long value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(Long value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(Long value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<Long> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<Long> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(Long value1, Long value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(Long value1, Long value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Long value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Long value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Long value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Long value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Long value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Long> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Long> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Long value1, Long value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Long value1, Long value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdIsNull() {
            addCriterion("purchase_pro_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdIsNotNull() {
            addCriterion("purchase_pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdEqualTo(Long value) {
            addCriterion("purchase_pro_id =", value, "purchaseProId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdNotEqualTo(Long value) {
            addCriterion("purchase_pro_id <>", value, "purchaseProId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdGreaterThan(Long value) {
            addCriterion("purchase_pro_id >", value, "purchaseProId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("purchase_pro_id >=", value, "purchaseProId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdLessThan(Long value) {
            addCriterion("purchase_pro_id <", value, "purchaseProId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdLessThanOrEqualTo(Long value) {
            addCriterion("purchase_pro_id <=", value, "purchaseProId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdIn(List<Long> values) {
            addCriterion("purchase_pro_id in", values, "purchaseProId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdNotIn(List<Long> values) {
            addCriterion("purchase_pro_id not in", values, "purchaseProId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdBetween(Long value1, Long value2) {
            addCriterion("purchase_pro_id between", value1, value2, "purchaseProId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProIdNotBetween(Long value1, Long value2) {
            addCriterion("purchase_pro_id not between", value1, value2, "purchaseProId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_pro_detail
     *
     * @mbg.generated do_not_delete_during_merge Thu Dec 31 09:50:02 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_pro_detail
     *
     * @mbg.generated Thu Dec 31 09:50:02 CST 2020
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
}