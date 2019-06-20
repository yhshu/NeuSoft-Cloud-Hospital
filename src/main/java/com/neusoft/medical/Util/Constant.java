package com.neusoft.medical.Util;

public interface Constant {
    /**
     * 收费状态
     */
    int CHARGE_STATUS_NOT_CHARGED = 0;
    int CHARGE_STATUS_CHARGED = 1;
    int CHARGE_STATUS_RETURNED = 2;

    /**
     * 收费项目类别 常量
     */
    int CATEGORY_UNCHARGED = 0;
    int CATEGORY_CHARGED = 1;
    int CATEGORY_ALL = 2;

    /**
     * 收费状态
     */
    int CHARGE_STATUS_NOT_CHARGED = 0;
    int CHARGE_STATUS_CHARGED = 1;
    int CHARGE_STATUS_RETURNED = 2;

    /**
     * 处方保存状态
     */
    int SAVE_TEMP = 0; // 暂存
    int SAVE_FORMAL = 1; // 正式提交
    int SAVE_HOSPITAL_TEMPLATE = 2; // 全院模板
    int SAVE_DEPART_TEMPLATE = 3; // 科室模板
    int SAVE_DOCTOR_TEMPLATE = 4; // 医生个人模板
}
