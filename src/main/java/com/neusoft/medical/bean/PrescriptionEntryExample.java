package com.neusoft.medical.bean;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionEntryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrescriptionEntryExample() {
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

        public Criteria andPrescriptionEntryIdIsNull() {
            addCriterion("prescription_entry_id is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEntryIdIsNotNull() {
            addCriterion("prescription_entry_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEntryIdEqualTo(Integer value) {
            addCriterion("prescription_entry_id =", value, "prescriptionEntryId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEntryIdNotEqualTo(Integer value) {
            addCriterion("prescription_entry_id <>", value, "prescriptionEntryId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEntryIdGreaterThan(Integer value) {
            addCriterion("prescription_entry_id >", value, "prescriptionEntryId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEntryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prescription_entry_id >=", value, "prescriptionEntryId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEntryIdLessThan(Integer value) {
            addCriterion("prescription_entry_id <", value, "prescriptionEntryId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEntryIdLessThanOrEqualTo(Integer value) {
            addCriterion("prescription_entry_id <=", value, "prescriptionEntryId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEntryIdIn(List<Integer> values) {
            addCriterion("prescription_entry_id in", values, "prescriptionEntryId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEntryIdNotIn(List<Integer> values) {
            addCriterion("prescription_entry_id not in", values, "prescriptionEntryId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEntryIdBetween(Integer value1, Integer value2) {
            addCriterion("prescription_entry_id between", value1, value2, "prescriptionEntryId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionEntryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prescription_entry_id not between", value1, value2, "prescriptionEntryId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdIsNull() {
            addCriterion("medicine_id is null");
            return (Criteria) this;
        }

        public Criteria andMedicineIdIsNotNull() {
            addCriterion("medicine_id is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineIdEqualTo(Integer value) {
            addCriterion("medicine_id =", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotEqualTo(Integer value) {
            addCriterion("medicine_id <>", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdGreaterThan(Integer value) {
            addCriterion("medicine_id >", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("medicine_id >=", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdLessThan(Integer value) {
            addCriterion("medicine_id <", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdLessThanOrEqualTo(Integer value) {
            addCriterion("medicine_id <=", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdIn(List<Integer> values) {
            addCriterion("medicine_id in", values, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotIn(List<Integer> values) {
            addCriterion("medicine_id not in", values, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdBetween(Integer value1, Integer value2) {
            addCriterion("medicine_id between", value1, value2, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotBetween(Integer value1, Integer value2) {
            addCriterion("medicine_id not between", value1, value2, "medicineId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIsNull() {
            addCriterion("prescription_id is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIsNotNull() {
            addCriterion("prescription_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdEqualTo(Integer value) {
            addCriterion("prescription_id =", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotEqualTo(Integer value) {
            addCriterion("prescription_id <>", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdGreaterThan(Integer value) {
            addCriterion("prescription_id >", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prescription_id >=", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdLessThan(Integer value) {
            addCriterion("prescription_id <", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdLessThanOrEqualTo(Integer value) {
            addCriterion("prescription_id <=", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIn(List<Integer> values) {
            addCriterion("prescription_id in", values, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotIn(List<Integer> values) {
            addCriterion("prescription_id not in", values, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdBetween(Integer value1, Integer value2) {
            addCriterion("prescription_id between", value1, value2, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prescription_id not between", value1, value2, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(Double value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(Double value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(Double value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(Double value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(Double value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<Double> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<Double> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(Double value1, Double value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(Double value1, Double value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Double value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Double value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Double value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Double value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Double value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Double> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Double> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Double value1, Double value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Double value1, Double value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andNumsIsNull() {
            addCriterion("nums is null");
            return (Criteria) this;
        }

        public Criteria andNumsIsNotNull() {
            addCriterion("nums is not null");
            return (Criteria) this;
        }

        public Criteria andNumsEqualTo(Integer value) {
            addCriterion("nums =", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotEqualTo(Integer value) {
            addCriterion("nums <>", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsGreaterThan(Integer value) {
            addCriterion("nums >", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("nums >=", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsLessThan(Integer value) {
            addCriterion("nums <", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsLessThanOrEqualTo(Integer value) {
            addCriterion("nums <=", value, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsIn(List<Integer> values) {
            addCriterion("nums in", values, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotIn(List<Integer> values) {
            addCriterion("nums not in", values, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsBetween(Integer value1, Integer value2) {
            addCriterion("nums between", value1, value2, "nums");
            return (Criteria) this;
        }

        public Criteria andNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("nums not between", value1, value2, "nums");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsIsNull() {
            addCriterion("not_given_nums is null");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsIsNotNull() {
            addCriterion("not_given_nums is not null");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsEqualTo(Integer value) {
            addCriterion("not_given_nums =", value, "notGivenNums");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsNotEqualTo(Integer value) {
            addCriterion("not_given_nums <>", value, "notGivenNums");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsGreaterThan(Integer value) {
            addCriterion("not_given_nums >", value, "notGivenNums");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("not_given_nums >=", value, "notGivenNums");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsLessThan(Integer value) {
            addCriterion("not_given_nums <", value, "notGivenNums");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsLessThanOrEqualTo(Integer value) {
            addCriterion("not_given_nums <=", value, "notGivenNums");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsIn(List<Integer> values) {
            addCriterion("not_given_nums in", values, "notGivenNums");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsNotIn(List<Integer> values) {
            addCriterion("not_given_nums not in", values, "notGivenNums");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsBetween(Integer value1, Integer value2) {
            addCriterion("not_given_nums between", value1, value2, "notGivenNums");
            return (Criteria) this;
        }

        public Criteria andNotGivenNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("not_given_nums not between", value1, value2, "notGivenNums");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageIsNull() {
            addCriterion("medicine_usage is null");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageIsNotNull() {
            addCriterion("medicine_usage is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageEqualTo(String value) {
            addCriterion("medicine_usage =", value, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageNotEqualTo(String value) {
            addCriterion("medicine_usage <>", value, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageGreaterThan(String value) {
            addCriterion("medicine_usage >", value, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_usage >=", value, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageLessThan(String value) {
            addCriterion("medicine_usage <", value, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageLessThanOrEqualTo(String value) {
            addCriterion("medicine_usage <=", value, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageLike(String value) {
            addCriterion("medicine_usage like", value, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageNotLike(String value) {
            addCriterion("medicine_usage not like", value, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageIn(List<String> values) {
            addCriterion("medicine_usage in", values, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageNotIn(List<String> values) {
            addCriterion("medicine_usage not in", values, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageBetween(String value1, String value2) {
            addCriterion("medicine_usage between", value1, value2, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineUsageNotBetween(String value1, String value2) {
            addCriterion("medicine_usage not between", value1, value2, "medicineUsage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageIsNull() {
            addCriterion("medicine_dosage is null");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageIsNotNull() {
            addCriterion("medicine_dosage is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageEqualTo(String value) {
            addCriterion("medicine_dosage =", value, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageNotEqualTo(String value) {
            addCriterion("medicine_dosage <>", value, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageGreaterThan(String value) {
            addCriterion("medicine_dosage >", value, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_dosage >=", value, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageLessThan(String value) {
            addCriterion("medicine_dosage <", value, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageLessThanOrEqualTo(String value) {
            addCriterion("medicine_dosage <=", value, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageLike(String value) {
            addCriterion("medicine_dosage like", value, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageNotLike(String value) {
            addCriterion("medicine_dosage not like", value, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageIn(List<String> values) {
            addCriterion("medicine_dosage in", values, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageNotIn(List<String> values) {
            addCriterion("medicine_dosage not in", values, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageBetween(String value1, String value2) {
            addCriterion("medicine_dosage between", value1, value2, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineDosageNotBetween(String value1, String value2) {
            addCriterion("medicine_dosage not between", value1, value2, "medicineDosage");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyIsNull() {
            addCriterion("medicine_frequency is null");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyIsNotNull() {
            addCriterion("medicine_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyEqualTo(String value) {
            addCriterion("medicine_frequency =", value, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyNotEqualTo(String value) {
            addCriterion("medicine_frequency <>", value, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyGreaterThan(String value) {
            addCriterion("medicine_frequency >", value, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_frequency >=", value, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyLessThan(String value) {
            addCriterion("medicine_frequency <", value, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyLessThanOrEqualTo(String value) {
            addCriterion("medicine_frequency <=", value, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyLike(String value) {
            addCriterion("medicine_frequency like", value, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyNotLike(String value) {
            addCriterion("medicine_frequency not like", value, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyIn(List<String> values) {
            addCriterion("medicine_frequency in", values, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyNotIn(List<String> values) {
            addCriterion("medicine_frequency not in", values, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyBetween(String value1, String value2) {
            addCriterion("medicine_frequency between", value1, value2, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineFrequencyNotBetween(String value1, String value2) {
            addCriterion("medicine_frequency not between", value1, value2, "medicineFrequency");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayIsNull() {
            addCriterion("medicine_number_day is null");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayIsNotNull() {
            addCriterion("medicine_number_day is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayEqualTo(String value) {
            addCriterion("medicine_number_day =", value, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayNotEqualTo(String value) {
            addCriterion("medicine_number_day <>", value, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayGreaterThan(String value) {
            addCriterion("medicine_number_day >", value, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_number_day >=", value, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayLessThan(String value) {
            addCriterion("medicine_number_day <", value, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayLessThanOrEqualTo(String value) {
            addCriterion("medicine_number_day <=", value, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayLike(String value) {
            addCriterion("medicine_number_day like", value, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayNotLike(String value) {
            addCriterion("medicine_number_day not like", value, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayIn(List<String> values) {
            addCriterion("medicine_number_day in", values, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayNotIn(List<String> values) {
            addCriterion("medicine_number_day not in", values, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayBetween(String value1, String value2) {
            addCriterion("medicine_number_day between", value1, value2, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andMedicineNumberDayNotBetween(String value1, String value2) {
            addCriterion("medicine_number_day not between", value1, value2, "medicineNumberDay");
            return (Criteria) this;
        }

        public Criteria andSkinTestIsNull() {
            addCriterion("skin_test is null");
            return (Criteria) this;
        }

        public Criteria andSkinTestIsNotNull() {
            addCriterion("skin_test is not null");
            return (Criteria) this;
        }

        public Criteria andSkinTestEqualTo(String value) {
            addCriterion("skin_test =", value, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestNotEqualTo(String value) {
            addCriterion("skin_test <>", value, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestGreaterThan(String value) {
            addCriterion("skin_test >", value, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestGreaterThanOrEqualTo(String value) {
            addCriterion("skin_test >=", value, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestLessThan(String value) {
            addCriterion("skin_test <", value, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestLessThanOrEqualTo(String value) {
            addCriterion("skin_test <=", value, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestLike(String value) {
            addCriterion("skin_test like", value, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestNotLike(String value) {
            addCriterion("skin_test not like", value, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestIn(List<String> values) {
            addCriterion("skin_test in", values, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestNotIn(List<String> values) {
            addCriterion("skin_test not in", values, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestBetween(String value1, String value2) {
            addCriterion("skin_test between", value1, value2, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestNotBetween(String value1, String value2) {
            addCriterion("skin_test not between", value1, value2, "skinTest");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultIsNull() {
            addCriterion("skin_test_result is null");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultIsNotNull() {
            addCriterion("skin_test_result is not null");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultEqualTo(String value) {
            addCriterion("skin_test_result =", value, "skinTestResult");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultNotEqualTo(String value) {
            addCriterion("skin_test_result <>", value, "skinTestResult");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultGreaterThan(String value) {
            addCriterion("skin_test_result >", value, "skinTestResult");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultGreaterThanOrEqualTo(String value) {
            addCriterion("skin_test_result >=", value, "skinTestResult");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultLessThan(String value) {
            addCriterion("skin_test_result <", value, "skinTestResult");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultLessThanOrEqualTo(String value) {
            addCriterion("skin_test_result <=", value, "skinTestResult");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultLike(String value) {
            addCriterion("skin_test_result like", value, "skinTestResult");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultNotLike(String value) {
            addCriterion("skin_test_result not like", value, "skinTestResult");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultIn(List<String> values) {
            addCriterion("skin_test_result in", values, "skinTestResult");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultNotIn(List<String> values) {
            addCriterion("skin_test_result not in", values, "skinTestResult");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultBetween(String value1, String value2) {
            addCriterion("skin_test_result between", value1, value2, "skinTestResult");
            return (Criteria) this;
        }

        public Criteria andSkinTestResultNotBetween(String value1, String value2) {
            addCriterion("skin_test_result not between", value1, value2, "skinTestResult");
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

        public Criteria andDoctorAdviceIsNull() {
            addCriterion("doctor_advice is null");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceIsNotNull() {
            addCriterion("doctor_advice is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceEqualTo(String value) {
            addCriterion("doctor_advice =", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceNotEqualTo(String value) {
            addCriterion("doctor_advice <>", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceGreaterThan(String value) {
            addCriterion("doctor_advice >", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_advice >=", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceLessThan(String value) {
            addCriterion("doctor_advice <", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceLessThanOrEqualTo(String value) {
            addCriterion("doctor_advice <=", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceLike(String value) {
            addCriterion("doctor_advice like", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceNotLike(String value) {
            addCriterion("doctor_advice not like", value, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceIn(List<String> values) {
            addCriterion("doctor_advice in", values, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceNotIn(List<String> values) {
            addCriterion("doctor_advice not in", values, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceBetween(String value1, String value2) {
            addCriterion("doctor_advice between", value1, value2, "doctorAdvice");
            return (Criteria) this;
        }

        public Criteria andDoctorAdviceNotBetween(String value1, String value2) {
            addCriterion("doctor_advice not between", value1, value2, "doctorAdvice");
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