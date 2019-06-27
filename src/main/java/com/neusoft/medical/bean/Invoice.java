package com.neusoft.medical.bean;

import java.util.Date;

public class Invoice {
    private Integer invoiceId;

    private String invoiceTitle;

    private Integer invoiceNums;

    private Integer collectorId;

    private Integer registrationId;

    private Date payTime;

    private Double invoiceAmount;

    private Double selfPay;

    private Double accountPay;

    private Double reimbursementPay;

    private Double discounted;

    private Integer invoiceState;

    private Double prescriptionFee;

    private Double examinationFee;

    private Double disposalFee;

    private Double registrationFee;

    private Integer valid;

    public Invoice(Integer invoiceId, String invoiceTitle, Integer invoiceNums, Integer collectorId, Integer registrationId, Date payTime, Double invoiceAmount, Double selfPay, Double accountPay, Double reimbursementPay, Double discounted, Integer invoiceState, Double prescriptionFee, Double examinationFee, Double disposalFee, Double registrationFee, Integer valid) {
        this.invoiceId = invoiceId;
        this.invoiceTitle = invoiceTitle;
        this.invoiceNums = invoiceNums;
        this.collectorId = collectorId;
        this.registrationId = registrationId;
        this.payTime = payTime;
        this.invoiceAmount = invoiceAmount;
        this.selfPay = selfPay;
        this.accountPay = accountPay;
        this.reimbursementPay = reimbursementPay;
        this.discounted = discounted;
        this.invoiceState = invoiceState;
        this.prescriptionFee = prescriptionFee;
        this.examinationFee = examinationFee;
        this.disposalFee = disposalFee;
        this.registrationFee = registrationFee;
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

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public Integer getInvoiceNums() {
        return invoiceNums;
    }

    public void setInvoiceNums(Integer invoiceNums) {
        this.invoiceNums = invoiceNums;
    }

    public Integer getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(Integer collectorId) {
        this.collectorId = collectorId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Double getSelfPay() {
        return selfPay;
    }

    public void setSelfPay(Double selfPay) {
        this.selfPay = selfPay;
    }

    public Double getAccountPay() {
        return accountPay;
    }

    public void setAccountPay(Double accountPay) {
        this.accountPay = accountPay;
    }

    public Double getReimbursementPay() {
        return reimbursementPay;
    }

    public void setReimbursementPay(Double reimbursementPay) {
        this.reimbursementPay = reimbursementPay;
    }

    public Double getDiscounted() {
        return discounted;
    }

    public void setDiscounted(Double discounted) {
        this.discounted = discounted;
    }

    public Integer getInvoiceState() {
        return invoiceState;
    }

    public void setInvoiceState(Integer invoiceState) {
        this.invoiceState = invoiceState;
    }

    public Double getPrescriptionFee() {
        return prescriptionFee;
    }

    public void setPrescriptionFee(Double prescriptionFee) {
        this.prescriptionFee = prescriptionFee;
    }

    public Double getExaminationFee() {
        return examinationFee;
    }

    public void setExaminationFee(Double examinationFee) {
        this.examinationFee = examinationFee;
    }

    public Double getDisposalFee() {
        return disposalFee;
    }

    public void setDisposalFee(Double disposalFee) {
        this.disposalFee = disposalFee;
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