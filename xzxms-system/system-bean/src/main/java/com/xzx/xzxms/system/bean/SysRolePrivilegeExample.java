package com.xzx.xzxms.system.bean;

import java.util.ArrayList;
import java.util.List;

public class SysRolePrivilegeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    public SysRolePrivilegeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
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
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Long value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Long value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Long value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Long value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Long value1, Long value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdIsNull() {
            addCriterion("privilege_id is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdIsNotNull() {
            addCriterion("privilege_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdEqualTo(Long value) {
            addCriterion("privilege_id =", value, "privilegeId");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdNotEqualTo(Long value) {
            addCriterion("privilege_id <>", value, "privilegeId");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdGreaterThan(Long value) {
            addCriterion("privilege_id >", value, "privilegeId");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("privilege_id >=", value, "privilegeId");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdLessThan(Long value) {
            addCriterion("privilege_id <", value, "privilegeId");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdLessThanOrEqualTo(Long value) {
            addCriterion("privilege_id <=", value, "privilegeId");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdIn(List<Long> values) {
            addCriterion("privilege_id in", values, "privilegeId");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdNotIn(List<Long> values) {
            addCriterion("privilege_id not in", values, "privilegeId");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdBetween(Long value1, Long value2) {
            addCriterion("privilege_id between", value1, value2, "privilegeId");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIdNotBetween(Long value1, Long value2) {
            addCriterion("privilege_id not between", value1, value2, "privilegeId");
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

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
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

        public Criteria andUpdateOperatorIsNull() {
            addCriterion("update_operator is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorIsNotNull() {
            addCriterion("update_operator is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorEqualTo(String value) {
            addCriterion("update_operator =", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotEqualTo(String value) {
            addCriterion("update_operator <>", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorGreaterThan(String value) {
            addCriterion("update_operator >", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("update_operator >=", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorLessThan(String value) {
            addCriterion("update_operator <", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorLessThanOrEqualTo(String value) {
            addCriterion("update_operator <=", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorLike(String value) {
            addCriterion("update_operator like", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotLike(String value) {
            addCriterion("update_operator not like", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorIn(List<String> values) {
            addCriterion("update_operator in", values, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotIn(List<String> values) {
            addCriterion("update_operator not in", values, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorBetween(String value1, String value2) {
            addCriterion("update_operator between", value1, value2, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotBetween(String value1, String value2) {
            addCriterion("update_operator not between", value1, value2, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("\" update_time\" is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("\" update_time\" is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("\" update_time\" =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("\" update_time\" <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("\" update_time\" >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("\" update_time\" >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("\" update_time\" <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("\" update_time\" <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("\" update_time\" in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("\" update_time\" not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("\" update_time\" between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("\" update_time\" not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_role_privilege
     *
     * @mbg.generated do_not_delete_during_merge Tue Jan 05 17:59:54 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_role_privilege
     *
     * @mbg.generated Tue Jan 05 17:59:54 CST 2021
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