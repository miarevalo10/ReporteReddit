package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public abstract class AbstractLoadingCache<K, V> extends AbstractCache<K, V> implements LoadingCache<K, V> {
    protected AbstractLoadingCache() {
    }

    public V getUnchecked(K k) {
        try {
            return get(k);
        } catch (K k2) {
            throw new UncheckedExecutionException(k2.getCause());
        }
    }

    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        Map c = Maps.m7230c();
        for (Object next : iterable) {
            if (!c.containsKey(next)) {
                c.put(next, get(next));
            }
        }
        return ImmutableMap.m7128a(c);
    }

    public final V apply(K k) {
        return getUnchecked(k);
    }

    public void refresh(K k) {
        throw new UnsupportedOperationException();
    }
}
