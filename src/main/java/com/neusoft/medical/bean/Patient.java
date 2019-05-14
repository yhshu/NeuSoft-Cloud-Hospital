package com.neusoft.medical.bean;

import java.io.Serializable;

public class Patient implements Serializable {
    private String patientId;
    private String patientName; // 患者姓名

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
