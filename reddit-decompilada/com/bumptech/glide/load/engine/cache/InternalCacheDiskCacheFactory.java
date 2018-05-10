package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter;
import java.io.File;

public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    class C10661 implements CacheDirectoryGetter {
        final /* synthetic */ Context f12508a;
        final /* synthetic */ String f12509b;

        C10661(Context context, String str) {
            this.f12508a = context;
            this.f12509b = str;
        }

        public final File mo956a() {
            File cacheDir = this.f12508a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f12509b != null ? new File(cacheDir, this.f12509b) : cacheDir;
        }
    }

    public InternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache");
    }

    private InternalCacheDiskCacheFactory(Context context, String str) {
        super(new C10661(context, str));
    }
}
