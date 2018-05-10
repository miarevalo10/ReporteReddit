package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.List;

public class TranscoderRegistry {
    private final List<Entry<?, ?>> f3578a = new ArrayList();

    private static final class Entry<Z, R> {
        final ResourceTranscoder<Z, R> f3575a;
        private final Class<Z> f3576b;
        private final Class<R> f3577c;

        Entry(Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
            this.f3576b = cls;
            this.f3577c = cls2;
            this.f3575a = resourceTranscoder;
        }

        public final boolean m3078a(Class<?> cls, Class<?> cls2) {
            return (this.f3576b.isAssignableFrom(cls) == null || cls2.isAssignableFrom(this.f3577c) == null) ? null : true;
        }
    }

    public final synchronized <Z, R> void m3080a(Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        this.f3578a.add(new Entry(cls, cls2, resourceTranscoder));
    }

    public final synchronized <Z, R> ResourceTranscoder<Z, R> m3079a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.m11686a();
        }
        for (Entry entry : this.f3578a) {
            if (entry.m3078a(cls, cls2)) {
                return entry.f3575a;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("No transcoder registered to transcode from ");
        stringBuilder.append(cls);
        stringBuilder.append(" to ");
        stringBuilder.append(cls2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final synchronized <Z, R> List<Class<R>> m3081b(Class<Z> cls, Class<R> cls2) {
        List<Class<R>> arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (Entry a : this.f3578a) {
            if (a.m3078a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }
}
