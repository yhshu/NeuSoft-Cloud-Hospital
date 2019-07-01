package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.DoctorExample;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.service.basicInfo.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> findAllDoctor() {
        DoctorExample doctorExample = new DoctorExample();
        DoctorExample.Criteria criteria = doctorExample.createCriteria();
        criteria.andValidEqualTo(1);
        return doctorMapper.selectByExample(doctorExample);
    }

    @Override
    public List<Doctor> selectDepartmentDoctorListByDoctorId(Integer doctorId) {
        Doctor doctor = doctorMapper.selectByPrimaryKey(doctorId);
        if (doctor.getDepartmentId() == null) {
            // 该医生没有所属科室，返回的医生列表仅包含该医生1人
            List<Doctor> doctorList = new CopyOnWriteArrayList<>();
            doctorList.add(doctor);
            return doctorList;
        } else {
            // 该医生有所属科室，返回该科室所有医生的列表
            DoctorExample doctorExample = new DoctorExample();
            doctorExample.or().andValidEqualTo(1).andDepartmentIdEqualTo(doctorMapper.selectByPrimaryKey(doctorId).getDepartmentId());
            return doctorMapper.selectByExample(doctorExample);
        }
    }

    @Override
    public List<Integer> selectDepartmentDoctorIdListByDoctorId(Integer doctorId) {
        List<Doctor> doctorList = selectDepartmentDoctorListByDoctorId(doctorId);
        List<Integer> doctorIdList = new CopyOnWriteArrayList<>();
        for (Doctor doctor : doctorList) {
            doctorIdList.add(doctor.getDoctorId());
        }
        return doctorIdList;
    }

}
