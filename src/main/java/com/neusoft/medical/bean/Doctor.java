package com.neusoft.medical.bean;

public class Doctor {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..doctor.doctor_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Integer doctorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..doctor.doctor_name
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String doctorName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..doctor.department
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Integer department;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..doctor.type
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..doctor.job_title
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String jobTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..doctor.account_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Integer accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..doctor.valid
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Integer valid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..doctor.doctor_scheduling
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private Integer doctorScheduling;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..doctor.reserve1
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String reserve1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..doctor.reserve2
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String reserve2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..doctor.reserve3
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    private String reserve3;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..doctor
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Doctor(Integer doctorId, String doctorName, Integer department, Integer type, String jobTitle, Integer accountId, Integer valid, Integer doctorScheduling, String reserve1, String reserve2, String reserve3) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.department = department;
        this.type = type;
        this.jobTitle = jobTitle;
        this.accountId = accountId;
        this.valid = valid;
        this.doctorScheduling = doctorScheduling;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..doctor
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Doctor() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..doctor.doctor_id
     *
     * @return the value of hospital..doctor.doctor_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Integer getDoctorId() {
        return doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..doctor.doctor_id
     *
     * @param doctorId the value for hospital..doctor.doctor_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..doctor.doctor_name
     *
     * @return the value of hospital..doctor.doctor_name
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..doctor.doctor_name
     *
     * @param doctorName the value for hospital..doctor.doctor_name
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..doctor.department
     *
     * @return the value of hospital..doctor.department
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Integer getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..doctor.department
     *
     * @param department the value for hospital..doctor.department
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setDepartment(Integer department) {
        this.department = department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..doctor.type
     *
     * @return the value of hospital..doctor.type
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..doctor.type
     *
     * @param type the value for hospital..doctor.type
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..doctor.job_title
     *
     * @return the value of hospital..doctor.job_title
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..doctor.job_title
     *
     * @param jobTitle the value for hospital..doctor.job_title
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..doctor.account_id
     *
     * @return the value of hospital..doctor.account_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..doctor.account_id
     *
     * @param accountId the value for hospital..doctor.account_id
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..doctor.valid
     *
     * @return the value of hospital..doctor.valid
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..doctor.valid
     *
     * @param valid the value for hospital..doctor.valid
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..doctor.doctor_scheduling
     *
     * @return the value of hospital..doctor.doctor_scheduling
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public Integer getDoctorScheduling() {
        return doctorScheduling;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..doctor.doctor_scheduling
     *
     * @param doctorScheduling the value for hospital..doctor.doctor_scheduling
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setDoctorScheduling(Integer doctorScheduling) {
        this.doctorScheduling = doctorScheduling;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..doctor.reserve1
     *
     * @return the value of hospital..doctor.reserve1
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getReserve1() {
        return reserve1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..doctor.reserve1
     *
     * @param reserve1 the value for hospital..doctor.reserve1
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..doctor.reserve2
     *
     * @return the value of hospital..doctor.reserve2
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getReserve2() {
        return reserve2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..doctor.reserve2
     *
     * @param reserve2 the value for hospital..doctor.reserve2
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..doctor.reserve3
     *
     * @return the value of hospital..doctor.reserve3
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public String getReserve3() {
        return reserve3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..doctor.reserve3
     *
     * @param reserve3 the value for hospital..doctor.reserve3
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }
}