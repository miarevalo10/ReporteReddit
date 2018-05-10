package com.bumptech.glide.load.engine;

import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ResourceCacheGenerator implements DataCallback<Object>, DataFetcherGenerator {
    private final FetcherReadyCallback f12439a;
    private final DecodeHelper<?> f12440b;
    private int f12441c;
    private int f12442d = -1;
    private Key f12443e;
    private List<ModelLoader<File, ?>> f12444f;
    private int f12445g;
    private volatile LoadData<?> f12446h;
    private File f12447i;
    private ResourceCacheKey f12448j;

    ResourceCacheGenerator(DecodeHelper<?> decodeHelper, FetcherReadyCallback fetcherReadyCallback) {
        this.f12440b = decodeHelper;
        this.f12439a = fetcherReadyCallback;
    }

    public final boolean mo904a() {
        List c = this.f12440b.m2895c();
        boolean z = false;
        if (c.isEmpty()) {
            return false;
        }
        DecodeHelper decodeHelper = r0.f12440b;
        Registry registry = decodeHelper.f3369c.f3221d;
        Class cls = decodeHelper.f3370d.getClass();
        Class cls2 = decodeHelper.f3373g;
        Class cls3 = decodeHelper.f3377k;
        List list = registry.f3244h.get(cls, cls2);
        if (list == null) {
            list = new ArrayList();
            for (Class b : registry.f3237a.m3004a(cls)) {
                for (Class cls4 : registry.f3239c.m3117b(b, cls2)) {
                    if (!(registry.f3242f.m3081b(cls4, cls3).isEmpty() || list.contains(cls4))) {
                        list.add(cls4);
                    }
                }
            }
            registry.f3244h.put(cls, cls2, Collections.unmodifiableList(list));
        }
        while (true) {
            if (r0.f12444f != null) {
                if (m11351c()) {
                    break;
                }
            }
            r0.f12442d++;
            if (r0.f12442d >= list.size()) {
                r0.f12441c++;
                if (r0.f12441c >= c.size()) {
                    return false;
                }
                r0.f12442d = 0;
            }
            Key key = (Key) c.get(r0.f12441c);
            Class cls5 = (Class) list.get(r0.f12442d);
            Key key2 = key;
            r0.f12448j = new ResourceCacheKey(r0.f12440b.f3369c.f3220c, key2, r0.f12440b.f3380n, r0.f12440b.f3371e, r0.f12440b.f3372f, r0.f12440b.m2894c(cls5), cls5, r0.f12440b.f3375i);
            r0.f12447i = r0.f12440b.m2889a().get(r0.f12448j);
            if (r0.f12447i != null) {
                r0.f12443e = key;
                r0.f12444f = r0.f12440b.m2890a(r0.f12447i);
                r0.f12445g = 0;
            }
        }
        r0.f12446h = null;
        while (!z && m11351c()) {
            c = r0.f12444f;
            int i = r0.f12445g;
            r0.f12445g = i + 1;
            r0.f12446h = ((ModelLoader) c.get(i)).mo890a(r0.f12447i, r0.f12440b.f3371e, r0.f12440b.f3372f, r0.f12440b.f3375i);
            if (r0.f12446h != null && r0.f12440b.m2891a(r0.f12446h.f3500c.mo887c())) {
                r0.f12446h.f3500c.mo885a(r0.f12440b.f3381o, r0);
                z = true;
            }
        }
        return z;
    }

    private boolean m11351c() {
        return this.f12445g < this.f12444f.size();
    }

    public final void mo905b() {
        LoadData loadData = this.f12446h;
        if (loadData != null) {
            loadData.f3500c.mo886b();
        }
    }

    public final void mo903a(Object obj) {
        this.f12439a.mo909a(this.f12443e, obj, this.f12446h.f3500c, DataSource.RESOURCE_DISK_CACHE, this.f12448j);
    }

    public final void mo902a(Exception exception) {
        this.f12439a.mo908a(this.f12448j, exception, this.f12446h.f3500c, DataSource.RESOURCE_DISK_CACHE);
    }
}
