package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class ResourceCacheKey implements Key {
    private static final LruCache<Class<?>, byte[]> f12449b = new LruCache(50);
    private final ArrayPool f12450c;
    private final Key f12451d;
    private final Key f12452e;
    private final int f12453f;
    private final int f12454g;
    private final Class<?> f12455h;
    private final Options f12456i;
    private final Transformation<?> f12457j;

    ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int i, int i2, Transformation<?> transformation, Class<?> cls, Options options) {
        this.f12450c = arrayPool;
        this.f12451d = key;
        this.f12452e = key2;
        this.f12453f = i;
        this.f12454g = i2;
        this.f12457j = transformation;
        this.f12455h = cls;
        this.f12456i = options;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ResourceCacheKey)) {
            return false;
        }
        ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
        if (this.f12454g == resourceCacheKey.f12454g && this.f12453f == resourceCacheKey.f12453f && Util.m3232a(this.f12457j, resourceCacheKey.f12457j) && this.f12455h.equals(resourceCacheKey.f12455h) && this.f12451d.equals(resourceCacheKey.f12451d) && this.f12452e.equals(resourceCacheKey.f12452e) && this.f12456i.equals(resourceCacheKey.f12456i) != null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((((this.f12451d.hashCode() * 31) + this.f12452e.hashCode()) * 31) + this.f12453f) * 31) + this.f12454g;
        if (this.f12457j != null) {
            hashCode = (hashCode * 31) + this.f12457j.hashCode();
        }
        return (31 * ((hashCode * 31) + this.f12455h.hashCode())) + this.f12456i.hashCode();
    }

    public final void mo893a(MessageDigest messageDigest) {
        Object obj = (byte[]) this.f12450c.mo947a(byte[].class);
        ByteBuffer.wrap(obj).putInt(this.f12453f).putInt(this.f12454g).array();
        this.f12452e.mo893a(messageDigest);
        this.f12451d.mo893a(messageDigest);
        messageDigest.update(obj);
        if (this.f12457j != null) {
            this.f12457j.mo893a(messageDigest);
        }
        this.f12456i.mo893a(messageDigest);
        byte[] bArr = (byte[]) f12449b.get(this.f12455h);
        if (bArr == null) {
            bArr = this.f12455h.getName().getBytes(a);
            f12449b.put(this.f12455h, bArr);
        }
        messageDigest.update(bArr);
        this.f12450c.mo950a(obj);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ResourceCacheKey{sourceKey=");
        stringBuilder.append(this.f12451d);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.f12452e);
        stringBuilder.append(", width=");
        stringBuilder.append(this.f12453f);
        stringBuilder.append(", height=");
        stringBuilder.append(this.f12454g);
        stringBuilder.append(", decodedResourceClass=");
        stringBuilder.append(this.f12455h);
        stringBuilder.append(", transformation='");
        stringBuilder.append(this.f12457j);
        stringBuilder.append('\'');
        stringBuilder.append(", options=");
        stringBuilder.append(this.f12456i);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
