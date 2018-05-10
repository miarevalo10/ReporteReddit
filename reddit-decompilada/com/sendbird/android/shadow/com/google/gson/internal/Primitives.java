package com.sendbird.android.shadow.com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Primitives {
    private static final Map<Class<?>, Class<?>> f22935a;
    private static final Map<Class<?>, Class<?>> f22936b;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        m25123a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        m25123a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        m25123a(hashMap, hashMap2, Character.TYPE, Character.class);
        m25123a(hashMap, hashMap2, Double.TYPE, Double.class);
        m25123a(hashMap, hashMap2, Float.TYPE, Float.class);
        m25123a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        m25123a(hashMap, hashMap2, Long.TYPE, Long.class);
        m25123a(hashMap, hashMap2, Short.TYPE, Short.class);
        m25123a(hashMap, hashMap2, Void.TYPE, Void.class);
        f22935a = Collections.unmodifiableMap(hashMap);
        f22936b = Collections.unmodifiableMap(hashMap2);
    }

    private static void m25123a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean m25124a(Type type) {
        return f22935a.containsKey(type);
    }
}
