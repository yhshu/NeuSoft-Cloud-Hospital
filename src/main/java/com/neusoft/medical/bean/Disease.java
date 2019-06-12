package com.neusoft.medical.bean;

public class Disease {
    private Integer diseaseId;

    private String diseaseCode;

    private String diseaseName;

    private String diseaseIcd;

    private Integer diseaseCategory;

    private Integer valid;

    public Disease(Integer diseaseId, String diseaseCode, String diseaseName, String diseaseIcd, Integer diseaseCategory, Integer valid) {
        this.diseaseId = diseaseId;
        this.diseaseCode = diseaseCode;
        this.diseaseName = diseaseName;
        this.diseaseIcd = diseaseIcd;
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

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode == null ? null : diseaseCode.trim();
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName == null ? null : diseaseName.trim();
    }

    public String getDiseaseIcd() {
        return diseaseIcd;
    }

    public void setDiseaseIcd(String diseaseIcd) {
        this.diseaseIcd = diseaseIcd == null ? null : diseaseIcd.trim();
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