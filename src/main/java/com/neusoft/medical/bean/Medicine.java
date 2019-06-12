package com.neusoft.medical.bean;

import java.util.Date;

public class Medicine {
    private Integer medicineId;

    private String medicineCode;

    private String nameZh;

    private String medicineFormat;

    private String medicineUnit;

    private String medicineManufacturer;

    private Integer medicineDosageId;

    private Integer medicineTypeId;

    private Long medicinePrice;

    private String namePinyin;

    private Date creationTime;

    private Integer nums;

    private String nameEn;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public Medicine(Integer medicineId, String medicineCode, String nameZh, String medicineFormat, String medicineUnit, String medicineManufacturer, Integer medicineDosageId, Integer medicineTypeId, Long medicinePrice, String namePinyin, Date creationTime, Integer nums, String nameEn, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.medicineId = medicineId;
        this.medicineCode = medicineCode;
        this.nameZh = nameZh;
        this.medicineFormat = medicineFormat;
        this.medicineUnit = medicineUnit;
        this.medicineManufacturer = medicineManufacturer;
        this.medicineDosageId = medicineDosageId;
        this.medicineTypeId = medicineTypeId;
        this.medicinePrice = medicinePrice;
        this.namePinyin = namePinyin;
        this.creationTime = creationTime;
        this.nums = nums;
        this.nameEn = nameEn;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public Medicine() {
        super();
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode == null ? null : medicineCode.trim();
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    public String getMedicineFormat() {
        return medicineFormat;
    }

    public void setMedicineFormat(String medicineFormat) {
        this.medicineFormat = medicineFormat == null ? null : medicineFormat.trim();
    }

    public String getMedicineUnit() {
        return medicineUnit;
    }

    public void setMedicineUnit(String medicineUnit) {
        this.medicineUnit = medicineUnit == null ? null : medicineUnit.trim();
    }

    public String getMedicineManufacturer() {
        return medicineManufacturer;
    }

    public void setMedicineManufacturer(String medicineManufacturer) {
        this.medicineManufacturer = medicineManufacturer == null ? null : medicineManufacturer.trim();
    }

    public Integer getMedicineDosageId() {
        return medicineDosageId;
    }

    public void setMedicineDosageId(Integer medicineDosageId) {
        this.medicineDosageId = medicineDosageId;
    }

    public Integer getMedicineTypeId() {
        return medicineTypeId;
    }

    public void setMedicineTypeId(Integer medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    public Long getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(Long medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin == null ? null : namePinyin.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
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