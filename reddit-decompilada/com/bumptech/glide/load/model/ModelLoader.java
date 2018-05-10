package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

public interface ModelLoader<Model, Data> {

    public static class LoadData<Data> {
        public final Key f3498a;
        public final List<Key> f3499b;
        public final DataFetcher<Data> f3500c;

        public LoadData(Key key, DataFetcher<Data> dataFetcher) {
            this(key, Collections.emptyList(), dataFetcher);
        }

        private LoadData(Key key, List<Key> list, DataFetcher<Data> dataFetcher) {
            this.f3498a = (Key) Preconditions.m3217a((Object) key);
            this.f3499b = (List) Preconditions.m3217a((Object) list);
            this.f3500c = (DataFetcher) Preconditions.m3217a((Object) dataFetcher);
        }
    }

    LoadData<Data> mo890a(Model model, int i, int i2, Options options);

    boolean mo891a(Model model);
}
