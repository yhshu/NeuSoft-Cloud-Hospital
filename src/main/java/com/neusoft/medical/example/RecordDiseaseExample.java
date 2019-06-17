package com.neusoft.medical.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RecordDiseaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordDiseaseExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRecordDiseaseIdIsNull() {
            addCriterion("record_disease_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordDiseaseIdIsNotNull() {
            addCriterion("record_disease_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordDiseaseIdEqualTo(Integer value) {
            addCriterion("record_disease_id =", value, "recordDiseaseId");
            return (Criteria) this;
        }

        public Criteria andRecordDiseaseIdNotEqualTo(Integer value) {
            addCriterion("record_disease_id <>", value, "recordDiseaseId");
            return (Criteria) this;
        }

        public Criteria andRecordDiseaseIdGreaterThan(Integer value) {
            addCriterion("record_disease_id >", value, "recordDiseaseId");
            return (Criteria) this;
        }

        public Criteria andRecordDiseaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_disease_id >=", value, "recordDiseaseId");
            return (Criteria) this;
        }

        public Criteria andRecordDiseaseIdLessThan(Integer value) {
            addCriterion("record_disease_id <", value, "recordDiseaseId");
            return (Criteria) this;
        }

        public Criteria andRecordDiseaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("record_disease_id <=", value, "recordDiseaseId");
            return (Criteria) this;
        }

        public Criteria andRecordDiseaseIdIn(List<Integer> values) {
            addCriterion("record_disease_id in", values, "recordDiseaseId");
            return (Criteria) this;
        }

        public Criteria andRecordDiseaseIdNotIn(List<Integer> values) {
            addCriterion("record_disease_id not in", values, "recordDiseaseId");
            return (Criteria) this;
        }

        public Criteria andRecordDiseaseIdBetween(Integer value1, Integer value2) {
            addCriterion("record_disease_id between", value1, value2, "recordDiseaseId");
            return (Criteria) this;
        }

        public Criteria andRecordDiseaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("record_disease_id not between", value1, value2, "recordDiseaseId");
            return (Criteria) this;
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

        public Criteria andDiseaseIdIsNull() {
            addCriterion("disease_id is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNotNull() {
            addCriterion("disease_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdEqualTo(Integer value) {
            addCriterion("disease_id =", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotEqualTo(Integer value) {
            addCriterion("disease_id <>", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThan(Integer value) {
            addCriterion("disease_id >", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("disease_id >=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThan(Integer value) {
            addCriterion("disease_id <", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("disease_id <=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIn(List<Integer> values) {
            addCriterion("disease_id in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotIn(List<Integer> values) {
            addCriterion("disease_id not in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdBetween(Integer value1, Integer value2) {
            addCriterion("disease_id between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("disease_id not between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdIsNull() {
            addCriterion("disease_ICD is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdIsNotNull() {
            addCriterion("disease_ICD is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdEqualTo(String value) {
            addCriterion("disease_ICD =", value, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdNotEqualTo(String value) {
            addCriterion("disease_ICD <>", value, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdGreaterThan(String value) {
            addCriterion("disease_ICD >", value, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdGreaterThanOrEqualTo(String value) {
            addCriterion("disease_ICD >=", value, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdLessThan(String value) {
            addCriterion("disease_ICD <", value, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdLessThanOrEqualTo(String value) {
            addCriterion("disease_ICD <=", value, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdLike(String value) {
            addCriterion("disease_ICD like", value, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdNotLike(String value) {
            addCriterion("disease_ICD not like", value, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdIn(List<String> values) {
            addCriterion("disease_ICD in", values, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdNotIn(List<String> values) {
            addCriterion("disease_ICD not in", values, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdBetween(String value1, String value2) {
            addCriterion("disease_ICD between", value1, value2, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseIcdNotBetween(String value1, String value2) {
            addCriterion("disease_ICD not between", value1, value2, "diseaseIcd");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameIsNull() {
            addCriterion("disease_name is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameIsNotNull() {
            addCriterion("disease_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameEqualTo(String value) {
            addCriterion("disease_name =", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameNotEqualTo(String value) {
            addCriterion("disease_name <>", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameGreaterThan(String value) {
            addCriterion("disease_name >", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("disease_name >=", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameLessThan(String value) {
            addCriterion("disease_name <", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameLessThanOrEqualTo(String value) {
            addCriterion("disease_name <=", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameLike(String value) {
            addCriterion("disease_name like", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameNotLike(String value) {
            addCriterion("disease_name not like", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameIn(List<String> values) {
            addCriterion("disease_name in", values, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameNotIn(List<String> values) {
            addCriterion("disease_name not in", values, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameBetween(String value1, String value2) {
            addCriterion("disease_name between", value1, value2, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameNotBetween(String value1, String value2) {
            addCriterion("disease_name not between", value1, value2, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseIsNull() {
            addCriterion("main_disease is null");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseIsNotNull() {
            addCriterion("main_disease is not null");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseEqualTo(Integer value) {
            addCriterion("main_disease =", value, "mainDisease");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseNotEqualTo(Integer value) {
            addCriterion("main_disease <>", value, "mainDisease");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseGreaterThan(Integer value) {
            addCriterion("main_disease >", value, "mainDisease");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("main_disease >=", value, "mainDisease");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseLessThan(Integer value) {
            addCriterion("main_disease <", value, "mainDisease");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseLessThanOrEqualTo(Integer value) {
            addCriterion("main_disease <=", value, "mainDisease");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseIn(List<Integer> values) {
            addCriterion("main_disease in", values, "mainDisease");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseNotIn(List<Integer> values) {
            addCriterion("main_disease not in", values, "mainDisease");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseBetween(Integer value1, Integer value2) {
            addCriterion("main_disease between", value1, value2, "mainDisease");
            return (Criteria) this;
        }

        public Criteria andMainDiseaseNotBetween(Integer value1, Integer value2) {
            addCriterion("main_disease not between", value1, value2, "mainDisease");
            return (Criteria) this;
        }

        public Criteria andSuspectIsNull() {
            addCriterion("suspect is null");
            return (Criteria) this;
        }

        public Criteria andSuspectIsNotNull() {
            addCriterion("suspect is not null");
            return (Criteria) this;
        }

        public Criteria andSuspectEqualTo(Integer value) {
            addCriterion("suspect =", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectNotEqualTo(Integer value) {
            addCriterion("suspect <>", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectGreaterThan(Integer value) {
            addCriterion("suspect >", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectGreaterThanOrEqualTo(Integer value) {
            addCriterion("suspect >=", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectLessThan(Integer value) {
            addCriterion("suspect <", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectLessThanOrEqualTo(Integer value) {
            addCriterion("suspect <=", value, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectIn(List<Integer> values) {
            addCriterion("suspect in", values, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectNotIn(List<Integer> values) {
            addCriterion("suspect not in", values, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectBetween(Integer value1, Integer value2) {
            addCriterion("suspect between", value1, value2, "suspect");
            return (Criteria) this;
        }

        public Criteria andSuspectNotBetween(Integer value1, Integer value2) {
            addCriterion("suspect not between", value1, value2, "suspect");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateIsNull() {
            addCriterion("incidence_date is null");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateIsNotNull() {
            addCriterion("incidence_date is not null");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateEqualTo(Date value) {
            addCriterionForJDBCDate("incidence_date =", value, "incidenceDate");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("incidence_date <>", value, "incidenceDate");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("incidence_date >", value, "incidenceDate");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("incidence_date >=", value, "incidenceDate");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateLessThan(Date value) {
            addCriterionForJDBCDate("incidence_date <", value, "incidenceDate");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("incidence_date <=", value, "incidenceDate");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateIn(List<Date> values) {
            addCriterionForJDBCDate("incidence_date in", values, "incidenceDate");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("incidence_date not in", values, "incidenceDate");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("incidence_date between", value1, value2, "incidenceDate");
            return (Criteria) this;
        }

        public Criteria andIncidenceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("incidence_date not between", value1, value2, "incidenceDate");
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