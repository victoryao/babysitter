package com.happymama.be.cache;

import java.util.concurrent.TimeUnit;

/**
 * Created by yaoqiang on 2018/7/15.
 */
public interface RedisClient {


    void set(String key, String value);

    void set(String key, String value, long time);

    String get(String key);

    void set(String key, String value, long time, TimeUnit unit);

}
