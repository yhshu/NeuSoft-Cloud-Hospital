package com.neusoft.medical.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neusoft.medical.Util.DateConverter;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.*;
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
    private DepartmentMapper departmentMapper;

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
        List<Registration> waitingRegistrationList = registrationMapper.selectByExample(registrationExample);
        for (Registration registration : waitingRegistrationList) {
            // 保留位1：科室名称
            // 保留位2：医生姓名
            registration.setReserve1(departmentMapper.selectByPrimaryKey(registration.getDepartmentId()).getDepartmentName());
            registration.setReserve2(doctorMapper.selectByPrimaryKey(registration.getDoctorId()).getDoctorName());
        }
        return waitingRegistrationList;
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
        List<Registration> visitedRegistrationList = registrationMapper.selectByExample(registrationExample);
        for (Registration registration : visitedRegistrationList) {
            // 保留位1：科室名称
            // 保留位2：医生姓名
            registration.setReserve1(departmentMapper.selectByPrimaryKey(registration.getDepartmentId()).getDepartmentName());
            registration.setReserve2(doctorMapper.selectByPrimaryKey(registration.getDoctorId()).getDoctorName());
        }
        return visitedRegistrationList;
    }

    @Override
    public boolean saveMedicalRecord(String medicalRecordJson) {
        // 首先获取 json 字符串中的各变量
        // 然后将信息存入数据库中

        try {
            JsonObject medicalRecordJsonObject = new JsonParser().parse(medicalRecordJson).getAsJsonObject();
            int registrationId = medicalRecordJsonObject.getAsJsonObject("registrationId").getAsInt();
            String mainInfo = medicalRecordJsonObject.getAsJsonObject("mainInfo").getAsString();
            String currentDisease = medicalRecordJsonObject.getAsJsonObject("currentDisease").getAsString();
            String pastDisease = medicalRecordJsonObject.getAsJsonObject("pastDisease").getAsString();
            String physicalExam = medicalRecordJsonObject.getAsJsonObject("physicalExam").getAsString();
            String auxiliaryExam = medicalRecordJsonObject.getAsJsonObject("auxiliaryExam").getAsString();
            String opinion = medicalRecordJsonObject.getAsJsonObject("opinion").getAsString();
            int saveState = medicalRecordJsonObject.getAsJsonObject("saveState").getAsInt();

            JsonArray diseaseJsonArray = medicalRecordJsonObject.getAsJsonArray("disease");

            // 初步处理 json 字符串后，下面存储数据到数据库
            // 涉及 medical_records 表和 record_disease 表

            // 存储病历信息到 medical_records 表
            // 如果病历记录已存在，则更新病历记录；如果病历记录尚不存在，则新增病历记录
            // 首先根据挂号编号，判断是否存在病历记录
            MedicalRecordsExample medicalRecordsExample = new MedicalRecordsExample();
            MedicalRecordsExample.Criteria criteria = medicalRecordsExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andRegistrationIdEqualTo(registrationId);
            List<MedicalRecords> medicalRecordsList = medicalRecordsMapper.selectByExample(medicalRecordsExample); // 获得指定挂号编号的病历记录
            MedicalRecords record = new MedicalRecords(null, registrationId, mainInfo, currentDisease, pastDisease, physicalExam, auxiliaryExam, opinion, 1, saveState, null, null, null);
            if (medicalRecordsList.isEmpty()) {
                // 新增病历记录
                medicalRecordsMapper.insert(record);
            } else {
                if (medicalRecordsList.size() > 1)
                    throw new Exception("The same registration contains duplicate medical records.");
                else {
                    // 更新病历记录
                    medicalRecordsMapper.updateByExampleSelective(record, medicalRecordsExample);
                }
            }

            // 存储病历中的评估/诊断信息到 record_disease 表
            // 遍历存储诊断信息的 JSONArray，逐条存储
            for (int i = 0; i < diseaseJsonArray.size(); i++) {
                JsonObject diseaseJsonObject = diseaseJsonArray.get(i).getAsJsonObject();
                String diseaseId = diseaseJsonObject.getAsJsonObject("diseaseId").getAsString();
                int mainDisease = diseaseJsonObject.getAsJsonObject("mainDisease").getAsInt();
                int suspect = diseaseJsonObject.getAsJsonObject("suspect").getAsInt();
                String incidenceDate = diseaseJsonObject.getAsJsonObject("incidenceDate").getAsString();
                Date incidenceDateConverted = dateConverter.convert(incidenceDate);


            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
