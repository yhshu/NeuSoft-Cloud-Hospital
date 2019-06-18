package com.neusoft.medical.bean;

public class PrescriptionItem {
    private Integer prescriptionItemId;

    private Integer medicineId;

    private Integer prescriptionId;

    private String medicineUsage;

    private String medicineDosage;

    private String medicineFrequency;

    private String medicineNumberDay;

    private Integer medicineQuantity;

    private String skinTest;

    private String skinTestResult;

    private Integer saveState;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public PrescriptionItem(Integer prescriptionItemId, Integer medicineId, Integer prescriptionId, String medicineUsage, String medicineDosage, String medicineFrequency, String medicineNumberDay, Integer medicineQuantity, String skinTest, String skinTestResult, Integer saveState, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.prescriptionItemId = prescriptionItemId;
        this.medicineId = medicineId;
        this.prescriptionId = prescriptionId;
        this.medicineUsage = medicineUsage;
        this.medicineDosage = medicineDosage;
        this.medicineFrequency = medicineFrequency;
        this.medicineNumberDay = medicineNumberDay;
        this.medicineQuantity = medicineQuantity;
        this.skinTest = skinTest;
        this.skinTestResult = skinTestResult;
        this.saveState = saveState;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public PrescriptionItem() {
        super();
    }

    public Integer getPrescriptionItemId() {
        return prescriptionItemId;
    }

    public void setPrescriptionItemId(Integer prescriptionItemId) {
        this.prescriptionItemId = prescriptionItemId;
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

    public Integer getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(Integer medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
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

    public Integer getSaveState() {
        return saveState;
    }

    public void setSaveState(Integer saveState) {
        this.saveState = saveState;
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