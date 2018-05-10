package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class zze {
    private static <K, V> Map<K, V> m4898a(int i) {
        return i <= 256 ? new ArrayMap(i) : new HashMap(i, 1.0f);
    }

    public static <K, V> Map<K, V> m4899a(K k, V v, K k2, V v2, K k3, V v3) {
        Map a = m4898a(3);
        a.put(k, v);
        a.put(k2, v2);
        a.put(k3, v3);
        return Collections.unmodifiableMap(a);
    }

    public static <K, V> Map<K, V> m4900a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map a = m4898a(6);
        a.put(k, v);
        a.put(k2, v2);
        a.put(k3, v3);
        a.put(k4, v4);
        a.put(k5, v5);
        a.put(k6, v6);
        return Collections.unmodifiableMap(a);
    }

    public static <T> Set<T> m4901a(T... tArr) {
        Object arraySet = new ArraySet((byte) 0);
        Collections.addAll(arraySet, tArr);
        return Collections.unmodifiableSet(arraySet);
    }
}
