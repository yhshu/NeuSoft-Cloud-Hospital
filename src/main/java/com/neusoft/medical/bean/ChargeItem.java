package com.neusoft.medical.bean;

import java.util.Date;

public class ChargeItem {
    private Integer chargeItemId;

    private String chargeItemCode;

    private String nameZh;

    private String chargeItemFormat;

    private Long price;

    private Integer expenseCategoryId;

    private Integer departmentId;

    private String namePinyin;

    private Integer chargeType;

    private Date creationTime;

    private Date chargeTime;

    private Integer nums;

    private String nameEn;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public ChargeItem(Integer chargeItemId, String chargeItemCode, String nameZh, String chargeItemFormat, Long price, Integer expenseCategoryId, Integer departmentId, String namePinyin, Integer chargeType, Date creationTime, Date chargeTime, Integer nums, String nameEn, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.chargeItemId = chargeItemId;
        this.chargeItemCode = chargeItemCode;
        this.nameZh = nameZh;
        this.chargeItemFormat = chargeItemFormat;
        this.price = price;
        this.expenseCategoryId = expenseCategoryId;
        this.departmentId = departmentId;
        this.namePinyin = namePinyin;
        this.chargeType = chargeType;
        this.creationTime = creationTime;
        this.chargeTime = chargeTime;
        this.nums = nums;
        this.nameEn = nameEn;
        this.valid = valid;
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

    public String getChargeItemCode() {
        return chargeItemCode;
    }

    public void setChargeItemCode(String chargeItemCode) {
        this.chargeItemCode = chargeItemCode == null ? null : chargeItemCode.trim();
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    public String getChargeItemFormat() {
        return chargeItemFormat;
    }

    public void setChargeItemFormat(String chargeItemFormat) {
        this.chargeItemFormat = chargeItemFormat == null ? null : chargeItemFormat.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(Integer expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin == null ? null : namePinyin.trim();
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Date chargeTime) {
        this.chargeTime = chargeTime;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
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