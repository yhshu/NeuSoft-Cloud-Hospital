package com.neusoft.medical.service.registration;

/**
 * 基础信息维护：收费、退费、退号服务
 */
public interface ChargeService {

    /**
     * 收费（包括检查检验项目、处置项目、药品等收费项目）
     *
     * @param checkoutJson 收费信息，json 数组
     * @return 操作结果
     * checkoutJson 是一个 json 字符串，其属性包括：
     * - invoiceTitle 支付者
     * - collectorId 收银员编号
     * - invoiceNums 发票数量
     * - registrationId 挂号单编号
     * - invoiceAmount 找零后的实际入账金额
     * - selfPay 自费支付金额
     * - accountPay 账户支付金额
     * - reimbursementPay 报销支付金额
     * - discounted 优惠金额
     * - invoiceState 发票状态（有效 1）
     * - entryList 收费项目的列表，json 数组
     * <p>
     * 其中，entryList 数组中每个元素包含的属性：
     * - entryType: charge_entry: 0, prescription_entry: 1
     * - entryId    收费条目或处方条目的编号
     */
    boolean checkout(String checkoutJson);

    /**
     * 退费（包括检查检验项目、处置项目、药品等收费项目）
     *
     * @param refundJson 退费信息，json 数组
     * @return 操作结果
     * refundJson 是一个 json 字符串，其属性包括：
     * - invoiceTitle 退费者
     * - collectorId 收银员编号
     * - invoiceNums 发票数量
     * - registrationId 挂号单编号
     * - entryList 退费项目的列表，json 数组
     * <p>
     * 其中，entryList 数组中每个元素包含的属性：
     * - entryType: charge_entry: 0, prescription_entry: 1
     * - entryId    收费条目或处方条目的编号
     * - refundNums 退费数量
     */
    boolean refund(String refundJson);

    /**
     * 退号，即撤回挂号
     *
     * @param registrationId 挂号单编号
     * @return 操作结果
     */
    boolean withdrawRegistration(Integer registrationId);
}
