package com.neusoft.medical.bean;

import java.util.Date;

public class Invoice {
    private Integer invoiceId;

    private Integer expenseCategoryId;

    private Integer registrationId;

    private Integer collectorId;

    private Date payTime;

    private Double payAmount;

    private Boolean valid;

    public Invoice(Integer invoiceId, Integer expenseCategoryId, Integer registrationId, Integer collectorId, Date payTime, Double payAmount, Boolean valid) {
        this.invoiceId = invoiceId;
        this.expenseCategoryId = expenseCategoryId;
        this.registrationId = registrationId;
        this.collectorId = collectorId;
        this.payTime = payTime;
        this.payAmount = payAmount;
        this.valid = valid;
    }

    public Invoice() {
        super();
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(Integer expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(Integer collectorId) {
        this.collectorId = collectorId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}