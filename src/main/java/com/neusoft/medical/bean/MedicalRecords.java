package com.neusoft.medical.bean;

public class MedicalRecords {
    private Integer medicalRecordsId;

    private Integer registrationId;

    private String mainInfo;

    private String currentDisease;

    private String pastDisease;

    private String physicalExam;

    private String auxiliaryExam;

    private String preliminaryWestern;

    private String preliminaryChinese;

    private String opinion;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public MedicalRecords(Integer medicalRecordsId, Integer registrationId, String mainInfo, String currentDisease, String pastDisease, String physicalExam, String auxiliaryExam, String preliminaryWestern, String preliminaryChinese, String opinion, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.medicalRecordsId = medicalRecordsId;
        this.registrationId = registrationId;
        this.mainInfo = mainInfo;
        this.currentDisease = currentDisease;
        this.pastDisease = pastDisease;
        this.physicalExam = physicalExam;
        this.auxiliaryExam = auxiliaryExam;
        this.preliminaryWestern = preliminaryWestern;
        this.preliminaryChinese = preliminaryChinese;
        this.opinion = opinion;
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

    public String getPastDisease() {
        return pastDisease;
    }

    public void setPastDisease(String pastDisease) {
        this.pastDisease = pastDisease == null ? null : pastDisease.trim();
    }

    public String getPhysicalExam() {
        return physicalExam;
    }

    public void setPhysicalExam(String physicalExam) {
        this.physicalExam = physicalExam == null ? null : physicalExam.trim();
    }

    public String getAuxiliaryExam() {
        return auxiliaryExam;
    }

    public void setAuxiliaryExam(String auxiliaryExam) {
        this.auxiliaryExam = auxiliaryExam == null ? null : auxiliaryExam.trim();
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

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
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