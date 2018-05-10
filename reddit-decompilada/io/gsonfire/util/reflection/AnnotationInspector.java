package io.gsonfire.util.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class AnnotationInspector<T extends AccessibleObject, M> {
    private final ConcurrentMap<Class, ConcurrentMap<Class<? extends Annotation>, Collection<M>>> f24975a = new ConcurrentHashMap();

    public abstract M mo5618a(T t);

    public abstract T[] mo5619a(Class cls);

    public final Collection<M> m26465a(Class cls, Class<? extends Annotation> cls2) {
        if (cls != null) {
            Collection<M> b = m26463b(cls, cls2);
            if (b != null) {
                return b;
            }
            if (m26463b(cls, cls2) == null) {
                Collection linkedHashSet = new LinkedHashSet();
                int i = 0;
                for (AccessibleObject accessibleObject : mo5619a(cls)) {
                    if (accessibleObject.isAnnotationPresent(cls2)) {
                        accessibleObject.setAccessible(true);
                        linkedHashSet.add(mo5618a(accessibleObject));
                    }
                }
                linkedHashSet.addAll(m26465a(cls.getSuperclass(), cls2));
                Class[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                while (i < length) {
                    linkedHashSet.addAll(m26465a(interfaces[i], cls2));
                    i++;
                }
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                cls = (ConcurrentMap) this.f24975a.putIfAbsent(cls, concurrentHashMap);
                if (cls == null) {
                    cls = concurrentHashMap;
                }
                cls.put(cls2, linkedHashSet);
                return linkedHashSet;
            }
        }
        return Collections.emptyList();
    }

    private Collection<M> m26463b(Class cls, Class<? extends Annotation> cls2) {
        Map map = (Map) this.f24975a.get(cls);
        if (map != null) {
            Collection collection = (Collection) map.get(cls2);
            if (collection != null) {
                return collection;
            }
        }
        return null;
    }
}
