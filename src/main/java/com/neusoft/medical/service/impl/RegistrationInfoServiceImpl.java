package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.PatientExample;
import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.bean.RegistrationExample;
import com.neusoft.medical.dao.DepartmentMapper;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.dao.PatientMapper;
import com.neusoft.medical.dao.RegistrationMapper;
import com.neusoft.medical.service.RegistrationInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegistrationInfoServiceImpl implements RegistrationInfoService {
    @Resource
    private RegistrationMapper registrationMapper;

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private DoctorMapper doctorMapper;

    @Resource
    private PatientMapper patientMapper;

    @Override
    public Registration addRegistration(Registration record) {
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
//        if(patientMapper.selectByExample(patientExample))

        // 新增病历记录

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
}
