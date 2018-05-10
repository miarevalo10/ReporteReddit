package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class ObjectKey implements Key {
    private final Object f12670b;

    public ObjectKey(Object obj) {
        this.f12670b = Preconditions.m3217a(obj);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ObjectKey{object=");
        stringBuilder.append(this.f12670b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ObjectKey)) {
            return null;
        }
        return this.f12670b.equals(((ObjectKey) obj).f12670b);
    }

    public final int hashCode() {
        return this.f12670b.hashCode();
    }

    public final void mo893a(MessageDigest messageDigest) {
        messageDigest.update(this.f12670b.toString().getBytes(a));
    }
}
