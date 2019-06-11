package com.neusoft.medical.bean;

import java.util.Date;

public class ChargeForm {
    private Integer chargeFormId;

    private Integer registrationId;

    private Integer chargeItemId;

    private Integer itemCount;

    private Integer unchargedNums;

    private Date madeTime;

    private Integer valid;

    private Integer departmentId;

    private Integer doctorId;

    private Integer collectorId;

    private Integer notGivenNums;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public ChargeForm(Integer chargeFormId, Integer registrationId, Integer chargeItemId, Integer itemCount, Integer unchargedNums, Date madeTime, Integer valid, Integer departmentId, Integer doctorId, Integer collectorId, Integer notGivenNums, String reserve1, String reserve2, String reserve3) {
        this.chargeFormId = chargeFormId;
        this.registrationId = registrationId;
        this.chargeItemId = chargeItemId;
        this.itemCount = itemCount;
        this.unchargedNums = unchargedNums;
        this.madeTime = madeTime;
        this.valid = valid;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.collectorId = collectorId;
        this.notGivenNums = notGivenNums;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public ChargeForm() {
        super();
    }

    public Integer getChargeFormId() {
        return chargeFormId;
    }

    public void setChargeFormId(Integer chargeFormId) {
        this.chargeFormId = chargeFormId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(Integer chargeItemId) {
        this.chargeItemId = chargeItemId;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getUnchargedNums() {
        return unchargedNums;
    }

    public void setUnchargedNums(Integer unchargedNums) {
        this.unchargedNums = unchargedNums;
    }

    public Date getMadeTime() {
        return madeTime;
    }

    public void setMadeTime(Date madeTime) {
        this.madeTime = madeTime;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
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

    public Integer getNotGivenNums() {
        return notGivenNums;
    }

    public void setNotGivenNums(Integer notGivenNums) {
        this.notGivenNums = notGivenNums;
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