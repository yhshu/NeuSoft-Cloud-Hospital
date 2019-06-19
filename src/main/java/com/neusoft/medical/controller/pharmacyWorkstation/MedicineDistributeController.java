package com.neusoft.medical.controller.pharmacyWorkstation;

import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.dto.ResultDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 门诊发药 控制器
 */
@RestController
@RequestMapping("/medicine_distribute")
public class MedicineDistributeController {

    @RequestMapping("/patient_info")
    public ResultDTO<Patient> patient(
            @RequestParam(value = "registrationId") Integer registrationId
    ) {
        return null; // todo
    }
}
