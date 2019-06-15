package com.neusoft.medical.service.doctorWorkstation;

import com.neusoft.medical.bean.MedicalRecords;
import com.neusoft.medical.bean.Registration;

import java.util.List;

/**
 * 门诊医生工作站
 * 门诊病历首页
 */
public interface OutpatientMedicalRecordService {
    /**
     * 挂号搜索范围
     */
    int REGIST_SCOPE_ALL = 0;
    int REGIST_SCOPE_DOCTOR = 1;
    int REGIST_SCOPE_DEPRAT = 2;

    /**
     * 病历保存状态
     */
    int SAVE_TEMP = 0; // 暂存
    int SAVE_FORMAL = 1; // 正式提交
    int SAVE_HOSPITAL_TEMPLATE = 2; // 全院模板
    int SAVE_DEPART_TEMPLATE = 3; // 科室模板
    int SAVE_DOCTOR_TEMPLATE = 4; // 医生个人模板

    /**
     * 获取医生的待诊患者列表
     *
     * @param registrationScope 查询的挂号范围
     * @param doctorId          医生编号
     * @return 待诊患者列表
     */
    List<Registration> waitingRegistrationList(int registrationScope, int doctorId);

    /**
     * 获取医生的已诊患者列表
     *
     * @param registrationScope 查询的挂号范围
     * @param doctorId          医生编号
     * @return 已诊患者列表
     */
    List<Registration> visitedRegistrationList(int registrationScope, int doctorId);

    /**
     * 保存门诊病历信息
     * 保存状态是暂存或正式提交
     * 在正式提交后之后，医生才可以进行检查、检验、处置、开立处方等操作
     *
     * @param medicalRecordJson 病历记录 json 字符串
     * @return 保存成功 true；保存失败 false
     */
    boolean saveMedicalRecord(String medicalRecordJson);

    /**
     * 将门诊病历信息存为模板
     *
     * @param medicalRecordsId 病历编号（可为空）
     * @param mainInfo         主诉
     * @param currentDisease   现病史
     * @param pastDisease      既往史
     * @param physicalExam     体格检查
     * @param auxiliaryExam    辅助检查
     * @param opinion          处理意见
     * @param saveState        保存状态
     * @param doctorId         医生编号
     * @param templateName     病历模板名称
     * @return 操作结果
     */
    boolean saveMedicalRecordTemplate(Integer medicalRecordsId, String mainInfo, String currentDisease, String pastDisease, String physicalExam, String auxiliaryExam, String opinion, Integer saveState, Integer doctorId, String templateName);

    /**
     * 获取病历模板列表
     *
     * @param templateScope 查找的病历模板范围
     * @param doctorId      医生编号
     * @return 指定范围的病历模板列表
     */
    List<MedicalRecords> selectMedicalRecordsTemplateList(int templateScope, int doctorId);

    /**
     * 诊断结束
     * 结束看诊之后，针对该患者不能再进行任何检查、检验的申请以及药品的开立、收费等
     *
     * @param registrationId 挂号编号
     * @return 操作结果
     */
    boolean endRegistration(int registrationId);

    /**
     * 获取患者历史病历
     *
     * @param registrationId 患者的挂号编号
     * @return 患者的历史病历记录
     */
    String selectPatientHistoryMedicalRecords(Integer registrationId);
}
