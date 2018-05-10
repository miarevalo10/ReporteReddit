package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceDecoderRegistry {
    private final List<String> f3606a = new ArrayList();
    private final Map<String, List<Entry<?, ?>>> f3607b = new HashMap();

    private static class Entry<T, R> {
        final Class<R> f3603a;
        final ResourceDecoder<T, R> f3604b;
        private final Class<T> f3605c;

        public Entry(Class<T> cls, Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            this.f3605c = cls;
            this.f3603a = cls2;
            this.f3604b = resourceDecoder;
        }

        public final boolean m3112a(Class<?> cls, Class<?> cls2) {
            return (this.f3605c.isAssignableFrom(cls) == null || cls2.isAssignableFrom(this.f3603a) == null) ? null : true;
        }
    }

    public final synchronized void m3116a(List<String> list) {
        List<String> arrayList = new ArrayList(this.f3606a);
        this.f3606a.clear();
        this.f3606a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f3606a.add(str);
            }
        }
    }

    public final synchronized <T, R> List<ResourceDecoder<T, R>> m3114a(Class<T> cls, Class<R> cls2) {
        List<ResourceDecoder<T, R>> arrayList;
        arrayList = new ArrayList();
        for (String str : this.f3606a) {
            List<Entry> list = (List) this.f3607b.get(str);
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.m3112a(cls, cls2)) {
                        arrayList.add(entry.f3604b);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized <T, R> List<Class<R>> m3117b(Class<T> cls, Class<R> cls2) {
        List<Class<R>> arrayList;
        arrayList = new ArrayList();
        for (String str : this.f3606a) {
            List<Entry> list = (List) this.f3607b.get(str);
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.m3112a(cls, cls2)) {
                        arrayList.add(entry.f3603a);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized <T, R> void m3115a(String str, ResourceDecoder<T, R> resourceDecoder, Class<T> cls, Class<R> cls2) {
        m3113a(str).add(new Entry(cls, cls2, resourceDecoder));
    }

    private synchronized List<Entry<?, ?>> m3113a(String str) {
        List<Entry<?, ?>> list;
        if (!this.f3606a.contains(str)) {
            this.f3606a.add(str);
        }
        list = (List) this.f3607b.get(str);
        if (list == null) {
            list = new ArrayList();
            this.f3607b.put(str, list);
        }
        return list;
    }
}
