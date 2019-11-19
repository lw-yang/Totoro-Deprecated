package com.lwyang.common.cache;

/**
 * 通用缓存处理
 * @author lwyang
 * @param <K> key
 * @param <V> value
 */
public interface ICache<K, V> {

    V get(K key);

    void set(K key, V value);
}
