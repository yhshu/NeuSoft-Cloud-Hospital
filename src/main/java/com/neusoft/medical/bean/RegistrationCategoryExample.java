package com.neusoft.medical.bean;

import java.util.ArrayList;
import java.util.List;

public class RegistrationCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegistrationCategoryExample() {
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

        public Criteria andRegistrationCategoryIdIsNull() {
            addCriterion("registration_category_id is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIdIsNotNull() {
            addCriterion("registration_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIdEqualTo(Integer value) {
            addCriterion("registration_category_id =", value, "registrationCategoryId");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIdNotEqualTo(Integer value) {
            addCriterion("registration_category_id <>", value, "registrationCategoryId");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIdGreaterThan(Integer value) {
            addCriterion("registration_category_id >", value, "registrationCategoryId");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("registration_category_id >=", value, "registrationCategoryId");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIdLessThan(Integer value) {
            addCriterion("registration_category_id <", value, "registrationCategoryId");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("registration_category_id <=", value, "registrationCategoryId");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIdIn(List<Integer> values) {
            addCriterion("registration_category_id in", values, "registrationCategoryId");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIdNotIn(List<Integer> values) {
            addCriterion("registration_category_id not in", values, "registrationCategoryId");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("registration_category_id between", value1, value2, "registrationCategoryId");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("registration_category_id not between", value1, value2, "registrationCategoryId");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameIsNull() {
            addCriterion("registration_category_name is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameIsNotNull() {
            addCriterion("registration_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameEqualTo(String value) {
            addCriterion("registration_category_name =", value, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameNotEqualTo(String value) {
            addCriterion("registration_category_name <>", value, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameGreaterThan(String value) {
            addCriterion("registration_category_name >", value, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("registration_category_name >=", value, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameLessThan(String value) {
            addCriterion("registration_category_name <", value, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("registration_category_name <=", value, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameLike(String value) {
            addCriterion("registration_category_name like", value, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameNotLike(String value) {
            addCriterion("registration_category_name not like", value, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameIn(List<String> values) {
            addCriterion("registration_category_name in", values, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameNotIn(List<String> values) {
            addCriterion("registration_category_name not in", values, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameBetween(String value1, String value2) {
            addCriterion("registration_category_name between", value1, value2, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNameNotBetween(String value1, String value2) {
            addCriterion("registration_category_name not between", value1, value2, "registrationCategoryName");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Boolean value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Boolean value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Boolean value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Boolean value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Boolean> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Boolean> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andSequenceNoIsNull() {
            addCriterion("sequence_no is null");
            return (Criteria) this;
        }

        public Criteria andSequenceNoIsNotNull() {
            addCriterion("sequence_no is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceNoEqualTo(Integer value) {
            addCriterion("sequence_no =", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotEqualTo(Integer value) {
            addCriterion("sequence_no <>", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoGreaterThan(Integer value) {
            addCriterion("sequence_no >", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence_no >=", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoLessThan(Integer value) {
            addCriterion("sequence_no <", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoLessThanOrEqualTo(Integer value) {
            addCriterion("sequence_no <=", value, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoIn(List<Integer> values) {
            addCriterion("sequence_no in", values, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotIn(List<Integer> values) {
            addCriterion("sequence_no not in", values, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoBetween(Integer value1, Integer value2) {
            addCriterion("sequence_no between", value1, value2, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andSequenceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence_no not between", value1, value2, "sequenceNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeIsNull() {
            addCriterion("registration_fee is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeIsNotNull() {
            addCriterion("registration_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeEqualTo(Double value) {
            addCriterion("registration_fee =", value, "registrationFee");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeNotEqualTo(Double value) {
            addCriterion("registration_fee <>", value, "registrationFee");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeGreaterThan(Double value) {
            addCriterion("registration_fee >", value, "registrationFee");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("registration_fee >=", value, "registrationFee");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeLessThan(Double value) {
            addCriterion("registration_fee <", value, "registrationFee");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeLessThanOrEqualTo(Double value) {
            addCriterion("registration_fee <=", value, "registrationFee");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeIn(List<Double> values) {
            addCriterion("registration_fee in", values, "registrationFee");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeNotIn(List<Double> values) {
            addCriterion("registration_fee not in", values, "registrationFee");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeBetween(Double value1, Double value2) {
            addCriterion("registration_fee between", value1, value2, "registrationFee");
            return (Criteria) this;
        }

        public Criteria andRegistrationFeeNotBetween(Double value1, Double value2) {
            addCriterion("registration_fee not between", value1, value2, "registrationFee");
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