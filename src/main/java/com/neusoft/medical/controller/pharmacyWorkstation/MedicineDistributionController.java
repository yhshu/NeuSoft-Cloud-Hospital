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

}
