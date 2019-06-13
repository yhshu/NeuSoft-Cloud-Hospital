package com.neusoft.medical.bean;

public class DiseaseCategory {
    private Integer diseaseCategoryId;

    private String diseaseCode;

    private String diseaseName;

    private Integer sequenceNo;

    private Integer diseaseType;

    private Integer valid;

    public DiseaseCategory(Integer diseaseCategoryId, String diseaseCode, String diseaseName, Integer sequenceNo, Integer diseaseType, Integer valid) {
        this.diseaseCategoryId = diseaseCategoryId;
        this.diseaseCode = diseaseCode;
        this.diseaseName = diseaseName;
        this.sequenceNo = sequenceNo;
        this.diseaseType = diseaseType;
        this.valid = valid;
    }

    public DiseaseCategory() {
        super();
    }

    public Integer getDiseaseCategoryId() {
        return diseaseCategoryId;
    }

    public void setDiseaseCategoryId(Integer diseaseCategoryId) {
        this.diseaseCategoryId = diseaseCategoryId;
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

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Integer getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(Integer diseaseType) {
        this.diseaseType = diseaseType;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}