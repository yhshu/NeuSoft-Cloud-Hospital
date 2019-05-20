package com.neusoft.medical.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegistrationInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoIsNull() {
            addCriterion("medical_record_no is null");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoIsNotNull() {
            addCriterion("medical_record_no is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoEqualTo(String value) {
            addCriterion("medical_record_no =", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotEqualTo(String value) {
            addCriterion("medical_record_no <>", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoGreaterThan(String value) {
            addCriterion("medical_record_no >", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoGreaterThanOrEqualTo(String value) {
            addCriterion("medical_record_no >=", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoLessThan(String value) {
            addCriterion("medical_record_no <", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoLessThanOrEqualTo(String value) {
            addCriterion("medical_record_no <=", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoLike(String value) {
            addCriterion("medical_record_no like", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotLike(String value) {
            addCriterion("medical_record_no not like", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoIn(List<String> values) {
            addCriterion("medical_record_no in", values, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotIn(List<String> values) {
            addCriterion("medical_record_no not in", values, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoBetween(String value1, String value2) {
            addCriterion("medical_record_no between", value1, value2, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotBetween(String value1, String value2) {
            addCriterion("medical_record_no not between", value1, value2, "medicalRecordNo");
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

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIsNull() {
            addCriterion("registration_category is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIsNotNull() {
            addCriterion("registration_category is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryEqualTo(String value) {
            addCriterion("registration_category =", value, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNotEqualTo(String value) {
            addCriterion("registration_category <>", value, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryGreaterThan(String value) {
            addCriterion("registration_category >", value, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("registration_category >=", value, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryLessThan(String value) {
            addCriterion("registration_category <", value, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryLessThanOrEqualTo(String value) {
            addCriterion("registration_category <=", value, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryLike(String value) {
            addCriterion("registration_category like", value, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNotLike(String value) {
            addCriterion("registration_category not like", value, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryIn(List<String> values) {
            addCriterion("registration_category in", values, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNotIn(List<String> values) {
            addCriterion("registration_category not in", values, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryBetween(String value1, String value2) {
            addCriterion("registration_category between", value1, value2, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andRegistrationCategoryNotBetween(String value1, String value2) {
            addCriterion("registration_category not between", value1, value2, "registrationCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryIsNull() {
            addCriterion("medical_category is null");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryIsNotNull() {
            addCriterion("medical_category is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryEqualTo(String value) {
            addCriterion("medical_category =", value, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryNotEqualTo(String value) {
            addCriterion("medical_category <>", value, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryGreaterThan(String value) {
            addCriterion("medical_category >", value, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("medical_category >=", value, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryLessThan(String value) {
            addCriterion("medical_category <", value, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryLessThanOrEqualTo(String value) {
            addCriterion("medical_category <=", value, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryLike(String value) {
            addCriterion("medical_category like", value, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryNotLike(String value) {
            addCriterion("medical_category not like", value, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryIn(List<String> values) {
            addCriterion("medical_category in", values, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryNotIn(List<String> values) {
            addCriterion("medical_category not in", values, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryBetween(String value1, String value2) {
            addCriterion("medical_category between", value1, value2, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andMedicalCategoryNotBetween(String value1, String value2) {
            addCriterion("medical_category not between", value1, value2, "medicalCategory");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoIsNull() {
            addCriterion("identity_card_no is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoIsNotNull() {
            addCriterion("identity_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoEqualTo(String value) {
            addCriterion("identity_card_no =", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotEqualTo(String value) {
            addCriterion("identity_card_no <>", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoGreaterThan(String value) {
            addCriterion("identity_card_no >", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("identity_card_no >=", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoLessThan(String value) {
            addCriterion("identity_card_no <", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoLessThanOrEqualTo(String value) {
            addCriterion("identity_card_no <=", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoLike(String value) {
            addCriterion("identity_card_no like", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotLike(String value) {
            addCriterion("identity_card_no not like", value, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoIn(List<String> values) {
            addCriterion("identity_card_no in", values, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotIn(List<String> values) {
            addCriterion("identity_card_no not in", values, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoBetween(String value1, String value2) {
            addCriterion("identity_card_no between", value1, value2, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNoNotBetween(String value1, String value2) {
            addCriterion("identity_card_no not between", value1, value2, "identityCardNo");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressIsNull() {
            addCriterion("family_address is null");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressIsNotNull() {
            addCriterion("family_address is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressEqualTo(String value) {
            addCriterion("family_address =", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotEqualTo(String value) {
            addCriterion("family_address <>", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressGreaterThan(String value) {
            addCriterion("family_address >", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("family_address >=", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressLessThan(String value) {
            addCriterion("family_address <", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressLessThanOrEqualTo(String value) {
            addCriterion("family_address <=", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressLike(String value) {
            addCriterion("family_address like", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotLike(String value) {
            addCriterion("family_address not like", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressIn(List<String> values) {
            addCriterion("family_address in", values, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotIn(List<String> values) {
            addCriterion("family_address not in", values, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressBetween(String value1, String value2) {
            addCriterion("family_address between", value1, value2, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotBetween(String value1, String value2) {
            addCriterion("family_address not between", value1, value2, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateIsNull() {
            addCriterion("registration_date is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateIsNotNull() {
            addCriterion("registration_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateEqualTo(Date value) {
            addCriterion("registration_date =", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateNotEqualTo(Date value) {
            addCriterion("registration_date <>", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateGreaterThan(Date value) {
            addCriterion("registration_date >", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("registration_date >=", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateLessThan(Date value) {
            addCriterion("registration_date <", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateLessThanOrEqualTo(Date value) {
            addCriterion("registration_date <=", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateIn(List<Date> values) {
            addCriterion("registration_date in", values, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateNotIn(List<Date> values) {
            addCriterion("registration_date not in", values, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateBetween(Date value1, Date value2) {
            addCriterion("registration_date between", value1, value2, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateNotBetween(Date value1, Date value2) {
            addCriterion("registration_date not between", value1, value2, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateIsNull() {
            addCriterion("visit_date is null");
            return (Criteria) this;
        }

        public Criteria andVisitDateIsNotNull() {
            addCriterion("visit_date is not null");
            return (Criteria) this;
        }

        public Criteria andVisitDateEqualTo(Date value) {
            addCriterion("visit_date =", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateNotEqualTo(Date value) {
            addCriterion("visit_date <>", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateGreaterThan(Date value) {
            addCriterion("visit_date >", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateGreaterThanOrEqualTo(Date value) {
            addCriterion("visit_date >=", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateLessThan(Date value) {
            addCriterion("visit_date <", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateLessThanOrEqualTo(Date value) {
            addCriterion("visit_date <=", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateIn(List<Date> values) {
            addCriterion("visit_date in", values, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateNotIn(List<Date> values) {
            addCriterion("visit_date not in", values, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateBetween(Date value1, Date value2) {
            addCriterion("visit_date between", value1, value2, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateNotBetween(Date value1, Date value2) {
            addCriterion("visit_date not between", value1, value2, "visitDate");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Integer value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Integer value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(Integer value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Integer value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Integer> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Integer> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
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

        public Criteria andRegistrationSourceIsNull() {
            addCriterion("registration_source is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceIsNotNull() {
            addCriterion("registration_source is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceEqualTo(String value) {
            addCriterion("registration_source =", value, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceNotEqualTo(String value) {
            addCriterion("registration_source <>", value, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceGreaterThan(String value) {
            addCriterion("registration_source >", value, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceGreaterThanOrEqualTo(String value) {
            addCriterion("registration_source >=", value, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceLessThan(String value) {
            addCriterion("registration_source <", value, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceLessThanOrEqualTo(String value) {
            addCriterion("registration_source <=", value, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceLike(String value) {
            addCriterion("registration_source like", value, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceNotLike(String value) {
            addCriterion("registration_source not like", value, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceIn(List<String> values) {
            addCriterion("registration_source in", values, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceNotIn(List<String> values) {
            addCriterion("registration_source not in", values, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceBetween(String value1, String value2) {
            addCriterion("registration_source between", value1, value2, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andRegistrationSourceNotBetween(String value1, String value2) {
            addCriterion("registration_source not between", value1, value2, "registrationSource");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryIsNull() {
            addCriterion("settle_accounts_category is null");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryIsNotNull() {
            addCriterion("settle_accounts_category is not null");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryEqualTo(String value) {
            addCriterion("settle_accounts_category =", value, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryNotEqualTo(String value) {
            addCriterion("settle_accounts_category <>", value, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryGreaterThan(String value) {
            addCriterion("settle_accounts_category >", value, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("settle_accounts_category >=", value, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryLessThan(String value) {
            addCriterion("settle_accounts_category <", value, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryLessThanOrEqualTo(String value) {
            addCriterion("settle_accounts_category <=", value, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryLike(String value) {
            addCriterion("settle_accounts_category like", value, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryNotLike(String value) {
            addCriterion("settle_accounts_category not like", value, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryIn(List<String> values) {
            addCriterion("settle_accounts_category in", values, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryNotIn(List<String> values) {
            addCriterion("settle_accounts_category not in", values, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryBetween(String value1, String value2) {
            addCriterion("settle_accounts_category between", value1, value2, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andSettleAccountsCategoryNotBetween(String value1, String value2) {
            addCriterion("settle_accounts_category not between", value1, value2, "settleAccountsCategory");
            return (Criteria) this;
        }

        public Criteria andIsVisitedIsNull() {
            addCriterion("is_visited is null");
            return (Criteria) this;
        }

        public Criteria andIsVisitedIsNotNull() {
            addCriterion("is_visited is not null");
            return (Criteria) this;
        }

        public Criteria andIsVisitedEqualTo(String value) {
            addCriterion("is_visited =", value, "isVisited");
            return (Criteria) this;
        }

        public Criteria andIsVisitedNotEqualTo(String value) {
            addCriterion("is_visited <>", value, "isVisited");
            return (Criteria) this;
        }

        public Criteria andIsVisitedGreaterThan(String value) {
            addCriterion("is_visited >", value, "isVisited");
            return (Criteria) this;
        }

        public Criteria andIsVisitedGreaterThanOrEqualTo(String value) {
            addCriterion("is_visited >=", value, "isVisited");
            return (Criteria) this;
        }

        public Criteria andIsVisitedLessThan(String value) {
            addCriterion("is_visited <", value, "isVisited");
            return (Criteria) this;
        }

        public Criteria andIsVisitedLessThanOrEqualTo(String value) {
            addCriterion("is_visited <=", value, "isVisited");
            return (Criteria) this;
        }

        public Criteria andIsVisitedLike(String value) {
            addCriterion("is_visited like", value, "isVisited");
            return (Criteria) this;
        }

        public Criteria andIsVisitedNotLike(String value) {
            addCriterion("is_visited not like", value, "isVisited");
            return (Criteria) this;
        }

        public Criteria andIsVisitedIn(List<String> values) {
            addCriterion("is_visited in", values, "isVisited");
            return (Criteria) this;
        }

        public Criteria andIsVisitedNotIn(List<String> values) {
            addCriterion("is_visited not in", values, "isVisited");
            return (Criteria) this;
        }

        public Criteria andIsVisitedBetween(String value1, String value2) {
            addCriterion("is_visited between", value1, value2, "isVisited");
            return (Criteria) this;
        }

        public Criteria andIsVisitedNotBetween(String value1, String value2) {
            addCriterion("is_visited not between", value1, value2, "isVisited");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andExpenseIsNull() {
            addCriterion("expense is null");
            return (Criteria) this;
        }

        public Criteria andExpenseIsNotNull() {
            addCriterion("expense is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseEqualTo(Long value) {
            addCriterion("expense =", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotEqualTo(Long value) {
            addCriterion("expense <>", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseGreaterThan(Long value) {
            addCriterion("expense >", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseGreaterThanOrEqualTo(Long value) {
            addCriterion("expense >=", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseLessThan(Long value) {
            addCriterion("expense <", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseLessThanOrEqualTo(Long value) {
            addCriterion("expense <=", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseIn(List<Long> values) {
            addCriterion("expense in", values, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotIn(List<Long> values) {
            addCriterion("expense not in", values, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseBetween(Long value1, Long value2) {
            addCriterion("expense between", value1, value2, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotBetween(Long value1, Long value2) {
            addCriterion("expense not between", value1, value2, "expense");
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