package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Registry.NoSourceEncoderAvailableException;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback;
import com.bumptech.glide.load.engine.cache.DiskCache.Writer;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

class SourceGenerator implements DataCallback<Object>, DataFetcherGenerator, FetcherReadyCallback {
    private final DecodeHelper<?> f12458a;
    private final FetcherReadyCallback f12459b;
    private int f12460c;
    private DataCacheGenerator f12461d;
    private Object f12462e;
    private volatile LoadData<?> f12463f;
    private DataCacheKey f12464g;

    SourceGenerator(DecodeHelper<?> decodeHelper, FetcherReadyCallback fetcherReadyCallback) {
        this.f12458a = decodeHelper;
        this.f12459b = fetcherReadyCallback;
    }

    public final boolean mo904a() {
        if (this.f12462e != null) {
            Object obj = this.f12462e;
            this.f12462e = null;
            long a = LogTime.m3213a();
            try {
                Encoder a2 = this.f12458a.f3369c.f3221d.f3238b.m3108a(obj.getClass());
                if (a2 != null) {
                    Writer dataCacheWriter = new DataCacheWriter(a2, obj, this.f12458a.f3375i);
                    this.f12464g = new DataCacheKey(this.f12463f.f3498a, this.f12458a.f3380n);
                    this.f12458a.m2889a().put(this.f12464g, dataCacheWriter);
                    if (Log.isLoggable("SourceGenerator", 2)) {
                        StringBuilder stringBuilder = new StringBuilder("Finished encoding source to cache, key: ");
                        stringBuilder.append(this.f12464g);
                        stringBuilder.append(", data: ");
                        stringBuilder.append(obj);
                        stringBuilder.append(", encoder: ");
                        stringBuilder.append(a2);
                        stringBuilder.append(", duration: ");
                        stringBuilder.append(LogTime.m3212a(a));
                        Log.v("SourceGenerator", stringBuilder.toString());
                    }
                    this.f12463f.f3500c.mo884a();
                    this.f12461d = new DataCacheGenerator(Collections.singletonList(this.f12463f.f3498a), this.f12458a, this);
                } else {
                    throw new NoSourceEncoderAvailableException(obj.getClass());
                }
            } catch (Throwable th) {
                this.f12463f.f3500c.mo884a();
            }
        }
        if (this.f12461d != null && this.f12461d.mo904a()) {
            return true;
        }
        this.f12461d = null;
        this.f12463f = null;
        boolean z = false;
        while (!z) {
            if (!(this.f12460c < this.f12458a.m2893b().size())) {
                break;
            }
            List b = this.f12458a.m2893b();
            int i = this.f12460c;
            this.f12460c = i + 1;
            this.f12463f = (LoadData) b.get(i);
            if (this.f12463f != null && (this.f12458a.f3382p.mo913a(this.f12463f.f3500c.mo888d()) || this.f12458a.m2891a(this.f12463f.f3500c.mo887c()))) {
                this.f12463f.f3500c.mo885a(this.f12458a.f3381o, this);
                z = true;
            }
        }
        return z;
    }

    public final void mo905b() {
        LoadData loadData = this.f12463f;
        if (loadData != null) {
            loadData.f3500c.mo886b();
        }
    }

    public final void mo903a(Object obj) {
        DiskCacheStrategy diskCacheStrategy = this.f12458a.f3382p;
        if (obj == null || !diskCacheStrategy.mo913a(this.f12463f.f3500c.mo888d())) {
            this.f12459b.mo909a(this.f12463f.f3498a, obj, this.f12463f.f3500c, this.f12463f.f3500c.mo888d(), this.f12464g);
            return;
        }
        this.f12462e = obj;
        this.f12459b.mo910c();
    }

    public final void mo902a(Exception exception) {
        this.f12459b.mo908a(this.f12464g, exception, this.f12463f.f3500c, this.f12463f.f3500c.mo888d());
    }

    public final void mo910c() {
        throw new UnsupportedOperationException();
    }

    public final void mo909a(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f12459b.mo909a(key, obj, dataFetcher, this.f12463f.f3500c.mo888d(), key);
    }

    public final void mo908a(Key key, Exception exception, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f12459b.mo908a(key, exception, dataFetcher, this.f12463f.f3500c.mo888d());
    }
}
