package io.gsonfire.util.reflection;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CachedReflectionFactory implements Factory {
    private final ConcurrentMap<Class, SoftReference<Object>> f31079a = new ConcurrentHashMap();

    public final <T> T mo5620a(Class<T> cls) {
        T t;
        SoftReference softReference = (SoftReference) this.f31079a.get(cls);
        if (softReference != null) {
            t = softReference.get();
            if (t != null) {
                return t;
            }
        }
        try {
            t = cls.newInstance();
            this.f31079a.putIfAbsent(cls, new SoftReference(t));
            return t;
        } catch (Class<T> cls2) {
            throw new RuntimeException(cls2);
        } catch (Class<T> cls22) {
            throw new RuntimeException(cls22);
        }
    }
}
