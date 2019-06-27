package com.neusoft.medical.Util;

public interface Constant {
    /**
     * 开销种类 详见 expense_category 表
     */
    int EXPENSE_CATEGORY_REGISTRATION = 1;  // 挂号费
    int EXPENSE_CATEGORY_WESTERN_MEDICINE = 13; // 西药费
    int EXPENSE_CATEGORY_CHINESE_PATENT_MEDICINE = 14; // 中成药费
    int EXPENSE_CATEGORY_CHINESE_HERBAL_MEDICINE = 15; // 中草药费
    int EXPENSE_CATEGORY_EXAM = 3;          // 检查费
    int EXPENSE_CATEGORY_DISPOSAL = 16;     // 处置费

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

    /**
     * 收费项目的类别
     */
    int ENTRY_TYPE_CHARGE_ENTRY = 0;       // 检查检验项目、处置项目
    int ENTRY_TYPE_PRESCRIPTION_ENTRY = 1; // 药品

    /**
     * 登录状态反馈
     */
    String SIGNIN_SUCCESS = "signin_success";       // 登录完成
    String SIGNIN_MISMATCH = "signin_mismatch";  // 用户名或密码错误
    String SIGNIN_EXCEPTION = "signin_exception";// 登录异常：数据库存在用户名重复

    /**
     * 用户类别
     */
    String TYPE_OUTPATIENT_DOCTOR = "00";   // 门诊医生
    String TYPE_TECH_DOCTOR = "01";         // 医技医生
    String TYPE_COLLECTOR_STAFF = "10";     // 医院收费员
    String TYPE_PHARMACY_STAFF = "11";      // 药房操作员
    String TYPE_FINANCIAL_STAFF = "12";     // 财务管理员
    String TYPE_REGISTRATION_STAFF = "13";  // 挂号管理员
    String TYPE_SYSTEM_ADMIN = "20";        // 系统管理员

    /**
     * 支付记录状态
     */
    int INVOICE_VALID = 1;                  // 有效
    int INVOICE_RUSHED = 2;                 // 红冲
    int INVOICE_REINVOICE = 3;              // 重打
}
