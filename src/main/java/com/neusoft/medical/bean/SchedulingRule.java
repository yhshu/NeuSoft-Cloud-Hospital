package com.neusoft.medical.bean;

import java.io.Serializable;
import java.util.Date;

public class SchedulingRule implements Serializable {
    private Integer schedulingRuleId;

    private Integer weekday;

    private Integer departmentId;

    private Integer doctorId;

    private Integer registrationCategoryId;

    private Integer noon;

    private Integer limitation;

    private Integer operationAccountId;

    private Date operationDate;

    private Integer valid;

    private static final long serialVersionUID = 1L;

    public SchedulingRule(Integer schedulingRuleId, Integer weekday, Integer departmentId, Integer doctorId, Integer registrationCategoryId, Integer noon, Integer limitation, Integer operationAccountId, Date operationDate, Integer valid) {
        this.schedulingRuleId = schedulingRuleId;
        this.weekday = weekday;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.registrationCategoryId = registrationCategoryId;
        this.noon = noon;
        this.limitation = limitation;
        this.operationAccountId = operationAccountId;
        this.operationDate = operationDate;
        this.valid = valid;
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

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
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

    public Integer getLimitation() {
        return limitation;
    }

    public void setLimitation(Integer limitation) {
        this.limitation = limitation;
    }

    public Integer getOperationAccountId() {
        return operationAccountId;
    }

    public void setOperationAccountId(Integer operationAccountId) {
        this.operationAccountId = operationAccountId;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}