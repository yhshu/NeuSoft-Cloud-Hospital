package com.neusoft.medical.service.impl;

import com.google.gson.*;
import com.neusoft.medical.service.ConstantService;
import com.neusoft.medical.Util.MathUtil;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.ChargeEntryMapper;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.dao.ExaminationMapper;
import com.neusoft.medical.dao.RegistrationMapper;
import com.neusoft.medical.service.basicInfo.DoctorService;
import com.neusoft.medical.service.doctorWorkstation.ExaminationService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.neusoft.medical.service.ConstantService.*;

@Service
public class ExaminationServiceImpl implements ExaminationService {
    private Logger logger = Logger.getLogger(ExaminationService.class);

    @Resource
    private ChargeItemMapper chargeItemMapper;
    @Resource
    private ExaminationMapper examinationMapper;
    @Resource
    private ChargeEntryMapper chargeEntryMapper;
    @Resource
    private RegistrationMapper registrationMapper;
    @Resource
    private DoctorService doctorService;

    private Gson gson = new Gson();

    @Override
    public boolean addExamination(String examinationJson) {
        // 首先获取 json 字符串中的属性值，然后将提交的信息加入到 examination 表和 charge_entry 表
        try {
            System.out.println("添加检查检验项目　Json 字符串: " + examinationJson);
            JsonObject examinationJsonObject = new JsonParser().parse(examinationJson).getAsJsonObject();
            Integer registrationId = null;
            try {
                registrationId = examinationJsonObject.get("registrationId").getAsInt();
            } catch (Exception ignore) {
            }
            int saveState = examinationJsonObject.get("saveState").getAsInt();
            String examName = examinationJsonObject.get("examName").getAsString();
            String clinicalImpression = examinationJsonObject.get("clinicalImpression").getAsString();
            String requirement = examinationJsonObject.get("requirement").getAsString();
            String examResult = examinationJsonObject.get("examResult").getAsString();
            JsonArray chargeEntryListJsonArray = examinationJsonObject.get("chargeEntryList").getAsJsonArray();

            Registration registration = registrationMapper.selectByPrimaryKey(registrationId);
            Examination examinationRecord = new Examination(null, registrationId, registration.getPatientName(), registration.getDoctorId(), registration.getDepartmentId(), saveState, PAY_STATE_NOT_CHARGED, EXEC_NOT_DONE, examName, clinicalImpression, requirement, examResult, 1, null, null, null);
            examinationMapper.insert(examinationRecord);
            int examinationId = examinationRecord.getExaminationId();

            for (JsonElement chargeEntryJsonElement : chargeEntryListJsonArray) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                int chargeItemId = chargeEntryJsonObject.get("chargeItemId").getAsInt();
                int nums = chargeEntryJsonObject.get("nums").getAsInt();
                String doctorAdvice = chargeEntryJsonObject.get("doctorAdvice").getAsString();

                ChargeItem chargeItemRecord = chargeItemMapper.selectByPrimaryKey(chargeItemId);
                double unitPrice = MathUtil.doubleSetScale(chargeItemRecord.getPrice(), 2);
                double totalPrice = MathUtil.doubleSetScale(unitPrice, 2);
                ChargeEntry chargeEntryRecord = new ChargeEntry(null, registrationId, null, chargeItemId, examinationId, unitPrice, totalPrice, nums, nums, nums, ConstantService.PAY_STATE_NOT_CHARGED, new Date(), registration.getDepartmentId(), registration.getDoctorId(), null, 1, doctorAdvice, null, null, null);
                chargeEntryMapper.insert(chargeEntryRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<ChargeItem> selectExamListInChargeItemByDepartmentId(Integer departmentId) {
        ChargeItemExample chargeItemExample = new ChargeItemExample();
        ChargeItemExample.Criteria criteria = chargeItemExample.createCriteria();
        criteria.andValidEqualTo(1);
        criteria.andDepartmentIdEqualTo(departmentId);
        criteria.andExpenseCategoryIdEqualTo(EXPENSE_CATEGORY_EXAM);

        return chargeItemMapper.selectByExample(chargeItemExample);
    }

    @Override
    public String selectHistoryExam(int registrationId) {
        ExaminationExample examinationExample = new ExaminationExample();
        examinationExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId);

        List<Examination> examinationList = examinationMapper.selectByExample(examinationExample);
        JsonArray examinationJsonArray = gson.toJsonTree(examinationList).getAsJsonArray();
        for (JsonElement examinationJsonElement : examinationJsonArray) {
            JsonObject examinationJsonObject = examinationJsonElement.getAsJsonObject();
            int examinationId = examinationJsonObject.get("examinationId").getAsInt();

            // 针对每项检查，找到其收费项目列表
            ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
            chargeEntryExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId).andExaminationIdEqualTo(examinationId);
            List<ChargeEntry> chargeEntryList = chargeEntryMapper.selectByExample(chargeEntryExample);
            JsonArray chargeEntryListJsonArray = gson.toJsonTree(chargeEntryList).getAsJsonArray();
            for (JsonElement chargeEntryJsonElement : chargeEntryListJsonArray) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                ChargeItem chargeItem = chargeItemMapper.selectByPrimaryKey(chargeEntryJsonObject.get("chargeItemId").getAsInt());
                chargeEntryJsonObject.add("chargeItem", gson.toJsonTree(chargeItem));
            }
            examinationJsonObject.add("chargeEntryList", chargeEntryListJsonArray);
        }
        return examinationJsonArray.toString();
    }

