package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

class EngineKey implements Key {
    private final Object f12418b;
    private final int f12419c;
    private final int f12420d;
    private final Class<?> f12421e;
    private final Class<?> f12422f;
    private final Key f12423g;
    private final Map<Class<?>, Transformation<?>> f12424h;
    private final Options f12425i;
    private int f12426j;

    EngineKey(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.f12418b = Preconditions.m3217a(obj);
        this.f12423g = (Key) Preconditions.m3218a((Object) key, "Signature must not be null");
        this.f12419c = i;
        this.f12420d = i2;
        this.f12424h = (Map) Preconditions.m3217a((Object) map);
        this.f12421e = (Class) Preconditions.m3218a((Object) cls, "Resource class must not be null");
        this.f12422f = (Class) Preconditions.m3218a((Object) cls2, "Transcode class must not be null");
        this.f12425i = (Options) Preconditions.m3217a((Object) options);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EngineKey)) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        if (this.f12418b.equals(engineKey.f12418b) && this.f12423g.equals(engineKey.f12423g) && this.f12420d == engineKey.f12420d && this.f12419c == engineKey.f12419c && this.f12424h.equals(engineKey.f12424h) && this.f12421e.equals(engineKey.f12421e) && this.f12422f.equals(engineKey.f12422f) && this.f12425i.equals(engineKey.f12425i) != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f12426j == 0) {
            this.f12426j = this.f12418b.hashCode();
            this.f12426j = (this.f12426j * 31) + this.f12423g.hashCode();
            this.f12426j = (this.f12426j * 31) + this.f12419c;
            this.f12426j = (this.f12426j * 31) + this.f12420d;
            this.f12426j = (this.f12426j * 31) + this.f12424h.hashCode();
            this.f12426j = (this.f12426j * 31) + this.f12421e.hashCode();
            this.f12426j = (this.f12426j * 31) + this.f12422f.hashCode();
            this.f12426j = (31 * this.f12426j) + this.f12425i.hashCode();
        }
        return this.f12426j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("EngineKey{model=");
        stringBuilder.append(this.f12418b);
        stringBuilder.append(", width=");
        stringBuilder.append(this.f12419c);
        stringBuilder.append(", height=");
        stringBuilder.append(this.f12420d);
        stringBuilder.append(", resourceClass=");
        stringBuilder.append(this.f12421e);
        stringBuilder.append(", transcodeClass=");
        stringBuilder.append(this.f12422f);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.f12423g);
        stringBuilder.append(", hashCode=");
        stringBuilder.append(this.f12426j);
        stringBuilder.append(", transformations=");
        stringBuilder.append(this.f12424h);
        stringBuilder.append(", options=");
        stringBuilder.append(this.f12425i);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final void mo893a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
