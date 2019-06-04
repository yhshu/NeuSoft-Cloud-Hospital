package com.neusoft.medical.bean;

public class Staff {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..staff.staff_id
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    private Integer staffId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..staff.department_name
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    private String departmentName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..staff.account_id
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    private Integer accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..staff.department_id
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    private Integer departmentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..staff.type
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..staff.valid
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    private Integer valid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..staff.reserve1
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    private String reserve1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..staff.reserve2
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    private String reserve2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..staff.reserve3
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    private String reserve3;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..staff
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public Staff(Integer staffId, String departmentName, Integer accountId, Integer departmentId, Integer type, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.staffId = staffId;
        this.departmentName = departmentName;
        this.accountId = accountId;
        this.departmentId = departmentId;
        this.type = type;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..staff
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public Staff() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..staff.staff_id
     *
     * @return the value of hospital..staff.staff_id
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..staff.staff_id
     *
     * @param staffId the value for hospital..staff.staff_id
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..staff.department_name
     *
     * @return the value of hospital..staff.department_name
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..staff.department_name
     *
     * @param departmentName the value for hospital..staff.department_name
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..staff.account_id
     *
     * @return the value of hospital..staff.account_id
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..staff.account_id
     *
     * @param accountId the value for hospital..staff.account_id
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..staff.department_id
     *
     * @return the value of hospital..staff.department_id
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..staff.department_id
     *
     * @param departmentId the value for hospital..staff.department_id
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..staff.type
     *
     * @return the value of hospital..staff.type
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..staff.type
     *
     * @param type the value for hospital..staff.type
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..staff.valid
     *
     * @return the value of hospital..staff.valid
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..staff.valid
     *
     * @param valid the value for hospital..staff.valid
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..staff.reserve1
     *
     * @return the value of hospital..staff.reserve1
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public String getReserve1() {
        return reserve1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..staff.reserve1
     *
     * @param reserve1 the value for hospital..staff.reserve1
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..staff.reserve2
     *
     * @return the value of hospital..staff.reserve2
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public String getReserve2() {
        return reserve2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..staff.reserve2
     *
     * @param reserve2 the value for hospital..staff.reserve2
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..staff.reserve3
     *
     * @return the value of hospital..staff.reserve3
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public String getReserve3() {
        return reserve3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..staff.reserve3
     *
     * @param reserve3 the value for hospital..staff.reserve3
     *
     * @mbggenerated Tue Jun 04 11:21:04 CST 2019
     */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }
}