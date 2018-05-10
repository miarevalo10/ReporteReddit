package com.bumptech.glide.util.pool;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.util.Log;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.ArrayList;
import java.util.List;

public final class FactoryPools {
    private static final Resetter<Object> f3676a = new C10831();

    public interface Factory<T> {
        T mo916a();
    }

    public interface Poolable {
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void mo1029a(T t);
    }

    class C10831 implements Resetter<Object> {
        public final void mo1029a(Object obj) {
        }

        C10831() {
        }
    }

    class C10842 implements Factory<List<T>> {
        C10842() {
        }

        public final /* synthetic */ Object mo916a() {
            return new ArrayList();
        }
    }

    class C10853 implements Resetter<List<T>> {
        C10853() {
        }

        public final /* synthetic */ void mo1029a(Object obj) {
            ((List) obj).clear();
        }
    }

    private static final class FactoryPool<T> implements Pool<T> {
        private final Factory<T> f12671a;
        private final Resetter<T> f12672b;
        private final Pool<T> f12673c;

        FactoryPool(Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
            this.f12673c = pool;
            this.f12671a = factory;
            this.f12672b = resetter;
        }

        public final T mo362a() {
            T a = this.f12673c.mo362a();
            if (a == null) {
                a = this.f12671a.mo916a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder stringBuilder = new StringBuilder("Created new ");
                    stringBuilder.append(a.getClass());
                    Log.v("FactoryPools", stringBuilder.toString());
                }
            }
            if (a instanceof Poolable) {
                ((Poolable) a).getVerifier().mo1030a(false);
            }
            return a;
        }

        public final boolean mo363a(T t) {
            if (t instanceof Poolable) {
                ((Poolable) t).getVerifier().mo1030a(true);
            }
            this.f12672b.mo1029a(t);
            return this.f12673c.mo363a(t);
        }
    }

    public static <T extends Poolable> Pool<T> m3246a(Factory<T> factory) {
        return m3244a(new SimplePool(ModuleDescriptor.MODULE_VERSION), (Factory) factory);
    }

    public static <T extends Poolable> Pool<T> m3243a(int i, Factory<T> factory) {
        return m3244a(new SynchronizedPool(i), (Factory) factory);
    }

    private static <T> Pool<T> m3245a(Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    public static <T> Pool<List<T>> m3242a() {
        return m3245a(new SynchronizedPool(20), new C10842(), new C10853());
    }

    private static <T extends Poolable> Pool<T> m3244a(Pool<T> pool, Factory<T> factory) {
        return m3245a(pool, factory, f3676a);
    }
}
