package com.neusoft.medical.bean;

import java.util.Date;

public class DailySettlement {
    private Integer dailySettlementId;

    private Integer collectorAccountId;

    private String collectorRealName;

    private Date dailySettlementDate;

    public DailySettlement(Integer dailySettlementId, Integer collectorAccountId, String collectorRealName, Date dailySettlementDate) {
        this.dailySettlementId = dailySettlementId;
        this.collectorAccountId = collectorAccountId;
        this.collectorRealName = collectorRealName;
        this.dailySettlementDate = dailySettlementDate;
    }

    public DailySettlement() {
        super();
    }

    public Integer getDailySettlementId() {
        return dailySettlementId;
    }

    public void setDailySettlementId(Integer dailySettlementId) {
        this.dailySettlementId = dailySettlementId;
    }

    public Integer getCollectorAccountId() {
        return collectorAccountId;
    }

    public void setCollectorAccountId(Integer collectorAccountId) {
        this.collectorAccountId = collectorAccountId;
    }

    public String getCollectorRealName() {
        return collectorRealName;
    }

    public void setCollectorRealName(String collectorRealName) {
        this.collectorRealName = collectorRealName == null ? null : collectorRealName.trim();
    }

    public Date getDailySettlementDate() {
        return dailySettlementDate;
    }

    public void setDailySettlementDate(Date dailySettlementDate) {
        this.dailySettlementDate = dailySettlementDate;
    }
}