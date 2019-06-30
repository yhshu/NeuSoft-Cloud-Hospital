package com.neusoft.medical.service;

import com.qcloud.cos.model.Bucket;

import java.util.List;

/**
 * 对象存储服务 Cloud Object Serivce
 * 使用腾讯云
 */
public interface COSService {

    /**
     * 获取存储桶列表
     *
     * @return
     */
    List<Bucket> queryBucketList();
}
