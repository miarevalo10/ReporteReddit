package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

abstract class AbstractMultimap<K, V> implements Multimap<K, V> {
    private transient Set<K> f14876a;
    private transient Map<K, Collection<V>> f14877b;

    abstract Set<K> mo3601c();

    abstract Map<K, Collection<V>> mo3602d();

    AbstractMultimap() {
    }

    public boolean mo2387a(K k, V v) {
        return mo3600a(k).add(v);
    }

    public Set<K> mo4392e() {
        Set<K> set = this.f14876a;
        if (set != null) {
            return set;
        }
        set = mo3601c();
        this.f14876a = set;
        return set;
    }

    public Map<K, Collection<V>> mo2388f() {
        Map<K, Collection<V>> map = this.f14877b;
        if (map != null) {
            return map;
        }
        map = mo3602d();
        this.f14877b = map;
        return map;
    }

    public boolean equals(Object obj) {
        return Multimaps.m7236a(this, obj);
    }

    public int hashCode() {
        return mo2388f().hashCode();
    }

    public String toString() {
        return mo2388f().toString();
    }
}
