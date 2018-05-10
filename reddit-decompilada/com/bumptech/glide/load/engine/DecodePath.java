package com.bumptech.glide.load.engine;

import android.support.v4.util.Pools.Pool;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

public class DecodePath<DataType, ResourceType, Transcode> {
    final ResourceTranscoder<ResourceType, Transcode> f3405a;
    private final Class<DataType> f3406b;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> f3407c;
    private final Pool<List<Throwable>> f3408d;
    private final String f3409e;

    interface DecodeCallback<ResourceType> {
        Resource<ResourceType> mo907a(Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pool<List<Throwable>> pool) {
        this.f3406b = cls;
        this.f3407c = list;
        this.f3405a = resourceTranscoder;
        this.f3408d = pool;
        list = new StringBuilder("Failed DecodePath{");
        list.append(cls.getSimpleName());
        list.append("->");
        list.append(cls2.getSimpleName());
        list.append("->");
        list.append(cls3.getSimpleName());
        list.append("}");
        this.f3409e = list.toString();
    }

    final Resource<ResourceType> m2908a(DataRewinder<DataType> dataRewinder, int i, int i2, Options options) throws GlideException {
        List list = (List) Preconditions.m3217a(this.f3408d.mo362a());
        try {
            dataRewinder = m2907a(dataRewinder, i, i2, options, list);
            return dataRewinder;
        } finally {
            this.f3408d.mo363a(list);
        }
    }

    private Resource<ResourceType> m2907a(DataRewinder<DataType> dataRewinder, int i, int i2, Options options, List<Throwable> list) throws GlideException {
        int size = this.f3407c.size();
        Resource<ResourceType> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) this.f3407c.get(i3);
            try {
                if (resourceDecoder.mo980a(dataRewinder.mo898a(), options)) {
                    resource = resourceDecoder.mo979a(dataRewinder.mo898a(), i, i2, options);
                }
            } catch (Throwable e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    StringBuilder stringBuilder = new StringBuilder("Failed to decode data for ");
                    stringBuilder.append(resourceDecoder);
                    Log.v("DecodePath", stringBuilder.toString(), e);
                }
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f3409e, new ArrayList(list));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DecodePath{ dataClass=");
        stringBuilder.append(this.f3406b);
        stringBuilder.append(", decoders=");
        stringBuilder.append(this.f3407c);
        stringBuilder.append(", transcoder=");
        stringBuilder.append(this.f3405a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
