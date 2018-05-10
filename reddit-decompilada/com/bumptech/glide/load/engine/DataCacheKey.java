package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

final class DataCacheKey implements Key {
    private final Key f12344b;
    private final Key f12345c;

    DataCacheKey(Key key, Key key2) {
        this.f12344b = key;
        this.f12345c = key2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DataCacheKey)) {
            return false;
        }
        DataCacheKey dataCacheKey = (DataCacheKey) obj;
        if (!this.f12344b.equals(dataCacheKey.f12344b) || this.f12345c.equals(dataCacheKey.f12345c) == null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (31 * this.f12344b.hashCode()) + this.f12345c.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataCacheKey{sourceKey=");
        stringBuilder.append(this.f12344b);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.f12345c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final void mo893a(MessageDigest messageDigest) {
        this.f12344b.mo893a(messageDigest);
        this.f12345c.mo893a(messageDigest);
    }
}
