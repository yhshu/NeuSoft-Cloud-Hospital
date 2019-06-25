package com.neusoft.medical.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailySettlementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DailySettlementExample() {
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

        public Criteria andDailySettlementIdIsNull() {
            addCriterion("daily_settlement_id is null");
            return (Criteria) this;
        }

        public Criteria andDailySettlementIdIsNotNull() {
            addCriterion("daily_settlement_id is not null");
            return (Criteria) this;
        }

        public Criteria andDailySettlementIdEqualTo(Integer value) {
            addCriterion("daily_settlement_id =", value, "dailySettlementId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementIdNotEqualTo(Integer value) {
            addCriterion("daily_settlement_id <>", value, "dailySettlementId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementIdGreaterThan(Integer value) {
            addCriterion("daily_settlement_id >", value, "dailySettlementId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_settlement_id >=", value, "dailySettlementId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementIdLessThan(Integer value) {
            addCriterion("daily_settlement_id <", value, "dailySettlementId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementIdLessThanOrEqualTo(Integer value) {
            addCriterion("daily_settlement_id <=", value, "dailySettlementId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementIdIn(List<Integer> values) {
            addCriterion("daily_settlement_id in", values, "dailySettlementId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementIdNotIn(List<Integer> values) {
            addCriterion("daily_settlement_id not in", values, "dailySettlementId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementIdBetween(Integer value1, Integer value2) {
            addCriterion("daily_settlement_id between", value1, value2, "dailySettlementId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementIdNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_settlement_id not between", value1, value2, "dailySettlementId");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdIsNull() {
            addCriterion("collector_account_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdIsNotNull() {
            addCriterion("collector_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdEqualTo(Integer value) {
            addCriterion("collector_account_id =", value, "collectorAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdNotEqualTo(Integer value) {
            addCriterion("collector_account_id <>", value, "collectorAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdGreaterThan(Integer value) {
            addCriterion("collector_account_id >", value, "collectorAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collector_account_id >=", value, "collectorAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdLessThan(Integer value) {
            addCriterion("collector_account_id <", value, "collectorAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("collector_account_id <=", value, "collectorAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdIn(List<Integer> values) {
            addCriterion("collector_account_id in", values, "collectorAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdNotIn(List<Integer> values) {
            addCriterion("collector_account_id not in", values, "collectorAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("collector_account_id between", value1, value2, "collectorAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectorAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collector_account_id not between", value1, value2, "collectorAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameIsNull() {
            addCriterion("collector_real_name is null");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameIsNotNull() {
            addCriterion("collector_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameEqualTo(String value) {
            addCriterion("collector_real_name =", value, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameNotEqualTo(String value) {
            addCriterion("collector_real_name <>", value, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameGreaterThan(String value) {
            addCriterion("collector_real_name >", value, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("collector_real_name >=", value, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameLessThan(String value) {
            addCriterion("collector_real_name <", value, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameLessThanOrEqualTo(String value) {
            addCriterion("collector_real_name <=", value, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameLike(String value) {
            addCriterion("collector_real_name like", value, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameNotLike(String value) {
            addCriterion("collector_real_name not like", value, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameIn(List<String> values) {
            addCriterion("collector_real_name in", values, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameNotIn(List<String> values) {
            addCriterion("collector_real_name not in", values, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameBetween(String value1, String value2) {
            addCriterion("collector_real_name between", value1, value2, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andCollectorRealNameNotBetween(String value1, String value2) {
            addCriterion("collector_real_name not between", value1, value2, "collectorRealName");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateIsNull() {
            addCriterion("daily_settlement_date is null");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateIsNotNull() {
            addCriterion("daily_settlement_date is not null");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateEqualTo(Date value) {
            addCriterion("daily_settlement_date =", value, "dailySettlementDate");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateNotEqualTo(Date value) {
            addCriterion("daily_settlement_date <>", value, "dailySettlementDate");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateGreaterThan(Date value) {
            addCriterion("daily_settlement_date >", value, "dailySettlementDate");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateGreaterThanOrEqualTo(Date value) {
            addCriterion("daily_settlement_date >=", value, "dailySettlementDate");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateLessThan(Date value) {
            addCriterion("daily_settlement_date <", value, "dailySettlementDate");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateLessThanOrEqualTo(Date value) {
            addCriterion("daily_settlement_date <=", value, "dailySettlementDate");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateIn(List<Date> values) {
            addCriterion("daily_settlement_date in", values, "dailySettlementDate");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateNotIn(List<Date> values) {
            addCriterion("daily_settlement_date not in", values, "dailySettlementDate");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateBetween(Date value1, Date value2) {
            addCriterion("daily_settlement_date between", value1, value2, "dailySettlementDate");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDateNotBetween(Date value1, Date value2) {
            addCriterion("daily_settlement_date not between", value1, value2, "dailySettlementDate");
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