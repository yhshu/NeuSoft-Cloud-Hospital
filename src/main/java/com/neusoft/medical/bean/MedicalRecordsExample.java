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

        public Criteria andPastDiseaseIsNull() {
            addCriterion("past_disease is null");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseIsNotNull() {
            addCriterion("past_disease is not null");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseEqualTo(String value) {
            addCriterion("past_disease =", value, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseNotEqualTo(String value) {
            addCriterion("past_disease <>", value, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseGreaterThan(String value) {
            addCriterion("past_disease >", value, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseGreaterThanOrEqualTo(String value) {
            addCriterion("past_disease >=", value, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseLessThan(String value) {
            addCriterion("past_disease <", value, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseLessThanOrEqualTo(String value) {
            addCriterion("past_disease <=", value, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseLike(String value) {
            addCriterion("past_disease like", value, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseNotLike(String value) {
            addCriterion("past_disease not like", value, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseIn(List<String> values) {
            addCriterion("past_disease in", values, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseNotIn(List<String> values) {
            addCriterion("past_disease not in", values, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseBetween(String value1, String value2) {
            addCriterion("past_disease between", value1, value2, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPastDiseaseNotBetween(String value1, String value2) {
            addCriterion("past_disease not between", value1, value2, "pastDisease");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamIsNull() {
            addCriterion("physical_exam is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamIsNotNull() {
            addCriterion("physical_exam is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamEqualTo(String value) {
            addCriterion("physical_exam =", value, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamNotEqualTo(String value) {
            addCriterion("physical_exam <>", value, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamGreaterThan(String value) {
            addCriterion("physical_exam >", value, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamGreaterThanOrEqualTo(String value) {
            addCriterion("physical_exam >=", value, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamLessThan(String value) {
            addCriterion("physical_exam <", value, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamLessThanOrEqualTo(String value) {
            addCriterion("physical_exam <=", value, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamLike(String value) {
            addCriterion("physical_exam like", value, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamNotLike(String value) {
            addCriterion("physical_exam not like", value, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamIn(List<String> values) {
            addCriterion("physical_exam in", values, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamNotIn(List<String> values) {
            addCriterion("physical_exam not in", values, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamBetween(String value1, String value2) {
            addCriterion("physical_exam between", value1, value2, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andPhysicalExamNotBetween(String value1, String value2) {
            addCriterion("physical_exam not between", value1, value2, "physicalExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamIsNull() {
            addCriterion("auxiliary_exam is null");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamIsNotNull() {
            addCriterion("auxiliary_exam is not null");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamEqualTo(String value) {
            addCriterion("auxiliary_exam =", value, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamNotEqualTo(String value) {
            addCriterion("auxiliary_exam <>", value, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamGreaterThan(String value) {
            addCriterion("auxiliary_exam >", value, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamGreaterThanOrEqualTo(String value) {
            addCriterion("auxiliary_exam >=", value, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamLessThan(String value) {
            addCriterion("auxiliary_exam <", value, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamLessThanOrEqualTo(String value) {
            addCriterion("auxiliary_exam <=", value, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamLike(String value) {
            addCriterion("auxiliary_exam like", value, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamNotLike(String value) {
            addCriterion("auxiliary_exam not like", value, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamIn(List<String> values) {
            addCriterion("auxiliary_exam in", values, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamNotIn(List<String> values) {
            addCriterion("auxiliary_exam not in", values, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamBetween(String value1, String value2) {
            addCriterion("auxiliary_exam between", value1, value2, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andAuxiliaryExamNotBetween(String value1, String value2) {
            addCriterion("auxiliary_exam not between", value1, value2, "auxiliaryExam");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNull() {
            addCriterion("opinion is null");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNotNull() {
            addCriterion("opinion is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionEqualTo(String value) {
            addCriterion("opinion =", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotEqualTo(String value) {
            addCriterion("opinion <>", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThan(String value) {
            addCriterion("opinion >", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("opinion >=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThan(String value) {
            addCriterion("opinion <", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThanOrEqualTo(String value) {
            addCriterion("opinion <=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLike(String value) {
            addCriterion("opinion like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotLike(String value) {
            addCriterion("opinion not like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionIn(List<String> values) {
            addCriterion("opinion in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotIn(List<String> values) {
            addCriterion("opinion not in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionBetween(String value1, String value2) {
            addCriterion("opinion between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotBetween(String value1, String value2) {
            addCriterion("opinion not between", value1, value2, "opinion");
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

        public Criteria andDoctorIdIsNull() {
            addCriterion("doctor_id is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNotNull() {
            addCriterion("doctor_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdEqualTo(Integer value) {
            addCriterion("doctor_id =", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotEqualTo(Integer value) {
            addCriterion("doctor_id <>", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThan(Integer value) {
            addCriterion("doctor_id >", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_id >=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThan(Integer value) {
            addCriterion("doctor_id <", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_id <=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIn(List<Integer> values) {
            addCriterion("doctor_id in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotIn(List<Integer> values) {
            addCriterion("doctor_id not in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdBetween(Integer value1, Integer value2) {
            addCriterion("doctor_id between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_id not between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNull() {
            addCriterion("template_name is null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNotNull() {
            addCriterion("template_name is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameEqualTo(String value) {
            addCriterion("template_name =", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotEqualTo(String value) {
            addCriterion("template_name <>", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThan(String value) {
            addCriterion("template_name >", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("template_name >=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThan(String value) {
            addCriterion("template_name <", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("template_name <=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLike(String value) {
            addCriterion("template_name like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotLike(String value) {
            addCriterion("template_name not like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIn(List<String> values) {
            addCriterion("template_name in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotIn(List<String> values) {
            addCriterion("template_name not in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameBetween(String value1, String value2) {
            addCriterion("template_name between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotBetween(String value1, String value2) {
            addCriterion("template_name not between", value1, value2, "templateName");
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