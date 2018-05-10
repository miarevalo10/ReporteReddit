package com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Primitives {
    private static final Map<Class<?>, Class<?>> f8774a;
    private static final Map<Class<?>, Class<?>> f8775b;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        m7551a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        m7551a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        m7551a(hashMap, hashMap2, Character.TYPE, Character.class);
        m7551a(hashMap, hashMap2, Double.TYPE, Double.class);
        m7551a(hashMap, hashMap2, Float.TYPE, Float.class);
        m7551a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        m7551a(hashMap, hashMap2, Long.TYPE, Long.class);
        m7551a(hashMap, hashMap2, Short.TYPE, Short.class);
        m7551a(hashMap, hashMap2, Void.TYPE, Void.class);
        f8774a = Collections.unmodifiableMap(hashMap);
        f8775b = Collections.unmodifiableMap(hashMap2);
    }

    private static void m7551a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean m7552a(Type type) {
        return f8774a.containsKey(type);
    }

    public static <T> Class<T> m7550a(Class<T> cls) {
        Class<T> cls2 = (Class) f8774a.get(C$Gson$Preconditions.m7521a((Object) cls));
        return cls2 == null ? cls : cls2;
    }
}
