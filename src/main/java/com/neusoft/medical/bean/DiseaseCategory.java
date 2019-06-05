package com.neusoft.medical.bean;

public class DiseaseCategory {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..disease_category.disease_id
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    private Integer diseaseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..disease_category.disease_code
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    private String diseaseCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..disease_category.disease_name
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    private String diseaseName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..disease_category.sequence_no
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    private Integer sequenceNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..disease_category.disease_type
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    private Integer diseaseType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospital..disease_category.valid
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    private Integer valid;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public DiseaseCategory(Integer diseaseId, String diseaseCode, String diseaseName, Integer sequenceNo, Integer diseaseType, Integer valid) {
        this.diseaseId = diseaseId;
        this.diseaseCode = diseaseCode;
        this.diseaseName = diseaseName;
        this.sequenceNo = sequenceNo;
        this.diseaseType = diseaseType;
        this.valid = valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public DiseaseCategory() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..disease_category.disease_id
     *
     * @return the value of hospital..disease_category.disease_id
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public Integer getDiseaseId() {
        return diseaseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..disease_category.disease_id
     *
     * @param diseaseId the value for hospital..disease_category.disease_id
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..disease_category.disease_code
     *
     * @return the value of hospital..disease_category.disease_code
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public String getDiseaseCode() {
        return diseaseCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..disease_category.disease_code
     *
     * @param diseaseCode the value for hospital..disease_category.disease_code
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode == null ? null : diseaseCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..disease_category.disease_name
     *
     * @return the value of hospital..disease_category.disease_name
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public String getDiseaseName() {
        return diseaseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..disease_category.disease_name
     *
     * @param diseaseName the value for hospital..disease_category.disease_name
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName == null ? null : diseaseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..disease_category.sequence_no
     *
     * @return the value of hospital..disease_category.sequence_no
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public Integer getSequenceNo() {
        return sequenceNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..disease_category.sequence_no
     *
     * @param sequenceNo the value for hospital..disease_category.sequence_no
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..disease_category.disease_type
     *
     * @return the value of hospital..disease_category.disease_type
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public Integer getDiseaseType() {
        return diseaseType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..disease_category.disease_type
     *
     * @param diseaseType the value for hospital..disease_category.disease_type
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public void setDiseaseType(Integer diseaseType) {
        this.diseaseType = diseaseType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospital..disease_category.valid
     *
     * @return the value of hospital..disease_category.valid
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospital..disease_category.valid
     *
     * @param valid the value for hospital..disease_category.valid
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }
}