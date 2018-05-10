package com.bumptech.glide.load.model;

import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
    private final List<ModelLoader<Model, Data>> f12558a;
    private final Pool<List<Throwable>> f12559b;

    static class MultiFetcher<Data> implements DataFetcher<Data>, DataCallback<Data> {
        private final List<DataFetcher<Data>> f12552a;
        private final Pool<List<Throwable>> f12553b;
        private int f12554c = null;
        private Priority f12555d;
        private DataCallback<? super Data> f12556e;
        private List<Throwable> f12557f;

        MultiFetcher(List<DataFetcher<Data>> list, Pool<List<Throwable>> pool) {
            this.f12553b = pool;
            Preconditions.m3220a((Collection) list);
            this.f12552a = list;
        }

        public final void mo885a(Priority priority, DataCallback<? super Data> dataCallback) {
            this.f12555d = priority;
            this.f12556e = dataCallback;
            this.f12557f = (List) this.f12553b.mo362a();
            ((DataFetcher) this.f12552a.get(this.f12554c)).mo885a(priority, this);
        }

        public final void mo884a() {
            if (this.f12557f != null) {
                this.f12553b.mo363a(this.f12557f);
            }
            this.f12557f = null;
            for (DataFetcher a : this.f12552a) {
                a.mo884a();
            }
        }

        public final void mo886b() {
            for (DataFetcher b : this.f12552a) {
                b.mo886b();
            }
        }

        public final Class<Data> mo887c() {
            return ((DataFetcher) this.f12552a.get(0)).mo887c();
        }

        public final DataSource mo888d() {
            return ((DataFetcher) this.f12552a.get(0)).mo888d();
        }

        public final void mo903a(Data data) {
            if (data != null) {
                this.f12556e.mo903a((Object) data);
            } else {
                m11504e();
            }
        }

        public final void mo902a(Exception exception) {
            ((List) Preconditions.m3217a(this.f12557f)).add(exception);
            m11504e();
        }

        private void m11504e() {
            if (this.f12554c < this.f12552a.size() - 1) {
                this.f12554c++;
                mo885a(this.f12555d, this.f12556e);
                return;
            }
            Preconditions.m3217a(this.f12557f);
            this.f12556e.mo902a(new GlideException("Fetch failed", new ArrayList(this.f12557f)));
        }
    }

    MultiModelLoader(List<ModelLoader<Model, Data>> list, Pool<List<Throwable>> pool) {
        this.f12558a = list;
        this.f12559b = pool;
    }

    public final LoadData<Data> mo890a(Model model, int i, int i2, Options options) {
        int size = this.f12558a.size();
        List arrayList = new ArrayList(size);
        Key key = null;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader modelLoader = (ModelLoader) this.f12558a.get(i3);
            if (modelLoader.mo891a(model)) {
                LoadData a = modelLoader.mo890a(model, i, i2, options);
                if (a != null) {
                    key = a.f3498a;
                    arrayList.add(a.f3500c);
                }
            }
        }
        if (arrayList.isEmpty() == null) {
            return new LoadData(key, new MultiFetcher(arrayList, this.f12559b));
        }
        return null;
    }

    public final boolean mo891a(Model model) {
        for (ModelLoader a : this.f12558a) {
            if (a.mo891a(model)) {
                return true;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MultiModelLoader{modelLoaders=");
        stringBuilder.append(Arrays.toString(this.f12558a.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
