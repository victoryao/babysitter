package com.yaohoo.be.cache.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CacheUtils {

    /**
     *
     * @param < K >
     * @param < V >
     */
    public static abstract class Fn<K, V> implements MedisCache.Key<K> {
        protected static final int MinuteUnit = 60;
        protected static final int HourUnit = 60 * 60;
        protected static final int DayUnit = 60 * 60 * 24;
        /**
         * 不过期
         */
        protected static final int Forever = -1;


        public abstract V get(K id);

        public K add(V v) {
            return null;
        }

        public abstract String key(K id);

        /**
         * 缓存的失效时间，单位为秒
         * @return
         */
        public int timeOut() {
            return 3 * HourUnit;
        }

        /**
         * 缓存的失效时间，单位为秒
         * @return
         */
        public int timeOut(V v) {
            return timeOut();
        }

        /**
         * 主动失效时，一并清空的keys
         * @param k
         * @return
         */
        public String[] evict(K id) {
            return null;
        }

        /**
         * 实际失效的keys
         * @param k
         * @return
         */
        final String[] evictKeys(K k) {
            return null;
        }

        /**
         * 从db和缓存中取最后的更新的值
         * @param k
         * @return
         */
        final V getCache(K k) {
            return null;
        }
    }

    public static <K, V extends Serializable> V getCache(K k, Fn<K, V> fn) {
       
        return null;
    }

    public static <K, V> V add(V v, Fn<K, V> fn) {
		return v;
    }

    public static <K, V> V fillCache(K k, V v, Fn<K, V> fn) {
		return v;
    }

    public static <K, V> V getWithPut(K k, Fn<K, V> fn) {
		return null;
    }


    public static <K, V extends Serializable> List<V> getCacheList(List<K> keys, Fn<K, V> fn) {
        return null;
    }

    public static <K, V extends Serializable> Map<K, V> getCacheMap(List<K> keys, Fn<K, V> fn) {
        return null;
    }

    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
    private static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

    /**
     * 失效所有相关的key,包括自己
     * @param k
     * @param fn
     */
    public static <K, V extends Serializable> void remove(K k, Fn<K, V> fn) {
        
    }

    /**
     * 失效所有相关的key,包括自己
     * @param k
     * @param fn
     */
    public static <K, V extends Serializable> void syncRemove(K k, Fn<K, V> fn) {
    }


    /**
     * 延迟更新就是重新将缓存载入，目的是防止db同步延迟
     * @param k
     * @param fn
     */
    public static <K, V extends Serializable> void postponeUpdate(K k, Fn<K, V> fn) {
    }

    /**
     * 失效相关联key，实际上会在1s后变更
     * @param k
     * @param fn
     */
    public static <K, V extends Serializable> void expire(K k, Fn<K, V> fn) {
    }

}
