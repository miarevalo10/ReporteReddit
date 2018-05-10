package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.File;
import java.util.List;

class DataCacheGenerator implements DataCallback<Object>, DataFetcherGenerator {
    private final List<Key> f12335a;
    private final DecodeHelper<?> f12336b;
    private final FetcherReadyCallback f12337c;
    private int f12338d;
    private Key f12339e;
    private List<ModelLoader<File, ?>> f12340f;
    private int f12341g;
    private volatile LoadData<?> f12342h;
    private File f12343i;

    DataCacheGenerator(DecodeHelper<?> decodeHelper, FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.m2895c(), decodeHelper, fetcherReadyCallback);
    }

    DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, FetcherReadyCallback fetcherReadyCallback) {
        this.f12338d = -1;
        this.f12335a = list;
        this.f12336b = decodeHelper;
        this.f12337c = fetcherReadyCallback;
    }

    public final boolean mo904a() {
        boolean z;
        while (true) {
            z = false;
            if (this.f12340f != null) {
                if (m11277c()) {
                    break;
                }
            }
            this.f12338d++;
            if (this.f12338d >= this.f12335a.size()) {
                return false;
            }
            Key key = (Key) this.f12335a.get(this.f12338d);
            this.f12343i = this.f12336b.m2889a().get(new DataCacheKey(key, this.f12336b.f3380n));
            if (this.f12343i != null) {
                this.f12339e = key;
                this.f12340f = this.f12336b.m2890a(this.f12343i);
                this.f12341g = 0;
            }
        }
        this.f12342h = null;
        while (!z && m11277c()) {
            List list = this.f12340f;
            int i = this.f12341g;
            this.f12341g = i + 1;
            this.f12342h = ((ModelLoader) list.get(i)).mo890a(this.f12343i, this.f12336b.f3371e, this.f12336b.f3372f, this.f12336b.f3375i);
            if (this.f12342h != null && this.f12336b.m2891a(this.f12342h.f3500c.mo887c())) {
                this.f12342h.f3500c.mo885a(this.f12336b.f3381o, this);
                z = true;
            }
        }
        return z;
    }

    private boolean m11277c() {
        return this.f12341g < this.f12340f.size();
    }

    public final void mo905b() {
        LoadData loadData = this.f12342h;
        if (loadData != null) {
            loadData.f3500c.mo886b();
        }
    }

    public final void mo903a(Object obj) {
        this.f12337c.mo909a(this.f12339e, obj, this.f12342h.f3500c, DataSource.DATA_DISK_CACHE, this.f12339e);
    }

    public final void mo902a(Exception exception) {
        this.f12337c.mo908a(this.f12339e, exception, this.f12342h.f3500c, DataSource.DATA_DISK_CACHE);
    }
}
