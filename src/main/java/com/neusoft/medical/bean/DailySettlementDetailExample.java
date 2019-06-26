package com.neusoft.medical.bean;

import java.util.ArrayList;
import java.util.List;

public class DailySettlementDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DailySettlementDetailExample() {
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

        public Criteria andDailySettlementDetailIdIsNull() {
            addCriterion("daily_settlement_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailIdIsNotNull() {
            addCriterion("daily_settlement_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailIdEqualTo(Integer value) {
            addCriterion("daily_settlement_detail_id =", value, "dailySettlementDetailId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailIdNotEqualTo(Integer value) {
            addCriterion("daily_settlement_detail_id <>", value, "dailySettlementDetailId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailIdGreaterThan(Integer value) {
            addCriterion("daily_settlement_detail_id >", value, "dailySettlementDetailId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_settlement_detail_id >=", value, "dailySettlementDetailId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailIdLessThan(Integer value) {
            addCriterion("daily_settlement_detail_id <", value, "dailySettlementDetailId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("daily_settlement_detail_id <=", value, "dailySettlementDetailId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailIdIn(List<Integer> values) {
            addCriterion("daily_settlement_detail_id in", values, "dailySettlementDetailId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailIdNotIn(List<Integer> values) {
            addCriterion("daily_settlement_detail_id not in", values, "dailySettlementDetailId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("daily_settlement_detail_id between", value1, value2, "dailySettlementDetailId");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_settlement_detail_id not between", value1, value2, "dailySettlementDetailId");
            return (Criteria) this;
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

        public Criteria andInvoiceNumsIsNull() {
            addCriterion("invoice_nums is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumsIsNotNull() {
            addCriterion("invoice_nums is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumsEqualTo(Integer value) {
            addCriterion("invoice_nums =", value, "invoiceNums");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumsNotEqualTo(Integer value) {
            addCriterion("invoice_nums <>", value, "invoiceNums");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumsGreaterThan(Integer value) {
            addCriterion("invoice_nums >", value, "invoiceNums");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_nums >=", value, "invoiceNums");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumsLessThan(Integer value) {
            addCriterion("invoice_nums <", value, "invoiceNums");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumsLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_nums <=", value, "invoiceNums");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumsIn(List<Integer> values) {
            addCriterion("invoice_nums in", values, "invoiceNums");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumsNotIn(List<Integer> values) {
            addCriterion("invoice_nums not in", values, "invoiceNums");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumsBetween(Integer value1, Integer value2) {
            addCriterion("invoice_nums between", value1, value2, "invoiceNums");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_nums not between", value1, value2, "invoiceNums");
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

        public Criteria andPatientNameIsNull() {
            addCriterion("patient_name is null");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNotNull() {
            addCriterion("patient_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatientNameEqualTo(String value) {
            addCriterion("patient_name =", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotEqualTo(String value) {
            addCriterion("patient_name <>", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThan(String value) {
            addCriterion("patient_name >", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThanOrEqualTo(String value) {
            addCriterion("patient_name >=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThan(String value) {
            addCriterion("patient_name <", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThanOrEqualTo(String value) {
            addCriterion("patient_name <=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLike(String value) {
            addCriterion("patient_name like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotLike(String value) {
            addCriterion("patient_name not like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameIn(List<String> values) {
            addCriterion("patient_name in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotIn(List<String> values) {
            addCriterion("patient_name not in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameBetween(String value1, String value2) {
            addCriterion("patient_name between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotBetween(String value1, String value2) {
            addCriterion("patient_name not between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountIsNull() {
            addCriterion("invoice_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountIsNotNull() {
            addCriterion("invoice_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountEqualTo(Double value) {
            addCriterion("invoice_total_amount =", value, "invoiceTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountNotEqualTo(Double value) {
            addCriterion("invoice_total_amount <>", value, "invoiceTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountGreaterThan(Double value) {
            addCriterion("invoice_total_amount >", value, "invoiceTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("invoice_total_amount >=", value, "invoiceTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountLessThan(Double value) {
            addCriterion("invoice_total_amount <", value, "invoiceTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountLessThanOrEqualTo(Double value) {
            addCriterion("invoice_total_amount <=", value, "invoiceTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountIn(List<Double> values) {
            addCriterion("invoice_total_amount in", values, "invoiceTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountNotIn(List<Double> values) {
            addCriterion("invoice_total_amount not in", values, "invoiceTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountBetween(Double value1, Double value2) {
            addCriterion("invoice_total_amount between", value1, value2, "invoiceTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceTotalAmountNotBetween(Double value1, Double value2) {
            addCriterion("invoice_total_amount not between", value1, value2, "invoiceTotalAmount");
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

        public Criteria andDailySettlementDetailStateIsNull() {
            addCriterion("daily_settlement_detail_state is null");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailStateIsNotNull() {
            addCriterion("daily_settlement_detail_state is not null");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailStateEqualTo(Integer value) {
            addCriterion("daily_settlement_detail_state =", value, "dailySettlementDetailState");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailStateNotEqualTo(Integer value) {
            addCriterion("daily_settlement_detail_state <>", value, "dailySettlementDetailState");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailStateGreaterThan(Integer value) {
            addCriterion("daily_settlement_detail_state >", value, "dailySettlementDetailState");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_settlement_detail_state >=", value, "dailySettlementDetailState");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailStateLessThan(Integer value) {
            addCriterion("daily_settlement_detail_state <", value, "dailySettlementDetailState");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailStateLessThanOrEqualTo(Integer value) {
            addCriterion("daily_settlement_detail_state <=", value, "dailySettlementDetailState");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailStateIn(List<Integer> values) {
            addCriterion("daily_settlement_detail_state in", values, "dailySettlementDetailState");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailStateNotIn(List<Integer> values) {
            addCriterion("daily_settlement_detail_state not in", values, "dailySettlementDetailState");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailStateBetween(Integer value1, Integer value2) {
            addCriterion("daily_settlement_detail_state between", value1, value2, "dailySettlementDetailState");
            return (Criteria) this;
        }

        public Criteria andDailySettlementDetailStateNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_settlement_detail_state not between", value1, value2, "dailySettlementDetailState");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdIsNull() {
            addCriterion("settlement_category_id is null");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdIsNotNull() {
            addCriterion("settlement_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdEqualTo(Integer value) {
            addCriterion("settlement_category_id =", value, "settlementCategoryId");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdNotEqualTo(Integer value) {
            addCriterion("settlement_category_id <>", value, "settlementCategoryId");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdGreaterThan(Integer value) {
            addCriterion("settlement_category_id >", value, "settlementCategoryId");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("settlement_category_id >=", value, "settlementCategoryId");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdLessThan(Integer value) {
            addCriterion("settlement_category_id <", value, "settlementCategoryId");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("settlement_category_id <=", value, "settlementCategoryId");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdIn(List<Integer> values) {
            addCriterion("settlement_category_id in", values, "settlementCategoryId");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdNotIn(List<Integer> values) {
            addCriterion("settlement_category_id not in", values, "settlementCategoryId");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("settlement_category_id between", value1, value2, "settlementCategoryId");
            return (Criteria) this;
        }

        public Criteria andSettlementCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("settlement_category_id not between", value1, value2, "settlementCategoryId");
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