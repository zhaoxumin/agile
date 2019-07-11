package com.agile.go.base.util;

import com.agile.go.base.constant.AliyunConstant;
import com.aliyun.oss.OSSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.UUID;

/**
 * @ClassName UploadUtils
 * @Description 上传文件
 * @Author xumin zhao
 * @Date 2019/6/24 17:33
 * @Version 1.0
 **/
public class UploadUtils {

    private static Logger logger = LoggerFactory.getLogger(UploadUtils.class);
    private static OSSClient ossClient = new OSSClient(AliyunConstant.ALIYUN_ENDPOINT,
            AliyunConstant.ALIYUN_ACCESSKEYID,
            AliyunConstant.ALIYUN_ACCESSKEYSECRET);

    private static boolean upLoad(String fileName, InputStream inputStream) {
        // 上传文件流
        ossClient.putObject(AliyunConstant.ALIYUN_BUCKETNAME, fileName, inputStream);
        return true;
    }

    /**
     * 上传图片
     *
     * @param postfix     拓展名
     * @param inputStream
     * @return
     */
    public static String uploadImage(String postfix, InputStream inputStream) {
        String uuid = UuidUtils.createUUID();
        if (!checkPrefix(postfix)) {
            return null;
        }
        String url = "pma/" + uuid + postfix;
        if (upLoad(url, inputStream)) {
            return AliyunConstant.ALIYUN_OSSURL + '/' + url;
        } else {
            return null;
        }
    }


    /**
     * 上传视频
     *
     * @param postfix     文件名
     * @param inputStream
     * @return
     */
    public static String uploadVideo(String postfix, InputStream inputStream) {
        String uuid = UuidUtils.createUUID();
        if (!checkPrefix(postfix)) {
            return null;
        }
        String url = "video/" + uuid + postfix;
        if (upLoad(url, inputStream)) {
            return AliyunConstant.ALIYUN_OSSURL + '/' + url;
        } else {
            return null;
        }
    }

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    public static String uploadImage(MultipartFile file) {
        if (file == null) {
            return null;
        }
        String url = null;
        try (InputStream fileInputStream = file.getInputStream()) {
            String postfix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            url = uploadImage(postfix, fileInputStream);
        } catch (IOException e) {
            return null;
        }
        return url;
    }

    /**
     * 上传
     *
     * @param inputStream
     * @return
     */
    public static String uploadImage(InputStream inputStream, String postfix) {
        String uuid = UuidUtils.createUUID();
        if (!checkPrefix(postfix)) {
            return null;
        }
        String url = "pma/" + uuid + postfix;
        if (!upLoad(url, inputStream)) {
            return null;
        }
        return AliyunConstant.ALIYUN_OSSURL + '/' + url;
    }

    /**
     * 上传
     *
     * @param inputStream
     * @return
     */
    public static String uploadFace(InputStream inputStream, String postfix) {
        String uuid = UUID.randomUUID().toString();
        if (!checkPrefix(postfix)) {
            return null;
        }
        String url = "pma/" + uuid + postfix;
        if (!upLoad(url, inputStream)) {
            return null;
        }
        return AliyunConstant.ALIYUN_OSSURL + '/' + url;
    }

    /**
     * 上传视频
     *
     * @param file
     * @return
     */
    public static String uploadVideo(MultipartFile file) {
        String url = null;
        try (InputStream fileInputStream = file.getInputStream()) {
            String postfix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            url = uploadVideo(postfix, fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return url;
    }

    public static String uploadImage(File file) {
        String url = null;
        try (InputStream fileInputStream = new FileInputStream(file)) {
            String prefix = file.getName().substring(file.getName().lastIndexOf("."));
            url = uploadImage(prefix, fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return url;
    }

    private static boolean checkPrefix(String postfix) {
        // TODO 可加入格式校验

        return postfix != null && postfix.startsWith(".");
    }

    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }


    /**
     * 上传word
     *
     * @param postfix     拓展名
     * @param inputStream
     * @return
     */
    public static String uploadDoc(String postfix, InputStream inputStream, String fileName) {
        String uuid = UuidUtils.createUUID();
        if (!checkPrefix(postfix)) {
            return null;
        }
        String url = "doc/" + uuid + "/" +fileName+ postfix;
        if (upLoad(url, inputStream)) {
            return AliyunConstant.ALIYUN_OSSURL + '/' + url;
        } else {
            return null;
        }
    }



    /**
     * 上传pdf
     *
     * @param postfix     拓展名
     * @param inputStream
     * @return
     */
    public static String uploadPdf(String postfix, InputStream inputStream, String fileName) {
        String uuid = UuidUtils.createUUID();
        if (!checkPrefix(postfix)) {
            return null;
        }
        String url = "pdf/" + uuid + "/" +fileName+ postfix;
        if (upLoad(url, inputStream)) {
            return AliyunConstant.ALIYUN_OSSURL + '/' + url;
        } else {
            return null;
        }
    }
}
