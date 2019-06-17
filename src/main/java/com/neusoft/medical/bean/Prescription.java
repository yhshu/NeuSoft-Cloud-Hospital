package com.neusoft.medical.bean;

public class Prescription {
    private Integer prescriptionId;

    private Integer registrationId;

    private String registrationName;

    private Integer doctorId;

    private String content;

    private Integer saveState;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public Prescription(Integer prescriptionId, Integer registrationId, String registrationName, Integer doctorId, String content, Integer saveState, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.prescriptionId = prescriptionId;
        this.registrationId = registrationId;
        this.registrationName = registrationName;
        this.doctorId = doctorId;
        this.content = content;
        this.saveState = saveState;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public Prescription() {
        super();
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName == null ? null : registrationName.trim();
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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