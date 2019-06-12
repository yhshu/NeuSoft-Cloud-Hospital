package com.neusoft.medical.bean;

import java.util.Date;

public class Patient {
    private Integer patientId;

    private String patientName;

    private Date birthDate;

    private String allergies;

    private String identityCardNo;

    private String socialSecurityCardNo;

    private String familyAddress;

    private String gender;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public Patient(Integer patientId, String patientName, Date birthDate, String allergies, String identityCardNo, String socialSecurityCardNo, String familyAddress, String gender, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.birthDate = birthDate;
        this.allergies = allergies;
        this.identityCardNo = identityCardNo;
        this.socialSecurityCardNo = socialSecurityCardNo;
        this.familyAddress = familyAddress;
        this.gender = gender;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public Patient() {
        super();
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies == null ? null : allergies.trim();
    }

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo == null ? null : identityCardNo.trim();
    }

    public String getSocialSecurityCardNo() {
        return socialSecurityCardNo;
    }

    public void setSocialSecurityCardNo(String socialSecurityCardNo) {
        this.socialSecurityCardNo = socialSecurityCardNo == null ? null : socialSecurityCardNo.trim();
    }

    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress == null ? null : familyAddress.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
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