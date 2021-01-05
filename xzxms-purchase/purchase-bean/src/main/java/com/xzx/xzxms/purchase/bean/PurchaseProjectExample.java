package com.xzx.xzxms.purchase.bean;

import java.util.ArrayList;
import java.util.List;

public class PurchaseProjectExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    public PurchaseProjectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
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
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
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

        public Criteria andInquiryProIdIsNull() {
            addCriterion("inquiry_pro_id is null");
            return (Criteria) this;
        }

        public Criteria andInquiryProIdIsNotNull() {
            addCriterion("inquiry_pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryProIdEqualTo(Long value) {
            addCriterion("inquiry_pro_id =", value, "inquiryProId");
            return (Criteria) this;
        }

        public Criteria andInquiryProIdNotEqualTo(Long value) {
            addCriterion("inquiry_pro_id <>", value, "inquiryProId");
            return (Criteria) this;
        }

        public Criteria andInquiryProIdGreaterThan(Long value) {
            addCriterion("inquiry_pro_id >", value, "inquiryProId");
            return (Criteria) this;
        }

        public Criteria andInquiryProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("inquiry_pro_id >=", value, "inquiryProId");
            return (Criteria) this;
        }

        public Criteria andInquiryProIdLessThan(Long value) {
            addCriterion("inquiry_pro_id <", value, "inquiryProId");
            return (Criteria) this;
        }

        public Criteria andInquiryProIdLessThanOrEqualTo(Long value) {
            addCriterion("inquiry_pro_id <=", value, "inquiryProId");
            return (Criteria) this;
        }

        public Criteria andInquiryProIdIn(List<Long> values) {
            addCriterion("inquiry_pro_id in", values, "inquiryProId");
            return (Criteria) this;
        }

        public Criteria andInquiryProIdNotIn(List<Long> values) {
            addCriterion("inquiry_pro_id not in", values, "inquiryProId");
            return (Criteria) this;
        }

        public Criteria andInquiryProIdBetween(Long value1, Long value2) {
            addCriterion("inquiry_pro_id between", value1, value2, "inquiryProId");
            return (Criteria) this;
        }

        public Criteria andInquiryProIdNotBetween(Long value1, Long value2) {
            addCriterion("inquiry_pro_id not between", value1, value2, "inquiryProId");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoIsNull() {
            addCriterion("purchase_pro_no is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoIsNotNull() {
            addCriterion("purchase_pro_no is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoEqualTo(String value) {
            addCriterion("purchase_pro_no =", value, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoNotEqualTo(String value) {
            addCriterion("purchase_pro_no <>", value, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoGreaterThan(String value) {
            addCriterion("purchase_pro_no >", value, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_pro_no >=", value, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoLessThan(String value) {
            addCriterion("purchase_pro_no <", value, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoLessThanOrEqualTo(String value) {
            addCriterion("purchase_pro_no <=", value, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoLike(String value) {
            addCriterion("purchase_pro_no like", value, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoNotLike(String value) {
            addCriterion("purchase_pro_no not like", value, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoIn(List<String> values) {
            addCriterion("purchase_pro_no in", values, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoNotIn(List<String> values) {
            addCriterion("purchase_pro_no not in", values, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoBetween(String value1, String value2) {
            addCriterion("purchase_pro_no between", value1, value2, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseProNoNotBetween(String value1, String value2) {
            addCriterion("purchase_pro_no not between", value1, value2, "purchaseProNo");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table purchase_project
     *
     * @mbg.generated do_not_delete_during_merge Thu Dec 31 09:44:51 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table purchase_project
     *
     * @mbg.generated Thu Dec 31 09:44:51 CST 2020
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