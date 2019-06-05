package com.neusoft.medical.bean;

import java.util.Date;

public class Medicine {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.medicine_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Integer medicineId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.medicine_code
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String medicineCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.name_zh
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String nameZh;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.medicine_format
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String medicineFormat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.medicine_unit
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String medicineUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.medicine_manufacturer
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String medicineManufacturer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.medicine_dosage_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Integer medicineDosageId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.medicine_type_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Integer medicineTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.medicine_price
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Long medicinePrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.name_pinyin
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String namePinyin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.creation_time
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Date creationTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.nums
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Integer nums;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.name_en
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String nameEn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.valid
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Integer valid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.reserve1
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String reserve1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.reserve2
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String reserve2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..medicine.reserve3
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String reserve3;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..medicine
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
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

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..medicine
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Medicine() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.medicine_id
     *
     * @return the value of hospital..medicine.medicine_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Integer getMedicineId() {
        return medicineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.medicine_id
     *
     * @param medicineId the value for hospital..medicine.medicine_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.medicine_code
     *
     * @return the value of hospital..medicine.medicine_code
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getMedicineCode() {
        return medicineCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.medicine_code
     *
     * @param medicineCode the value for hospital..medicine.medicine_code
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode == null ? null : medicineCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.name_zh
     *
     * @return the value of hospital..medicine.name_zh
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getNameZh() {
        return nameZh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.name_zh
     *
     * @param nameZh the value for hospital..medicine.name_zh
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.medicine_format
     *
     * @return the value of hospital..medicine.medicine_format
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getMedicineFormat() {
        return medicineFormat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.medicine_format
     *
     * @param medicineFormat the value for hospital..medicine.medicine_format
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setMedicineFormat(String medicineFormat) {
        this.medicineFormat = medicineFormat == null ? null : medicineFormat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.medicine_unit
     *
     * @return the value of hospital..medicine.medicine_unit
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getMedicineUnit() {
        return medicineUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.medicine_unit
     *
     * @param medicineUnit the value for hospital..medicine.medicine_unit
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setMedicineUnit(String medicineUnit) {
        this.medicineUnit = medicineUnit == null ? null : medicineUnit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.medicine_manufacturer
     *
     * @return the value of hospital..medicine.medicine_manufacturer
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getMedicineManufacturer() {
        return medicineManufacturer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.medicine_manufacturer
     *
     * @param medicineManufacturer the value for hospital..medicine.medicine_manufacturer
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setMedicineManufacturer(String medicineManufacturer) {
        this.medicineManufacturer = medicineManufacturer == null ? null : medicineManufacturer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.medicine_dosage_id
     *
     * @return the value of hospital..medicine.medicine_dosage_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Integer getMedicineDosageId() {
        return medicineDosageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.medicine_dosage_id
     *
     * @param medicineDosageId the value for hospital..medicine.medicine_dosage_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setMedicineDosageId(Integer medicineDosageId) {
        this.medicineDosageId = medicineDosageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.medicine_type_id
     *
     * @return the value of hospital..medicine.medicine_type_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Integer getMedicineTypeId() {
        return medicineTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.medicine_type_id
     *
     * @param medicineTypeId the value for hospital..medicine.medicine_type_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setMedicineTypeId(Integer medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.medicine_price
     *
     * @return the value of hospital..medicine.medicine_price
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Long getMedicinePrice() {
        return medicinePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.medicine_price
     *
     * @param medicinePrice the value for hospital..medicine.medicine_price
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setMedicinePrice(Long medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.name_pinyin
     *
     * @return the value of hospital..medicine.name_pinyin
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getNamePinyin() {
        return namePinyin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.name_pinyin
     *
     * @param namePinyin the value for hospital..medicine.name_pinyin
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin == null ? null : namePinyin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.creation_time
     *
     * @return the value of hospital..medicine.creation_time
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.creation_time
     *
     * @param creationTime the value for hospital..medicine.creation_time
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.nums
     *
     * @return the value of hospital..medicine.nums
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Integer getNums() {
        return nums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.nums
     *
     * @param nums the value for hospital..medicine.nums
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setNums(Integer nums) {
        this.nums = nums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.name_en
     *
     * @return the value of hospital..medicine.name_en
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.name_en
     *
     * @param nameEn the value for hospital..medicine.name_en
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.valid
     *
     * @return the value of hospital..medicine.valid
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.valid
     *
     * @param valid the value for hospital..medicine.valid
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.reserve1
     *
     * @return the value of hospital..medicine.reserve1
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getReserve1() {
        return reserve1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.reserve1
     *
     * @param reserve1 the value for hospital..medicine.reserve1
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.reserve2
     *
     * @return the value of hospital..medicine.reserve2
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getReserve2() {
        return reserve2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.reserve2
     *
     * @param reserve2 the value for hospital..medicine.reserve2
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..medicine.reserve3
     *
     * @return the value of hospital..medicine.reserve3
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getReserve3() {
        return reserve3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..medicine.reserve3
     *
     * @param reserve3 the value for hospital..medicine.reserve3
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }
}