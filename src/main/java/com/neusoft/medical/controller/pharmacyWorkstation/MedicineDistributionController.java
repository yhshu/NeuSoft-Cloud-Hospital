package com.neusoft.medical.controller.pharmacyWorkstation;

import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.pharmacyWorkstation.MedicineDistributionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/medicine_distribute")
public class MedicineDistributionController {
    @Resource
    private MedicineDistributionService medicineDistributionService;

     /*
      按挂号单编号获取患者信息，参见 RegistrationController 类的 selectPatient 方法
     */

    /**
     * 按挂号单编号获取药品项列表
     *
     * @param registrationId 挂号单编号
     * @return 药品项列表，json 字符串
     */
    @GetMapping("/list_prescription_entry")
    public ResultDTO<String> selectPrescriptionEntryList(
            @RequestParam(value = "registrationId") Integer registrationId
    ) {
        String res = null;
        try {
            res = medicineDistributionService.selectPrescriptionEntryList(registrationId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }

    /**
     * 修改药品项目数目
     * 交付药品或收到退药
     *
     * @param prescriptionEntryListJson 药品项目信息，json 数组
     * @return 操作结果
     * prescriptionEntryListJson 数组中每个元素包含的属性：
     * - prescriptionEntryId 药品项编号
     * - executionNums       变动的药品数（交付药品为正数，收到退药为负数）
     */
    @GetMapping("/apply")
    public ResultDTO<Boolean> prescriptionEntryDelivery(@RequestParam(value = "prescriptionEntryListJson") String prescriptionEntryListJson) {
        Boolean res;
        try {
            res = medicineDistributionService.prescriptionEntryDelivery(prescriptionEntryListJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }
}
