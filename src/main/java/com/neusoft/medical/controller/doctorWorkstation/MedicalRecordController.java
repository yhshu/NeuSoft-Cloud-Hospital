package com.neusoft.medical.controller.doctorWorkstation;

import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.OutpatientMedicalRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/doctor_work")
public class MedicalRecordController {

    @Resource
    private OutpatientMedicalRecordService outpatientMedicalRecordService;

    /**
     * 根据挂号编号查找患者信息
     * @param registrationId 挂号编号
     * @param patientScope   患者搜索范围：所有患者 0，本医生患者 1，本科室患者 2
     * @param doctorId       医生编号
     * @return 患者信息
     */
    @RequestMapping("/select_patient_by_registration")
    public ResultDTO<Patient> selectPatient(
            @RequestParam(value = "registrationId") Integer registrationId,
            @RequestParam(value = "patientScope") Integer patientScope,
            @RequestParam(value = "doctorId") Integer doctorId
    ) {
        Patient patient;
        try {
            patient = outpatientMedicalRecordService.selectPatientByRegistrationId(registrationId, patientScope, doctorId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new ResultDTO<>(patient);
    }

    @RequestMapping("/submit_record")
    public ResultDTO<Boolean> submitMedicalRecord(

    ) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }
}
