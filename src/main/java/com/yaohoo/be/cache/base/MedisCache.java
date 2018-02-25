package com.yaohoo.be.cache.base;


import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class MedisCache {
    private static final String REDIS_CLOUD_CONTENT = "conf/application-cache.xml";
    private static final String DEMO_POOL_NAME = "demoPool";
    private static final int DEFAULT_TIMEOUT = 60 * 60 * 3;
    private static final int DEFAULT_DEBUG_TIMEOUT = 60 * 5;
    public static final int DayUnit = 60 * 60 * 24;
    public static final int HourUnit = 60 * 60;
    public static final int MinuteUnit = 60;


   

    public static interface Key<K> {
        public String key(K k);
    }

    public static <K, V> Map<K, V> multiGet(String format, List<K> keys) {
        return null;
    }

    /**
     * 返回一个map,如果某个值对应的缓存不存在，就不会出现的map的keySet中
     * @param keys
     * @param fn
     * @return
     */
    public static <K, V> Map<K, V> multiGet(List<K> keys, Key<K> fn) {
        return null;
    }


    public static void remove(String key) {
    }

    public static void expire(String key, int timeOutSeconds) {
    }

    private static void removeWithFullKey(String fullKey) {
    }

    public static void multiRemove(String[] keys) {
    }

    public static <T> void multiPut(Map<String, T> map, int timeoutSecond) {
    }

    public static <T> void multiPut(Map<String, T> map) {
    }

    public static <T> void put(String key, T obj) {
    }

    /**
     * 永久持久化
     * @param key
     * @param obj
     */
    public static <T> void persistence(String key, T obj) {
    }


    public static <T> void put(String key, T obj, int timeoutSecond) {
    }

    private static void putWithFullKey(String fullKey, Object object, int timeoutSecond) {
    }

    public static class CacheableObject<T> implements Serializable {
    }
}

