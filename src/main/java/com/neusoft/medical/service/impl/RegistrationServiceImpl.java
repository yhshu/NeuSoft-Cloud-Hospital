package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.*;
import com.neusoft.medical.service.registration.RegistrationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Resource
    private RegistrationMapper registrationMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private PatientMapper patientMapper;
    @Resource
    private RegistrationCategoryMapper registrationCategoryMapper;
    @Resource
    private SchedulingInfoMapper schedulingInfoMapper;
    @Resource
    private InvoiceMapper invoiceMapper;

    @Override
    public Registration addRegistration(Registration registrationRecord) throws Exception {
        // 新增患者信息
        System.out.println("RegistrationInfoServiceImpl 新增患者信息: " + registrationRecord.getPatientName());
        PatientExample patientExample = new PatientExample();
        patientExample.or().andValidEqualTo(1).andIdentityCardNoEqualTo(registrationRecord.getIdentityCardNo());

        List<Patient> patientList = patientMapper.selectByExample(patientExample);
        if (patientList.size() > 1)
            throw new Exception("Duplicate selectPatient identity ID");

        Patient patient = new Patient(null, registrationRecord.getPatientName(), registrationRecord.getBirthday(), null, registrationRecord.getIdentityCardNo(), null, registrationRecord.getFamilyAddress(), registrationRecord.getGender(), 1, null, null, null);
        System.out.println("RegistrationInfoServiceImpl 尝试新增挂号: " + registrationRecord.toString());
        if (patientList.size() == 0) {
            // 暂无该患者信息
            patientMapper.insert(patient);
            registrationRecord.setPatientId(patient.getPatientId());
        } else {
            // 已有该患者信息
            patientMapper.updateByExampleSelective(patient, patientExample);
            registrationRecord.setPatientId(patientList.get(0).getPatientId());
        }

        // 新增挂号记录
        int effectRow = registrationMapper.insert(registrationRecord);
        System.out.println("RegistrationInfoServiceImpl 已新增挂号 " + effectRow + " 项");

        // 医生的剩余号数减少
        SchedulingInfoExample schedulingInfoExample = new SchedulingInfoExample();
        Date todayDate = new Date();
        Date d1 = new Date(todayDate.getTime() / 86400000 * 86400000);
        Date d2 = new Date((todayDate.getTime() / 86400000 + 1) * 86400000 - 1);
        schedulingInfoExample.or().andValidEqualTo(1).andSchedulingTimeBetween(d1, d2);
        List<SchedulingInfo> schedulingInfoList = schedulingInfoMapper.selectByExample(schedulingInfoExample);
        if (schedulingInfoList != null && !schedulingInfoList.isEmpty()) {
            for (SchedulingInfo schedulingInfo : schedulingInfoList) {
                schedulingInfo.setLimitation(schedulingInfo.getLimitation() - 1);
                schedulingInfoMapper.updateByPrimaryKeySelective(schedulingInfo);
            }
        }

        // 此次挂号的收费记录
        double registrationFee = registrationCategoryMapper.selectByPrimaryKey(registrationRecord.getRegistrationCategoryId()).getRegistrationFee();
        Invoice invoiceRecord = new Invoice(null, registrationRecord.getPatientName(), registrationRecord.getCollectorId(), new Date(), registrationFee, registrationFee, 0.0, 0.0, 0.0, Constant.INVOICE_VALID, 1);
        invoiceMapper.insert(invoiceRecord);

        // 病历记录在患者前往医生处就诊后生成
        return registrationMapper.selectByPrimaryKey(registrationRecord.getRegistrationId());
    }

    @Override
    public PageInfo<Registration> listRegistration(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        RegistrationExample registrationExample = new RegistrationExample();

        List<Registration> registrationList = registrationMapper.selectByExample(registrationExample);
        for (Registration registration : registrationList) {
            // 保留位1：科室名称
            // 保留位2：医生姓名
            registration.setReserve1(departmentMapper.selectByPrimaryKey(registration.getDepartmentId()).getDepartmentName());
            registration.setReserve2(doctorMapper.selectByPrimaryKey(registration.getDoctorId()).getDoctorName());
        }
        return new PageInfo<>(registrationList);
    }

    @Override
    public Registration selectRegistrationByPrimaryKey(Integer registrationId) {
        System.out.println("RegistrationInfoServiceImpl 按主键获取挂号信息");
        Registration registration = registrationMapper.selectByPrimaryKey(registrationId);
        if (registration.getValid() == 0)
            return null;
        // 保留位1：科室名称
        // 保留位2：医生姓名
        registration.setReserve1(departmentMapper.selectByPrimaryKey(registration.getDepartmentId()).getDepartmentName());
        registration.setReserve2(doctorMapper.selectByPrimaryKey(registration.getDoctorId()).getDoctorName());
        return registration;
    }

    @Override
    public List<Registration> historyRegistrationList(int registrationId) {
        // 按挂号单编号获取相同患者的挂号单编号列表
        List<Registration> registrationList = null;
        try {
            int patientId = registrationMapper.selectByPrimaryKey(registrationId).getPatientId(); // 获取患者编号
            RegistrationExample registrationExample = new RegistrationExample();
            RegistrationExample.Criteria registrationExampleCriteria = registrationExample.createCriteria();
            registrationExampleCriteria.andValidEqualTo(1);        // 有效的挂号记录
            registrationExampleCriteria.andPatientIdEqualTo(patientId); // 对应当前患者
            registrationList = registrationMapper.selectByExample(registrationExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registrationList;
    }

    @Override
    public List<Integer> historyRegistrationIdList(int registrationId) {
        List<Registration> registrationList = historyRegistrationList(registrationId);

        List<Integer> registrationIdList = new CopyOnWriteArrayList<>(); // 构建患者的挂号单编号列表
        for (Registration registration : registrationList) {
            registrationIdList.add(registration.getRegistrationId());
        }
        return registrationIdList;
    }

    @Override
    public Patient selectPatientByRegistrationId(int registrationId) {
        Registration registration = registrationMapper.selectByPrimaryKey(registrationId);
        return patientMapper.selectByPrimaryKey(registration.getPatientId());

    }
}
