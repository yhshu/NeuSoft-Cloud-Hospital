package com.neusoft.medical.bean;

import java.util.Date;

public class Pathography {
    private Integer pathographyId;

    private Integer patientId;

    private String physicalExamination;

    private String pathography;

    private Date foundTime;

    private String note;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public Pathography(Integer pathographyId, Integer patientId, String physicalExamination, String pathography, Date foundTime, String note, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.pathographyId = pathographyId;
        this.patientId = patientId;
        this.physicalExamination = physicalExamination;
        this.pathography = pathography;
        this.foundTime = foundTime;
        this.note = note;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public Pathography() {
        super();
    }

    public Integer getPathographyId() {
        return pathographyId;
    }

    public void setPathographyId(Integer pathographyId) {
        this.pathographyId = pathographyId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPhysicalExamination() {
        return physicalExamination;
    }

    public void setPhysicalExamination(String physicalExamination) {
        this.physicalExamination = physicalExamination == null ? null : physicalExamination.trim();
    }

    public String getPathography() {
        return pathography;
    }

    public void setPathography(String pathography) {
        this.pathography = pathography == null ? null : pathography.trim();
    }

    public Date getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Date foundTime) {
        this.foundTime = foundTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
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