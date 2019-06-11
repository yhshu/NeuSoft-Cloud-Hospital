package com.neusoft.medical.bean;

import java.util.Date;

public class Registration {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.registration_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private Integer registrationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.patient_name
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String patientName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.patient_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private Integer patientId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.gender
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.age
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.birthday
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.registration_category
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String registrationCategory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.medical_category
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String medicalCategory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.identity_card_no
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String identityCardNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.registration_status
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String registrationStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.visit_date
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private Date visitDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.registration_date
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private Date registrationDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.department_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private Integer departmentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.doctor_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private Integer doctorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.registration_source
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String registrationSource;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.settle_accounts_category
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String settleAccountsCategory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.is_visited
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String isVisited;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.valid
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private Integer valid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.family_address
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String familyAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.collector_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private Integer collectorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.total_charge
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private Integer totalCharge;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.reserve1
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String reserve1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.reserve2
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String reserve2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital.registration.reserve3
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    private String reserve3;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Registration(Integer registrationId, String patientName, Integer patientId, String gender, Integer age, Date birthday, String registrationCategory, String medicalCategory, String identityCardNo, String registrationStatus, Date visitDate, Date registrationDate, Integer departmentId, Integer doctorId, String registrationSource, String settleAccountsCategory, String isVisited, Integer valid, String familyAddress, Integer collectorId, Integer totalCharge, String reserve1, String reserve2, String reserve3) {
        this.registrationId = registrationId;
        this.patientName = patientName;
        this.patientId = patientId;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.registrationCategory = registrationCategory;
        this.medicalCategory = medicalCategory;
        this.identityCardNo = identityCardNo;
        this.registrationStatus = registrationStatus;
        this.visitDate = visitDate;
        this.registrationDate = registrationDate;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.registrationSource = registrationSource;
        this.settleAccountsCategory = settleAccountsCategory;
        this.isVisited = isVisited;
        this.valid = valid;
        this.familyAddress = familyAddress;
        this.collectorId = collectorId;
        this.totalCharge = totalCharge;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Registration() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.registration_id
     *
     * @return the value of hospital.registration.registration_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Integer getRegistrationId() {
        return registrationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.registration_id
     *
     * @param registrationId the value for hospital.registration.registration_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.patient_name
     *
     * @return the value of hospital.registration.patient_name
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.patient_name
     *
     * @param patientName the value for hospital.registration.patient_name
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.patient_id
     *
     * @return the value of hospital.registration.patient_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Integer getPatientId() {
        return patientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.patient_id
     *
     * @param patientId the value for hospital.registration.patient_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.gender
     *
     * @return the value of hospital.registration.gender
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.gender
     *
     * @param gender the value for hospital.registration.gender
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.age
     *
     * @return the value of hospital.registration.age
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.age
     *
     * @param age the value for hospital.registration.age
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.birthday
     *
     * @return the value of hospital.registration.birthday
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.birthday
     *
     * @param birthday the value for hospital.registration.birthday
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.registration_category
     *
     * @return the value of hospital.registration.registration_category
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getRegistrationCategory() {
        return registrationCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.registration_category
     *
     * @param registrationCategory the value for hospital.registration.registration_category
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setRegistrationCategory(String registrationCategory) {
        this.registrationCategory = registrationCategory == null ? null : registrationCategory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.medical_category
     *
     * @return the value of hospital.registration.medical_category
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getMedicalCategory() {
        return medicalCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.medical_category
     *
     * @param medicalCategory the value for hospital.registration.medical_category
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setMedicalCategory(String medicalCategory) {
        this.medicalCategory = medicalCategory == null ? null : medicalCategory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.identity_card_no
     *
     * @return the value of hospital.registration.identity_card_no
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getIdentityCardNo() {
        return identityCardNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.identity_card_no
     *
     * @param identityCardNo the value for hospital.registration.identity_card_no
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.registration_status
     *
     * @return the value of hospital.registration.registration_status
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getRegistrationStatus() {
        return registrationStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.registration_status
     *
     * @param registrationStatus the value for hospital.registration.registration_status
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus == null ? null : registrationStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.visit_date
     *
     * @return the value of hospital.registration.visit_date
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Date getVisitDate() {
        return visitDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.visit_date
     *
     * @param visitDate the value for hospital.registration.visit_date
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.registration_date
     *
     * @return the value of hospital.registration.registration_date
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.registration_date
     *
     * @param registrationDate the value for hospital.registration.registration_date
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.department_id
     *
     * @return the value of hospital.registration.department_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.department_id
     *
     * @param departmentId the value for hospital.registration.department_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.doctor_id
     *
     * @return the value of hospital.registration.doctor_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Integer getDoctorId() {
        return doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.doctor_id
     *
     * @param doctorId the value for hospital.registration.doctor_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.registration_source
     *
     * @return the value of hospital.registration.registration_source
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getRegistrationSource() {
        return registrationSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.registration_source
     *
     * @param registrationSource the value for hospital.registration.registration_source
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setRegistrationSource(String registrationSource) {
        this.registrationSource = registrationSource == null ? null : registrationSource.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.settle_accounts_category
     *
     * @return the value of hospital.registration.settle_accounts_category
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getSettleAccountsCategory() {
        return settleAccountsCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.settle_accounts_category
     *
     * @param settleAccountsCategory the value for hospital.registration.settle_accounts_category
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setSettleAccountsCategory(String settleAccountsCategory) {
        this.settleAccountsCategory = settleAccountsCategory == null ? null : settleAccountsCategory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.is_visited
     *
     * @return the value of hospital.registration.is_visited
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getIsVisited() {
        return isVisited;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.is_visited
     *
     * @param isVisited the value for hospital.registration.is_visited
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setIsVisited(String isVisited) {
        this.isVisited = isVisited == null ? null : isVisited.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.valid
     *
     * @return the value of hospital.registration.valid
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.valid
     *
     * @param valid the value for hospital.registration.valid
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.family_address
     *
     * @return the value of hospital.registration.family_address
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getFamilyAddress() {
        return familyAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.family_address
     *
     * @param familyAddress the value for hospital.registration.family_address
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress == null ? null : familyAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.collector_id
     *
     * @return the value of hospital.registration.collector_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Integer getCollectorId() {
        return collectorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.collector_id
     *
     * @param collectorId the value for hospital.registration.collector_id
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setCollectorId(Integer collectorId) {
        this.collectorId = collectorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.total_charge
     *
     * @return the value of hospital.registration.total_charge
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public Integer getTotalCharge() {
        return totalCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.total_charge
     *
     * @param totalCharge the value for hospital.registration.total_charge
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setTotalCharge(Integer totalCharge) {
        this.totalCharge = totalCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.reserve1
     *
     * @return the value of hospital.registration.reserve1
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getReserve1() {
        return reserve1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.reserve1
     *
     * @param reserve1 the value for hospital.registration.reserve1
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.reserve2
     *
     * @return the value of hospital.registration.reserve2
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getReserve2() {
        return reserve2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.reserve2
     *
     * @param reserve2 the value for hospital.registration.reserve2
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital.registration.reserve3
     *
     * @return the value of hospital.registration.reserve3
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public String getReserve3() {
        return reserve3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital.registration.reserve3
     *
     * @param reserve3 the value for hospital.registration.reserve3
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }
}