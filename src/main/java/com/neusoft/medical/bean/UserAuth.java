package com.neusoft.medical.bean;

import java.util.Date;

public class UserAuth {
    private Integer userAuthId;

    private Integer userId;

    private Integer authId;

    private Integer valid;

    private Date operationTime;

    public UserAuth(Integer userAuthId, Integer userId, Integer authId, Integer valid, Date operationTime) {
        this.userAuthId = userAuthId;
        this.userId = userId;
        this.authId = authId;
        this.valid = valid;
        this.operationTime = operationTime;
    }

    public UserAuth() {
        super();
    }

    public Integer getUserAuthId() {
        return userAuthId;
    }

    public void setUserAuthId(Integer userAuthId) {
        this.userAuthId = userAuthId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}