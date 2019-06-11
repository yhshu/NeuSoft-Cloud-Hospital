package com.neusoft.medical.bean;

public class Doctor {
    private Integer doctorId;

    private String doctorName;

    private Integer department;

    private Integer type;

    private String jobTitle;

    private Integer accountId;

    private Integer valid;

    private Integer doctorScheduling;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public Doctor(Integer doctorId, String doctorName, Integer department, Integer type, String jobTitle, Integer accountId, Integer valid, Integer doctorScheduling, String reserve1, String reserve2, String reserve3) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.department = department;
        this.type = type;
        this.jobTitle = jobTitle;
        this.accountId = accountId;
        this.valid = valid;
        this.doctorScheduling = doctorScheduling;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public Doctor() {
        super();
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getDoctorScheduling() {
        return doctorScheduling;
    }

    public void setDoctorScheduling(Integer doctorScheduling) {
        this.doctorScheduling = doctorScheduling;
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