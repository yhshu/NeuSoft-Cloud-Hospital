package com.neusoft.medical.bean;

public class AccountTypePermission {
    private Integer accountTypePermissionId;

    private Integer accountType;

    private Integer permissionId;

    private Integer valid;

    public AccountTypePermission(Integer accountTypePermissionId, Integer accountType, Integer permissionId, Integer valid) {
        this.accountTypePermissionId = accountTypePermissionId;
        this.accountType = accountType;
        this.permissionId = permissionId;
        this.valid = valid;
    }

    public AccountTypePermission() {
        super();
    }

    public Integer getAccountTypePermissionId() {
        return accountTypePermissionId;
    }

    public void setAccountTypePermissionId(Integer accountTypePermissionId) {
        this.accountTypePermissionId = accountTypePermissionId;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}