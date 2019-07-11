package com.agile.go.base.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName DownLoadUtils
 * @Description TODO
 * @Author xumin zhao
 * @Date 2019/6/29 11:43
 * @Version 1.0
 **/
public class DownLoadUtils {


    /**
     * 下载文件
     *
     * @return
     * @throws Exception
     */
    public static void downloadFile(String fileUrl, String path,String fileName) {
        path=changeFilePath(path);
        path=path+fileName;
        if (StringUtils.isEmpty(fileUrl) || StringUtils.isEmpty(path)) {
            return;
        }
        URL url = null;
        try {
            url = new URL(fileUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try (DataInputStream dataInputStream = new DataInputStream(url.openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(new File(path))) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 转换文件路径
     *
     * @return
     * @throws Exception
     */
    public static String changeFilePath(String path) {

        if (StringUtils.isEmpty(path)) {
            return null;
        }
        if(path.indexOf(":")==-1){
           return null;
        }
        if(path.indexOf("\\")==-1 && path.indexOf("/")!=-1){
            return path;
        }
        if(path.indexOf("\\")!=-1){
            return path.replace("\\","/");
        }
        return null;
    }
}
