package com.vincentbrison.openlibraries.android.dualcache;

import android.content.Context;
import java.io.File;

public class Builder<T> {
    private String f24296a;
    private int f24297b = 209200;
    private boolean f24298c = null;
    private int f24299d;
    private DualCacheRamMode f24300e = null;
    private CacheSerializer<T> f24301f;
    private SizeOf<T> f24302g;
    private int f24303h;
    private DualCacheDiskMode f24304i = null;
    private DiskCacheSerializer<T> f24305j;
    private File f24306k;

    public Builder(String str) {
        this.f24296a = str;
    }

    public final Builder<T> m25997a() {
        this.f24298c = true;
        return this;
    }

    public final DualCache<T> m26000b() {
        if (this.f24300e == null) {
            throw new IllegalStateException("No ram mode set");
        } else if (this.f24304i == null) {
            throw new IllegalStateException("No disk mode set");
        } else {
            DualCache<T> dualCache = new DualCache(this.f24297b, new Logger(this.f24298c), this.f24300e, this.f24301f, this.f24299d, this.f24302g, this.f24304i, this.f24305j, this.f24303h, this.f24306k);
            boolean equals = dualCache.getRAMMode().equals(DualCacheRamMode.DISABLE);
            boolean equals2 = dualCache.getDiskMode().equals(DualCacheDiskMode.DISABLE);
            if (!equals || !equals2) {
                return dualCache;
            }
            throw new IllegalStateException("The ram cache layer and the disk cache layer are disable. You have to use at least one of those layers.");
        }
    }

    public final Builder<T> m25999a(SizeOf<T> sizeOf) {
        this.f24300e = DualCacheRamMode.ENABLE_WITH_REFERENCE;
        this.f24299d = 5;
        this.f24302g = sizeOf;
        return this;
    }

    public final Builder<T> m25998a(DiskCacheSerializer<T> diskCacheSerializer, Context context) {
        StringBuilder stringBuilder = new StringBuilder("dualcache");
        stringBuilder.append(this.f24296a);
        this.f24306k = context.getDir(stringBuilder.toString(), 0);
        this.f24304i = DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER;
        this.f24303h = 26214400;
        this.f24305j = diskCacheSerializer;
        return this;
    }
}
