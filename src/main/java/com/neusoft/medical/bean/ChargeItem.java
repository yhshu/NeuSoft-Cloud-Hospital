package com.neusoft.medical.bean;

import java.util.Date;

public class ChargeItem {
    private Integer chargeItemId;

    private String nameZh;

    private String nameEn;

    private Long price;

    private Integer nums;

    private Integer departmentId;

    private Date chargeTime;

    private String namePinyin;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public ChargeItem(Integer chargeItemId, String nameZh, String nameEn, Long price, Integer nums, Integer departmentId, Date chargeTime, String namePinyin, String reserve1, String reserve2, String reserve3) {
        this.chargeItemId = chargeItemId;
        this.nameZh = nameZh;
        this.nameEn = nameEn;
        this.price = price;
        this.nums = nums;
        this.departmentId = departmentId;
        this.chargeTime = chargeTime;
        this.namePinyin = namePinyin;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public ChargeItem() {
        super();
    }

    public Integer getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(Integer chargeItemId) {
        this.chargeItemId = chargeItemId;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Date getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Date chargeTime) {
        this.chargeTime = chargeTime;
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin == null ? null : namePinyin.trim();
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