package com.bumptech.glide.load.model;

import android.support.v4.util.Pools.Pool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelLoaderRegistry {
    private final MultiModelLoaderFactory f3503a;
    private final ModelLoaderCache f3504b;

    private static class ModelLoaderCache {
        final Map<Class<?>, Entry<?>> f3502a = new HashMap();

        private static class Entry<Model> {
            final List<ModelLoader<Model, ?>> f3501a;

            public Entry(List<ModelLoader<Model, ?>> list) {
                this.f3501a = list;
            }
        }

        ModelLoaderCache() {
        }

        public final void m3003a() {
            this.f3502a.clear();
        }
    }

    public ModelLoaderRegistry(Pool<List<Throwable>> pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    private ModelLoaderRegistry(MultiModelLoaderFactory multiModelLoaderFactory) {
        this.f3504b = new ModelLoaderCache();
        this.f3503a = multiModelLoaderFactory;
    }

    public final synchronized <Model, Data> void m3006a(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f3503a.m3015a(cls, cls2, modelLoaderFactory);
        this.f3504b.m3003a();
    }

    public final synchronized <Model, Data> void m3007b(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        cls = this.f3503a.m3017b(cls, cls2, modelLoaderFactory).iterator();
        while (cls.hasNext() != null) {
            cls.next();
        }
        this.f3504b.m3003a();
    }

    public final synchronized List<Class<?>> m3004a(Class<?> cls) {
        return this.f3503a.m3016b(cls);
    }

    public final synchronized <A> List<ModelLoader<A, ?>> m3005a(A a) {
        List<ModelLoader<A, ?>> arrayList;
        List list;
        Class cls = a.getClass();
        Entry entry = (Entry) this.f3504b.f3502a.get(cls);
        if (entry == null) {
            list = null;
        } else {
            list = entry.f3501a;
        }
        if (list == null) {
            list = Collections.unmodifiableList(this.f3503a.m3014a(cls));
            if (((Entry) this.f3504b.f3502a.put(cls, new Entry(list))) != null) {
                StringBuilder stringBuilder = new StringBuilder("Already cached loaders for model: ");
                stringBuilder.append(cls);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        int size = list.size();
        arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            ModelLoader modelLoader = (ModelLoader) list.get(i);
            if (modelLoader.mo891a(a)) {
                arrayList.add(modelLoader);
            }
        }
        return arrayList;
    }
}
