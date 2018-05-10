package com.nytimes.android.external.cache3;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

public interface LoadingCache<K, V> extends Cache<K, V>, Function<K, V> {
    @Deprecated
    V apply(K k);

    ConcurrentMap<K, V> asMap();

    V get(K k) throws ExecutionException;

    Map<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException;

    V getUnchecked(K k);

    void refresh(K k);
}
