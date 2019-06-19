package com.neusoft.medical.service.pharmacyWorkstation;

import com.neusoft.medical.bean.Patient;

import java.util.List;

/**
 * 门诊发药服务
 */
public interface MedicineDistributeService {
    /**
     * 按挂号单编号获取患者信息
     *
     * @param registrationId 挂号单编号
     * @return 患者信息
     */
    Patient selectPatient(int registrationId);

    /**
     * 按挂号单编号获取药品列表
     *
     * @param registrationId 挂号单编号
     * @return 药品列表，json 字符串
     */
    String selectChargeFormList(int registrationId);

    /**
     * 发放药品
     *
     * @param chargeFormIdList 被发放药品的编号列表
     * @return 操作结果
     */
    boolean medicineDistribute(List<Integer> chargeFormIdList);

    /**
     * 门诊退药
     * 退药数量不能超过可退数量，如果找出只按可退数量计算
     *
     * @param medicineReturnJson 退药信息，json 字符串
     * @return 操作结果
     * <p>
     * 退药信息 json 字符串是 json 数组，该数组中的每项元素包含如下属性：
     * - chargeFormId 收费项目的编号，int 型
     * - returnNums   退药数量，int 型
     */
    boolean medicineReturn(String medicineReturnJson);
}
