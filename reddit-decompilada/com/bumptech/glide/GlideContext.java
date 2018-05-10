package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import java.util.Map;

public class GlideContext extends ContextWrapper {
    static final TransitionOptions<?, ?> f3218a = new GenericTransitionOptions();
    final Handler f3219b = new Handler(Looper.getMainLooper());
    public final ArrayPool f3220c;
    public final Registry f3221d;
    final RequestOptions f3222e;
    final Map<Class<?>, TransitionOptions<?, ?>> f3223f;
    final Engine f3224g;
    public final int f3225h;
    private final ImageViewTargetFactory f3226i;

    public GlideContext(Context context, ArrayPool arrayPool, Registry registry, ImageViewTargetFactory imageViewTargetFactory, RequestOptions requestOptions, Map<Class<?>, TransitionOptions<?, ?>> map, Engine engine, int i) {
        super(context.getApplicationContext());
        this.f3220c = arrayPool;
        this.f3221d = registry;
        this.f3226i = imageViewTargetFactory;
        this.f3222e = requestOptions;
        this.f3223f = map;
        this.f3224g = engine;
        this.f3225h = i;
    }
}
