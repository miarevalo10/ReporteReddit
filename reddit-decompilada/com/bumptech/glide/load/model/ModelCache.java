package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> f3494a = Util.m3229a(0);
        private int f3495b;
        private int f3496c;
        private A f3497d;

        static <A> ModelKey<A> m2998a(A a, int i, int i2) {
            ModelKey<A> modelKey;
            synchronized (f3494a) {
                modelKey = (ModelKey) f3494a.poll();
            }
            if (modelKey == null) {
                modelKey = new ModelKey();
            }
            modelKey.f3497d = a;
            modelKey.f3496c = i;
            modelKey.f3495b = i2;
            return modelKey;
        }

        private ModelKey() {
        }

        public final void m2999a() {
            synchronized (f3494a) {
                f3494a.offer(this);
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            if (this.f3496c == modelKey.f3496c && this.f3495b == modelKey.f3495b && this.f3497d.equals(modelKey.f3497d) != null) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (31 * ((this.f3495b * 31) + this.f3496c)) + this.f3497d.hashCode();
        }
    }

    public ModelCache() {
        this(250);
    }

    public ModelCache(long j) {
        this.cache = new LruCache<ModelKey<A>, B>(this, j) {
            final /* synthetic */ ModelCache f12551a;

            protected /* synthetic */ void onItemEvicted(Object obj, Object obj2) {
                ((ModelKey) obj).m2999a();
            }
        };
    }

    public B get(A a, int i, int i2) {
        a = ModelKey.m2998a(a, i, i2);
        i = this.cache.get(a);
        a.m2999a();
        return i;
    }

    public void put(A a, int i, int i2, B b) {
        this.cache.put(ModelKey.m2998a(a, i, i2), b);
    }

    public void clear() {
        this.cache.clearMemory();
    }
}
