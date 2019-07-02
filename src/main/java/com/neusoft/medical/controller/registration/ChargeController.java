package com.neusoft.medical.controller.registration;

import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.registration.ChargeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 基础信息维护：收费、退费、退号 控制器
 */
@RestController
@RequestMapping("/charge")
public class ChargeController {
    @Resource
    private ChargeService chargeService;

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
    @GetMapping("/checkout")
    public ResultDTO<Boolean> checkout(
            @RequestParam(value = "checkoutJson") String checkoutJson
    ) {
        boolean res;
        try {
            res = chargeService.checkout(checkoutJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

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
    @GetMapping("/refund")
    public ResultDTO<Boolean> refund(
            @RequestParam(value = "refundJson") String refundJson
    ) {
        boolean res;
        try {
            res = chargeService.refund(refundJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

    /**
     * 退号，即撤回挂号
     *
     * @param registrationId 挂号单编号
     * @return 操作结果
     */
    @GetMapping("/withdraw_registration")
    public ResultDTO<Boolean> withdrawRegistration(
            @RequestParam(value = "registrationId") Integer registrationId
    ) {
        boolean res;
        try {
            res = chargeService.withdrawRegistration(registrationId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }
}
