package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;

public class EngineJob<R> implements Callback<R>, Poolable {
    private static final EngineResourceFactory f12393r = new EngineResourceFactory();
    private static final Handler f12394s = new Handler(Looper.getMainLooper(), new MainThreadCallback());
    public final List<ResourceCallback> f12395a;
    public final StateVerifier f12396b;
    public final EngineJobListener f12397c;
    public final GlideExecutor f12398d;
    public Key f12399e;
    public boolean f12400f;
    public boolean f12401g;
    public boolean f12402h;
    public boolean f12403i;
    Resource<?> f12404j;
    DataSource f12405k;
    public boolean f12406l;
    public boolean f12407m;
    public List<ResourceCallback> f12408n;
    EngineResource<?> f12409o;
    public DecodeJob<R> f12410p;
    public volatile boolean f12411q;
    private final Pool<EngineJob<?>> f12412t;
    private final EngineResourceFactory f12413u;
    private final GlideExecutor f12414v;
    private final GlideExecutor f12415w;
    private final GlideExecutor f12416x;
    private GlideException f12417y;

    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public static <R> EngineResource<R> m2913a(Resource<R> resource, boolean z) {
            return new EngineResource(resource, z, true);
        }
    }

    private static class MainThreadCallback implements Callback {
        MainThreadCallback() {
        }

        public boolean handleMessage(Message message) {
            EngineJob engineJob = (EngineJob) message.obj;
            switch (message.what) {
                case 1:
                    engineJob.f12396b.mo1031b();
                    if (engineJob.f12411q == null) {
                        if (engineJob.f12395a.isEmpty() == null) {
                            if (engineJob.f12406l == null) {
                                engineJob.f12409o = EngineResourceFactory.m2913a(engineJob.f12404j, engineJob.f12400f);
                                engineJob.f12406l = true;
                                engineJob.f12409o.m11342e();
                                engineJob.f12397c.mo920a(engineJob, engineJob.f12399e, engineJob.f12409o);
                                int size = engineJob.f12395a.size();
                                for (message = null; message < size; message++) {
                                    ResourceCallback resourceCallback = (ResourceCallback) engineJob.f12395a.get(message);
                                    if (!engineJob.m11334b(resourceCallback)) {
                                        engineJob.f12409o.m11342e();
                                        resourceCallback.onResourceReady(engineJob.f12409o, engineJob.f12405k);
                                    }
                                }
                                engineJob.f12409o.m11343f();
                                engineJob.m11333b();
                                break;
                            }
                            throw new IllegalStateException("Already have resource");
                        }
                        throw new IllegalStateException("Received a resource without any callbacks to notify");
                    }
                    engineJob.f12404j.mo928d();
                    engineJob.m11333b();
                    break;
                case 2:
                    engineJob.m11335c();
                    break;
                case 3:
                    engineJob.f12396b.mo1031b();
                    if (engineJob.f12411q != null) {
                        engineJob.f12397c.mo919a(engineJob, engineJob.f12399e);
                        engineJob.m11333b();
                        break;
                    }
                    throw new IllegalStateException("Not cancelled");
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unrecognized message: ");
                    stringBuilder.append(message.what);
                    throw new IllegalStateException(stringBuilder.toString());
            }
            return true;
        }
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, pool, f12393r);
    }

    private EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pool<EngineJob<?>> pool, EngineResourceFactory engineResourceFactory) {
        this.f12395a = new ArrayList(2);
        this.f12396b = StateVerifier.m3247a();
        this.f12398d = glideExecutor;
        this.f12414v = glideExecutor2;
        this.f12415w = glideExecutor3;
        this.f12416x = glideExecutor4;
        this.f12397c = engineJobListener;
        this.f12412t = pool;
        this.f12413u = engineResourceFactory;
    }

    public final void m11332a(ResourceCallback resourceCallback) {
        Util.m3230a();
        this.f12396b.mo1031b();
        if (this.f12406l) {
            resourceCallback.onResourceReady(this.f12409o, this.f12405k);
        } else if (this.f12407m) {
            resourceCallback.onLoadFailed(this.f12417y);
        } else {
            this.f12395a.add(resourceCallback);
        }
    }

    public final GlideExecutor m11328a() {
        if (this.f12401g) {
            return this.f12415w;
        }
        return this.f12402h ? this.f12416x : this.f12414v;
    }

    final boolean m11334b(ResourceCallback resourceCallback) {
        return (this.f12408n == null || this.f12408n.contains(resourceCallback) == null) ? null : true;
    }

    final void m11333b() {
        Util.m3230a();
        this.f12395a.clear();
        this.f12399e = null;
        this.f12409o = null;
        this.f12404j = null;
        if (this.f12408n != null) {
            this.f12408n.clear();
        }
        this.f12407m = false;
        this.f12411q = false;
        this.f12406l = false;
        DecodeJob decodeJob = this.f12410p;
        if (decodeJob.f12358d.m2902a()) {
            decodeJob.m11295a();
        }
        this.f12410p = null;
        this.f12417y = null;
        this.f12405k = null;
        this.f12412t.mo363a(this);
    }

    public final void mo924a(Resource<R> resource, DataSource dataSource) {
        this.f12404j = resource;
        this.f12405k = dataSource;
        f12394s.obtainMessage(1, this).sendToTarget();
    }

    public final void mo923a(GlideException glideException) {
        this.f12417y = glideException;
        f12394s.obtainMessage(2, this).sendToTarget();
    }

    public final void mo922a(DecodeJob<?> decodeJob) {
        m11328a().execute(decodeJob);
    }

    final void m11335c() {
        this.f12396b.mo1031b();
        if (this.f12411q) {
            m11333b();
        } else if (this.f12395a.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        } else if (this.f12407m) {
            throw new IllegalStateException("Already failed once");
        } else {
            this.f12407m = true;
            this.f12397c.mo920a(this, this.f12399e, null);
            for (ResourceCallback resourceCallback : this.f12395a) {
                if (!m11334b(resourceCallback)) {
                    resourceCallback.onLoadFailed(this.f12417y);
                }
            }
            m11333b();
        }
    }

    public StateVerifier getVerifier() {
        return this.f12396b;
    }
}
