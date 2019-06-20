package com.neusoft.medical.bean;

public class ChargeForm {
    private Integer chargeFormId;

    private Integer registrationId;

    private Integer saveState;

    private Integer valid;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    public ChargeForm(Integer chargeFormId, Integer registrationId, Integer saveState, Integer valid, String reserve1, String reserve2, String reserve3) {
        this.chargeFormId = chargeFormId;
        this.registrationId = registrationId;
        this.saveState = saveState;
        this.valid = valid;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
    }

    public ChargeForm() {
        super();
    }

    public Integer getChargeFormId() {
        return chargeFormId;
    }

    public void setChargeFormId(Integer chargeFormId) {
        this.chargeFormId = chargeFormId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getSaveState() {
        return saveState;
    }

    public void setSaveState(Integer saveState) {
        this.saveState = saveState;
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