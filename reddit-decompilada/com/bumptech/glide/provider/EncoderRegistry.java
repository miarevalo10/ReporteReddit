package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

public class EncoderRegistry {
    private final List<Entry<?>> f3601a = new ArrayList();

    private static final class Entry<T> {
        final Class<T> f3599a;
        final Encoder<T> f3600b;

        Entry(Class<T> cls, Encoder<T> encoder) {
            this.f3599a = cls;
            this.f3600b = encoder;
        }
    }

    public final synchronized <T> Encoder<T> m3108a(Class<T> cls) {
        for (Entry entry : this.f3601a) {
            if (entry.f3599a.isAssignableFrom(cls)) {
                return entry.f3600b;
            }
        }
        return null;
    }

    public final synchronized <T> void m3109a(Class<T> cls, Encoder<T> encoder) {
        this.f3601a.add(new Entry(cls, encoder));
    }
}
