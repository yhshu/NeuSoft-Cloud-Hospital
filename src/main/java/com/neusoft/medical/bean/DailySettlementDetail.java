package com.neusoft.medical.bean;

public class DailySettlementDetail {
    private Integer dailySettlementDetailId;

    private Integer invoiceNums;

    private Integer registrationId;

    private String patientname;

    private Double invoiceTotalAmount;

    private Double selfPay;

    private Double accountPay;

    private Double reimbursementPay;

    private Double discounted;

    private Integer dailySettlementDetailState;

    private Integer settlementCategoryId;

    public DailySettlementDetail(Integer dailySettlementDetailId, Integer invoiceNums, Integer registrationId, String patientname, Double invoiceTotalAmount, Double selfPay, Double accountPay, Double reimbursementPay, Double discounted, Integer dailySettlementDetailState, Integer settlementCategoryId) {
        this.dailySettlementDetailId = dailySettlementDetailId;
        this.invoiceNums = invoiceNums;
        this.registrationId = registrationId;
        this.patientname = patientname;
        this.invoiceTotalAmount = invoiceTotalAmount;
        this.selfPay = selfPay;
        this.accountPay = accountPay;
        this.reimbursementPay = reimbursementPay;
        this.discounted = discounted;
        this.dailySettlementDetailState = dailySettlementDetailState;
        this.settlementCategoryId = settlementCategoryId;
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

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname == null ? null : patientname.trim();
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
}