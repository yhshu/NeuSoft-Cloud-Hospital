package com.neusoft.medical.controller.registration;

import com.neusoft.medical.bean.*;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.Resource;
import javax.print.Doc;
import java.util.Date;
import java.util.List;

/**
 * 挂号信息控制器
 */
@RestController
@RequestMapping("/registration")
public class RegistrationInfoController {
    @Resource
    private RegistrationInfoService registrationInfoService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PatientService patientService;

    @Resource
    private SchedulingService schedulingService;

    /**
     * 获取挂号科室列表
     *
     * @return 可挂号的科室列表
     */
    @GetMapping("/list_department")
    public ResultDTO<List<Department>> departmentList() {
        System.out.println("RegistrationInfoController 获取挂号科室列表");
        List<Department> departmentList = departmentService.findAllDepartment();
        return new ResultDTO<>(departmentList);
    }

    /**
     * 获取挂号医生列表
     *
     * @return 可挂号的医生列表
     */
    @GetMapping("/list_doctor")
    public ResultDTO<List<Doctor>> doctorList(@RequestParam("departmentId") Integer departmentId) {
        System.out.println("RegistrationInfoController 获取挂号医生列表");
        List<Doctor> doctorList = schedulingService.findCurrentAvailableDoctor(departmentId);
        if (doctorList.size() != 0)
            return new ResultDTO<>(doctorList);
        return new ResultDTO<>(20000, "not found", null);
    }

    /**
     * 获取患者个人信息
     *
     * @param identityCardNo 患者身份证号
     * @return 如果找到，返回信息；如果未找到，被封装的患者信息为 null
     */
    @GetMapping("/patient_info")
    public ResultDTO<Patient> patient(@RequestParam(value = "identityCardNo") String identityCardNo) {
        System.out.println("获取患者信息 身份证号：" + identityCardNo);
        Patient patient = patientService.selectPatientByIdentifyCardNo(identityCardNo);
        if (patient != null)
            return new ResultDTO<>(patient);
        return new ResultDTO<>(20000, "not found", null);
    }

    /**
     * 提交挂号信息
     */
    @PostMapping("/add_registration")
    public ResultDTO<Boolean> register(
            @RequestParam(value = "registrationId") Integer registrationId,
            @RequestParam(value = "patientName") String patientName,
            @RequestParam(value = "gender") String gender,
            @RequestParam(value = "age") Integer age,
            @RequestParam(value = "birthday") Date birthday,
            @RequestParam(value = "registrationCategory") String registrationCategory,
            @RequestParam(value = "medicalCategory") String medicalCategory,
            @RequestParam(value = "identityCardNo") String identityCardNo,
            @RequestParam(value = "registrationStatus") String registrationStatus,
            @RequestParam(value = "visitDate") Date visitDate,
            @RequestParam(value = "registrationDate") Date registrationDate,
            @RequestParam(value = "departmentId") Integer departmentId,
            @RequestParam(value = "doctorId") Integer doctorId,
            @RequestParam(value = "registrationSource") String registrationSource,
            @RequestParam(value = "settleAccountsCategory") String settleAccountsCategory,
            @RequestParam(value = "isVisited") String isVisited,
            @RequestParam(value = "familyAddress") String familyAddress,
            @RequestParam(value = "collectorId") Integer collectorId) {
        System.out.println("提交挂号信息");
        registrationInfoService.addRegistration(
                new Registration(registrationId, patientName, null, gender, age, birthday, registrationCategory, medicalCategory, identityCardNo, registrationStatus, visitDate, registrationDate, departmentId, doctorId, registrationSource, settleAccountsCategory, isVisited, 1, familyAddress, collectorId, null, null, null, null));
// todo 尚未测试
        return null;
    }

}
