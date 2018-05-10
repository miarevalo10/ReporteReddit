package com.nytimes.android.external.cache3;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {
    protected abstract Cache<K, V> delegate();

    protected ForwardingCache() {
    }

    public V getIfPresent(Object obj) {
        return delegate().getIfPresent(obj);
    }

    public V get(K k, Callable<? extends V> callable) throws ExecutionException {
        return delegate().get(k, callable);
    }

    public Map<K, V> getAllPresent(Iterable<?> iterable) {
        return delegate().getAllPresent(iterable);
    }

    public void put(K k, V v) {
        delegate().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    public void invalidate(Object obj) {
        delegate().invalidate(obj);
    }

    public void invalidateAll(Iterable<?> iterable) {
        delegate().invalidateAll(iterable);
    }

    public void invalidateAll() {
        delegate().invalidateAll();
    }

    public long size() {
        return delegate().size();
    }

    public ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    public void cleanUp() {
        delegate().cleanUp();
    }
}
