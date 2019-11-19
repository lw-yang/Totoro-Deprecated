package com.lwyang.common.cache.map;

import com.lwyang.common.cache.ICache;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 内存缓存 Map
 * @author lwyang
 */
@Service
@Primary
public class MapCache<K, V> implements ICache<K, V> {

    private Map<K, V> MAP_CACHE;

    @PostConstruct
    public void init(){
        MAP_CACHE = new ConcurrentHashMap<>();
    }

    @Override
    public V get(K key) {
        return MAP_CACHE.get(key);
    }

    @Override
    public void set(K key, V value) {
        MAP_CACHE.put(key, value);
    }
}
