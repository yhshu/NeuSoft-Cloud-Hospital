package com.neusoft.medical.bean;

import java.util.Date;

public class DailySettlement {
    private Integer dailySettlementId;

    private Integer collectorAccountId;

    private String collectorRealName;

    private Date dailySettlementDate;

    private Date previousDailySettlementDate;

    private Integer checked;

    private Integer valid;

    public DailySettlement(Integer dailySettlementId, Integer collectorAccountId, String collectorRealName, Date dailySettlementDate, Date previousDailySettlementDate, Integer checked, Integer valid) {
        this.dailySettlementId = dailySettlementId;
        this.collectorAccountId = collectorAccountId;
        this.collectorRealName = collectorRealName;
        this.dailySettlementDate = dailySettlementDate;
        this.previousDailySettlementDate = previousDailySettlementDate;
        this.checked = checked;
        this.valid = valid;
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

    public Date getPreviousDailySettlementDate() {
        return previousDailySettlementDate;
    }

    public void setPreviousDailySettlementDate(Date previousDailySettlementDate) {
        this.previousDailySettlementDate = previousDailySettlementDate;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}