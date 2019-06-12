package com.neusoft.medical.bean;

import java.util.Date;

public class SchedulingInfo {
    private Integer schedulingInfoId;

    private Date schedulingTime;

    private Integer departmentId;

    private String departmentName;

    private Integer doctorId;

    private String doctorName;

    private String type;

    private Integer valid;

    private String period;

    private Integer limitation;

    private Integer remainNums;

    public SchedulingInfo(Integer schedulingInfoId, Date schedulingTime, Integer departmentId, String departmentName, Integer doctorId, String doctorName, String type, Integer valid, String period, Integer limitation, Integer remainNums) {
        this.schedulingInfoId = schedulingInfoId;
        this.schedulingTime = schedulingTime;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.type = type;
        this.valid = valid;
        this.period = period;
        this.limitation = limitation;
        this.remainNums = remainNums;
    }

    public SchedulingInfo() {
        super();
    }

    public Integer getSchedulingInfoId() {
        return schedulingInfoId;
    }

    public void setSchedulingInfoId(Integer schedulingInfoId) {
        this.schedulingInfoId = schedulingInfoId;
    }

    public Date getSchedulingTime() {
        return schedulingTime;
    }

    public void setSchedulingTime(Date schedulingTime) {
        this.schedulingTime = schedulingTime;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public Integer getLimitation() {
        return limitation;
    }

    public void setLimitation(Integer limitation) {
        this.limitation = limitation;
    }

    public Integer getRemainNums() {
        return remainNums;
    }

    public void setRemainNums(Integer remainNums) {
        this.remainNums = remainNums;
    }
}