package com.happymama.be.utils;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by yaoqiang on 2018/7/30.
 */

@Slf4j
public class FileUploadUtil {

    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAIVz6W5g7AzUPz";
    private static String accessKeySecret = "PYC94GMjyIBSmuKS6ceSkqDMR6T3U6";
    private static String bucketName = "happymama";
    private static OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    public static void uploadImg(String imgName, InputStream is) {
        ossClient.putObject(bucketName, imgName, is);
    }

    public static String getImgUrl(String imgName) {
        String style = "image/resize,m_fixed,w_330,h_330";
        GetObjectRequest request = new GetObjectRequest(bucketName, imgName);
        request.setProcess(style);
        OSSObject metadata = ossClient.getObject(request);
        return metadata.getResponse().getUri();
    }


    public static void main(String[] args) {
        File file = new File("/Users/yaoqiang/imgs");
        File[] files = file.listFiles();
        for (File file2 : files) {
            System.out.println(file2.getName());
            try {
                uploadImg(file2.getName(), new FileInputStream(file2));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
//        try {
//            uploadImg("banner2.jpg", new FileInputStream(file));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(getImgUrl("banner2.jpg"));
    }
}
