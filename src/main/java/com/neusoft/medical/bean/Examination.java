package com.neusoft.medical.bean;

public class Examination {
    private Integer examinationId;

    private String patientName;

    private Integer registrationId;

    private Integer chargeItemId;

    private String result;

    private Integer doctorId;

    private Integer departmentId;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private Integer valid;

    public Examination(Integer examinationId, String patientName, Integer registrationId, Integer chargeItemId, String result, Integer doctorId, Integer departmentId, String reserve1, String reserve2, String reserve3, Integer valid) {
        this.examinationId = examinationId;
        this.patientName = patientName;
        this.registrationId = registrationId;
        this.chargeItemId = chargeItemId;
        this.result = result;
        this.doctorId = doctorId;
        this.departmentId = departmentId;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
        this.valid = valid;
    }

    public Examination() {
        super();
    }

    public Integer getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(Integer examinationId) {
        this.examinationId = examinationId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}