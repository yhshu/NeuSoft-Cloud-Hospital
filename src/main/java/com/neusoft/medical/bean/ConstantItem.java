package com.neusoft.medical.bean;

import java.io.Serializable;

public class ConstantItem implements Serializable {
    private Integer constantItemId;

    private Integer constantTypeId;

    private String constantCode;

    private String constantName;

    private Integer valid;

    private static final long serialVersionUID = 1L;

    public ConstantItem(Integer constantItemId, Integer constantTypeId, String constantCode, String constantName, Integer valid) {
        this.constantItemId = constantItemId;
        this.constantTypeId = constantTypeId;
        this.constantCode = constantCode;
        this.constantName = constantName;
        this.valid = valid;
    }

    public ConstantItem() {
        super();
    }

    public Integer getConstantItemId() {
        return constantItemId;
    }

    public void setConstantItemId(Integer constantItemId) {
        this.constantItemId = constantItemId;
    }

    public Integer getConstantTypeId() {
        return constantTypeId;
    }

    public void setConstantTypeId(Integer constantTypeId) {
        this.constantTypeId = constantTypeId;
    }

    public String getConstantCode() {
        return constantCode;
    }

    public void setConstantCode(String constantCode) {
        this.constantCode = constantCode == null ? null : constantCode.trim();
    }

    public String getConstantName() {
        return constantName;
    }

    public void setConstantName(String constantName) {
        this.constantName = constantName == null ? null : constantName.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}