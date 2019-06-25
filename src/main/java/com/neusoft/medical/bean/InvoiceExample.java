package com.neusoft.medical.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvoiceExample() {
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

        public Criteria andInvoiceIdIsNull() {
            addCriterion("invoice_id is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIsNotNull() {
            addCriterion("invoice_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdEqualTo(Integer value) {
            addCriterion("invoice_id =", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotEqualTo(Integer value) {
            addCriterion("invoice_id <>", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdGreaterThan(Integer value) {
            addCriterion("invoice_id >", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_id >=", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLessThan(Integer value) {
            addCriterion("invoice_id <", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_id <=", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIn(List<Integer> values) {
            addCriterion("invoice_id in", values, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotIn(List<Integer> values) {
            addCriterion("invoice_id not in", values, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdBetween(Integer value1, Integer value2) {
            addCriterion("invoice_id between", value1, value2, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_id not between", value1, value2, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNull() {
            addCriterion("invoice_title is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNotNull() {
            addCriterion("invoice_title is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleEqualTo(String value) {
            addCriterion("invoice_title =", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotEqualTo(String value) {
            addCriterion("invoice_title <>", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThan(String value) {
            addCriterion("invoice_title >", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_title >=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThan(String value) {
            addCriterion("invoice_title <", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThanOrEqualTo(String value) {
            addCriterion("invoice_title <=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLike(String value) {
            addCriterion("invoice_title like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotLike(String value) {
            addCriterion("invoice_title not like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIn(List<String> values) {
            addCriterion("invoice_title in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotIn(List<String> values) {
            addCriterion("invoice_title not in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleBetween(String value1, String value2) {
            addCriterion("invoice_title between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotBetween(String value1, String value2) {
            addCriterion("invoice_title not between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andCollectorIdIsNull() {
            addCriterion("collector_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectorIdIsNotNull() {
            addCriterion("collector_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectorIdEqualTo(Integer value) {
            addCriterion("collector_id =", value, "collectorId");
            return (Criteria) this;
        }

        public Criteria andCollectorIdNotEqualTo(Integer value) {
            addCriterion("collector_id <>", value, "collectorId");
            return (Criteria) this;
        }

        public Criteria andCollectorIdGreaterThan(Integer value) {
            addCriterion("collector_id >", value, "collectorId");
            return (Criteria) this;
        }

        public Criteria andCollectorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collector_id >=", value, "collectorId");
            return (Criteria) this;
        }

        public Criteria andCollectorIdLessThan(Integer value) {
            addCriterion("collector_id <", value, "collectorId");
            return (Criteria) this;
        }

        public Criteria andCollectorIdLessThanOrEqualTo(Integer value) {
            addCriterion("collector_id <=", value, "collectorId");
            return (Criteria) this;
        }

        public Criteria andCollectorIdIn(List<Integer> values) {
            addCriterion("collector_id in", values, "collectorId");
            return (Criteria) this;
        }

        public Criteria andCollectorIdNotIn(List<Integer> values) {
            addCriterion("collector_id not in", values, "collectorId");
            return (Criteria) this;
        }

        public Criteria andCollectorIdBetween(Integer value1, Integer value2) {
            addCriterion("collector_id between", value1, value2, "collectorId");
            return (Criteria) this;
        }

        public Criteria andCollectorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collector_id not between", value1, value2, "collectorId");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountIsNull() {
            addCriterion("invoice_amount is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountIsNotNull() {
            addCriterion("invoice_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountEqualTo(Double value) {
            addCriterion("invoice_amount =", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountNotEqualTo(Double value) {
            addCriterion("invoice_amount <>", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountGreaterThan(Double value) {
            addCriterion("invoice_amount >", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("invoice_amount >=", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountLessThan(Double value) {
            addCriterion("invoice_amount <", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountLessThanOrEqualTo(Double value) {
            addCriterion("invoice_amount <=", value, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountIn(List<Double> values) {
            addCriterion("invoice_amount in", values, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountNotIn(List<Double> values) {
            addCriterion("invoice_amount not in", values, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountBetween(Double value1, Double value2) {
            addCriterion("invoice_amount between", value1, value2, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceAmountNotBetween(Double value1, Double value2) {
            addCriterion("invoice_amount not between", value1, value2, "invoiceAmount");
            return (Criteria) this;
        }

        public Criteria andSelfPayIsNull() {
            addCriterion("self_pay is null");
            return (Criteria) this;
        }

        public Criteria andSelfPayIsNotNull() {
            addCriterion("self_pay is not null");
            return (Criteria) this;
        }

        public Criteria andSelfPayEqualTo(Double value) {
            addCriterion("self_pay =", value, "selfPay");
            return (Criteria) this;
        }

        public Criteria andSelfPayNotEqualTo(Double value) {
            addCriterion("self_pay <>", value, "selfPay");
            return (Criteria) this;
        }

        public Criteria andSelfPayGreaterThan(Double value) {
            addCriterion("self_pay >", value, "selfPay");
            return (Criteria) this;
        }

        public Criteria andSelfPayGreaterThanOrEqualTo(Double value) {
            addCriterion("self_pay >=", value, "selfPay");
            return (Criteria) this;
        }

        public Criteria andSelfPayLessThan(Double value) {
            addCriterion("self_pay <", value, "selfPay");
            return (Criteria) this;
        }

        public Criteria andSelfPayLessThanOrEqualTo(Double value) {
            addCriterion("self_pay <=", value, "selfPay");
            return (Criteria) this;
        }

        public Criteria andSelfPayIn(List<Double> values) {
            addCriterion("self_pay in", values, "selfPay");
            return (Criteria) this;
        }

        public Criteria andSelfPayNotIn(List<Double> values) {
            addCriterion("self_pay not in", values, "selfPay");
            return (Criteria) this;
        }

        public Criteria andSelfPayBetween(Double value1, Double value2) {
            addCriterion("self_pay between", value1, value2, "selfPay");
            return (Criteria) this;
        }

        public Criteria andSelfPayNotBetween(Double value1, Double value2) {
            addCriterion("self_pay not between", value1, value2, "selfPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayIsNull() {
            addCriterion("account_pay is null");
            return (Criteria) this;
        }

        public Criteria andAccountPayIsNotNull() {
            addCriterion("account_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPayEqualTo(Double value) {
            addCriterion("account_pay =", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayNotEqualTo(Double value) {
            addCriterion("account_pay <>", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayGreaterThan(Double value) {
            addCriterion("account_pay >", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayGreaterThanOrEqualTo(Double value) {
            addCriterion("account_pay >=", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayLessThan(Double value) {
            addCriterion("account_pay <", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayLessThanOrEqualTo(Double value) {
            addCriterion("account_pay <=", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayIn(List<Double> values) {
            addCriterion("account_pay in", values, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayNotIn(List<Double> values) {
            addCriterion("account_pay not in", values, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayBetween(Double value1, Double value2) {
            addCriterion("account_pay between", value1, value2, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayNotBetween(Double value1, Double value2) {
            addCriterion("account_pay not between", value1, value2, "accountPay");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayIsNull() {
            addCriterion("reimbursement_pay is null");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayIsNotNull() {
            addCriterion("reimbursement_pay is not null");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayEqualTo(Double value) {
            addCriterion("reimbursement_pay =", value, "reimbursementPay");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayNotEqualTo(Double value) {
            addCriterion("reimbursement_pay <>", value, "reimbursementPay");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayGreaterThan(Double value) {
            addCriterion("reimbursement_pay >", value, "reimbursementPay");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayGreaterThanOrEqualTo(Double value) {
            addCriterion("reimbursement_pay >=", value, "reimbursementPay");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayLessThan(Double value) {
            addCriterion("reimbursement_pay <", value, "reimbursementPay");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayLessThanOrEqualTo(Double value) {
            addCriterion("reimbursement_pay <=", value, "reimbursementPay");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayIn(List<Double> values) {
            addCriterion("reimbursement_pay in", values, "reimbursementPay");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayNotIn(List<Double> values) {
            addCriterion("reimbursement_pay not in", values, "reimbursementPay");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayBetween(Double value1, Double value2) {
            addCriterion("reimbursement_pay between", value1, value2, "reimbursementPay");
            return (Criteria) this;
        }

        public Criteria andReimbursementPayNotBetween(Double value1, Double value2) {
            addCriterion("reimbursement_pay not between", value1, value2, "reimbursementPay");
            return (Criteria) this;
        }

        public Criteria andDiscountedIsNull() {
            addCriterion("discounted is null");
            return (Criteria) this;
        }

        public Criteria andDiscountedIsNotNull() {
            addCriterion("discounted is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountedEqualTo(Double value) {
            addCriterion("discounted =", value, "discounted");
            return (Criteria) this;
        }

        public Criteria andDiscountedNotEqualTo(Double value) {
            addCriterion("discounted <>", value, "discounted");
            return (Criteria) this;
        }

        public Criteria andDiscountedGreaterThan(Double value) {
            addCriterion("discounted >", value, "discounted");
            return (Criteria) this;
        }

        public Criteria andDiscountedGreaterThanOrEqualTo(Double value) {
            addCriterion("discounted >=", value, "discounted");
            return (Criteria) this;
        }

        public Criteria andDiscountedLessThan(Double value) {
            addCriterion("discounted <", value, "discounted");
            return (Criteria) this;
        }

        public Criteria andDiscountedLessThanOrEqualTo(Double value) {
            addCriterion("discounted <=", value, "discounted");
            return (Criteria) this;
        }

        public Criteria andDiscountedIn(List<Double> values) {
            addCriterion("discounted in", values, "discounted");
            return (Criteria) this;
        }

        public Criteria andDiscountedNotIn(List<Double> values) {
            addCriterion("discounted not in", values, "discounted");
            return (Criteria) this;
        }

        public Criteria andDiscountedBetween(Double value1, Double value2) {
            addCriterion("discounted between", value1, value2, "discounted");
            return (Criteria) this;
        }

        public Criteria andDiscountedNotBetween(Double value1, Double value2) {
            addCriterion("discounted not between", value1, value2, "discounted");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateIsNull() {
            addCriterion("invoice_state is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateIsNotNull() {
            addCriterion("invoice_state is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateEqualTo(Integer value) {
            addCriterion("invoice_state =", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateNotEqualTo(Integer value) {
            addCriterion("invoice_state <>", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateGreaterThan(Integer value) {
            addCriterion("invoice_state >", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_state >=", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateLessThan(Integer value) {
            addCriterion("invoice_state <", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_state <=", value, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateIn(List<Integer> values) {
            addCriterion("invoice_state in", values, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateNotIn(List<Integer> values) {
            addCriterion("invoice_state not in", values, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateBetween(Integer value1, Integer value2) {
            addCriterion("invoice_state between", value1, value2, "invoiceState");
            return (Criteria) this;
        }

        public Criteria andInvoiceStateNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_state not between", value1, value2, "invoiceState");
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