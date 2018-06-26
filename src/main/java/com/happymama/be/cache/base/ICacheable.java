package com.happymama.be.cache.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ICacheable<K, V extends Serializable> {
    public V get(K id);

    public List<V> getList(List<K> ids);

    public Map<K, V> getMap(List<K> ids);

    public void removeCache(K id);

    void syncRemoveCache(K id);

    public V add(V v);
}
