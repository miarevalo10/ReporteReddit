package com.google.common.eventbus;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

final class SubscriberRegistry {
    private static final LoadingCache<Class<?>, ImmutableList<Method>> f8501c = CacheBuilder.m6950a().m6952b().m6951a(new C11851());
    private static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> f8502d = CacheBuilder.m6950a().m6952b().m6951a(new C11862());
    final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> f8503a = Maps.m7231d();
    private final EventBus f8504b;

    private static final class MethodIdentifier {
        private final String f8499a;
        private final List<Class<?>> f8500b;

        MethodIdentifier(Method method) {
            this.f8499a = method.getName();
            this.f8500b = Arrays.asList(method.getParameterTypes());
        }

        public final int hashCode() {
            return Objects.m14556a(this.f8499a, this.f8500b);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof MethodIdentifier)) {
                return false;
            }
            MethodIdentifier methodIdentifier = (MethodIdentifier) obj;
            if (!this.f8499a.equals(methodIdentifier.f8499a) || this.f8500b.equals(methodIdentifier.f8500b) == null) {
                return false;
            }
            return true;
        }
    }

    static class C11851 extends CacheLoader<Class<?>, ImmutableList<Method>> {
        C11851() {
        }

        public final /* synthetic */ Object mo2376a(Object obj) throws Exception {
            return SubscriberRegistry.m7276b((Class) obj);
        }
    }

    static class C11862 extends CacheLoader<Class<?>, ImmutableSet<Class<?>>> {
        C11862() {
        }

        public final /* synthetic */ Object mo2376a(Object obj) throws Exception {
            return ImmutableSet.m14747a(TypeToken.m14845a((Class) obj).m14852c().m20501c());
        }
    }

    SubscriberRegistry(EventBus eventBus) {
        this.f8504b = (EventBus) Preconditions.m6908a((Object) eventBus);
    }

    final Multimap<Class<?>, Subscriber> m7277a(Object obj) {
        Multimap<Class<?>, Subscriber> h = HashMultimap.m21556h();
        Iterator a = ((ImmutableList) f8501c.getUnchecked(obj.getClass())).m14740a(0);
        while (a.hasNext()) {
            Method method = (Method) a.next();
            h.mo2387a(method.getParameterTypes()[0], Subscriber.m7270a(this.f8504b, obj, method));
        }
        return h;
    }

    static ImmutableSet<Class<?>> m7275a(Class<?> cls) {
        try {
            return (ImmutableSet) f8502d.getUnchecked(cls);
        } catch (Class<?> cls2) {
            throw Throwables.m6939b(cls2.getCause());
        }
    }

    static /* synthetic */ ImmutableList m7276b(Class cls) {
        Class<Class> c = TypeToken.m14845a(cls).m14852c().m20501c();
        Map b = Maps.m7226b();
        for (Class declaredMethods : c) {
            for (Object obj : declaredMethods.getDeclaredMethods()) {
                if (obj.isAnnotationPresent(Subscribe.class) && !obj.isSynthetic()) {
                    Class[] parameterTypes = obj.getParameterTypes();
                    boolean z = true;
                    if (parameterTypes.length != 1) {
                        z = false;
                    }
                    Preconditions.m6918a(z, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", obj, parameterTypes.length);
                    MethodIdentifier methodIdentifier = new MethodIdentifier(obj);
                    if (!b.containsKey(methodIdentifier)) {
                        b.put(methodIdentifier, obj);
                    }
                }
            }
        }
        return ImmutableList.m14730a(b.values());
    }
}
