package com.neusoft.medical.bean;

public class Examination {
    private Integer examinationId;

    private Integer registrationId;

    private String patientName;

    private Integer chargeEntryId;

    private Integer doctorId;

    private Integer departmentId;

    private Integer saveState;

    private String examName;

    private String clinicalImpression;

    private String requirement;

    private String examResult;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public Examination(Integer examinationId, Integer registrationId, String patientName, Integer chargeEntryId, Integer doctorId, Integer departmentId, Integer saveState, String examName, String clinicalImpression, String requirement, String examResult, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.examinationId = examinationId;
        this.registrationId = registrationId;
        this.patientName = patientName;
        this.chargeEntryId = chargeEntryId;
        this.doctorId = doctorId;
        this.departmentId = departmentId;
        this.saveState = saveState;
        this.examName = examName;
        this.clinicalImpression = clinicalImpression;
        this.requirement = requirement;
        this.examResult = examResult;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
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

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public Integer getChargeEntryId() {
        return chargeEntryId;
    }

    public void setChargeEntryId(Integer chargeEntryId) {
        this.chargeEntryId = chargeEntryId;
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

    public Integer getSaveState() {
        return saveState;
    }

    public void setSaveState(Integer saveState) {
        this.saveState = saveState;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName == null ? null : examName.trim();
    }

    public String getClinicalImpression() {
        return clinicalImpression;
    }

    public void setClinicalImpression(String clinicalImpression) {
        this.clinicalImpression = clinicalImpression == null ? null : clinicalImpression.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public String getExamResult() {
        return examResult;
    }

    public void setExamResult(String examResult) {
        this.examResult = examResult == null ? null : examResult.trim();
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