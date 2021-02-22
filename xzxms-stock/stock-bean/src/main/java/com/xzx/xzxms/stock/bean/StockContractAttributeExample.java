package com.xzx.xzxms.stock.bean;

import java.util.ArrayList;
import java.util.List;

public class StockContractAttributeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    public StockContractAttributeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
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
     * This method corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
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

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(Long value) {
            addCriterion("contract_id =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(Long value) {
            addCriterion("contract_id <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(Long value) {
            addCriterion("contract_id >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contract_id >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(Long value) {
            addCriterion("contract_id <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(Long value) {
            addCriterion("contract_id <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<Long> values) {
            addCriterion("contract_id in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<Long> values) {
            addCriterion("contract_id not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(Long value1, Long value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(Long value1, Long value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(String value) {
            addCriterion("payment_method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(String value) {
            addCriterion("payment_method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(String value) {
            addCriterion("payment_method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(String value) {
            addCriterion("payment_method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(String value) {
            addCriterion("payment_method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(String value) {
            addCriterion("payment_method <=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLike(String value) {
            addCriterion("payment_method like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotLike(String value) {
            addCriterion("payment_method not like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<String> values) {
            addCriterion("payment_method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<String> values) {
            addCriterion("payment_method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(String value1, String value2) {
            addCriterion("payment_method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(String value1, String value2) {
            addCriterion("payment_method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPayableIsNull() {
            addCriterion("payable is null");
            return (Criteria) this;
        }

        public Criteria andPayableIsNotNull() {
            addCriterion("payable is not null");
            return (Criteria) this;
        }

        public Criteria andPayableEqualTo(Double value) {
            addCriterion("payable =", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableNotEqualTo(Double value) {
            addCriterion("payable <>", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableGreaterThan(Double value) {
            addCriterion("payable >", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableGreaterThanOrEqualTo(Double value) {
            addCriterion("payable >=", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableLessThan(Double value) {
            addCriterion("payable <", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableLessThanOrEqualTo(Double value) {
            addCriterion("payable <=", value, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableIn(List<Double> values) {
            addCriterion("payable in", values, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableNotIn(List<Double> values) {
            addCriterion("payable not in", values, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableBetween(Double value1, Double value2) {
            addCriterion("payable between", value1, value2, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableNotBetween(Double value1, Double value2) {
            addCriterion("payable not between", value1, value2, "payable");
            return (Criteria) this;
        }

        public Criteria andPayableTimeIsNull() {
            addCriterion("payable_time is null");
            return (Criteria) this;
        }

        public Criteria andPayableTimeIsNotNull() {
            addCriterion("payable_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayableTimeEqualTo(Long value) {
            addCriterion("payable_time =", value, "payableTime");
            return (Criteria) this;
        }

        public Criteria andPayableTimeNotEqualTo(Long value) {
            addCriterion("payable_time <>", value, "payableTime");
            return (Criteria) this;
        }

        public Criteria andPayableTimeGreaterThan(Long value) {
            addCriterion("payable_time >", value, "payableTime");
            return (Criteria) this;
        }

        public Criteria andPayableTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("payable_time >=", value, "payableTime");
            return (Criteria) this;
        }

        public Criteria andPayableTimeLessThan(Long value) {
            addCriterion("payable_time <", value, "payableTime");
            return (Criteria) this;
        }

        public Criteria andPayableTimeLessThanOrEqualTo(Long value) {
            addCriterion("payable_time <=", value, "payableTime");
            return (Criteria) this;
        }

        public Criteria andPayableTimeIn(List<Long> values) {
            addCriterion("payable_time in", values, "payableTime");
            return (Criteria) this;
        }

        public Criteria andPayableTimeNotIn(List<Long> values) {
            addCriterion("payable_time not in", values, "payableTime");
            return (Criteria) this;
        }

        public Criteria andPayableTimeBetween(Long value1, Long value2) {
            addCriterion("payable_time between", value1, value2, "payableTime");
            return (Criteria) this;
        }

        public Criteria andPayableTimeNotBetween(Long value1, Long value2) {
            addCriterion("payable_time not between", value1, value2, "payableTime");
            return (Criteria) this;
        }

        public Criteria andIsBondIsNull() {
            addCriterion("is_bond is null");
            return (Criteria) this;
        }

        public Criteria andIsBondIsNotNull() {
            addCriterion("is_bond is not null");
            return (Criteria) this;
        }

        public Criteria andIsBondEqualTo(Integer value) {
            addCriterion("is_bond =", value, "isBond");
            return (Criteria) this;
        }

        public Criteria andIsBondNotEqualTo(Integer value) {
            addCriterion("is_bond <>", value, "isBond");
            return (Criteria) this;
        }

        public Criteria andIsBondGreaterThan(Integer value) {
            addCriterion("is_bond >", value, "isBond");
            return (Criteria) this;
        }

        public Criteria andIsBondGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_bond >=", value, "isBond");
            return (Criteria) this;
        }

        public Criteria andIsBondLessThan(Integer value) {
            addCriterion("is_bond <", value, "isBond");
            return (Criteria) this;
        }

        public Criteria andIsBondLessThanOrEqualTo(Integer value) {
            addCriterion("is_bond <=", value, "isBond");
            return (Criteria) this;
        }

        public Criteria andIsBondIn(List<Integer> values) {
            addCriterion("is_bond in", values, "isBond");
            return (Criteria) this;
        }

        public Criteria andIsBondNotIn(List<Integer> values) {
            addCriterion("is_bond not in", values, "isBond");
            return (Criteria) this;
        }

        public Criteria andIsBondBetween(Integer value1, Integer value2) {
            addCriterion("is_bond between", value1, value2, "isBond");
            return (Criteria) this;
        }

        public Criteria andIsBondNotBetween(Integer value1, Integer value2) {
            addCriterion("is_bond not between", value1, value2, "isBond");
            return (Criteria) this;
        }

        public Criteria andBondIsNull() {
            addCriterion("bond is null");
            return (Criteria) this;
        }

        public Criteria andBondIsNotNull() {
            addCriterion("bond is not null");
            return (Criteria) this;
        }

        public Criteria andBondEqualTo(Double value) {
            addCriterion("bond =", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondNotEqualTo(Double value) {
            addCriterion("bond <>", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondGreaterThan(Double value) {
            addCriterion("bond >", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondGreaterThanOrEqualTo(Double value) {
            addCriterion("bond >=", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondLessThan(Double value) {
            addCriterion("bond <", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondLessThanOrEqualTo(Double value) {
            addCriterion("bond <=", value, "bond");
            return (Criteria) this;
        }

        public Criteria andBondIn(List<Double> values) {
            addCriterion("bond in", values, "bond");
            return (Criteria) this;
        }

        public Criteria andBondNotIn(List<Double> values) {
            addCriterion("bond not in", values, "bond");
            return (Criteria) this;
        }

        public Criteria andBondBetween(Double value1, Double value2) {
            addCriterion("bond between", value1, value2, "bond");
            return (Criteria) this;
        }

        public Criteria andBondNotBetween(Double value1, Double value2) {
            addCriterion("bond not between", value1, value2, "bond");
            return (Criteria) this;
        }

        public Criteria andBondTimeIsNull() {
            addCriterion("bond_time is null");
            return (Criteria) this;
        }

        public Criteria andBondTimeIsNotNull() {
            addCriterion("bond_time is not null");
            return (Criteria) this;
        }

        public Criteria andBondTimeEqualTo(Long value) {
            addCriterion("bond_time =", value, "bondTime");
            return (Criteria) this;
        }

        public Criteria andBondTimeNotEqualTo(Long value) {
            addCriterion("bond_time <>", value, "bondTime");
            return (Criteria) this;
        }

        public Criteria andBondTimeGreaterThan(Long value) {
            addCriterion("bond_time >", value, "bondTime");
            return (Criteria) this;
        }

        public Criteria andBondTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("bond_time >=", value, "bondTime");
            return (Criteria) this;
        }

        public Criteria andBondTimeLessThan(Long value) {
            addCriterion("bond_time <", value, "bondTime");
            return (Criteria) this;
        }

        public Criteria andBondTimeLessThanOrEqualTo(Long value) {
            addCriterion("bond_time <=", value, "bondTime");
            return (Criteria) this;
        }

        public Criteria andBondTimeIn(List<Long> values) {
            addCriterion("bond_time in", values, "bondTime");
            return (Criteria) this;
        }

        public Criteria andBondTimeNotIn(List<Long> values) {
            addCriterion("bond_time not in", values, "bondTime");
            return (Criteria) this;
        }

        public Criteria andBondTimeBetween(Long value1, Long value2) {
            addCriterion("bond_time between", value1, value2, "bondTime");
            return (Criteria) this;
        }

        public Criteria andBondTimeNotBetween(Long value1, Long value2) {
            addCriterion("bond_time not between", value1, value2, "bondTime");
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
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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
     * This class corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated do_not_delete_during_merge Sun Feb 07 14:14:53 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table stock_contract_attribute
     *
     * @mbg.generated Sun Feb 07 14:14:53 CST 2021
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