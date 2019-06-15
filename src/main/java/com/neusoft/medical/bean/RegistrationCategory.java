package com.neusoft.medical.bean;

public class RegistrationCategory {
    private Integer registrationCategoryId;

    private String registrationCategoryName;

    private Boolean isDefault;

    private Integer sequenceNo;

    private Double registrationFee;

    private Integer valid;

    public RegistrationCategory(Integer registrationCategoryId, String registrationCategoryName, Boolean isDefault, Integer sequenceNo, Double registrationFee, Integer valid) {
        this.registrationCategoryId = registrationCategoryId;
        this.registrationCategoryName = registrationCategoryName;
        this.isDefault = isDefault;
        this.sequenceNo = sequenceNo;
        this.registrationFee = registrationFee;
        this.valid = valid;
    }

    public RegistrationCategory() {
        super();
    }

    public Integer getRegistrationCategoryId() {
        return registrationCategoryId;
    }

    public void setRegistrationCategoryId(Integer registrationCategoryId) {
        this.registrationCategoryId = registrationCategoryId;
    }

    public String getRegistrationCategoryName() {
        return registrationCategoryName;
    }

    public void setRegistrationCategoryName(String registrationCategoryName) {
        this.registrationCategoryName = registrationCategoryName == null ? null : registrationCategoryName.trim();
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}