package com.neusoft.medical.bean;

public class PrescriptionEntry {
    private Integer prescriptionEntryId;

    private Integer medicineId;

    private Integer prescriptionId;

    private Double unitPrice;

    private Double totalPrice;

    private Integer nums;

    private String medicineUsage;

    private String medicineDosage;

    private String medicineFrequency;

    private String medicineNumberDay;

    private String skinTest;

    private String skinTestResult;

    private Integer payState;

    private String doctorAdvice;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public PrescriptionEntry(Integer prescriptionEntryId, Integer medicineId, Integer prescriptionId, Double unitPrice, Double totalPrice, Integer nums, String medicineUsage, String medicineDosage, String medicineFrequency, String medicineNumberDay, String skinTest, String skinTestResult, Integer payState, String doctorAdvice, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.prescriptionEntryId = prescriptionEntryId;
        this.medicineId = medicineId;
        this.prescriptionId = prescriptionId;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.nums = nums;
        this.medicineUsage = medicineUsage;
        this.medicineDosage = medicineDosage;
        this.medicineFrequency = medicineFrequency;
        this.medicineNumberDay = medicineNumberDay;
        this.skinTest = skinTest;
        this.skinTestResult = skinTestResult;
        this.payState = payState;
        this.doctorAdvice = doctorAdvice;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public PrescriptionEntry() {
        super();
    }

    public Integer getPrescriptionEntryId() {
        return prescriptionEntryId;
    }

    public void setPrescriptionEntryId(Integer prescriptionEntryId) {
        this.prescriptionEntryId = prescriptionEntryId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getMedicineUsage() {
        return medicineUsage;
    }

    public void setMedicineUsage(String medicineUsage) {
        this.medicineUsage = medicineUsage == null ? null : medicineUsage.trim();
    }

    public String getMedicineDosage() {
        return medicineDosage;
    }

    public void setMedicineDosage(String medicineDosage) {
        this.medicineDosage = medicineDosage == null ? null : medicineDosage.trim();
    }

    public String getMedicineFrequency() {
        return medicineFrequency;
    }

    public void setMedicineFrequency(String medicineFrequency) {
        this.medicineFrequency = medicineFrequency == null ? null : medicineFrequency.trim();
    }

    public String getMedicineNumberDay() {
        return medicineNumberDay;
    }

    public void setMedicineNumberDay(String medicineNumberDay) {
        this.medicineNumberDay = medicineNumberDay == null ? null : medicineNumberDay.trim();
    }

    public String getSkinTest() {
        return skinTest;
    }

    public void setSkinTest(String skinTest) {
        this.skinTest = skinTest == null ? null : skinTest.trim();
    }

    public String getSkinTestResult() {
        return skinTestResult;
    }

    public void setSkinTestResult(String skinTestResult) {
        this.skinTestResult = skinTestResult == null ? null : skinTestResult.trim();
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice == null ? null : doctorAdvice.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }
}