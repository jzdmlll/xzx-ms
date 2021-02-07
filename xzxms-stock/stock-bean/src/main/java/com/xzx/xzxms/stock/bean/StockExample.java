package com.xzx.xzxms.stock.bean;

import java.util.ArrayList;
import java.util.List;

public class StockExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    public StockExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
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
     * This method corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Long value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Long value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Long value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Long> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andStockNumberIsNull() {
            addCriterion("stock_number is null");
            return (Criteria) this;
        }

        public Criteria andStockNumberIsNotNull() {
            addCriterion("stock_number is not null");
            return (Criteria) this;
        }

        public Criteria andStockNumberEqualTo(Double value) {
            addCriterion("stock_number =", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberNotEqualTo(Double value) {
            addCriterion("stock_number <>", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberGreaterThan(Double value) {
            addCriterion("stock_number >", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberGreaterThanOrEqualTo(Double value) {
            addCriterion("stock_number >=", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberLessThan(Double value) {
            addCriterion("stock_number <", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberLessThanOrEqualTo(Double value) {
            addCriterion("stock_number <=", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberIn(List<Double> values) {
            addCriterion("stock_number in", values, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberNotIn(List<Double> values) {
            addCriterion("stock_number not in", values, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberBetween(Double value1, Double value2) {
            addCriterion("stock_number between", value1, value2, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberNotBetween(Double value1, Double value2) {
            addCriterion("stock_number not between", value1, value2, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockStatusIsNull() {
            addCriterion("stock_status is null");
            return (Criteria) this;
        }

        public Criteria andStockStatusIsNotNull() {
            addCriterion("stock_status is not null");
            return (Criteria) this;
        }

        public Criteria andStockStatusEqualTo(Integer value) {
            addCriterion("stock_status =", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotEqualTo(Integer value) {
            addCriterion("stock_status <>", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusGreaterThan(Integer value) {
            addCriterion("stock_status >", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_status >=", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusLessThan(Integer value) {
            addCriterion("stock_status <", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusLessThanOrEqualTo(Integer value) {
            addCriterion("stock_status <=", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusIn(List<Integer> values) {
            addCriterion("stock_status in", values, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotIn(List<Integer> values) {
            addCriterion("stock_status not in", values, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusBetween(Integer value1, Integer value2) {
            addCriterion("stock_status between", value1, value2, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_status not between", value1, value2, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockRemarkIsNull() {
            addCriterion("stock_remark is null");
            return (Criteria) this;
        }

        public Criteria andStockRemarkIsNotNull() {
            addCriterion("stock_remark is not null");
            return (Criteria) this;
        }

        public Criteria andStockRemarkEqualTo(String value) {
            addCriterion("stock_remark =", value, "stockRemark");
            return (Criteria) this;
        }

        public Criteria andStockRemarkNotEqualTo(String value) {
            addCriterion("stock_remark <>", value, "stockRemark");
            return (Criteria) this;
        }

        public Criteria andStockRemarkGreaterThan(String value) {
            addCriterion("stock_remark >", value, "stockRemark");
            return (Criteria) this;
        }

        public Criteria andStockRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("stock_remark >=", value, "stockRemark");
            return (Criteria) this;
        }

        public Criteria andStockRemarkLessThan(String value) {
            addCriterion("stock_remark <", value, "stockRemark");
            return (Criteria) this;
        }

        public Criteria andStockRemarkLessThanOrEqualTo(String value) {
            addCriterion("stock_remark <=", value, "stockRemark");
            return (Criteria) this;
        }

        public Criteria andStockRemarkLike(String value) {
            addCriterion("stock_remark like", value, "stockRemark");
            return (Criteria) this;
        }

        public Criteria andStockRemarkNotLike(String value) {
            addCriterion("stock_remark not like", value, "stockRemark");
            return (Criteria) this;
        }

        public Criteria andStockRemarkIn(List<String> values) {
            addCriterion("stock_remark in", values, "stockRemark");
            return (Criteria) this;
        }

        public Criteria andStockRemarkNotIn(List<String> values) {
            addCriterion("stock_remark not in", values, "stockRemark");
            return (Criteria) this;
        }

        public Criteria andStockRemarkBetween(String value1, String value2) {
            addCriterion("stock_remark between", value1, value2, "stockRemark");
            return (Criteria) this;
        }

        public Criteria andStockRemarkNotBetween(String value1, String value2) {
            addCriterion("stock_remark not between", value1, value2, "stockRemark");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table stock
     *
     * @mbg.generated do_not_delete_during_merge Sun Feb 07 14:16:16 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table stock
     *
     * @mbg.generated Sun Feb 07 14:16:16 CST 2021
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