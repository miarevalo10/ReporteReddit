package com.google.common.collect;

import java.io.Serializable;

class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    final K f14892a;
    final V f14893b;

    ImmutableEntry(K k, V v) {
        this.f14892a = k;
        this.f14893b = v;
    }

    public final K getKey() {
        return this.f14892a;
    }

    public final V getValue() {
        return this.f14893b;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
