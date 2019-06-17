package com.neusoft.medical.controller.doctorWorkstation;

import com.neusoft.medical.bean.Medicine;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.doctorWorkstation.PrescriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 成药处方、草药处方 控制器
 */
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Resource
    private PrescriptionService prescriptionService;

    @GetMapping("/list_medicine")
    public ResultDTO<List<Medicine>> selectMedicine() {
        List<Medicine> medicineList = null;
        try {
            medicineList = prescriptionService.selectMedicine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(medicineList);
    }
}
