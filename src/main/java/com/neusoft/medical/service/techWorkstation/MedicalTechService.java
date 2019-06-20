package com.neusoft.medical.service.techWorkstation;

import java.util.List;

/**
 * 医技工作站服务
 */
public interface MedicalTechService {
    /**
     * 按挂号单编号获取收费项目列表
     *
     * @param registrationId 挂号单编号
     * @return 收费项目列表，json 字符串
     */
    String selectChargeEntryList(int registrationId);

    /**
     * 应用收费项目
     *
     * @param chargeEntryIdList 收费项目编号列表
     * @return 操作结果
     */
    boolean chargeEntryListApply(List<Integer> chargeEntryIdList);

    /**
     * 收费项目退费
     * 收费项目只有在执行前可退，执行后的收费项目无法退费
     *
     * @param chargeEntryListRefundJson 退费信息，json 字符串
     * @return 操作结果
     * <p>
     * 退费信息 json 字符串是 json 数组，该数组中的每项元素包含如下属性：
     * - chargeId 收费项目的编号，int 型
     * - returnNums   退费数量，int 型
     */
    boolean chargeEntryListRefund(String chargeEntryListRefundJson);
}
