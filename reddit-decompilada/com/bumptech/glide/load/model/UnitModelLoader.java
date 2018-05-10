package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;

public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {
    private static final UnitModelLoader<?> f12570a = new UnitModelLoader();

    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {
        private static final Factory<?> f12568a = new Factory();

        public static <T> Factory<T> m11531a() {
            return f12568a;
        }

        public final ModelLoader<Model, Model> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.m11538a();
        }
    }

    private static class UnitFetcher<Model> implements DataFetcher<Model> {
        private final Model f12569a;

        public final void mo884a() {
        }

        public final void mo886b() {
        }

        UnitFetcher(Model model) {
            this.f12569a = model;
        }

        public final void mo885a(Priority priority, DataCallback<? super Model> dataCallback) {
            dataCallback.mo903a(this.f12569a);
        }

        public final Class<Model> mo887c() {
            return this.f12569a.getClass();
        }

        public final DataSource mo888d() {
            return DataSource.LOCAL;
        }
    }

    public final boolean mo891a(Model model) {
        return true;
    }

    public static <T> UnitModelLoader<T> m11538a() {
        return f12570a;
    }

    public final LoadData<Model> mo890a(Model model, int i, int i2, Options options) {
        return new LoadData(new ObjectKey(model), new UnitFetcher(model));
    }
}
