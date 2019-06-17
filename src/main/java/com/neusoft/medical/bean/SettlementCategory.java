package com.neusoft.medical.bean;

public class SettlementCategory {
    private Integer settlementCategoryId;

    private String settlementCategoryName;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public SettlementCategory(Integer settlementCategoryId, String settlementCategoryName, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.settlementCategoryId = settlementCategoryId;
        this.settlementCategoryName = settlementCategoryName;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public SettlementCategory() {
        super();
    }

    public Integer getSettlementCategoryId() {
        return settlementCategoryId;
    }

    public void setSettlementCategoryId(Integer settlementCategoryId) {
        this.settlementCategoryId = settlementCategoryId;
    }

    public String getSettlementCategoryName() {
        return settlementCategoryName;
    }

    public void setSettlementCategoryName(String settlementCategoryName) {
        this.settlementCategoryName = settlementCategoryName == null ? null : settlementCategoryName.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }
}