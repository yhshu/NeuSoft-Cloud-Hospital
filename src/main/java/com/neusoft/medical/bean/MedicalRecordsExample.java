package com.neusoft.medical.bean;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MedicalRecordsExample() {
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

        public Criteria andMedicalRecordsIdIsNull() {
            addCriterion("medical_records_id is null");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordsIdIsNotNull() {
            addCriterion("medical_records_id is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordsIdEqualTo(Integer value) {
            addCriterion("medical_records_id =", value, "medicalRecordsId");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordsIdNotEqualTo(Integer value) {
            addCriterion("medical_records_id <>", value, "medicalRecordsId");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordsIdGreaterThan(Integer value) {
            addCriterion("medical_records_id >", value, "medicalRecordsId");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("medical_records_id >=", value, "medicalRecordsId");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordsIdLessThan(Integer value) {
            addCriterion("medical_records_id <", value, "medicalRecordsId");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordsIdLessThanOrEqualTo(Integer value) {
            addCriterion("medical_records_id <=", value, "medicalRecordsId");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordsIdIn(List<Integer> values) {
            addCriterion("medical_records_id in", values, "medicalRecordsId");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordsIdNotIn(List<Integer> values) {
            addCriterion("medical_records_id not in", values, "medicalRecordsId");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordsIdBetween(Integer value1, Integer value2) {
            addCriterion("medical_records_id between", value1, value2, "medicalRecordsId");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("medical_records_id not between", value1, value2, "medicalRecordsId");
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

        public Criteria andMainInfoIsNull() {
            addCriterion("main_info is null");
            return (Criteria) this;
        }

        public Criteria andMainInfoIsNotNull() {
            addCriterion("main_info is not null");
            return (Criteria) this;
        }

        public Criteria andMainInfoEqualTo(String value) {
            addCriterion("main_info =", value, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andMainInfoNotEqualTo(String value) {
            addCriterion("main_info <>", value, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andMainInfoGreaterThan(String value) {
            addCriterion("main_info >", value, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andMainInfoGreaterThanOrEqualTo(String value) {
            addCriterion("main_info >=", value, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andMainInfoLessThan(String value) {
            addCriterion("main_info <", value, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andMainInfoLessThanOrEqualTo(String value) {
            addCriterion("main_info <=", value, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andMainInfoLike(String value) {
            addCriterion("main_info like", value, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andMainInfoNotLike(String value) {
            addCriterion("main_info not like", value, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andMainInfoIn(List<String> values) {
            addCriterion("main_info in", values, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andMainInfoNotIn(List<String> values) {
            addCriterion("main_info not in", values, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andMainInfoBetween(String value1, String value2) {
            addCriterion("main_info between", value1, value2, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andMainInfoNotBetween(String value1, String value2) {
            addCriterion("main_info not between", value1, value2, "mainInfo");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseIsNull() {
            addCriterion("current_disease is null");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseIsNotNull() {
            addCriterion("current_disease is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseEqualTo(String value) {
            addCriterion("current_disease =", value, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseNotEqualTo(String value) {
            addCriterion("current_disease <>", value, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseGreaterThan(String value) {
            addCriterion("current_disease >", value, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseGreaterThanOrEqualTo(String value) {
            addCriterion("current_disease >=", value, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseLessThan(String value) {
            addCriterion("current_disease <", value, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseLessThanOrEqualTo(String value) {
            addCriterion("current_disease <=", value, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseLike(String value) {
            addCriterion("current_disease like", value, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseNotLike(String value) {
            addCriterion("current_disease not like", value, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseIn(List<String> values) {
            addCriterion("current_disease in", values, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseNotIn(List<String> values) {
            addCriterion("current_disease not in", values, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseBetween(String value1, String value2) {
            addCriterion("current_disease between", value1, value2, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentDiseaseNotBetween(String value1, String value2) {
            addCriterion("current_disease not between", value1, value2, "currentDisease");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentIsNull() {
            addCriterion("current_treatment is null");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentIsNotNull() {
            addCriterion("current_treatment is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentEqualTo(String value) {
            addCriterion("current_treatment =", value, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentNotEqualTo(String value) {
            addCriterion("current_treatment <>", value, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentGreaterThan(String value) {
            addCriterion("current_treatment >", value, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentGreaterThanOrEqualTo(String value) {
            addCriterion("current_treatment >=", value, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentLessThan(String value) {
            addCriterion("current_treatment <", value, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentLessThanOrEqualTo(String value) {
            addCriterion("current_treatment <=", value, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentLike(String value) {
            addCriterion("current_treatment like", value, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentNotLike(String value) {
            addCriterion("current_treatment not like", value, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentIn(List<String> values) {
            addCriterion("current_treatment in", values, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentNotIn(List<String> values) {
            addCriterion("current_treatment not in", values, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentBetween(String value1, String value2) {
            addCriterion("current_treatment between", value1, value2, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andCurrentTreatmentNotBetween(String value1, String value2) {
            addCriterion("current_treatment not between", value1, value2, "currentTreatment");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternIsNull() {
            addCriterion("preliminary_western is null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternIsNotNull() {
            addCriterion("preliminary_western is not null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternEqualTo(String value) {
            addCriterion("preliminary_western =", value, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternNotEqualTo(String value) {
            addCriterion("preliminary_western <>", value, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternGreaterThan(String value) {
            addCriterion("preliminary_western >", value, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternGreaterThanOrEqualTo(String value) {
            addCriterion("preliminary_western >=", value, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternLessThan(String value) {
            addCriterion("preliminary_western <", value, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternLessThanOrEqualTo(String value) {
            addCriterion("preliminary_western <=", value, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternLike(String value) {
            addCriterion("preliminary_western like", value, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternNotLike(String value) {
            addCriterion("preliminary_western not like", value, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternIn(List<String> values) {
            addCriterion("preliminary_western in", values, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternNotIn(List<String> values) {
            addCriterion("preliminary_western not in", values, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternBetween(String value1, String value2) {
            addCriterion("preliminary_western between", value1, value2, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryWesternNotBetween(String value1, String value2) {
            addCriterion("preliminary_western not between", value1, value2, "preliminaryWestern");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseIsNull() {
            addCriterion("preliminary_chinese is null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseIsNotNull() {
            addCriterion("preliminary_chinese is not null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseEqualTo(String value) {
            addCriterion("preliminary_chinese =", value, "preliminaryChinese");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseNotEqualTo(String value) {
            addCriterion("preliminary_chinese <>", value, "preliminaryChinese");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseGreaterThan(String value) {
            addCriterion("preliminary_chinese >", value, "preliminaryChinese");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseGreaterThanOrEqualTo(String value) {
            addCriterion("preliminary_chinese >=", value, "preliminaryChinese");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseLessThan(String value) {
            addCriterion("preliminary_chinese <", value, "preliminaryChinese");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseLessThanOrEqualTo(String value) {
            addCriterion("preliminary_chinese <=", value, "preliminaryChinese");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseLike(String value) {
            addCriterion("preliminary_chinese like", value, "preliminaryChinese");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseNotLike(String value) {
            addCriterion("preliminary_chinese not like", value, "preliminaryChinese");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseIn(List<String> values) {
            addCriterion("preliminary_chinese in", values, "preliminaryChinese");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseNotIn(List<String> values) {
            addCriterion("preliminary_chinese not in", values, "preliminaryChinese");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseBetween(String value1, String value2) {
            addCriterion("preliminary_chinese between", value1, value2, "preliminaryChinese");
            return (Criteria) this;
        }

        public Criteria andPreliminaryChineseNotBetween(String value1, String value2) {
            addCriterion("preliminary_chinese not between", value1, value2, "preliminaryChinese");
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