package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder.Factory;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

public class DataRewinderRegistry {
    private static final Factory<?> f3341b = new C10571();
    private final Map<Class<?>, Factory<?>> f3342a = new HashMap();

    class C10571 implements Factory<Object> {
        C10571() {
        }

        public final DataRewinder<Object> mo896a(Object obj) {
            return new DefaultRewinder(obj);
        }

        public final Class<Object> mo897a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    private static final class DefaultRewinder implements DataRewinder<Object> {
        private final Object f12315a;

        public final void mo899b() {
        }

        DefaultRewinder(Object obj) {
            this.f12315a = obj;
        }

        public final Object mo898a() {
            return this.f12315a;
        }
    }

    public final synchronized void m2867a(Factory<?> factory) {
        this.f3342a.put(factory.mo897a(), factory);
    }

    public final synchronized <T> DataRewinder<T> m2866a(T t) {
        Factory factory;
        Preconditions.m3217a((Object) t);
        factory = (Factory) this.f3342a.get(t.getClass());
        if (factory == null) {
            for (Factory factory2 : this.f3342a.values()) {
                if (factory2.mo897a().isAssignableFrom(t.getClass())) {
                    factory = factory2;
                    break;
                }
            }
        }
        if (factory == null) {
            factory = f3341b;
        }
        return factory.mo896a(t);
    }
}
