package com.neusoft.medical.bean;

import java.util.Date;

public class SchedulingRule {
    private Integer schedulingRuleId;

    private String weekDay;

    private Integer departmentId;

    private String departmentName;

    private Integer doctorId;

    private String doctorName;

    private String type;

    private Integer valid;

    private String period;

    private Integer limitation;

    private Integer operatorId;

    private String operatorName;

    private Date operatingDate;

    public SchedulingRule(Integer schedulingRuleId, String weekDay, Integer departmentId, String departmentName, Integer doctorId, String doctorName, String type, Integer valid, String period, Integer limitation, Integer operatorId, String operatorName, Date operatingDate) {
        this.schedulingRuleId = schedulingRuleId;
        this.weekDay = weekDay;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.type = type;
        this.valid = valid;
        this.period = period;
        this.limitation = limitation;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operatingDate = operatingDate;
    }

    public SchedulingRule() {
        super();
    }

    public Integer getSchedulingRuleId() {
        return schedulingRuleId;
    }

    public void setSchedulingRuleId(Integer schedulingRuleId) {
        this.schedulingRuleId = schedulingRuleId;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay == null ? null : weekDay.trim();
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Date getOperatingDate() {
        return operatingDate;
    }

    public void setOperatingDate(Date operatingDate) {
        this.operatingDate = operatingDate;
    }
}