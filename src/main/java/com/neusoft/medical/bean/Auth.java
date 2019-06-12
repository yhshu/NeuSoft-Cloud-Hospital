package com.neusoft.medical.bean;

public class Auth {
    private Integer authId;

    private String authName;

    private String authDescription;

    private Integer valid;

    public Auth(Integer authId, String authName, String authDescription, Integer valid) {
        this.authId = authId;
        this.authName = authName;
        this.authDescription = authDescription;
        this.valid = valid;
    }

    public Auth() {
        super();
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName == null ? null : authName.trim();
    }

    public String getAuthDescription() {
        return authDescription;
    }

    public void setAuthDescription(String authDescription) {
        this.authDescription = authDescription == null ? null : authDescription.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}