package com.yaohoo.be.cache.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

abstract class CacheableManager<K, V extends Serializable> implements ICacheable<K, V> {
    CacheUtils.Fn<K, V> cacheFunc;

    protected abstract CacheUtils.Fn<K, V> cacheFn();

    private CacheUtils.Fn<K, V> fn() {
        if (cacheFunc == null) {
            cacheFunc = cacheFn();
        }
        return cacheFunc;
    }

    CacheUtils.Fn<K, V> getCacheFn() {
        return fn();
    }


   
    public V get(K id) {
        return CacheUtils.getCache(id, fn());
    }

    public List<V> getList(List<K> ids) {
        return CacheUtils.getCacheList(ids, fn());
    }

    public Map<K, V> getMap(List<K> ids) {
        return CacheUtils.getCacheMap(ids, fn());
    }


    public void removeCache(K id) {
        CacheUtils.remove(id, fn());
    }

    public void syncRemoveCache(K id) {
        CacheUtils.syncRemove(id, fn());
    }


    public V add(V v) {
        return CacheUtils.add(v, fn());
    }
}
