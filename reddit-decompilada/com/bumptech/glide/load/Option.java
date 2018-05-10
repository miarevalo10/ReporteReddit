package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class Option<T> {
    private static final CacheKeyUpdater<Object> f3336e = new C10561();
    final T f3337a;
    final CacheKeyUpdater<T> f3338b;
    final String f3339c;
    volatile byte[] f3340d;

    public interface CacheKeyUpdater<T> {
        void mo892a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    class C10561 implements CacheKeyUpdater<Object> {
        public final void mo892a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }

        C10561() {
        }
    }

    public static <T> Option<T> m2850a(String str) {
        return new Option(str, null, f3336e);
    }

    public static <T> Option<T> m2851a(String str, T t) {
        return new Option(str, t, f3336e);
    }

    public static <T> Option<T> m2852a(String str, T t, CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option(str, t, cacheKeyUpdater);
    }

    private Option(String str, T t, CacheKeyUpdater<T> cacheKeyUpdater) {
        this.f3339c = Preconditions.m3219a(str);
        this.f3337a = t;
        this.f3338b = (CacheKeyUpdater) Preconditions.m3217a((Object) cacheKeyUpdater);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Option)) {
            return null;
        }
        return this.f3339c.equals(((Option) obj).f3339c);
    }

    public final int hashCode() {
        return this.f3339c.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Option{key='");
        stringBuilder.append(this.f3339c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
