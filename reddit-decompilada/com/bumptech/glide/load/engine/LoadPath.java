package com.bumptech.glide.load.engine;

import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class LoadPath<Data, ResourceType, Transcode> {
    private final Class<Data> f3436a;
    private final Pool<List<Throwable>> f3437b;
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> f3438c;
    private final String f3439d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pool<List<Throwable>> pool) {
        this.f3436a = cls;
        this.f3437b = pool;
        this.f3438c = (List) Preconditions.m3220a((Collection) list);
        list = new StringBuilder("Failed LoadPath{");
        list.append(cls.getSimpleName());
        list.append("->");
        list.append(cls2.getSimpleName());
        list.append("->");
        list.append(cls3.getSimpleName());
        list.append("}");
        this.f3439d = list.toString();
    }

    public final Resource<Transcode> m2929a(DataRewinder<Data> dataRewinder, Options options, int i, int i2, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        List list = (List) Preconditions.m3217a(this.f3437b.mo362a());
        try {
            dataRewinder = m2928a(dataRewinder, options, i, i2, decodeCallback, list);
            return dataRewinder;
        } finally {
            this.f3437b.mo363a(list);
        }
    }

    private Resource<Transcode> m2928a(DataRewinder<Data> dataRewinder, Options options, int i, int i2, DecodeCallback<ResourceType> decodeCallback, List<Throwable> list) throws GlideException {
        int size = this.f3438c.size();
        Resource<Transcode> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            DecodePath decodePath = (DecodePath) this.f3438c.get(i3);
            try {
                resource = decodePath.f3405a.mo1002a(decodeCallback.mo907a(decodePath.m2908a(dataRewinder, i, i2, options)), options);
            } catch (GlideException e) {
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f3439d, new ArrayList(list));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LoadPath{decodePaths=");
        stringBuilder.append(Arrays.toString(this.f3438c.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
