package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

public abstract class AbstractCache<K, V> implements Cache<K, V> {

    public interface StatsCounter {
        void mo2330a();

        void mo2331a(int i);

        void mo2332a(long j);

        CacheStats mo2333b();

        void mo2334b(int i);

        void mo2335b(long j);
    }

    public static final class SimpleStatsCounter implements StatsCounter {
        private final LongAddable f14838a = LongAddables.m7050a();
        private final LongAddable f14839b = LongAddables.m7050a();
        private final LongAddable f14840c = LongAddables.m7050a();
        private final LongAddable f14841d = LongAddables.m7050a();
        private final LongAddable f14842e = LongAddables.m7050a();
        private final LongAddable f14843f = LongAddables.m7050a();

        public final void mo2331a(int i) {
            this.f14838a.mo2380a((long) i);
        }

        public final void mo2334b(int i) {
            this.f14839b.mo2380a((long) i);
        }

        public final void mo2332a(long j) {
            this.f14840c.mo2379a();
            this.f14842e.mo2380a(j);
        }

        public final void mo2335b(long j) {
            this.f14841d.mo2379a();
            this.f14842e.mo2380a(j);
        }

        public final void mo2330a() {
            this.f14843f.mo2379a();
        }

        public final CacheStats mo2333b() {
            return new CacheStats(this.f14838a.mo2381b(), this.f14839b.mo2381b(), this.f14840c.mo2381b(), this.f14841d.mo2381b(), this.f14842e.mo2381b(), this.f14843f.mo2381b());
        }

        public final void m14569a(StatsCounter statsCounter) {
            statsCounter = statsCounter.mo2333b();
            this.f14838a.mo2380a(statsCounter.f8271a);
            this.f14839b.mo2380a(statsCounter.f8272b);
            this.f14840c.mo2380a(statsCounter.f8273c);
            this.f14841d.mo2380a(statsCounter.f8274d);
            this.f14842e.mo2380a(statsCounter.f8275e);
            this.f14843f.mo2380a(statsCounter.f8276f);
        }
    }

    public void cleanUp() {
    }

    protected AbstractCache() {
    }

    public V get(K k, Callable<? extends V> callable) throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        Map c = Maps.m7230c();
        for (Object next : iterable) {
            if (!c.containsKey(next)) {
                Object ifPresent = getIfPresent(next);
                if (ifPresent != null) {
                    c.put(next, ifPresent);
                }
            }
        }
        return ImmutableMap.m7128a(c);
    }

    public void put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            put(entry.getKey(), entry.getValue());
        }
    }

    public long size() {
        throw new UnsupportedOperationException();
    }

    public void invalidate(Object obj) {
        throw new UnsupportedOperationException();
    }

    public void invalidateAll(Iterable<?> iterable) {
        for (Object invalidate : iterable) {
            invalidate(invalidate);
        }
    }

    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }

    public CacheStats stats() {
        throw new UnsupportedOperationException();
    }

    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }
}
