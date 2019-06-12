package com.neusoft.medical.bean;

public class MedicalRecords {
    private Integer medicalRecordsId;

    private Integer registrationId;

    private String mainInfo;

    private String currentDisease;

    private String currentTreatment;

    private String preliminaryWestern;

    private String preliminaryChinese;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public MedicalRecords(Integer medicalRecordsId, Integer registrationId, String mainInfo, String currentDisease, String currentTreatment, String preliminaryWestern, String preliminaryChinese, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.medicalRecordsId = medicalRecordsId;
        this.registrationId = registrationId;
        this.mainInfo = mainInfo;
        this.currentDisease = currentDisease;
        this.currentTreatment = currentTreatment;
        this.preliminaryWestern = preliminaryWestern;
        this.preliminaryChinese = preliminaryChinese;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public MedicalRecords() {
        super();
    }

    public Integer getMedicalRecordsId() {
        return medicalRecordsId;
    }

    public void setMedicalRecordsId(Integer medicalRecordsId) {
        this.medicalRecordsId = medicalRecordsId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public String getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(String mainInfo) {
        this.mainInfo = mainInfo == null ? null : mainInfo.trim();
    }

    public String getCurrentDisease() {
        return currentDisease;
    }

    public void setCurrentDisease(String currentDisease) {
        this.currentDisease = currentDisease == null ? null : currentDisease.trim();
    }

    public String getCurrentTreatment() {
        return currentTreatment;
    }

    public void setCurrentTreatment(String currentTreatment) {
        this.currentTreatment = currentTreatment == null ? null : currentTreatment.trim();
    }

    public String getPreliminaryWestern() {
        return preliminaryWestern;
    }

    public void setPreliminaryWestern(String preliminaryWestern) {
        this.preliminaryWestern = preliminaryWestern == null ? null : preliminaryWestern.trim();
    }

    public String getPreliminaryChinese() {
        return preliminaryChinese;
    }

    public void setPreliminaryChinese(String preliminaryChinese) {
        this.preliminaryChinese = preliminaryChinese == null ? null : preliminaryChinese.trim();
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