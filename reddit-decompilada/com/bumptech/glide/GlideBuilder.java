package com.bumptech.glide;

import android.support.v4.util.ArrayMap;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import com.bumptech.glide.request.RequestOptions;
import java.util.Map;

public final class GlideBuilder {
    final Map<Class<?>, TransitionOptions<?, ?>> f3203a = new ArrayMap();
    Engine f3204b;
    BitmapPool f3205c;
    ArrayPool f3206d;
    MemoryCache f3207e;
    GlideExecutor f3208f;
    GlideExecutor f3209g;
    Factory f3210h;
    MemorySizeCalculator f3211i;
    ConnectivityMonitorFactory f3212j;
    int f3213k = 4;
    public RequestOptions f3214l = new RequestOptions();
    RequestManagerFactory f3215m;
    GlideExecutor f3216n;
    boolean f3217o;
}
