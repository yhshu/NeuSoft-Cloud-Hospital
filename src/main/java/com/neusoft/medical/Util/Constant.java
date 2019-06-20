package com.neusoft.medical.Util;

public interface Constant {
    /**
     * 开销种类
     */
    int EXPENSE_CATEGORY_EXAM = 3;     // 检查费

    /**
     * 收费状态
     */
    int CHARGE_STATUS_NOT_CHARGED = 0; // 未支付
    int CHARGE_STATUS_CHARGED = 1;     // 已支付
    int CHARGE_STATUS_RETURNED = 2;    // 已退费

    /**
     * 保存状态
     */
    int SAVE_TEMP = 0;                 // 暂存
    int SAVE_FORMAL = 1;               // 正式提交
    int SAVE_HOSPITAL_TEMPLATE = 2;    // 全院模板
    int SAVE_DEPART_TEMPLATE = 3;      // 科室模板
    int SAVE_DOCTOR_TEMPLATE = 4;      // 医生个人模板
    int SAVE_CONFIRMED = 5;            // 确诊

    /**
     * 挂号搜索范围
     */
    int REGIST_SCOPE_ALL = 0;          // 全院搜索
    int REGIST_SCOPE_DOCTOR = 1;       // 按医生搜索
    int REGIST_SCOPE_DEPRAT = 2;       // 按科室搜索
}
