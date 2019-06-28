package com.neusoft.medical.bean;

import java.io.Serializable;

public class DailySettlementDetail implements Serializable {
    private Integer dailySettlementDetailId;

    private Integer dailySettlementId;

    private Integer invoiceNums;

    private Integer registrationId;

    private String patientName;

    private Double invoiceTotalAmount;

    private Double selfPay;

    private Double accountPay;

    private Double reimbursementPay;

    private Double discounted;

    private Integer dailySettlementDetailState;

    private Integer settlementCategoryId;

    private Integer valid;

    private static final long serialVersionUID = 1L;

    public DailySettlementDetail(Integer dailySettlementDetailId, Integer dailySettlementId, Integer invoiceNums, Integer registrationId, String patientName, Double invoiceTotalAmount, Double selfPay, Double accountPay, Double reimbursementPay, Double discounted, Integer dailySettlementDetailState, Integer settlementCategoryId, Integer valid) {
        this.dailySettlementDetailId = dailySettlementDetailId;
        this.dailySettlementId = dailySettlementId;
        this.invoiceNums = invoiceNums;
        this.registrationId = registrationId;
        this.patientName = patientName;
        this.invoiceTotalAmount = invoiceTotalAmount;
        this.selfPay = selfPay;
        this.accountPay = accountPay;
        this.reimbursementPay = reimbursementPay;
        this.discounted = discounted;
        this.dailySettlementDetailState = dailySettlementDetailState;
        this.settlementCategoryId = settlementCategoryId;
        this.valid = valid;
    }

    public DailySettlementDetail() {
        super();
    }

    public Integer getDailySettlementDetailId() {
        return dailySettlementDetailId;
    }

    public void setDailySettlementDetailId(Integer dailySettlementDetailId) {
        this.dailySettlementDetailId = dailySettlementDetailId;
    }

    public Integer getDailySettlementId() {
        return dailySettlementId;
    }

    public void setDailySettlementId(Integer dailySettlementId) {
        this.dailySettlementId = dailySettlementId;
    }

    public Integer getInvoiceNums() {
        return invoiceNums;
    }

    public void setInvoiceNums(Integer invoiceNums) {
        this.invoiceNums = invoiceNums;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public Double getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    public void setInvoiceTotalAmount(Double invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
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

    public Integer getDailySettlementDetailState() {
        return dailySettlementDetailState;
    }

    public void setDailySettlementDetailState(Integer dailySettlementDetailState) {
        this.dailySettlementDetailState = dailySettlementDetailState;
    }

    public Integer getSettlementCategoryId() {
        return settlementCategoryId;
    }

    public void setSettlementCategoryId(Integer settlementCategoryId) {
        this.settlementCategoryId = settlementCategoryId;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}