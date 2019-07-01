package com.neusoft.medical.bean;

import java.io.Serializable;

public class Disease implements Serializable {
    private Integer diseaseId;

    private String diseaseIcd;

    private String diseaseName;

    private String diseaseCode;

    private Integer diseaseCategory;

    private Integer valid;

    private static final long serialVersionUID = 1L;

    public Disease(Integer diseaseId, String diseaseIcd, String diseaseName, String diseaseCode, Integer diseaseCategory, Integer valid) {
        this.diseaseId = diseaseId;
        this.diseaseIcd = diseaseIcd;
        this.diseaseName = diseaseName;
        this.diseaseCode = diseaseCode;
        this.diseaseCategory = diseaseCategory;
        this.valid = valid;
    }

    public Disease() {
        super();
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

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode == null ? null : diseaseCode.trim();
    }

    public Integer getDiseaseCategory() {
        return diseaseCategory;
    }

    public void setDiseaseCategory(Integer diseaseCategory) {
        this.diseaseCategory = diseaseCategory;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}