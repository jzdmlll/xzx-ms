package com.xzx.xzxms.bean;

import java.util.ArrayList;
import java.util.List;

public class SysProCheckExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    public SysProCheckExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
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
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
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

        public Criteria andBusinessCheckIsNull() {
            addCriterion("business_check is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCheckIsNotNull() {
            addCriterion("business_check is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCheckEqualTo(Integer value) {
            addCriterion("business_check =", value, "businessCheck");
            return (Criteria) this;
        }

        public Criteria andBusinessCheckNotEqualTo(Integer value) {
            addCriterion("business_check <>", value, "businessCheck");
            return (Criteria) this;
        }

        public Criteria andBusinessCheckGreaterThan(Integer value) {
            addCriterion("business_check >", value, "businessCheck");
            return (Criteria) this;
        }

        public Criteria andBusinessCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_check >=", value, "businessCheck");
            return (Criteria) this;
        }

        public Criteria andBusinessCheckLessThan(Integer value) {
            addCriterion("business_check <", value, "businessCheck");
            return (Criteria) this;
        }

        public Criteria andBusinessCheckLessThanOrEqualTo(Integer value) {
            addCriterion("business_check <=", value, "businessCheck");
            return (Criteria) this;
        }

        public Criteria andBusinessCheckIn(List<Integer> values) {
            addCriterion("business_check in", values, "businessCheck");
            return (Criteria) this;
        }

        public Criteria andBusinessCheckNotIn(List<Integer> values) {
            addCriterion("business_check not in", values, "businessCheck");
            return (Criteria) this;
        }

        public Criteria andBusinessCheckBetween(Integer value1, Integer value2) {
            addCriterion("business_check between", value1, value2, "businessCheck");
            return (Criteria) this;
        }

        public Criteria andBusinessCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("business_check not between", value1, value2, "businessCheck");
            return (Criteria) this;
        }

        public Criteria andEngineCheckIsNull() {
            addCriterion("engine_check is null");
            return (Criteria) this;
        }

        public Criteria andEngineCheckIsNotNull() {
            addCriterion("engine_check is not null");
            return (Criteria) this;
        }

        public Criteria andEngineCheckEqualTo(Integer value) {
            addCriterion("engine_check =", value, "engineCheck");
            return (Criteria) this;
        }

        public Criteria andEngineCheckNotEqualTo(Integer value) {
            addCriterion("engine_check <>", value, "engineCheck");
            return (Criteria) this;
        }

        public Criteria andEngineCheckGreaterThan(Integer value) {
            addCriterion("engine_check >", value, "engineCheck");
            return (Criteria) this;
        }

        public Criteria andEngineCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("engine_check >=", value, "engineCheck");
            return (Criteria) this;
        }

        public Criteria andEngineCheckLessThan(Integer value) {
            addCriterion("engine_check <", value, "engineCheck");
            return (Criteria) this;
        }

        public Criteria andEngineCheckLessThanOrEqualTo(Integer value) {
            addCriterion("engine_check <=", value, "engineCheck");
            return (Criteria) this;
        }

        public Criteria andEngineCheckIn(List<Integer> values) {
            addCriterion("engine_check in", values, "engineCheck");
            return (Criteria) this;
        }

        public Criteria andEngineCheckNotIn(List<Integer> values) {
            addCriterion("engine_check not in", values, "engineCheck");
            return (Criteria) this;
        }

        public Criteria andEngineCheckBetween(Integer value1, Integer value2) {
            addCriterion("engine_check between", value1, value2, "engineCheck");
            return (Criteria) this;
        }

        public Criteria andEngineCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("engine_check not between", value1, value2, "engineCheck");
            return (Criteria) this;
        }

        public Criteria andFinalCheckIsNull() {
            addCriterion("final_check is null");
            return (Criteria) this;
        }

        public Criteria andFinalCheckIsNotNull() {
            addCriterion("final_check is not null");
            return (Criteria) this;
        }

        public Criteria andFinalCheckEqualTo(Integer value) {
            addCriterion("final_check =", value, "finalCheck");
            return (Criteria) this;
        }

        public Criteria andFinalCheckNotEqualTo(Integer value) {
            addCriterion("final_check <>", value, "finalCheck");
            return (Criteria) this;
        }

        public Criteria andFinalCheckGreaterThan(Integer value) {
            addCriterion("final_check >", value, "finalCheck");
            return (Criteria) this;
        }

        public Criteria andFinalCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("final_check >=", value, "finalCheck");
            return (Criteria) this;
        }

        public Criteria andFinalCheckLessThan(Integer value) {
            addCriterion("final_check <", value, "finalCheck");
            return (Criteria) this;
        }

        public Criteria andFinalCheckLessThanOrEqualTo(Integer value) {
            addCriterion("final_check <=", value, "finalCheck");
            return (Criteria) this;
        }

        public Criteria andFinalCheckIn(List<Integer> values) {
            addCriterion("final_check in", values, "finalCheck");
            return (Criteria) this;
        }

        public Criteria andFinalCheckNotIn(List<Integer> values) {
            addCriterion("final_check not in", values, "finalCheck");
            return (Criteria) this;
        }

        public Criteria andFinalCheckBetween(Integer value1, Integer value2) {
            addCriterion("final_check between", value1, value2, "finalCheck");
            return (Criteria) this;
        }

        public Criteria andFinalCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("final_check not between", value1, value2, "finalCheck");
            return (Criteria) this;
        }

        public Criteria andProDetailIdIsNull() {
            addCriterion("pro_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andProDetailIdIsNotNull() {
            addCriterion("pro_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andProDetailIdEqualTo(Long value) {
            addCriterion("pro_detail_id =", value, "proDetailId");
            return (Criteria) this;
        }

        public Criteria andProDetailIdNotEqualTo(Long value) {
            addCriterion("pro_detail_id <>", value, "proDetailId");
            return (Criteria) this;
        }

        public Criteria andProDetailIdGreaterThan(Long value) {
            addCriterion("pro_detail_id >", value, "proDetailId");
            return (Criteria) this;
        }

        public Criteria andProDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_detail_id >=", value, "proDetailId");
            return (Criteria) this;
        }

        public Criteria andProDetailIdLessThan(Long value) {
            addCriterion("pro_detail_id <", value, "proDetailId");
            return (Criteria) this;
        }

        public Criteria andProDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("pro_detail_id <=", value, "proDetailId");
            return (Criteria) this;
        }

        public Criteria andProDetailIdIn(List<Long> values) {
            addCriterion("pro_detail_id in", values, "proDetailId");
            return (Criteria) this;
        }

        public Criteria andProDetailIdNotIn(List<Long> values) {
            addCriterion("pro_detail_id not in", values, "proDetailId");
            return (Criteria) this;
        }

        public Criteria andProDetailIdBetween(Long value1, Long value2) {
            addCriterion("pro_detail_id between", value1, value2, "proDetailId");
            return (Criteria) this;
        }

        public Criteria andProDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("pro_detail_id not between", value1, value2, "proDetailId");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_pro_check
     *
     * @mbg.generated do_not_delete_during_merge Tue Sep 15 09:45:45 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_pro_check
     *
     * @mbg.generated Tue Sep 15 09:45:45 CST 2020
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