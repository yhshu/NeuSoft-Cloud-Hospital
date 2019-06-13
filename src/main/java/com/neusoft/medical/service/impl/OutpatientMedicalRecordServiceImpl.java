package com.neusoft.medical.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neusoft.medical.Util.DateConverter;
import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.bean.RegistrationExample;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.dao.MedicalRecordsMapper;
import com.neusoft.medical.dao.RecordDiseaseMapper;
import com.neusoft.medical.dao.RegistrationMapper;
import com.neusoft.medical.service.OutpatientMedicalRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class OutpatientMedicalRecordServiceImpl implements OutpatientMedicalRecordService {

    @Resource
    private RegistrationMapper registrationMapper;

    @Resource
    private MedicalRecordsMapper medicalRecordsMapper;

    @Resource
    private RecordDiseaseMapper recordDiseaseMapper;

    @Resource
    private DoctorMapper doctorMapper;

    @Resource
    private DateConverter dateConverter;

    public final int REGIST_SCOPE_ALL = 0;
    public final int REGIST_SCOPE_DOCTOR = 1;
    public final int REGIST_SCOPE_DEPRAT = 2;

    @Override
    public List<Registration> waitingRegistrationList(int registrationScope, int doctorId) {
        RegistrationExample registrationExample = new RegistrationExample();
        try {
            RegistrationExample.Criteria criteria = registrationExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andIsVisitedEqualTo("0");
            if (registrationScope == REGIST_SCOPE_DOCTOR) {
                criteria.andDoctorIdEqualTo(doctorId);
            }
            if (registrationScope == REGIST_SCOPE_DEPRAT) {
                Doctor doctor = doctorMapper.selectByPrimaryKey(doctorId);
                int departmentId = doctor.getDepartment();
                criteria.andDepartmentIdEqualTo(departmentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CopyOnWriteArrayList<>();
        }
        return registrationMapper.selectByExample(registrationExample);
    }

    @Override
    public List<Registration> visitedRegistrationList(int registrationScope, int doctorId) {
        RegistrationExample registrationExample = new RegistrationExample();
        try {
            RegistrationExample.Criteria criteria = registrationExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andIsVisitedEqualTo("1");
            if (registrationScope == REGIST_SCOPE_DOCTOR) {
                criteria.andDoctorIdEqualTo(doctorId);
            }
            if (registrationScope == REGIST_SCOPE_DEPRAT) {
                Doctor doctor = doctorMapper.selectByPrimaryKey(doctorId);
                int departmentId = doctor.getDepartment();
                criteria.andDepartmentIdEqualTo(departmentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CopyOnWriteArrayList<>();
        }
        return registrationMapper.selectByExample(registrationExample);
    }

    @Override
    public boolean saveMedicalRecord(String medicalRecordJson) {
        // 首先获取 json 字符串中的各变量
        // 然后将信息存入数据库中

        try {
            JsonObject medicalRecordJsonObject = new JsonParser().parse(medicalRecordJson).getAsJsonObject();
            String registrationId = medicalRecordJsonObject.getAsJsonObject("registrationId").getAsString();
            String mainInfo = medicalRecordJsonObject.getAsJsonObject("mainInfo").getAsString();
            String currentDisease = medicalRecordJsonObject.getAsJsonObject("currentDisease").getAsString();
            String pastDisease = medicalRecordJsonObject.getAsJsonObject("pastDisease").getAsString();
            String physicalExam = medicalRecordJsonObject.getAsJsonObject("physicalExam").getAsString();
            String auxiliaryExam = medicalRecordJsonObject.getAsJsonObject("auxiliaryExam").getAsString();
            String opinion = medicalRecordJsonObject.getAsJsonObject("opinion").getAsString();
            int saveState = medicalRecordJsonObject.getAsJsonObject("saveState").getAsInt();

            JsonObject diseaseJsonObject = medicalRecordJsonObject.getAsJsonObject("disease");

            String diseaseId = diseaseJsonObject.getAsJsonObject("diseaseId").getAsString();
            int mainDisease = diseaseJsonObject.getAsJsonObject("mainDisease").getAsInt();
            int suspect = diseaseJsonObject.getAsJsonObject("suspect").getAsInt();
            String incidenceDate = diseaseJsonObject.getAsJsonObject("incidenceDate").getAsString();
            Date incidenceDateConverted = dateConverter.convert(incidenceDate);

            // todo
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
