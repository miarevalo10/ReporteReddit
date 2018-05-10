package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Set;

final class Platform {
    static <K, V> Map<K, V> m7247a() {
        return CompactHashMap.m7093a();
    }

    static <E> Set<E> m7248a(int i) {
        return CompactHashSet.m7102a(i);
    }

    static <T> T[] m7249a(T[] tArr, int i) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
    }
}
