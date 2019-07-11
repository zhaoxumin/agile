package com.agile.go.base.config;

import com.agile.go.base.constant.AliyunConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName StaticConfig
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/6/24 18:14
 * @Version 1.0
 **/
@Configuration
public class StaticConfig {

    @Value("${aliyun.oss.endPoint}")
    private String endPoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Value("${aliyun.oss.ossUrl}")
    private String ossUrl;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getOssUrl() {
        return ossUrl;
    }

    public void setOssUrl(String ossUrl) {
        this.ossUrl = ossUrl;
    }

    @Bean
    public int initStatic() {
        AliyunConstant.setAliyunAccesskeyid(accessKeyId);
        AliyunConstant.setAliyunAccesskeysecret(accessKeySecret);
        AliyunConstant.setAliyunBucketname(bucketName);
        AliyunConstant.setAliyunEndpoint(endPoint);
        AliyunConstant.setAliyunOssurl(ossUrl);
        return 0;
    }
}
