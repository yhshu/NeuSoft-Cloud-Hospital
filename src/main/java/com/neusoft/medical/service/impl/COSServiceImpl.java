//package com.neusoft.medical.service.impl;
//
//import com.neusoft.medical.service.COSService;
//import com.qcloud.cos.COSClient;
//import com.qcloud.cos.ClientConfig;
//import com.qcloud.cos.auth.BasicCOSCredentials;
//import com.qcloud.cos.auth.COSCredentials;
//import com.qcloud.cos.exception.CosClientException;
//import com.qcloud.cos.exception.CosServiceException;
//import com.qcloud.cos.model.Bucket;
//import com.qcloud.cos.model.CannedAccessControlList;
//import com.qcloud.cos.model.CreateBucketRequest;
//import com.qcloud.cos.region.Region;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class COSServiceImpl implements COSService {
//
//    // 1 初始化用户身份信息(secretId, secretKey)
//    static COSCredentials cred = new BasicCOSCredentials("AKIDHQK4h66DvPgiWGF6C2mKdhdMtBFBCPiu", "7zhHdqnU2LSPDsPhyf7f3IF5h74mGWbE");
//
//    // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
//    // clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
//    static ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));
//
//    // 3 生成cos客户端
//    static COSClient cosClient = new COSClient(cred, clientConfig);
//    // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
//    static String bucketName = "neusoft-hospital-1259205273";
//
//    // 指定要上传到 COS 上对象键
//    // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-chengdu.myqcloud.com/mydemo.jpg` 中，对象键为 mydemo.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
//
//    @Override
//    public List<Bucket> queryBucketList() {
//        List<Bucket> bucketList = null;
//        try {
//            bucketList = cosClient.listBuckets();
//        } catch (CosClientException serverException) {
//            serverException.printStackTrace();
//        }
//        return bucketList;
//    }
//
//}
