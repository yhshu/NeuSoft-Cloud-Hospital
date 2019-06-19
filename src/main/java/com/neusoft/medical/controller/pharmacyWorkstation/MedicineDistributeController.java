package com.neusoft.medical.controller.pharmacyWorkstation;

import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.pharmacyWorkstation.MedicineDistributeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 门诊发药 控制器
 */
@RestController
@RequestMapping("/medicine_distribute")
public class MedicineDistributeController {
    @Resource
    private MedicineDistributeService medicineDistributeService;

    /**
     * 按挂号单编号获取患者信息
     *
     * @param registrationId 挂号单编号
     * @return 患者信息
     */
    @GetMapping("/patient_info")
    public ResultDTO<Patient> selectPatient(
            @RequestParam(value = "registrationId") Integer registrationId
    ) {
        Patient patient = null;
        try {
            patient = medicineDistributeService.selectPatient(registrationId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(patient);
    }

    /**
     * 按挂号单编号获取药品列表
     *
     * @param registrationId 挂号单编号
     * @return 药品列表，json 字符串
     */
    @GetMapping("/list_medicine")
    public ResultDTO<String> selectChargeFormList(
            @RequestParam(value = "registrationId") Integer registrationId) {
        String res = null;
        try {
            res = medicineDistributeService.selectChargeFormList(registrationId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }

    /**
     * 发放药品
     *
     * @param chargeFormIdList 被发放药品的编号列表
     * @return 操作结果
     */
    @GetMapping("/distribute")
    public ResultDTO<Boolean> medicineDistribute(
            @RequestParam(value = "chargeFormIdList[]") Integer[] chargeFormIdList
    ) {
        Boolean res = null;
        try {
            res = medicineDistributeService.medicineDistribute(Arrays.asList(chargeFormIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

    /**
     * 门诊退药
     * 退药数量不能超过可退数量，如果找出只按可退数量计算
     *
     * @param medicineReturnJson 退药信息，json 字符串
     * @return 操作结果
     * <p>
     * 退药信息 json 字符串是 json 数组，该数组中的每项元素包含如下属性：
     * - chargeFormId 收费项目的编号，int 型
     * - returnNums   退药数量，int 型
     */
    @GetMapping("/return")
    public ResultDTO<Boolean> medicineReturn(
            @RequestParam(value = "medicineReturn") String medicineReturnJson
    ) {
        Boolean res;
        try {
            res = medicineDistributeService.medicineReturn(medicineReturnJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }
}
