package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements SetMultimap<K, V> {
    abstract Set<V> mo4393g();

    /* synthetic */ Collection mo4053a() {
        return mo4393g();
    }

    public final /* synthetic */ Collection mo3600a(Object obj) {
        return mo4390b(obj);
    }

    protected AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    public Set<V> mo4390b(K k) {
        return (Set) super.mo3600a((Object) k);
    }

    public Map<K, Collection<V>> mo2388f() {
        return super.mo2388f();
    }

    public boolean mo2387a(K k, V v) {
        return super.mo2387a((Object) k, (Object) v);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
