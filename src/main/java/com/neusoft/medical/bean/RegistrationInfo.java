package com.neusoft.medical.bean;

import java.util.Date;

public class RegistrationInfo {
    private Integer id;

    private String medicalRecordNo;

    private String patientName;

    private String gender;

    private Integer age;

    private Date birthday;

    private String registrationCategory;

    private String medicalCategory;

    private String identityCardNo;

    private String familyAddress;

    private Date registrationDate;

    private Date visitDate;

    private Integer departmentId;

    private Integer doctorId;

    private String registrationSource;

    private String settleAccountsCategory;

    private String isVisited;

    private String status;

    private Long expense;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public RegistrationInfo(Integer id, String medicalRecordNo, String patientName, String gender, Integer age, Date birthday, String registrationCategory, String medicalCategory, String identityCardNo, String familyAddress, Date registrationDate, Date visitDate, Integer departmentId, Integer doctorId, String registrationSource, String settleAccountsCategory, String isVisited, String status, Long expense, String reserve1, String reserve2, String reserve3) {
        this.id = id;
        this.medicalRecordNo = medicalRecordNo;
        this.patientName = patientName;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.registrationCategory = registrationCategory;
        this.medicalCategory = medicalCategory;
        this.identityCardNo = identityCardNo;
        this.familyAddress = familyAddress;
        this.registrationDate = registrationDate;
        this.visitDate = visitDate;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.registrationSource = registrationSource;
        this.settleAccountsCategory = settleAccountsCategory;
        this.isVisited = isVisited;
        this.status = status;
        this.expense = expense;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public RegistrationInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo == null ? null : medicalRecordNo.trim();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRegistrationCategory() {
        return registrationCategory;
    }

    public void setRegistrationCategory(String registrationCategory) {
        this.registrationCategory = registrationCategory == null ? null : registrationCategory.trim();
    }

    public String getMedicalCategory() {
        return medicalCategory;
    }

    public void setMedicalCategory(String medicalCategory) {
        this.medicalCategory = medicalCategory == null ? null : medicalCategory.trim();
    }

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo == null ? null : identityCardNo.trim();
    }

    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress == null ? null : familyAddress.trim();
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getRegistrationSource() {
        return registrationSource;
    }

    public void setRegistrationSource(String registrationSource) {
        this.registrationSource = registrationSource == null ? null : registrationSource.trim();
    }

    public String getSettleAccountsCategory() {
        return settleAccountsCategory;
    }

    public void setSettleAccountsCategory(String settleAccountsCategory) {
        this.settleAccountsCategory = settleAccountsCategory == null ? null : settleAccountsCategory.trim();
    }

    public String getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(String isVisited) {
        this.isVisited = isVisited == null ? null : isVisited.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getExpense() {
        return expense;
    }

    public void setExpense(Long expense) {
        this.expense = expense;
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