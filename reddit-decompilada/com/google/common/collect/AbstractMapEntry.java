package com.google.common.collect;

import com.google.common.base.Objects;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Map.Entry;

abstract class AbstractMapEntry<K, V> implements Entry<K, V> {
    public abstract K getKey();

    public abstract V getValue();

    AbstractMapEntry() {
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (!Objects.m14557a(getKey(), entry.getKey()) || Objects.m14557a(getValue(), entry.getValue()) == null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getKey());
        stringBuilder.append(Operation.EQUALS);
        stringBuilder.append(getValue());
        return stringBuilder.toString();
    }
}
