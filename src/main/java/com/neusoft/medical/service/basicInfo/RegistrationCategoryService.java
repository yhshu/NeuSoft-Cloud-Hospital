package com.neusoft.medical.service.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.RegistrationCategory;

import java.util.List;

public interface RegistrationCategoryService {

    /**
     * 获取挂号级别列表
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 分页的挂号级别信息
     */
    PageInfo<RegistrationCategory> selectRegistrationCategory(int currentPage, int pageSize);

    /**
     * 添加挂号级别
     *
     * @param registrationCategoryName 挂号级别名称
     * @param isDefault                是否为默认挂号级别（是1 否0）
     * @param sequenceNo               挂号级别序列号
     * @param registrationFee          挂号费用
     * @return 操作结果
     */
    boolean addRegistrationCategory(String registrationCategoryName, boolean isDefault, int sequenceNo, double registrationFee);

    /**
     * 按主键更新挂号级别
     *
     * @param registrationCategoryId   挂号级别编号
     * @param registrationCategoryName 挂号级别名称
     * @param isDefault                是否为默认挂号级别（是1 否0）
     * @param sequenceNo               挂号级别序列号
     * @param registrationFee          挂号费用
     * @return 操作结果
     */
    boolean updateRegistrationCategoryByPrimaryKey(int registrationCategoryId, String registrationCategoryName, boolean isDefault, int sequenceNo, double registrationFee);

    /**
     * 按主键删除挂号级别
     *
     * @param registrationCategoryId 挂号级别编号的列表
     * @return 操作结果
     */
    boolean deleteRegistrationCategoryByPrimaryKey(List<Integer> registrationCategoryId);
}
