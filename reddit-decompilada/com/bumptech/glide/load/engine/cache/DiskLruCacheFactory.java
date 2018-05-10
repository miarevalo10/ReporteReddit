package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import java.io.File;

public class DiskLruCacheFactory implements Factory {
    private final long f12501a = 262144000;
    private final CacheDirectoryGetter f12502b;

    public interface CacheDirectoryGetter {
        File mo956a();
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter) {
        this.f12502b = cacheDirectoryGetter;
    }

    public final DiskCache mo955a() {
        File a = this.f12502b.mo956a();
        if (a == null) {
            return null;
        }
        if (a.mkdirs() || (a.exists() && a.isDirectory())) {
            return DiskLruCacheWrapper.m11424a(a, this.f12501a);
        }
        return null;
    }
}
