package com.nytimes.android.external.cache3;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Map.Entry;

public final class RemovalNotification<K, V> implements Entry<K, V> {
    private final K f10215a;
    private final V f10216b;
    private final RemovalCause f10217c;

    public static <K, V> RemovalNotification<K, V> m8677a(K k, V v, RemovalCause removalCause) {
        return new RemovalNotification(k, v, removalCause);
    }

    private RemovalNotification(K k, V v, RemovalCause removalCause) {
        this.f10215a = k;
        this.f10216b = v;
        this.f10217c = (RemovalCause) Preconditions.m8670a((Object) removalCause);
    }

    public final K getKey() {
        return this.f10215a;
    }

    public final V getValue() {
        return this.f10216b;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (!Objects.m8668a(getKey(), entry.getKey()) || Objects.m8668a(getValue(), entry.getValue()) == null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        Object key = getKey();
        Object value = getValue();
        int i2 = 0;
        if (key == null) {
            i = 0;
        } else {
            i = key.hashCode();
        }
        if (value != null) {
            i2 = value.hashCode();
        }
        return i ^ i2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getKey());
        stringBuilder.append(Operation.EQUALS);
        stringBuilder.append(getValue());
        return stringBuilder.toString();
    }
}
