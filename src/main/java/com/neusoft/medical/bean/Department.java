package com.neusoft.medical.bean;

import java.io.Serializable;

public class Department implements Serializable {
    private Integer departmentId;

    private String departmentCode;

    private String departmentName;

    private Integer category;

    private Integer type;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private static final long serialVersionUID = 1L;

    public Department(Integer departmentId, String departmentCode, String departmentName, Integer category, Integer type, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.departmentId = departmentId;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.category = category;
        this.type = type;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public Department() {
        super();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode == null ? null : departmentCode.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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