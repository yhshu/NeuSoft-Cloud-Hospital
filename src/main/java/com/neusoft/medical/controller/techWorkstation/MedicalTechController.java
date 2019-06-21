package com.neusoft.medical.controller.techWorkstation;

import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.techWorkstation.MedicalTechService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 医技工作站 控制器
 */
@RestController
@RequestMapping("/medical_tech")
public class MedicalTechController {
    @Resource
    private MedicalTechService medicalTechService;

    /*
      按挂号单编号获取患者信息，参见 RegistrationController 类的 selectPatient 方法
     */

    /**
     * 按挂号单编号获取收费项目列表
     *
     * @param registrationId 挂号单编号
     * @return 收费项目列表，json 字符串
     */
    @GetMapping("/list_charge_entry")
    public ResultDTO<String> selectChargeEntryList(
            @RequestParam(value = "registrationId") Integer registrationId) {
        String res = null;
        try {
            res = medicalTechService.selectChargeEntryList(registrationId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }

    /**
     * 应用收费项目
     *
     * @param chargeEntryListJson 收费项目信息，json 数组
     * @return 操作结果
     * chargeEntryListJson 数组中每个元素包含的属性：
     * - chargeEntryId 收费项目编号
     * - executionNums 此次消耗的项目数
     */
    @GetMapping("/apply")
    public ResultDTO<Boolean> chargeEntryListApply(
            @RequestParam("chargeEntryListJson") String chargeEntryListJson) {
        Boolean res;
        try {
            res = medicalTechService.chargeEntryListApply(chargeEntryListJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

    /**
     * 收费项目退费
     * 收费项目只有在执行前可退，执行后的收费项目无法退费
     *
     * @param chargeEntryListRefundJson 退费信息，json 字符串
     * @return 操作结果
     * <p>
     * 退费信息 json 字符串是 json 数组，该数组中的每项元素包含如下属性：
     * - chargeId 收费项目的编号，int 型
     * - returnNums   退费数量，int 型
     */
    @GetMapping("/return")
    public ResultDTO<Boolean> chargeEntryListRefund(
            @RequestParam(value = "chargeEntryListRefund") String chargeEntryListRefundJson
    ) {
        Boolean res;
        try {
            res = medicalTechService.chargeEntryListRefund(chargeEntryListRefundJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }
}
