package com.google.common.cache;

import com.google.common.base.Preconditions;
import java.util.AbstractMap.SimpleImmutableEntry;

public final class RemovalNotification<K, V> extends SimpleImmutableEntry<K, V> {
    private final RemovalCause f8359a;

    public static <K, V> RemovalNotification<K, V> m7069a(K k, V v, RemovalCause removalCause) {
        return new RemovalNotification(k, v, removalCause);
    }

    private RemovalNotification(K k, V v, RemovalCause removalCause) {
        super(k, v);
        this.f8359a = (RemovalCause) Preconditions.m6908a((Object) removalCause);
    }
}
