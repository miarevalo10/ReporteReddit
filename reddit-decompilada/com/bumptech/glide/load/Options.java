package com.bumptech.glide.load;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;
import com.bumptech.glide.load.Option.CacheKeyUpdater;
import java.security.MessageDigest;

public final class Options implements Key {
    private final ArrayMap<Option<?>, Object> f12311b = new ArrayMap();

    public final void m11236a(Options options) {
        this.f12311b.m1051a((SimpleArrayMap) options.f12311b);
    }

    public final <T> Options m11234a(Option<T> option, T t) {
        this.f12311b.put(option, t);
        return this;
    }

    public final <T> T m11235a(Option<T> option) {
        return this.f12311b.containsKey(option) ? this.f12311b.get(option) : option.f3337a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Options)) {
            return null;
        }
        return this.f12311b.equals(((Options) obj).f12311b);
    }

    public final int hashCode() {
        return this.f12311b.hashCode();
    }

    public final void mo893a(MessageDigest messageDigest) {
        for (int i = 0; i < this.f12311b.size(); i++) {
            Option option = (Option) this.f12311b.m1053b(i);
            Object c = this.f12311b.m1054c(i);
            CacheKeyUpdater cacheKeyUpdater = option.f3338b;
            if (option.f3340d == null) {
                option.f3340d = option.f3339c.getBytes(Key.f3335a);
            }
            cacheKeyUpdater.mo892a(option.f3340d, c, messageDigest);
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Options{values=");
        stringBuilder.append(this.f12311b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
