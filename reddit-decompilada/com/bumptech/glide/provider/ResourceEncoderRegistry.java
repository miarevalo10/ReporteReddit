package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

public class ResourceEncoderRegistry {
    private final List<Entry<?>> f3610a = new ArrayList();

    private static final class Entry<T> {
        final Class<T> f3608a;
        final ResourceEncoder<T> f3609b;

        Entry(Class<T> cls, ResourceEncoder<T> resourceEncoder) {
            this.f3608a = cls;
            this.f3609b = resourceEncoder;
        }
    }

    public final synchronized <Z> void m3119a(Class<Z> cls, ResourceEncoder<Z> resourceEncoder) {
        this.f3610a.add(new Entry(cls, resourceEncoder));
    }

    public final synchronized <Z> ResourceEncoder<Z> m3118a(Class<Z> cls) {
        int size = this.f3610a.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) this.f3610a.get(i);
            if (entry.f3608a.isAssignableFrom(cls)) {
                return entry.f3609b;
            }
        }
        return null;
    }
}
