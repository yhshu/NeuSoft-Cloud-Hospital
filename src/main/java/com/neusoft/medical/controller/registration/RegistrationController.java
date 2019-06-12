package com.neusoft.medical.controller.registration;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.Util.DateConverter;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.*;
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
    private RegistrationInfoService registrationInfoService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PatientService patientService;

    @Resource
    private SchedulingService schedulingService;

    @Resource
    private DateConverter dateConverter;

    @Resource
    private ChargeFormService chargeFormService;

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
     * <p>
     * 1. 添加挂号信息
     * 2. 添加患者信息
     *
     * @param patientName            患者姓名
     * @param gender                 患者性别
     * @param age                    患者年龄
     * @param birthday               患者生日
     * @param registrationCategory   挂号类型
     * @param medicalCategory        医疗类别
     * @param identityCardNo         患者身份证号
     * @param registrationDate       挂号日期
     * @param departmentId           挂号科室编号
     * @param doctorId               看诊医生编号
     * @param registrationSource     挂号来源
     * @param settleAccountsCategory 结算类别
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
            @RequestParam(value = "registrationCategory") String registrationCategory,
            @RequestParam(value = "medicalCategory") String medicalCategory,
            @RequestParam(value = "identityCardNo") String identityCardNo,
            @RequestParam(value = "registrationDate") String registrationDate,
            @RequestParam(value = "departmentId") Integer departmentId,
            @RequestParam(value = "doctorId") Integer doctorId,
            @RequestParam(value = "registrationSource") String registrationSource,
            @RequestParam(value = "settleAccountsCategory") String settleAccountsCategory,
            @RequestParam(value = "familyAddress") String familyAddress,
            @RequestParam(value = "collectorId") Integer collectorId) {

        Date birthdayConverted = dateConverter.convert(birthday);
        Date registrationDateConverted = dateConverter.convert(registrationDate);
        try {
            registrationInfoService.addRegistration(
                    new Registration(null, patientName, null, gender, age, birthdayConverted, registrationCategory, medicalCategory, identityCardNo, null, null, registrationDateConverted, departmentId, doctorId, registrationSource, settleAccountsCategory, null, 1, familyAddress, collectorId, null, null, null, null));
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
        PageInfo<Registration> registrationList = registrationInfoService.listRegistration(currentPage, pageSize);
        return new ResultDTO<>(registrationList);
    }

    /**
     * 按挂号编号获取挂号信息
     *
     * @param registrationId 挂号编号
     * @return 挂号信息
     */
    @GetMapping("/select_registration")
    public ResultDTO<Registration> selectRegistrationByPrimaryKey(@RequestParam(value = "registrationId") Integer registrationId) {
        System.out.println("RegistrationInfoController 按主键获取挂号信息");
        Registration registration = registrationInfoService.selectRegistrationByPrimaryKey(registrationId);
        return new ResultDTO<>(registration);
    }

    @GetMapping("/charge_form")
    public ResultDTO<PageInfo<ChargeForm>> selectChargeForm(@RequestParam(value = "currentPage") Integer currentPage, @RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "registrationId") Integer registrationId) {
        System.out.println("RegistrationController 按挂号编号获取收费账单");
        PageInfo<ChargeForm> chargeFormPageInfo = chargeFormService.selectChargeFormByRegistrationId(currentPage, pageSize, registrationId);
        return new ResultDTO<>(chargeFormPageInfo);
    }
}
