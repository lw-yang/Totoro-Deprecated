package com.lwyang.common.cache;

/**
 * 通用缓存处理
 * @author lwyang
 * @param <K> key
 * @param <V> value
 */
public interface ICache<K, V> {

    /**
     * 根据Key获取缓存数据
     * @param key key
     * @return V
     */
    V get(K key);

    /**
     * 设置缓存数据
     * @param key key
     * @param value value
     */
    void set(K key, V value);
}
