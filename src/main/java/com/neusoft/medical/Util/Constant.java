package com.neusoft.medical.Util;

public interface Constant {
    /**
     * 开销种类
     */
    int EXPENSE_CATEGORY_EXAM = 3;    // 检查费
    int EXPENSE_CATEGORY_DISPOSAL = 16;// 处置费

    /**
     * 收费状态
     */
    int PAY_STATE_NOT_CHARGED = 0; // 未支付
    int PAY_STATE_CHARGED = 1;     // 已支付
    int PAY_STATE_RETURNED = 2;    // 已退费

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

    /**
     * 执行状态
     */
    int EXEC_NOT_DONE = 0;             // 未执行或未完全执行
    int EXEC_DONE = 1;                 // 已执行

    /**
     * 挂号状态
     */
    String REGIST_WITHDRAW = "2";      // 退号
    String REGIST_IN_PROCESS = "1";    // 诊断过程中
    String REGIST_DONE = "0";          // 诊断结束
    String REGIST_NOT_VISITED = "0";   // 尚未就诊
    String REGIST_VISITED = "1";       // 就诊过

    /**
     * 午别
     */
    int NOON_ALL_DAY = 0;              // 全天
    int NOON_MORNING = 1;              // 上午
    int NOON_AFTERNOON = 2;            // 下午
}
