package com.neusoft.medical.controller.registration;

import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.registration.ChargeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/charge")
public class ChargeController {
    @Resource
    private ChargeService chargeService;

    /**
     * 收费（包括检查检验项目、处置项目、药品等收费项目）
     *
     * @param checkoutJson 收费信息，json 字符串
     * @return 操作结果
     * checkoutJson 字符串中的属性包括：
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
     * @param refundJson 退费信息，json 字符串
     * @return 操作结果
     * refundJson 字符串中的属性包括：
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

//    @GetMapping("select_history_cost")
//    public ResultDTO<String >
}
