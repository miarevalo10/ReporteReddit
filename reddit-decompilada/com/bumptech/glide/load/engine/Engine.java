package com.bumptech.glide.load.engine;

import android.support.v4.util.Pools.Pool;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.FactoryPools.Factory;

public class Engine implements EngineJobListener, ResourceListener, ResourceRemovedListener {
    public final Jobs f12385a;
    public final MemoryCache f12386b;
    public final EngineJobFactory f12387c;
    public final DecodeJobFactory f12388d;
    public final ActiveResources f12389e;
    private final EngineKeyFactory f12390f;
    private final ResourceRecycler f12391g;
    private final LazyDiskCacheProvider f12392h;

    static class DecodeJobFactory {
        final DiskCacheProvider f3415a;
        public final Pool<DecodeJob<?>> f3416b = FactoryPools.m3246a(new C10631(this));
        public int f3417c;

        class C10631 implements Factory<DecodeJob<?>> {
            final /* synthetic */ DecodeJobFactory f12381a;

            C10631(DecodeJobFactory decodeJobFactory) {
                this.f12381a = decodeJobFactory;
            }

            public final /* synthetic */ Object mo916a() {
                return new DecodeJob(this.f12381a.f3415a, this.f12381a.f3416b);
            }
        }

        DecodeJobFactory(DiskCacheProvider diskCacheProvider) {
            this.f3415a = diskCacheProvider;
        }
    }

    static class EngineJobFactory {
        final GlideExecutor f3418a;
        final GlideExecutor f3419b;
        final GlideExecutor f3420c;
        final GlideExecutor f3421d;
        final EngineJobListener f3422e;
        public final Pool<EngineJob<?>> f3423f = FactoryPools.m3246a(new C10641(this));

        class C10641 implements Factory<EngineJob<?>> {
            final /* synthetic */ EngineJobFactory f12382a;

            C10641(EngineJobFactory engineJobFactory) {
                this.f12382a = engineJobFactory;
            }

            public final /* synthetic */ Object mo916a() {
                return new EngineJob(this.f12382a.f3418a, this.f12382a.f3419b, this.f12382a.f3420c, this.f12382a.f3421d, this.f12382a.f3422e, this.f12382a.f3423f);
            }
        }

        EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener) {
            this.f3418a = glideExecutor;
            this.f3419b = glideExecutor2;
            this.f3420c = glideExecutor3;
            this.f3421d = glideExecutor4;
            this.f3422e = engineJobListener;
        }
    }

    public static class LoadStatus {
        public final EngineJob<?> f3424a;
        public final ResourceCallback f3425b;

        public LoadStatus(ResourceCallback resourceCallback, EngineJob<?> engineJob) {
            this.f3425b = resourceCallback;
            this.f3424a = engineJob;
        }
    }

    private static class LazyDiskCacheProvider implements DiskCacheProvider {
        private final DiskCache.Factory f12383a;
        private volatile DiskCache f12384b;

        LazyDiskCacheProvider(DiskCache.Factory factory) {
            this.f12383a = factory;
        }

        public final DiskCache mo917a() {
            if (this.f12384b == null) {
                synchronized (this) {
                    if (this.f12384b == null) {
                        this.f12384b = this.f12383a.mo955a();
                    }
                    if (this.f12384b == null) {
                        this.f12384b = new DiskCacheAdapter();
                    }
                }
            }
            return this.f12384b;
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, z, (byte) 0);
    }

    private Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z, byte b) {
        this.f12386b = memoryCache;
        this.f12392h = new LazyDiskCacheProvider(factory);
        factory = new ActiveResources(z);
        this.f12389e = factory;
        factory.f3361c = this;
        this.f12390f = new EngineKeyFactory();
        this.f12385a = new Jobs();
        this.f12387c = new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this);
        this.f12388d = new DecodeJobFactory(this.f12392h);
        this.f12391g = new ResourceRecycler();
        memoryCache.setResourceRemovedListener(this);
    }

    public static void m11323a(String str, long j, Key key) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" in ");
        stringBuilder.append(LogTime.m3212a(j));
        stringBuilder.append("ms, key: ");
        stringBuilder.append(key);
        Log.v("Engine", stringBuilder.toString());
    }

    public static void m11322a(Resource<?> resource) {
        Util.m3230a();
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).m11343f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public final void mo920a(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource) {
        Util.m3230a();
        if (engineResource != null) {
            engineResource.m11338a(key, this);
            if (engineResource.f12427a) {
                this.f12389e.m2882a(key, engineResource);
            }
        }
        this.f12385a.m2927a(key, engineJob);
    }

    public final void mo919a(EngineJob<?> engineJob, Key key) {
        Util.m3230a();
        this.f12385a.m2927a(key, engineJob);
    }

    public final void mo921b(Resource<?> resource) {
        Util.m3230a();
        this.f12391g.m2934a(resource);
    }

    public final void mo918a(Key key, EngineResource<?> engineResource) {
        Util.m3230a();
        ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.f12389e.f3360b.remove(key);
        if (resourceWeakReference != null) {
            resourceWeakReference.m2881a();
        }
        if (engineResource.f12427a) {
            this.f12386b.put(key, engineResource);
        } else {
            this.f12391g.m2934a(engineResource);
        }
    }
}
