package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class Enums {
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> f8230a = new WeakHashMap();

    public static <T extends Enum<T>> Optional<T> m6873a(Class<T> cls, String str) {
        Preconditions.m6908a((Object) cls);
        Preconditions.m6908a((Object) str);
        return Platform.m6904a(cls, str);
    }

    static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> m6874a(Class<T> cls) {
        Map<String, WeakReference<? extends Enum<?>>> map;
        synchronized (f8230a) {
            map = (Map) f8230a.get(cls);
            if (map == null) {
                map = new HashMap();
                Iterator it = EnumSet.allOf(cls).iterator();
                while (it.hasNext()) {
                    Enum enumR = (Enum) it.next();
                    map.put(enumR.name(), new WeakReference(enumR));
                }
                f8230a.put(cls, map);
            }
        }
        return map;
    }
}
