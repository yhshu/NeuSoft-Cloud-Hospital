package com.neusoft.medical.bean;

import java.io.Serializable;
import java.util.Date;

public class SchedulingInfo implements Serializable {
    private Integer schedulingInfoId;

    private Date schedulingTime;

    private Integer schedulingRuleId;

    private Integer departmentId;

    private Integer doctorId;

    private Integer registrationCategoryId;

    private Integer noon;

    private Integer valid;

    private Integer limitation;

    private Integer remainNums;

    private static final long serialVersionUID = 1L;

    public SchedulingInfo(Integer schedulingInfoId, Date schedulingTime, Integer schedulingRuleId, Integer departmentId, Integer doctorId, Integer registrationCategoryId, Integer noon, Integer valid, Integer limitation, Integer remainNums) {
        this.schedulingInfoId = schedulingInfoId;
        this.schedulingTime = schedulingTime;
        this.schedulingRuleId = schedulingRuleId;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.registrationCategoryId = registrationCategoryId;
        this.noon = noon;
        this.valid = valid;
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

    public Integer getSchedulingRuleId() {
        return schedulingRuleId;
    }

    public void setSchedulingRuleId(Integer schedulingRuleId) {
        this.schedulingRuleId = schedulingRuleId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getRegistrationCategoryId() {
        return registrationCategoryId;
    }

    public void setRegistrationCategoryId(Integer registrationCategoryId) {
        this.registrationCategoryId = registrationCategoryId;
    }

    public Integer getNoon() {
        return noon;
    }

    public void setNoon(Integer noon) {
        this.noon = noon;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
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