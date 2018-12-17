package com.happymama.be.utils;

import com.happymama.be.exception.AesException;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by yaoqiang on 2018/9/15.
 */
public class SHA1 {

    /**
     * 用SHA1算法验证Token
     *
     * @param token     票据
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @return 安全签名
     * @throws AesException
     */
    public static String getSHA1(String token, String timestamp, String nonce) throws AesException {
        try {
            String[] array = new String[]{token, timestamp, nonce};
            StringBuffer sb = new StringBuffer();
            // 字符串排序
            Arrays.sort(array);
            for (int i = 0; i < 3; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            // SHA1签名生成
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            doSha(digest, hexstr);
            return hexstr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.ComputeSignatureError);
        }
    }


    public static String getSHA1(String str) throws AesException {
        return DigestUtils.shaHex(str);
    }

    public static void main(String[] args) throws Exception{
        String s = getSHA1("jsapi_ticket=LIKLckvwlJT9cWIhEQTwfAGsc8IiRcsMcRGLFcizQ-Wp26ecNdOroHap-gm-wPTPM4gx9Ym68yfgWgVfwGIRFg&noncestr=1540917722048&timestamp=1540917722&url=http://www.newmami.cn/app/shop/activity/detail.do?id=9");
        System.out.println(s);
    }

    private static void doSha(byte[] digest, StringBuffer hexstr) {
        String shaHex;
        for (int i = 0; i < digest.length; i++) {
            shaHex = Integer.toHexString(digest[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexstr.append(0);
            }
            hexstr.append(shaHex);
        }
    }

}
