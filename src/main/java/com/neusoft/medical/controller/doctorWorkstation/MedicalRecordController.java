package com.neusoft.medical.controller.doctorWorkstation;

import com.neusoft.medical.bean.MedicalRecords;
import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.OutpatientMedicalRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/doctor_work")
public class MedicalRecordController {
    @Resource
    private OutpatientMedicalRecordService outpatientMedicalRecordService;

    /**
     * 获取医生的待诊患者列表
     *
     * @param registrationScope 查询的挂号范围（所有 0；医生本人 1；医生所在科室 2）
     * @param doctorId          医生编号
     * @return 待诊患者列表
     */
    @GetMapping("/waiting_registration")
    public ResultDTO<List<Registration>> waitingRegistrationList(
            @RequestParam(value = "registrationScope") Integer registrationScope,
            @RequestParam(value = "doctorId") Integer doctorId
    ) {
        return new ResultDTO<>(outpatientMedicalRecordService.waitingRegistrationList(registrationScope, doctorId));
    }

    /**
     * 获取医生的已诊患者列表
     *
     * @param registrationScope 查询的挂号范围（所有 0；医生本人 1；医生所在科室 2）
     * @param doctorId          医生编号
     * @return 已诊患者列表
     */
    @GetMapping("/visited_registration")
    public ResultDTO<List<Registration>> visitedRegistrationList(
            @RequestParam(value = "registrationScope") int registrationScope,
            @RequestParam(value = "doctorId") int doctorId) {
        return new ResultDTO<>(outpatientMedicalRecordService.visitedRegistrationList(registrationScope, doctorId));

    }

    /**
     * 保存门诊病历信息（暂存 或 正式提交）
     * 在正式提交后之后，医生才可以进行检查、检验、处置、开立处方等操作
     * <p>
     * 病历记录包含的元素有：
     * - registrationId 挂号单编号
     * - mainInfo 主诉
     * - currentDisease 现病史
     * - pastDisease 既往史
     * - physicalExam 体格检查
     * - auxiliaryExam 辅助检查
     * - opinion 处理意见
     * - saveState 保存状态（暂存0 正式提交1）
     * - doctorId 填写病历的医生编号
     * - disease 评估/诊断（JSONArray）
     * <p>
     * 其中，disease 数组中的每个元素包含的元素有：
     * - diseaseId 诊断目录中的编号
     * - mainDisease 主诊（是1 否0）
     * - suspect 疑似（是1 否0）
     * - incidenceDate 发病日期
     *
     * @param medicalRecordJson 病历记录 json 字符串
     * @return 保存成功 true；保存失败 false
     */
    @GetMapping("/save_record")
    public ResultDTO<Boolean> saveMedicalRecord(@RequestParam(value = "medicalRecordJson") String medicalRecordJson) {
        try {
            outpatientMedicalRecordService.saveMedicalRecord(medicalRecordJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }

    /**
     * 保存门诊病历模板
     *
     * @param medicalRecordsId 病历编号（可为空）
     * @param mainInfo         主诉
     * @param currentDisease   现病史
     * @param pastDisease      既往史
     * @param physicalExam     体格检查
     * @param auxiliaryExam    辅助检查
     * @param opinion          处理意见
     * @param saveState        保存方式（全院可见 科室可见 或 医生本人可见）
     * @param doctorId         医生编号
     * @param templateName     病历模板名称
     * @return 操作结果
     */
    @GetMapping("/save_record_template")
    public ResultDTO<Boolean> saveMedicalRecordAsTemplate(
            @RequestParam(value = "medicalRecordsId", required = false) Integer medicalRecordsId,
            @RequestParam(value = "mainInfo") String mainInfo,
            @RequestParam(value = "currentDisease") String currentDisease,
            @RequestParam(value = "pastDisease") String pastDisease,
            @RequestParam(value = "physicalExam") String physicalExam,
            @RequestParam(value = "auxiliaryExam") String auxiliaryExam,
            @RequestParam(value = "opinion") String opinion,
            @RequestParam(value = "saveState") Integer saveState,
            @RequestParam(value = "doctorId") Integer doctorId,
            @RequestParam(value = "templateName") String templateName) {
        try {
            outpatientMedicalRecordService.saveMedicalRecordTemplate(medicalRecordsId, mainInfo, currentDisease, pastDisease, physicalExam, auxiliaryExam, opinion, saveState, doctorId, templateName);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }

    /**
     * 获取病历模板列表
     *
     * @param templateScope 查找的病历模板范围（全院模板2 科室模板3 医生模板4）
     * @param doctorId      医生编号
     * @return 指定范围的病历模板列表
     */
    @GetMapping("/select_record_template")
    public ResultDTO<List<MedicalRecords>> selectMedicalRecordsTemplateList(
            @RequestParam(value = "templateScope") Integer templateScope,
            @RequestParam(value = "doctorId") Integer doctorId
    ) {
        try {
            return new ResultDTO<>(outpatientMedicalRecordService.selectMedicalRecordsTemplateList(templateScope, doctorId));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(ResultDTO.CODE_SUCCESS, "Server exception", null);
        }
    }

    /**
     * 诊断结束
     * 结束看诊之后，针对该患者不能再进行任何检查、检验的申请以及药品的开立、收费等
     *
     * @param registrationId 挂号编号
     * @return 操作结果
     */
    @GetMapping("/end_registration")
    public ResultDTO<Boolean> endRegistration(
            @RequestParam(value = "registrationId") Integer registrationId) {
        try {
            outpatientMedicalRecordService.endRegistration(registrationId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }

    /**
     * 获取患者的历史病历列表
     *
     * @param registrationId 患者的挂号单编号
     * @return 患者的包括此次就诊在内的所有历史病历（包含诊断信息），json 字符串
     */
    @GetMapping("/history_record")
    public ResultDTO<String> selectPatientHistoryMedicalRecords(
            @RequestParam(value = "registrationId") Integer registrationId
    ) {
        String res;
        try {
            res = outpatientMedicalRecordService.selectPatientHistoryMedicalRecords(registrationId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new ResultDTO<>(res);
    }
}
