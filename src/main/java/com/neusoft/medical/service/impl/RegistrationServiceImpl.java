package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.bean.PatientExample;
import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.bean.RegistrationExample;
import com.neusoft.medical.dao.*;
import com.neusoft.medical.service.registration.RegistrationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private MedicalRecordsMapper medicalRecordsMapper;

    @Override
    public Registration addRegistration(Registration record) throws Exception {
        // 新增挂号记录
        System.out.println("RegistrationInfoServiceImpl 尝试新增挂号: " + record.toString());
        int effectRow = registrationMapper.insert(record);
        System.out.println("RegistrationInfoServiceImpl 已新增挂号 " + effectRow + " 项");

        // 新增患者信息
        System.out.println("RegistrationInfoServiceImpl 新增患者信息: " + record.getPatientName());
        PatientExample patientExample = new PatientExample();
        PatientExample.Criteria criteria = patientExample.createCriteria();
        criteria.andValidEqualTo(1);
        criteria.andIdentityCardNoEqualTo(record.getIdentityCardNo());

        List<Patient> patientList = patientMapper.selectByExample(patientExample);
        if (patientList.size() > 1)
            throw new Exception("Duplicate patient identity ID");
        Patient patient = new Patient(null, record.getPatientName(), record.getBirthday(), null, record.getIdentityCardNo(), null, null, record.getGender(), 1, null, null, null);
        if (patientList.size() == 0) {
            // 暂无该患者信息
            patientMapper.insert(patient);
        } else {
            // 已有该患者信息
            patient.setPatientId(record.getPatientId());
            patientMapper.updateByPrimaryKey(patient);
        }

        // 病历记录在患者前往医生处就诊后生成
        return registrationMapper.selectByPrimaryKey(record.getRegistrationId());
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
    public List<Integer> historyRegistratioinIdList(int registrationId) {
        List<Registration> registrationList = historyRegistrationList(registrationId);

        List<Integer> registrationIdList = new CopyOnWriteArrayList<>(); // 构建患者的挂号单编号列表
        for (Registration registration : registrationList) {
            registrationIdList.add(registration.getRegistrationId());
        }
        return registrationIdList;
    }
}
