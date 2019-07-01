package com.neusoft.medical.controller.registration;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.Util.converter.StringToDateConverter;
import com.neusoft.medical.bean.Department;
import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.basicInfo.DepartmentService;
import com.neusoft.medical.service.basicInfo.PatientService;
import com.neusoft.medical.service.basicInfo.SchedulingService;
import com.neusoft.medical.service.registration.RegistrationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 挂号信息控制器
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Resource
    private RegistrationService registrationService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PatientService patientService;

    @Resource
    private SchedulingService schedulingService;

    @Resource
    private StringToDateConverter stringToDateConverter;

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
     * @param departmentId 科室编号
     * @return 可挂号的医生列表
     */
    @GetMapping("/list_doctor")
    public ResultDTO<List<Doctor>> doctorList(@RequestParam("departmentId") Integer departmentId) {
        System.out.println("RegistrationInfoController 获取挂号医生列表");
        List<Doctor> doctorList = schedulingService.findCurrentAvailableDoctor(departmentId);
        if (doctorList.size() != 0)
            return new ResultDTO<>(doctorList);
        return new ResultDTO<>(ResultDTO.CODE_SUCCESS, "not found", null);
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
        Patient patient = patientService.selectPatientByIdentityCardNo(identityCardNo);
        if (patient != null)
            return new ResultDTO<>(patient);
        return new ResultDTO<>(ResultDTO.CODE_SUCCESS, "not found", null);
    }

    /**
     * 提交挂号信息
     * 1. 添加挂号信息
     * 2. 添加患者信息
     *
     * @param patientName            患者姓名
     * @param gender                 患者性别
     * @param age                    患者年龄
     * @param birthday               患者生日
     * @param registrationCategoryId 挂号类型
     * @param medicalCategory        医疗类别
     * @param identityCardNo         患者身份证号
     * @param visitDate              预约日期（年-月-日）
     * @param registrationDate       挂号日期
     * @param departmentId           挂号科室编号
     * @param doctorId               看诊医生编号
     * @param registrationSource     挂号来源
     * @param settlementCategoryId   结算类别
     * @param familyAddress          家庭住址
     * @param collectorId            收费员编号
     * @return 挂号成功 true，挂号失败 false
     */
    @PostMapping("/add_registration")
    public ResultDTO<Boolean> addRegistration(
            @RequestParam(value = "patientName") String patientName,
            @RequestParam(value = "gender") String gender,
            @RequestParam(value = "age") Integer age,
            @RequestParam(value = "birthday") String birthday,
            @RequestParam(value = "registrationCategoryId") Integer registrationCategoryId,
            @RequestParam(value = "medicalCategory") String medicalCategory,
            @RequestParam(value = "identityCardNo") String identityCardNo,
            @RequestParam(value = "visitDate") String visitDate,
            @RequestParam(value = "registrationDate") String registrationDate,
            @RequestParam(value = "departmentId") Integer departmentId,
            @RequestParam(value = "doctorId") Integer doctorId,
            @RequestParam(value = "registrationSource") String registrationSource,
            @RequestParam(value = "settlementCategoryId") Integer settlementCategoryId,
            @RequestParam(value = "familyAddress") String familyAddress,
            @RequestParam(value = "collectorId") Integer collectorId) {

        Date visitDateConverted = stringToDateConverter.convert(visitDate);
        Date birthdayConverted = stringToDateConverter.convert(birthday);
        Date registrationDateConverted = stringToDateConverter.convert(registrationDate);
        try {
            registrationService.addRegistration(
                    new Registration(null, null, patientName, registrationCategoryId, gender, age, birthdayConverted, medicalCategory, identityCardNo, "1", visitDateConverted, registrationDateConverted, departmentId, doctorId, registrationSource, settlementCategoryId, "0", familyAddress, collectorId, null, 1, null, null, null));
            System.out.println("已提交挂号信息");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }

    /**
     * 分页获取挂号信息
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 分页的挂号信息
     */
    @GetMapping("/list_registration")
    public ResultDTO<PageInfo<Registration>> listRegistration(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize) {

        System.out.println("RegistrationInfoController listRegistration: 获取挂号列表");
        PageInfo<Registration> registrationList = registrationService.listRegistration(currentPage, pageSize);
        return new ResultDTO<>(registrationList);
    }

    /**
     * 按挂号编号获取挂号信息
     *
     * @param registrationId 挂号编号
     * @return 挂号信息
     */
    @GetMapping("/select_registration")
    public ResultDTO<Registration> selectRegistrationByPrimaryKey(
            @RequestParam(value = "registrationId") Integer registrationId) {
        System.out.println("RegistrationInfoController 按主键获取挂号信息");
        Registration registration = registrationService.selectRegistrationByPrimaryKey(registrationId);
        return new ResultDTO<>(registration);
    }

    /**
     * 按挂号单编号获取患者信息
     *
     * @param registrationId 挂号单编号
     * @return 患者信息
     */
    @GetMapping("/patient_info_by_registration")
    public ResultDTO<Patient> selectPatient(
            @RequestParam(value = "registrationId") Integer registrationId
    ) {
        Patient patient = null;
        try {
            patient = registrationService.selectPatientByRegistrationId(registrationId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(patient);
    }
}
