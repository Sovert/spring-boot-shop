package com.qch.shop.cache;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public interface CacheStore<K, V> {
    Optional<V> get(K key);

    void put(K key, V value, long timeout, TimeUnit timeUnit);


}
