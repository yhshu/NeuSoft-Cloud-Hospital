package com.neusoft.medical.bean;

import java.util.ArrayList;
import java.util.List;

public class ExpenseCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpenseCategoryExample() {
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

        public Criteria andExpenseCategoryIdIsNull() {
            addCriterion("expense_category_id is null");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIdIsNotNull() {
            addCriterion("expense_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIdEqualTo(Integer value) {
            addCriterion("expense_category_id =", value, "expenseCategoryId");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIdNotEqualTo(Integer value) {
            addCriterion("expense_category_id <>", value, "expenseCategoryId");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIdGreaterThan(Integer value) {
            addCriterion("expense_category_id >", value, "expenseCategoryId");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("expense_category_id >=", value, "expenseCategoryId");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIdLessThan(Integer value) {
            addCriterion("expense_category_id <", value, "expenseCategoryId");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("expense_category_id <=", value, "expenseCategoryId");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIdIn(List<Integer> values) {
            addCriterion("expense_category_id in", values, "expenseCategoryId");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIdNotIn(List<Integer> values) {
            addCriterion("expense_category_id not in", values, "expenseCategoryId");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("expense_category_id between", value1, value2, "expenseCategoryId");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("expense_category_id not between", value1, value2, "expenseCategoryId");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeIsNull() {
            addCriterion("expense_category_code is null");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeIsNotNull() {
            addCriterion("expense_category_code is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeEqualTo(String value) {
            addCriterion("expense_category_code =", value, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeNotEqualTo(String value) {
            addCriterion("expense_category_code <>", value, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeGreaterThan(String value) {
            addCriterion("expense_category_code >", value, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("expense_category_code >=", value, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeLessThan(String value) {
            addCriterion("expense_category_code <", value, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeLessThanOrEqualTo(String value) {
            addCriterion("expense_category_code <=", value, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeLike(String value) {
            addCriterion("expense_category_code like", value, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeNotLike(String value) {
            addCriterion("expense_category_code not like", value, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeIn(List<String> values) {
            addCriterion("expense_category_code in", values, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeNotIn(List<String> values) {
            addCriterion("expense_category_code not in", values, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeBetween(String value1, String value2) {
            addCriterion("expense_category_code between", value1, value2, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryCodeNotBetween(String value1, String value2) {
            addCriterion("expense_category_code not between", value1, value2, "expenseCategoryCode");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameIsNull() {
            addCriterion("expense_category_name is null");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameIsNotNull() {
            addCriterion("expense_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameEqualTo(String value) {
            addCriterion("expense_category_name =", value, "expenseCategoryName");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameNotEqualTo(String value) {
            addCriterion("expense_category_name <>", value, "expenseCategoryName");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameGreaterThan(String value) {
            addCriterion("expense_category_name >", value, "expenseCategoryName");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("expense_category_name >=", value, "expenseCategoryName");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameLessThan(String value) {
            addCriterion("expense_category_name <", value, "expenseCategoryName");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("expense_category_name <=", value, "expenseCategoryName");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameLike(String value) {
            addCriterion("expense_category_name like", value, "expenseCategoryName");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameNotLike(String value) {
            addCriterion("expense_category_name not like", value, "expenseCategoryName");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameIn(List<String> values) {
            addCriterion("expense_category_name in", values, "expenseCategoryName");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameNotIn(List<String> values) {
            addCriterion("expense_category_name not in", values, "expenseCategoryName");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameBetween(String value1, String value2) {
            addCriterion("expense_category_name between", value1, value2, "expenseCategoryName");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNameNotBetween(String value1, String value2) {
            addCriterion("expense_category_name not between", value1, value2, "expenseCategoryName");
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