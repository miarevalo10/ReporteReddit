package com.bumptech.glide.load.model;

import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiModelLoaderFactory {
    private static final Factory f3508a = new Factory();
    private static final ModelLoader<Object, Object> f3509b = new EmptyModelLoader();
    private final List<Entry<?, ?>> f3510c;
    private final Factory f3511d;
    private final Set<Entry<?, ?>> f3512e;
    private final Pool<List<Throwable>> f3513f;

    private static class Entry<Model, Data> {
        final Class<Data> f3505a;
        final ModelLoaderFactory<? extends Model, ? extends Data> f3506b;
        private final Class<Model> f3507c;

        public Entry(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.f3507c = cls;
            this.f3505a = cls2;
            this.f3506b = modelLoaderFactory;
        }

        public final boolean m3009a(Class<?> cls, Class<?> cls2) {
            return (m3008a(cls) == null || this.f3505a.isAssignableFrom(cls2) == null) ? null : true;
        }

        public final boolean m3008a(Class<?> cls) {
            return this.f3507c.isAssignableFrom(cls);
        }
    }

    static class Factory {
        Factory() {
        }

        public static <Model, Data> MultiModelLoader<Model, Data> m3010a(List<ModelLoader<Model, Data>> list, Pool<List<Throwable>> pool) {
            return new MultiModelLoader(list, pool);
        }
    }

    private static class EmptyModelLoader implements ModelLoader<Object, Object> {
        public final LoadData<Object> mo890a(Object obj, int i, int i2, Options options) {
            return null;
        }

        public final boolean mo891a(Object obj) {
            return false;
        }

        EmptyModelLoader() {
        }
    }

    public MultiModelLoaderFactory(Pool<List<Throwable>> pool) {
        this(pool, f3508a);
    }

    private MultiModelLoaderFactory(Pool<List<Throwable>> pool, Factory factory) {
        this.f3510c = new ArrayList();
        this.f3512e = new HashSet();
        this.f3513f = pool;
        this.f3511d = factory;
    }

    final synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> m3017b(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> b;
        b = m3012b(cls, cls2);
        m3015a(cls, cls2, modelLoaderFactory);
        return b;
    }

    private synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> m3012b(Class<Model> cls, Class<Data> cls2) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f3510c.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (entry.m3009a(cls, cls2)) {
                it.remove();
                arrayList.add(entry.f3506b);
            }
        }
        return arrayList;
    }

    final synchronized <Model> List<ModelLoader<Model, ?>> m3014a(Class<Model> cls) {
        List<ModelLoader<Model, ?>> arrayList;
        try {
            arrayList = new ArrayList();
            for (Entry entry : this.f3510c) {
                if (!this.f3512e.contains(entry) && entry.m3008a(cls)) {
                    this.f3512e.add(entry);
                    arrayList.add(m3011a(entry));
                    this.f3512e.remove(entry);
                }
            }
        } catch (Throwable th) {
            this.f3512e.clear();
        }
        return arrayList;
    }

    final synchronized List<Class<?>> m3016b(Class<?> cls) {
        List<Class<?>> arrayList;
        arrayList = new ArrayList();
        for (Entry entry : this.f3510c) {
            if (!arrayList.contains(entry.f3505a) && entry.m3008a(cls)) {
                arrayList.add(entry.f3505a);
            }
        }
        return arrayList;
    }

    public final synchronized <Model, Data> ModelLoader<Model, Data> m3013a(Class<Model> cls, Class<Data> cls2) {
        try {
            List arrayList = new ArrayList();
            int i = 0;
            for (Entry entry : this.f3510c) {
                if (this.f3512e.contains(entry)) {
                    i = 1;
                } else if (entry.m3009a(cls, cls2)) {
                    this.f3512e.add(entry);
                    arrayList.add(m3011a(entry));
                    this.f3512e.remove(entry);
                }
            }
            if (arrayList.size() > 1) {
                return Factory.m3010a(arrayList, this.f3513f);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (i != 0) {
                return f3509b;
            } else {
                throw new NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.f3512e.clear();
        }
    }

    private <Model, Data> ModelLoader<Model, Data> m3011a(Entry<?, ?> entry) {
        return (ModelLoader) Preconditions.m3217a(entry.f3506b.mo889a(this));
    }

    final synchronized <Model, Data> void m3015a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f3510c.add(this.f3510c.size(), new Entry(cls, cls2, modelLoaderFactory));
    }
}
