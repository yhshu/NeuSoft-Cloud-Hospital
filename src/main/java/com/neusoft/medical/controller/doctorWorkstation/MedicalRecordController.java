package com.neusoft.medical.controller.doctorWorkstation;

import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.OutpatientMedicalRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/doctor_work")
public class MedicalRecordController {
    @Resource
    private OutpatientMedicalRecordService outpatientMedicalRecordService;

    /**
     * 获取医生的待诊患者列表
     *
     * @param registrationScope 查询的挂号范围：0 所有；1 医生本人；2 医生所在科室
     * @param doctorId          医生编号
     * @return 待诊患者列表
     */
    @GetMapping("/waiting_registration")
    public ResultDTO<List<Registration>> waitingRegistrationList(
            @RequestParam(value = "registrationScope") Integer registrationScope,
            @RequestParam(value = "doctorId") Integer doctorId
    ) {
        return new ResultDTO<>(outpatientMedicalRecordService.waitingRegistrationList(registrationScope, doctorId));
    }

    /**
     * 获取医生的已诊患者列表
     *
     * @param registrationScope 查询的挂号范围：0 所有；1 医生本人；2 医生所在科室
     * @param doctorId          医生编号
     * @return 已诊患者列表
     */
    @GetMapping("/visited_registration")
    public ResultDTO<List<Registration>> visitedRegistrationList(
            @RequestParam(value = "registrationScope") int registrationScope,
            @RequestParam(value = "doctorId") int doctorId) {
        return new ResultDTO<>(outpatientMedicalRecordService.visitedRegistrationList(registrationScope, doctorId));

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
