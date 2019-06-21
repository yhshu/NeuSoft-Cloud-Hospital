package com.neusoft.medical.bean;

import java.util.ArrayList;
import java.util.List;

public class ChargeFormExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChargeFormExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andChargeFormIdIsNull() {
            addCriterion("charge_form_id is null");
            return (Criteria) this;
        }

        public Criteria andChargeFormIdIsNotNull() {
            addCriterion("charge_form_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargeFormIdEqualTo(Integer value) {
            addCriterion("charge_form_id =", value, "chargeFormId");
            return (Criteria) this;
        }

        public Criteria andChargeFormIdNotEqualTo(Integer value) {
            addCriterion("charge_form_id <>", value, "chargeFormId");
            return (Criteria) this;
        }

        public Criteria andChargeFormIdGreaterThan(Integer value) {
            addCriterion("charge_form_id >", value, "chargeFormId");
            return (Criteria) this;
        }

        public Criteria andChargeFormIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("charge_form_id >=", value, "chargeFormId");
            return (Criteria) this;
        }

        public Criteria andChargeFormIdLessThan(Integer value) {
            addCriterion("charge_form_id <", value, "chargeFormId");
            return (Criteria) this;
        }

        public Criteria andChargeFormIdLessThanOrEqualTo(Integer value) {
            addCriterion("charge_form_id <=", value, "chargeFormId");
            return (Criteria) this;
        }

        public Criteria andChargeFormIdIn(List<Integer> values) {
            addCriterion("charge_form_id in", values, "chargeFormId");
            return (Criteria) this;
        }

        public Criteria andChargeFormIdNotIn(List<Integer> values) {
            addCriterion("charge_form_id not in", values, "chargeFormId");
            return (Criteria) this;
        }

        public Criteria andChargeFormIdBetween(Integer value1, Integer value2) {
            addCriterion("charge_form_id between", value1, value2, "chargeFormId");
            return (Criteria) this;
        }

        public Criteria andChargeFormIdNotBetween(Integer value1, Integer value2) {
            addCriterion("charge_form_id not between", value1, value2, "chargeFormId");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameIsNull() {
            addCriterion("charge_form_name is null");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameIsNotNull() {
            addCriterion("charge_form_name is not null");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameEqualTo(String value) {
            addCriterion("charge_form_name =", value, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameNotEqualTo(String value) {
            addCriterion("charge_form_name <>", value, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameGreaterThan(String value) {
            addCriterion("charge_form_name >", value, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameGreaterThanOrEqualTo(String value) {
            addCriterion("charge_form_name >=", value, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameLessThan(String value) {
            addCriterion("charge_form_name <", value, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameLessThanOrEqualTo(String value) {
            addCriterion("charge_form_name <=", value, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameLike(String value) {
            addCriterion("charge_form_name like", value, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameNotLike(String value) {
            addCriterion("charge_form_name not like", value, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameIn(List<String> values) {
            addCriterion("charge_form_name in", values, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameNotIn(List<String> values) {
            addCriterion("charge_form_name not in", values, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameBetween(String value1, String value2) {
            addCriterion("charge_form_name between", value1, value2, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andChargeFormNameNotBetween(String value1, String value2) {
            addCriterion("charge_form_name not between", value1, value2, "chargeFormName");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdIsNull() {
            addCriterion("registration_id is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdIsNotNull() {
            addCriterion("registration_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdEqualTo(Integer value) {
            addCriterion("registration_id =", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdNotEqualTo(Integer value) {
            addCriterion("registration_id <>", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdGreaterThan(Integer value) {
            addCriterion("registration_id >", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("registration_id >=", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdLessThan(Integer value) {
            addCriterion("registration_id <", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdLessThanOrEqualTo(Integer value) {
            addCriterion("registration_id <=", value, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdIn(List<Integer> values) {
            addCriterion("registration_id in", values, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdNotIn(List<Integer> values) {
            addCriterion("registration_id not in", values, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdBetween(Integer value1, Integer value2) {
            addCriterion("registration_id between", value1, value2, "registrationId");
            return (Criteria) this;
        }

        public Criteria andRegistrationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("registration_id not between", value1, value2, "registrationId");
            return (Criteria) this;
        }

        public Criteria andSaveStateIsNull() {
            addCriterion("save_state is null");
            return (Criteria) this;
        }

        public Criteria andSaveStateIsNotNull() {
            addCriterion("save_state is not null");
            return (Criteria) this;
        }

        public Criteria andSaveStateEqualTo(Integer value) {
            addCriterion("save_state =", value, "saveState");
            return (Criteria) this;
        }

        public Criteria andSaveStateNotEqualTo(Integer value) {
            addCriterion("save_state <>", value, "saveState");
            return (Criteria) this;
        }

        public Criteria andSaveStateGreaterThan(Integer value) {
            addCriterion("save_state >", value, "saveState");
            return (Criteria) this;
        }

        public Criteria andSaveStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("save_state >=", value, "saveState");
            return (Criteria) this;
        }

        public Criteria andSaveStateLessThan(Integer value) {
            addCriterion("save_state <", value, "saveState");
            return (Criteria) this;
        }

        public Criteria andSaveStateLessThanOrEqualTo(Integer value) {
            addCriterion("save_state <=", value, "saveState");
            return (Criteria) this;
        }

        public Criteria andSaveStateIn(List<Integer> values) {
            addCriterion("save_state in", values, "saveState");
            return (Criteria) this;
        }

        public Criteria andSaveStateNotIn(List<Integer> values) {
            addCriterion("save_state not in", values, "saveState");
            return (Criteria) this;
        }

        public Criteria andSaveStateBetween(Integer value1, Integer value2) {
            addCriterion("save_state between", value1, value2, "saveState");
            return (Criteria) this;
        }

        public Criteria andSaveStateNotBetween(Integer value1, Integer value2) {
            addCriterion("save_state not between", value1, value2, "saveState");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNull() {
            addCriterion("pay_state is null");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNotNull() {
            addCriterion("pay_state is not null");
            return (Criteria) this;
        }

        public Criteria andPayStateEqualTo(Integer value) {
            addCriterion("pay_state =", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotEqualTo(Integer value) {
            addCriterion("pay_state <>", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThan(Integer value) {
            addCriterion("pay_state >", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_state >=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThan(Integer value) {
            addCriterion("pay_state <", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThanOrEqualTo(Integer value) {
            addCriterion("pay_state <=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateIn(List<Integer> values) {
            addCriterion("pay_state in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotIn(List<Integer> values) {
            addCriterion("pay_state not in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateBetween(Integer value1, Integer value2) {
            addCriterion("pay_state between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_state not between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateIsNull() {
            addCriterion("execution_state is null");
            return (Criteria) this;
        }

        public Criteria andExecutionStateIsNotNull() {
            addCriterion("execution_state is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionStateEqualTo(Integer value) {
            addCriterion("execution_state =", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateNotEqualTo(Integer value) {
            addCriterion("execution_state <>", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateGreaterThan(Integer value) {
            addCriterion("execution_state >", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("execution_state >=", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateLessThan(Integer value) {
            addCriterion("execution_state <", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateLessThanOrEqualTo(Integer value) {
            addCriterion("execution_state <=", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateIn(List<Integer> values) {
            addCriterion("execution_state in", values, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateNotIn(List<Integer> values) {
            addCriterion("execution_state not in", values, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateBetween(Integer value1, Integer value2) {
            addCriterion("execution_state between", value1, value2, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateNotBetween(Integer value1, Integer value2) {
            addCriterion("execution_state not between", value1, value2, "executionState");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("valid is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("valid is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Integer value) {
            addCriterion("valid =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Integer value) {
            addCriterion("valid <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Integer value) {
            addCriterion("valid >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Integer value) {
            addCriterion("valid >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Integer value) {
            addCriterion("valid <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Integer value) {
            addCriterion("valid <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Integer> values) {
            addCriterion("valid in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Integer> values) {
            addCriterion("valid not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Integer value1, Integer value2) {
            addCriterion("valid between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Integer value1, Integer value2) {
            addCriterion("valid not between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNull() {
            addCriterion("reserve1 is null");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNotNull() {
            addCriterion("reserve1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve1EqualTo(String value) {
            addCriterion("reserve1 =", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotEqualTo(String value) {
            addCriterion("reserve1 <>", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThan(String value) {
            addCriterion("reserve1 >", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThanOrEqualTo(String value) {
            addCriterion("reserve1 >=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThan(String value) {
            addCriterion("reserve1 <", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThanOrEqualTo(String value) {
            addCriterion("reserve1 <=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Like(String value) {
            addCriterion("reserve1 like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotLike(String value) {
            addCriterion("reserve1 not like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1In(List<String> values) {
            addCriterion("reserve1 in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotIn(List<String> values) {
            addCriterion("reserve1 not in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Between(String value1, String value2) {
            addCriterion("reserve1 between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotBetween(String value1, String value2) {
            addCriterion("reserve1 not between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNull() {
            addCriterion("reserve2 is null");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNotNull() {
            addCriterion("reserve2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve2EqualTo(String value) {
            addCriterion("reserve2 =", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotEqualTo(String value) {
            addCriterion("reserve2 <>", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThan(String value) {
            addCriterion("reserve2 >", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThanOrEqualTo(String value) {
            addCriterion("reserve2 >=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThan(String value) {
            addCriterion("reserve2 <", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThanOrEqualTo(String value) {
            addCriterion("reserve2 <=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Like(String value) {
            addCriterion("reserve2 like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotLike(String value) {
            addCriterion("reserve2 not like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2In(List<String> values) {
            addCriterion("reserve2 in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotIn(List<String> values) {
            addCriterion("reserve2 not in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Between(String value1, String value2) {
            addCriterion("reserve2 between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotBetween(String value1, String value2) {
            addCriterion("reserve2 not between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNull() {
            addCriterion("reserve3 is null");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNotNull() {
            addCriterion("reserve3 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve3EqualTo(String value) {
            addCriterion("reserve3 =", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotEqualTo(String value) {
            addCriterion("reserve3 <>", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThan(String value) {
            addCriterion("reserve3 >", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThanOrEqualTo(String value) {
            addCriterion("reserve3 >=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThan(String value) {
            addCriterion("reserve3 <", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThanOrEqualTo(String value) {
            addCriterion("reserve3 <=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Like(String value) {
            addCriterion("reserve3 like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotLike(String value) {
            addCriterion("reserve3 not like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3In(List<String> values) {
            addCriterion("reserve3 in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotIn(List<String> values) {
            addCriterion("reserve3 not in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Between(String value1, String value2) {
            addCriterion("reserve3 between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotBetween(String value1, String value2) {
            addCriterion("reserve3 not between", value1, value2, "reserve3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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