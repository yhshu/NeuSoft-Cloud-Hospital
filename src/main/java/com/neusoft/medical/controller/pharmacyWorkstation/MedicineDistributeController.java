package com.neusoft.medical.controller.pharmacyWorkstation;

import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.pharmacyWorkstation.MedicineDistributeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @RequestMapping("/patient_info")
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
    @RequestMapping("/list_medicine")
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
}
