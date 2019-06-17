package com.neusoft.medical.bean;

import java.util.Date;

public class RecordDisease {
    private Integer recordDiseaseId;

    private Integer medicalRecordsId;

    private Integer diseaseId;

    private String diseaseIcd;

    private String diseaseName;

    private Integer mainDisease;

    private Integer suspect;

    private Date incidenceDate;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public RecordDisease(Integer recordDiseaseId, Integer medicalRecordsId, Integer diseaseId, String diseaseIcd, String diseaseName, Integer mainDisease, Integer suspect, Date incidenceDate, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.recordDiseaseId = recordDiseaseId;
        this.medicalRecordsId = medicalRecordsId;
        this.diseaseId = diseaseId;
        this.diseaseIcd = diseaseIcd;
        this.diseaseName = diseaseName;
        this.mainDisease = mainDisease;
        this.suspect = suspect;
        this.incidenceDate = incidenceDate;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public RecordDisease() {
        super();
    }

    public Integer getRecordDiseaseId() {
        return recordDiseaseId;
    }

    public void setRecordDiseaseId(Integer recordDiseaseId) {
        this.recordDiseaseId = recordDiseaseId;
    }

    public Integer getMedicalRecordsId() {
        return medicalRecordsId;
    }

    public void setMedicalRecordsId(Integer medicalRecordsId) {
        this.medicalRecordsId = medicalRecordsId;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseaseIcd() {
        return diseaseIcd;
    }

    public void setDiseaseIcd(String diseaseIcd) {
        this.diseaseIcd = diseaseIcd == null ? null : diseaseIcd.trim();
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName == null ? null : diseaseName.trim();
    }

    public Integer getMainDisease() {
        return mainDisease;
    }

    public void setMainDisease(Integer mainDisease) {
        this.mainDisease = mainDisease;
    }

    public Integer getSuspect() {
        return suspect;
    }

    public void setSuspect(Integer suspect) {
        this.suspect = suspect;
    }

    public Date getIncidenceDate() {
        return incidenceDate;
    }

    public void setIncidenceDate(Date incidenceDate) {
        this.incidenceDate = incidenceDate;
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