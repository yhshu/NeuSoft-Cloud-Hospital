package com.neusoft.medical.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neusoft.medical.service.ConstantService;
import com.neusoft.medical.Util.converter.StringToDateConverter;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.*;
import com.neusoft.medical.service.doctorWorkstation.OutpatientMedicalRecordService;
import com.neusoft.medical.service.registration.RegistrationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.neusoft.medical.service.ConstantService.*;

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
    private StringToDateConverter stringToDateConverter;
    @Resource
    private DiseaseMapper diseaseMapper;
    @Resource
    private RegistrationService registrationService;

    private Gson gson = new Gson();

    @Override
    public List<Registration> waitingRegistrationList(int registrationScope, int doctorId) {
        RegistrationExample registrationExample = new RegistrationExample();
        try {
            RegistrationExample.Criteria criteria = registrationExample.createCriteria();
            criteria.andValidEqualTo(1).andRegistrationStatusEqualTo(REGIST_IN_PROCESS);
            if (registrationScope == REGIST_SCOPE_DOCTOR) {
                criteria.andDoctorIdEqualTo(doctorId);
            }
            if (registrationScope == REGIST_SCOPE_DEPRAT) {
                Doctor doctor = doctorMapper.selectByPrimaryKey(doctorId);
                int departmentId = doctor.getDepartmentId();
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
            criteria.andRegistrationStatusEqualTo(REGIST_DONE);
            if (registrationScope == REGIST_SCOPE_DOCTOR) {
                criteria.andDoctorIdEqualTo(doctorId);
            }
            if (registrationScope == REGIST_SCOPE_DEPRAT) {
                criteria.andDepartmentIdEqualTo(doctorMapper.selectByPrimaryKey(doctorId).getDepartmentId());
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
            System.out.println("saveMedicalRecord 提交病历记录：" + medicalRecordJson);
            JsonObject medicalRecordJsonObject = new JsonParser().parse(medicalRecordJson).getAsJsonObject();
            int registrationId = medicalRecordJsonObject.getAsJsonPrimitive("registrationId").getAsInt();
            String mainInfo = medicalRecordJsonObject.getAsJsonPrimitive("mainInfo").getAsString();
            String currentDisease = medicalRecordJsonObject.getAsJsonPrimitive("currentDisease").getAsString();
            String pastDisease = medicalRecordJsonObject.getAsJsonPrimitive("pastDisease").getAsString();
            String physicalExam = medicalRecordJsonObject.getAsJsonPrimitive("physicalExam").getAsString();
            String auxiliaryExam = medicalRecordJsonObject.getAsJsonPrimitive("auxiliaryExam").getAsString();
            String opinion = medicalRecordJsonObject.getAsJsonPrimitive("opinion").getAsString();
            int saveState = medicalRecordJsonObject.getAsJsonPrimitive("saveState").getAsInt();
            int doctorId = medicalRecordJsonObject.getAsJsonPrimitive("doctorId").getAsInt();

            JsonArray diseaseJsonArray = medicalRecordJsonObject.getAsJsonArray("disease");

            // 初步处理 json 字符串后，下面存储数据到数据库
            // 涉及 registration 表、medical_records 表和 record_disease 表

            if (saveState == SAVE_FORMAL) { // 正式提交病历记录时，修改挂号单为已就诊
                Registration registrationRecord = new Registration();
                registrationRecord.setRegistrationId(registrationId);
                registrationRecord.setIsVisited("1");  // 是否已就诊
                registrationMapper.updateByPrimaryKeySelective(registrationRecord);
            }

            // 存储病历信息到 medical_records 表
            // 如果病历记录已存在，则更新病历记录；如果病历记录尚不存在，则新增病历记录
            // 首先根据挂号单编号，判断是否存在病历记录
            MedicalRecordsExample medicalRecordsExample = new MedicalRecordsExample();
            MedicalRecordsExample.Criteria criteria = medicalRecordsExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andRegistrationIdEqualTo(registrationId);
            List<MedicalRecords> medicalRecordsList = medicalRecordsMapper.selectByExample(medicalRecordsExample); // 获得指定挂号单编号的病历记录
            MedicalRecords record = new MedicalRecords(null, registrationId, mainInfo, currentDisease, pastDisease, physicalExam, auxiliaryExam, opinion, 1, saveState, doctorId, null, null, null, null);
            int medicalRecordsId = -1;

            if (medicalRecordsList.isEmpty()) {
                // 新增病历记录
                medicalRecordsMapper.insert(record);
                medicalRecordsId = record.getMedicalRecordsId(); // 确保 MyBatis 生成的 DAO 可以在 insert 后返回主键
            } else {
                if (medicalRecordsList.size() > 1)
                    throw new Exception("The same registration contains duplicate medical records.");
                else {
                    // 更新病历记录
                    medicalRecordsMapper.updateByExampleSelective(record, medicalRecordsExample);
                    medicalRecordsId = medicalRecordsList.get(0).getMedicalRecordsId();
                }
            }

            // 存储病历中的评估/诊断信息到 record_disease 表

            RecordDisease recordDiseaseRecord = new RecordDisease();
            // 首先使之前的诊断记录失效
            recordDiseaseRecord.setValid(0);
            RecordDiseaseExample recordDiseaseExample = new RecordDiseaseExample();
            RecordDiseaseExample.Criteria recordDiseaseCriteria = recordDiseaseExample.createCriteria();
            recordDiseaseCriteria.andValidEqualTo(1);
            recordDiseaseCriteria.andMedicalRecordsIdEqualTo(medicalRecordsId);
            recordDiseaseMapper.updateByExampleSelective(recordDiseaseRecord, recordDiseaseExample);

            // 遍历存储诊断信息的 JSONArray，逐条存储
            for (int i = 0; i < diseaseJsonArray.size(); i++) {
                JsonObject diseaseJsonObject = diseaseJsonArray.get(i).getAsJsonObject();
                int diseaseId = diseaseJsonObject.getAsJsonPrimitive("diseaseId").getAsInt();
                int mainDisease = diseaseJsonObject.getAsJsonPrimitive("mainDisease").getAsInt();
                int suspect = diseaseJsonObject.getAsJsonPrimitive("suspect").getAsInt();
                String incidenceDate = diseaseJsonObject.getAsJsonPrimitive("incidenceDate").getAsString();
                Date incidenceDateConverted = stringToDateConverter.convert(incidenceDate);

                // 新增诊断记录
                if (-1 == medicalRecordsId)
                    throw new Exception("The corresponding medical record could not be found when saving the diagnostic record.");
                recordDiseaseRecord.setMedicalRecordsId(medicalRecordsId);
                recordDiseaseRecord.setDiseaseId(diseaseId);
                recordDiseaseRecord.setDiseaseIcd(diseaseMapper.selectByPrimaryKey(diseaseId).getDiseaseIcd());
                recordDiseaseRecord.setDiseaseName(diseaseMapper.selectByPrimaryKey(diseaseId).getDiseaseName());
                recordDiseaseRecord.setMainDisease(mainDisease);
                recordDiseaseRecord.setSuspect(suspect);
                recordDiseaseRecord.setIncidenceDate(incidenceDateConverted);
                recordDiseaseRecord.setValid(1);
                recordDiseaseMapper.insert(recordDiseaseRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean saveMedicalRecordTemplate(Integer medicalRecordsId, String mainInfo, String currentDisease, String pastDisease, String physicalExam, String auxiliaryExam, String opinion, Integer saveState, Integer doctorId, String templateName) {
        if (saveState == SAVE_TEMP || saveState == SAVE_FORMAL)
            return false;
        try {
            MedicalRecords medicalRecords = new MedicalRecords(null, null, mainInfo, currentDisease, pastDisease, physicalExam, auxiliaryExam, opinion, 1, saveState, doctorId, templateName, null, null, null);
            if (medicalRecordsId == null) { // 新增病历模板
                medicalRecordsMapper.insert(medicalRecords);
            } else {                        // 更新病历模板
                medicalRecords.setMedicalRecordsId(medicalRecordsId);
                medicalRecordsMapper.updateByPrimaryKey(medicalRecords);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<MedicalRecords> selectMedicalRecordsTemplateList(int templateScope, int doctorId) {
        MedicalRecordsExample medicalRecordsExample = new MedicalRecordsExample();
        try {
            MedicalRecordsExample.Criteria medicalRecordsExampleCriteria = medicalRecordsExample.createCriteria();
            medicalRecordsExampleCriteria.andValidEqualTo(1);
            medicalRecordsExampleCriteria.andSaveStateEqualTo(templateScope);

            if (templateScope == ConstantService.SAVE_DOCTOR_TEMPLATE) {
                // 查找医生本人可见的病历模板
                medicalRecordsExampleCriteria.andDoctorIdEqualTo(doctorId);
            } else if (templateScope == ConstantService.SAVE_DEPART_TEMPLATE) {
                // 查找医生所在科室的病历模板
                DoctorExample doctorExample = new DoctorExample();
                DoctorExample.Criteria doctorExampleCriteria = doctorExample.createCriteria();
                doctorExampleCriteria.andValidEqualTo(1).andDepartmentIdEqualTo(doctorMapper.selectByPrimaryKey(doctorId).getDepartmentId());
                List<Doctor> doctorListOfDepartment = doctorMapper.selectByExample(doctorExample);
                List<Integer> doctorIdListOfDepartment = new CopyOnWriteArrayList<>();
                for (Doctor doctor : doctorListOfDepartment) {
                    doctorIdListOfDepartment.add(doctor.getDoctorId());
                }
                medicalRecordsExampleCriteria.andDoctorIdIn(doctorIdListOfDepartment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicalRecordsMapper.selectByExample(medicalRecordsExample);
    }

    @Override
    public boolean endRegistration(int registrationId) {
        try {
            Registration registrationRecord = new Registration();
            registrationRecord.setRegistrationStatus(REGIST_DONE);

            RegistrationExample registrationExample = new RegistrationExample();
            registrationExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId);

            registrationMapper.updateByExampleSelective(registrationRecord, registrationExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String selectPatientHistoryMedicalRecords(Integer registrationId) {
        /*
         实现过程：
          1. 按挂号单编号获取相同患者的挂号单编号列表
          2. 找到每项挂号对应的历史病历
          3. 找到每项病历对应的诊断信息
          4. 将数据转换为 json 字符串返回
         */

        String res = null;
        try {
            // 构建患者的挂号单编号列表
            List<Integer> registrationIdList = registrationService.historyRegistrationIdList(registrationId);

            // 找到每项挂号对应的历史病历
            MedicalRecordsExample medicalRecordsExample = new MedicalRecordsExample();
            // 病历记录是有效的，且在患者的挂号单编号列表中，且已正式提交或确诊
            medicalRecordsExample.or().andValidEqualTo(1).andRegistrationIdIn(registrationIdList).andSaveStateEqualTo(SAVE_FORMAL);
            medicalRecordsExample.or().andValidEqualTo(1).andRegistrationIdIn(registrationIdList).andSaveStateEqualTo(SAVE_CONFIRMED);
            List<MedicalRecords> medicalRecordsList = medicalRecordsMapper.selectByExample(medicalRecordsExample);
            JsonArray medicalRecordsJsonArray = new JsonArray();
            for (MedicalRecords medicalRecords : medicalRecordsList) {
                JsonObject medicalRecordsJsonObject = gson.toJsonTree(medicalRecords).getAsJsonObject();
                medicalRecordsJsonObject.remove("templateName");
                medicalRecordsJsonObject.remove("valid");

                // 找到每项病历对应的诊断信息
                RecordDiseaseExample recordDiseaseExample = new RecordDiseaseExample();
                RecordDiseaseExample.Criteria recordDiseaseExampleCriteria = recordDiseaseExample.createCriteria();
                recordDiseaseExampleCriteria.andValidEqualTo(1);
                recordDiseaseExampleCriteria.andMedicalRecordsIdEqualTo(medicalRecords.getMedicalRecordsId());
                List<RecordDisease> recordDiseaseList = recordDiseaseMapper.selectByExample(recordDiseaseExample);
                System.out.println(gson.toJsonTree(recordDiseaseList));
                medicalRecordsJsonObject.addProperty("disease", gson.toJsonTree(recordDiseaseList).toString());
                medicalRecordsJsonArray.add(medicalRecordsJsonObject);
            }
            res = medicalRecordsJsonArray.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean deleteMedicalRecords(List<Integer> medicalRecordsIdList) {
        try {
            MedicalRecordsExample medicalRecordsExample = new MedicalRecordsExample();
            medicalRecordsExample.or().andValidEqualTo(1).andMedicalRecordsIdIn(medicalRecordsIdList);

            MedicalRecords medicalRecords = new MedicalRecords();
            medicalRecords.setValid(0);
            medicalRecordsMapper.updateByExampleSelective(medicalRecords, medicalRecordsExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
