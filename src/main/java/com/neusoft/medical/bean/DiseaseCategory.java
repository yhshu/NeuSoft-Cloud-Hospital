package com.neusoft.medical.bean;

public class DiseaseCategory {
    private Integer diseaseId;

    private String diseaseCode;

    private String diseaseName;

    private Integer sequenceNo;

    private Integer diseaseType;

    private Integer valid;

    public DiseaseCategory(Integer diseaseId, String diseaseCode, String diseaseName, Integer sequenceNo, Integer diseaseType, Integer valid) {
        this.diseaseId = diseaseId;
        this.diseaseCode = diseaseCode;
        this.diseaseName = diseaseName;
        this.sequenceNo = sequenceNo;
        this.diseaseType = diseaseType;
        this.valid = valid;
    }

    public DiseaseCategory() {
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