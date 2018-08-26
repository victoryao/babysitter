package com.happymama.be.service;

import com.happymama.be.cache.impl.SimpleRedisClientImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaoqiang on 2018/7/15.
 */
@Service
public class SmsService {

    private static final String CODE_KEY = "verify_";


    @Resource
    private SimpleRedisClientImpl simpleRedisClient;

    public String getVerifyCode(String mobile) {
        return simpleRedisClient.get(CODE_KEY + mobile);
    }

    public void setVerifyCode(String mobile, String code) {
        simpleRedisClient.set(CODE_KEY + mobile, code, 1800, TimeUnit.SECONDS);
    }
}
