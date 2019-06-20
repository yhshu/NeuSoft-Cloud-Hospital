package com.neusoft.medical.bean;

import java.util.Date;

public class ChargeEntry {
    private Integer chargeEntryId;

    private Integer registrationId;

    private Integer chargeFormId;

    private Integer chargeItemId;

    private Integer examinationId;

    private Double unitPrice;

    private Double totalPrice;

    private Integer nums;

    private Integer unchargedNums;

    private Integer notGivenNums;

    private Integer payState;

    private Date madeTime;

    private Integer departmentId;

    private Integer doctorId;

    private Integer collectorId;

    private Integer valid;

    private String doctorAdvice;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public ChargeEntry(Integer chargeEntryId, Integer registrationId, Integer chargeFormId, Integer chargeItemId, Integer examinationId, Double unitPrice, Double totalPrice, Integer nums, Integer unchargedNums, Integer notGivenNums, Integer payState, Date madeTime, Integer departmentId, Integer doctorId, Integer collectorId, Integer valid, String doctorAdvice, String reserve1, String reserve2, String reserve3) {
        this.chargeEntryId = chargeEntryId;
        this.registrationId = registrationId;
        this.chargeFormId = chargeFormId;
        this.chargeItemId = chargeItemId;
        this.examinationId = examinationId;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.nums = nums;
        this.unchargedNums = unchargedNums;
        this.notGivenNums = notGivenNums;
        this.payState = payState;
        this.madeTime = madeTime;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.collectorId = collectorId;
        this.valid = valid;
        this.doctorAdvice = doctorAdvice;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public ChargeEntry() {
        super();
    }

    public Integer getChargeEntryId() {
        return chargeEntryId;
    }

    public void setChargeEntryId(Integer chargeEntryId) {
        this.chargeEntryId = chargeEntryId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getChargeFormId() {
        return chargeFormId;
    }

    public void setChargeFormId(Integer chargeFormId) {
        this.chargeFormId = chargeFormId;
    }

    public Integer getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(Integer chargeItemId) {
        this.chargeItemId = chargeItemId;
    }

    public Integer getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(Integer examinationId) {
        this.examinationId = examinationId;
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

    public Integer getUnchargedNums() {
        return unchargedNums;
    }

    public void setUnchargedNums(Integer unchargedNums) {
        this.unchargedNums = unchargedNums;
    }

    public Integer getNotGivenNums() {
        return notGivenNums;
    }

    public void setNotGivenNums(Integer notGivenNums) {
        this.notGivenNums = notGivenNums;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Date getMadeTime() {
        return madeTime;
    }

    public void setMadeTime(Date madeTime) {
        this.madeTime = madeTime;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(Integer collectorId) {
        this.collectorId = collectorId;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice == null ? null : doctorAdvice.trim();
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