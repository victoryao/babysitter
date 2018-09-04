package com.happymama.be.utils;

import com.happymama.be.model.CourseOrderDO;
import org.apache.commons.collections.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Created by yaoqiang on 2018/6/30.
 */
public class Utils {

    public static String getId() {
        return MD5Utils.getMD5(UUID.randomUUID().toString());
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        System.out.println("x-forwarded-for ip: " + ip);
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.contains(",")) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String secureName(String name) {
        if (StringUtils.isBlank(name)) {
            return "***";
        }
        if (name.length() == 1) {
            return "***";
        }
        if (name.length() == 2) {
            return name.charAt(0) + "*";
        }
        if (name.length() == 3) {
            return name.charAt(0) + "*" + name.charAt(name.length() - 1);
        }
        if (name.length() == 4) {
            return name.charAt(0) + "**" + name.charAt(name.length() - 1);
        }
        if (name.length() == 5) {
            return name.substring(0, 2) + "**" + name.charAt(name.length() - 1);
        }

        return name.substring(0, 3) + "***" + name.substring(6);
    }

    public static String genToken(String mobile) {
        StringBuilder builder = new StringBuilder(50);
        return MD5Utils.getMD5(builder.append(mobile).append("###").append(System.currentTimeMillis()).toString());
    }

    public static String generateCode(int codeLength) {
        return RandomStringUtils.randomNumeric(codeLength);
    }

    public static boolean isNumberValidate(String mobile) {

        if (StringUtils.isBlank(mobile)) {
            return false;
        }

        if (mobile.startsWith("+86")) {
            mobile = mobile.substring(3);
        }

        return checkCellphone(mobile);
    }

    private static boolean checkCellphone(String cellphone) {
        String regex = "^1\\d{10}$";
        return Pattern.matches(regex, cellphone);
    }

}
