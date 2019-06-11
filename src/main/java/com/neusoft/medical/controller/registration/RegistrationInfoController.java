package com.neusoft.medical.controller.registration;

import com.neusoft.medical.bean.Department;
import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.DepartmentService;
import com.neusoft.medical.service.DoctorService;
import com.neusoft.medical.service.PatientService;
import com.neusoft.medical.service.RegistrationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 挂号信息控制器
 */
@Controller
@RequestMapping("/registration")
public class RegistrationInfoController {
    @Resource
    private RegistrationInfoService registrationInfoService;

    @Resource
    private DoctorService doctorService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PatientService patientService;

    /**
     * 自动生成病历号
     *
     * @return 唯一的病历号
     */
    @RequestMapping("/auto_registration_id")
    public ResultDTO<Integer> registrationId() {
// todo
        return null;
    }


    /**
     * 获取挂号科室列表
     *
     * @return 可挂号的科室列表
     */
    @RequestMapping("/department_list")
    public ResultDTO<List<Department>> departmentList() {
// todo
        return null;

    }

    /**
     * 获取挂号医生列表
     *
     * @return 可挂号的医生列表
     */
    @RequestMapping("/doctor_list")
    public ResultDTO<List<Doctor>> doctorList() {
// todo
        return null;

    }

    /**
     * 获取患者个人信息
     *
     * @param identifyCardNO 患者身份证号
     * @return 如果找到，返回信息；如果未找到，被封装的患者信息为 null
     */
    @RequestMapping("/patient_info")
    public ResultDTO<Patient> patient(@RequestParam(value = "identify_card_no") String identifyCardNO) {
        System.out.println("获取患者信息 身份证号：" + identifyCardNO);
        Patient patient = patientService.selectPatientByIdentifyCardNo(identifyCardNO);
        return new ResultDTO<>(patient);
    }
}
