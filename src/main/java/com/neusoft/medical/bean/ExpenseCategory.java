package com.neusoft.medical.bean;

public class ExpenseCategory {
    private Integer expenseCategoryId;

    private String expenseCode;

    private String expenseName;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public ExpenseCategory(Integer expenseCategoryId, String expenseCode, String expenseName, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.expenseCategoryId = expenseCategoryId;
        this.expenseCode = expenseCode;
        this.expenseName = expenseName;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public ExpenseCategory() {
        super();
    }

    public Integer getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(Integer expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    public String getExpenseCode() {
        return expenseCode;
    }

    public void setExpenseCode(String expenseCode) {
        this.expenseCode = expenseCode == null ? null : expenseCode.trim();
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName == null ? null : expenseName.trim();
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