    @Override
    public boolean updateExamResult(String examinationJson) {
        try {
            JsonObject examinationJsonObject = new JsonParser().parse(examinationJson).getAsJsonObject();
            int examinationId = examinationJsonObject.get("examinationId").getAsInt();
            String clinicalImpression = examinationJsonObject.get("clinicalImpression").getAsString();
            String examResult = examinationJsonObject.get("examResult").getAsString();
            Examination examinationRecord = new Examination();
            examinationRecord.setExaminationId(examinationId);
            examinationRecord.setClinicalImpression(clinicalImpression);
            examinationRecord.setExamResult(examResult);

            JsonArray chargeEntryList = examinationJsonObject.get("chargeEntryList").getAsJsonArray();
            for (JsonElement chargeEntryJsonElement : chargeEntryList) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                int chargeEntryId = chargeEntryJsonObject.get("chargeEntryId").getAsInt();
                int notGivenNums = chargeEntryJsonObject.get("notGivenNums").getAsInt();
                ChargeEntry chargeEntryRecord = new ChargeEntry();
                chargeEntryRecord.setChargeEntryId(chargeEntryId);
                chargeEntryRecord.setNotGivenNums(notGivenNums);
                chargeEntryMapper.updateByPrimaryKeySelective(chargeEntryRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUnpaidChargeEntry(List<Integer> chargeEntryIdList) {
        try {
            ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
            chargeEntryExample.or().andChargeEntryIdIn(chargeEntryIdList).andValidEqualTo(1).andPayStateEqualTo(PAY_STATE_NOT_CHARGED);

            ChargeEntry chargeEntryRecord = new ChargeEntry();
            chargeEntryRecord.setValid(0);
            chargeEntryMapper.updateByExampleSelective(chargeEntryRecord, chargeEntryExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteExaminationList(List<Integer> examinationIdList) {
        try {
            ExaminationExample examinationExample = new ExaminationExample();
            examinationExample.or().andValidEqualTo(1).andExaminationIdIn(examinationIdList);
            List<Examination> examinationList = examinationMapper.selectByExample(examinationExample);

            for (Examination examination : examinationList) {
                if (examination.getSaveState().equals(SAVE_FORMAL) && examination.getExecutionState().equals(ConstantService.EXEC_DONE))
                    continue;

                ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
                chargeEntryExample.or().andValidEqualTo(1).andExaminationIdEqualTo(examination.getExaminationId());

                ChargeEntry chargeEntryRecord = new ChargeEntry();
                chargeEntryRecord.setValid(0);
                chargeEntryMapper.updateByExampleSelective(chargeEntryRecord, chargeEntryExample);

                examination.setValid(0);
                examinationMapper.updateByPrimaryKey(examination);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String selectExaminationTemplate(Integer examinationScope, Integer doctorId) {
        String res = null;
        try {
            if (examinationScope != SAVE_HOSPITAL_TEMPLATE && examinationScope != SAVE_DEPART_TEMPLATE && examinationScope != SAVE_DOCTOR_TEMPLATE) {
                // 模板范围 参数非法
                logger.error("The search scope for templates is illegal");
                return null;
            }

            ExaminationExample examinationExample = new ExaminationExample();
            ExaminationExample.Criteria examinationExampleCriteria = examinationExample.createCriteria();
            examinationExampleCriteria.andValidEqualTo(1).andSaveStateEqualTo(examinationScope);
            if (examinationScope == SAVE_DEPART_TEMPLATE) {
                // 科室模板
                List<Integer> doctorIdList = doctorService.selectDepartmentDoctorIdListByDoctorId(doctorId);
                examinationExampleCriteria.andDoctorIdIn(doctorIdList);
            } else {
                // 医生个人模板
                examinationExampleCriteria.andDoctorIdEqualTo(doctorId);
            }

            List<Examination> examinationList = examinationMapper.selectByExample(examinationExample);
            res = examinationListToJson(examinationList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public String examinationListToJson(List<Examination> examinationList) {
        // todo
        String res = null;
        try {
            JsonArray examinationWithEntryJsonArray = new JsonArray();
            for (Examination examination : examinationList) {
                JsonObject examinationJsonObject = gson.toJsonTree(examination).getAsJsonObject();

                // 找到每张检查单对应的检查项目
                ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
                chargeEntryExample.or().andValidEqualTo(1).andExaminationIdEqualTo(examination.getExaminationId());
                List<ChargeEntry> chargeEntryList = chargeEntryMapper.selectByExample(chargeEntryExample);
                JsonArray chargeEntryListJsonArray = gson.toJsonTree(chargeEntryList).getAsJsonArray();
                for (JsonElement chargeEntryJsonElement : chargeEntryListJsonArray) {
                    JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                    chargeEntryJsonObject.add("chargeItem", gson.toJsonTree(chargeItemMapper.selectByPrimaryKey(chargeEntryJsonObject.get("chargeItemId").getAsInt())));
                }

                examinationJsonObject.add("chargeEntryList", chargeEntryListJsonArray);
                examinationWithEntryJsonArray.add(examinationJsonObject);
            }
            res = examinationWithEntryJsonArray.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
