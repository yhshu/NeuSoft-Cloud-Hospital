package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.bean.RegistrationExample;
import com.neusoft.medical.dao.DepartmentMapper;
import com.neusoft.medical.dao.DoctorMapper;
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

    @Override
    public Registration addRegistration(Registration record) {
        System.out.println("RegistrationInfoServiceImpl addRegistration: " + record.toString());
        int effectRow = registrationMapper.insert(record);
        System.out.println("RegistrationInfoServiceImpl addRegistration " + effectRow + " 项");
        return registrationMapper.selectByPrimaryKey(record.getRegistrationId());
    }

    @Override
    public PageInfo<Registration> listRegistration(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        RegistrationExample registrationExample = new RegistrationExample();

        List<Registration> registrationList = registrationMapper.selectByExample(registrationExample);
        for (Registration registration : registrationList) {
            registration.setReserve1(departmentMapper.selectByPrimaryKey(registration.getDepartmentId()).getDepartmentName()); // 保留位1：科室名称
            registration.setReserve2(doctorMapper.selectByPrimaryKey(registration.getDoctorId()).getDoctorName()); // 保留位2：医生姓名
        }
        return new PageInfo<>(registrationList);
    }
}
