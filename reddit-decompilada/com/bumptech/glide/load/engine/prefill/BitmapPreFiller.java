package com.bumptech.glide.load.engine.prefill;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;

public final class BitmapPreFiller {
    private final MemoryCache f3483a;
    private final BitmapPool f3484b;
    private final DecodeFormat f3485c;
    private final Handler f3486d = new Handler(Looper.getMainLooper());

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.f3483a = memoryCache;
        this.f3484b = bitmapPool;
        this.f3485c = decodeFormat;
    }
}
