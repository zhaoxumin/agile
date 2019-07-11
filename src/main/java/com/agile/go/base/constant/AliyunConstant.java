package com.agile.go.base.constant;

/**
 * @ClassName AliyunConstant
 * @Description 阿里云OSS配置
 * @Author xumin zhao
 * @Date 2019/6/24 17:35
 * @Version 1.0
 **/
public final class AliyunConstant {


    public static String ALIYUN_ENDPOINT;

    public static String ALIYUN_ACCESSKEYID;

    public static String ALIYUN_ACCESSKEYSECRET;

    public static String ALIYUN_BUCKETNAME;

    public static String ALIYUN_OSSURL;


    public static String getAliyunEndpoint() {
        return ALIYUN_ENDPOINT;
    }

    public static void setAliyunEndpoint(String aliyunEndpoint) {
        ALIYUN_ENDPOINT = aliyunEndpoint;
    }

    public static String getAliyunAccesskeyid() {
        return ALIYUN_ACCESSKEYID;
    }

    public static void setAliyunAccesskeyid(String aliyunAccesskeyid) {
        ALIYUN_ACCESSKEYID = aliyunAccesskeyid;
    }

    public static String getAliyunAccesskeysecret() {
        return ALIYUN_ACCESSKEYSECRET;
    }

    public static void setAliyunAccesskeysecret(String aliyunAccesskeysecret) {
        ALIYUN_ACCESSKEYSECRET = aliyunAccesskeysecret;
    }

    public static String getAliyunBucketname() {
        return ALIYUN_BUCKETNAME;
    }

    public static void setAliyunBucketname(String aliyunBucketname) {
        ALIYUN_BUCKETNAME = aliyunBucketname;
    }

    public static String getAliyunOssurl() {
        return ALIYUN_OSSURL;
    }

    public static void setAliyunOssurl(String aliyunOssurl) {
        ALIYUN_OSSURL = aliyunOssurl;
    }
}
