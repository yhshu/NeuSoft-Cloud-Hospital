package com.neusoft.medical.bean;

public class ConstantType {
    private Integer constantTypeId;

    private String constantTypeCode;

    private String constantTypeName;

    private Integer valid;

    public ConstantType(Integer constantTypeId, String constantTypeCode, String constantTypeName, Integer valid) {
        this.constantTypeId = constantTypeId;
        this.constantTypeCode = constantTypeCode;
        this.constantTypeName = constantTypeName;
        this.valid = valid;
    }

    public ConstantType() {
        super();
    }

    public Integer getConstantTypeId() {
        return constantTypeId;
    }

    public void setConstantTypeId(Integer constantTypeId) {
        this.constantTypeId = constantTypeId;
    }

    public String getConstantTypeCode() {
        return constantTypeCode;
    }

    public void setConstantTypeCode(String constantTypeCode) {
        this.constantTypeCode = constantTypeCode == null ? null : constantTypeCode.trim();
    }

    public String getConstantTypeName() {
        return constantTypeName;
    }

    public void setConstantTypeName(String constantTypeName) {
        this.constantTypeName = constantTypeName == null ? null : constantTypeName.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}