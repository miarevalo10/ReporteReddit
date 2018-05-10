package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.util.Pools.Pool;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.ActiveResources;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodeHelper;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.Engine.LoadStatus;
import com.bumptech.glide.load.engine.EngineJob;
import com.bumptech.glide.load.engine.EngineKeyFactory;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.FactoryPools.Factory;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Map;

public final class SingleRequest<R> implements Request, ResourceCallback, SizeReadyCallback, Poolable {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    private static final Pool<SingleRequest<?>> POOL = FactoryPools.m3246a(new C10821());
    private static final String TAG = "Request";
    private TransitionFactory<? super R> animationFactory;
    private Context context;
    private Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private LoadStatus loadStatus;
    private Object model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private Priority priority;
    private RequestCoordinator requestCoordinator;
    private RequestListener<R> requestListener;
    private RequestOptions requestOptions;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private Target<R> target;
    private RequestListener<R> targetListener;
    private Class<R> transcodeClass;
    private int width;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    class C10821 implements Factory<SingleRequest<?>> {
        C10821() {
        }

        public final /* synthetic */ Object mo916a() {
            return new SingleRequest();
        }
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Class<R> cls, RequestOptions requestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, RequestListener<R> requestListener2, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
        SingleRequest<R> singleRequest = (SingleRequest) POOL.mo362a();
        if (singleRequest == null) {
            singleRequest = new SingleRequest();
        }
        singleRequest.init(context, glideContext, obj, cls, requestOptions, i, i2, priority, target, requestListener, requestListener2, requestCoordinator, engine, transitionFactory);
        return singleRequest;
    }

    SingleRequest() {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.m3247a();
    }

    private void init(Context context, GlideContext glideContext, Object obj, Class<R> cls, RequestOptions requestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, RequestListener<R> requestListener2, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
        this.context = context;
        this.glideContext = glideContext;
        this.model = obj;
        this.transcodeClass = cls;
        this.requestOptions = requestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority;
        this.target = target;
        this.targetListener = requestListener;
        this.requestListener = requestListener2;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.animationFactory = transitionFactory;
        this.status = Status.PENDING;
    }

    public final StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public final void recycle() {
        assertNotCallingCallbacks();
        this.context = null;
        this.glideContext = null;
        this.model = null;
        this.transcodeClass = null;
        this.requestOptions = null;
        this.overrideWidth = -1;
        this.overrideHeight = -1;
        this.target = null;
        this.requestListener = null;
        this.targetListener = null;
        this.requestCoordinator = null;
        this.animationFactory = null;
        this.loadStatus = null;
        this.errorDrawable = null;
        this.placeholderDrawable = null;
        this.fallbackDrawable = null;
        this.width = -1;
        this.height = -1;
        POOL.mo363a(this);
    }

    public final void begin() {
        assertNotCallingCallbacks();
        this.stateVerifier.mo1031b();
        this.startTime = LogTime.m3213a();
        if (this.model == null) {
            if (Util.m3231a(this.overrideWidth, this.overrideHeight)) {
                this.width = this.overrideWidth;
                this.height = this.overrideHeight;
            }
            onLoadFailed(new GlideException("Received null model"), getFallbackDrawable() == null ? 5 : 3);
        } else if (this.status == Status.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (this.status == Status.COMPLETE) {
            onResourceReady(this.resource, DataSource.MEMORY_CACHE);
        } else {
            this.status = Status.WAITING_FOR_SIZE;
            if (Util.m3231a(this.overrideWidth, this.overrideHeight)) {
                onSizeReady(this.overrideWidth, this.overrideHeight);
            } else {
                this.target.mo3857a((SizeReadyCallback) this);
            }
            if ((this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE) && canNotifyStatusChanged()) {
                this.target.mo3270b(getPlaceholderDrawable());
            }
            if (IS_VERBOSE_LOGGABLE) {
                StringBuilder stringBuilder = new StringBuilder("finished run method in ");
                stringBuilder.append(LogTime.m3212a(this.startTime));
                logV(stringBuilder.toString());
            }
        }
    }

    final void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.mo1031b();
        this.target.mo3859b((SizeReadyCallback) this);
        this.status = Status.CANCELLED;
        if (this.loadStatus != null) {
            LoadStatus loadStatus = this.loadStatus;
            EngineJob engineJob = loadStatus.f3424a;
            ResourceCallback resourceCallback = loadStatus.f3425b;
            Util.m3230a();
            engineJob.f12396b.mo1031b();
            if (!engineJob.f12406l) {
                if (!engineJob.f12407m) {
                    engineJob.f12395a.remove(resourceCallback);
                    if (!(!engineJob.f12395a.isEmpty() || engineJob.f12407m || engineJob.f12406l)) {
                        if (!engineJob.f12411q) {
                            engineJob.f12411q = true;
                            DecodeJob decodeJob = engineJob.f12410p;
                            decodeJob.f12373s = true;
                            DataFetcherGenerator dataFetcherGenerator = decodeJob.f12372r;
                            if (dataFetcherGenerator != null) {
                                dataFetcherGenerator.mo905b();
                            }
                            engineJob.f12397c.mo919a(engineJob, engineJob.f12399e);
                        }
                    }
                    this.loadStatus = null;
                }
            }
            if (engineJob.f12408n == null) {
                engineJob.f12408n = new ArrayList(2);
            }
            if (!engineJob.f12408n.contains(resourceCallback)) {
                engineJob.f12408n.add(resourceCallback);
            }
            this.loadStatus = null;
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    public final void clear() {
        Util.m3230a();
        assertNotCallingCallbacks();
        this.stateVerifier.mo1031b();
        if (this.status != Status.CLEARED) {
            cancel();
            if (this.resource != null) {
                releaseResource(this.resource);
            }
            if (canNotifyCleared()) {
                this.target.mo3268a(getPlaceholderDrawable());
            }
            this.status = Status.CLEARED;
        }
    }

    public final boolean isPaused() {
        return this.status == Status.PAUSED;
    }

    public final void pause() {
        clear();
        this.status = Status.PAUSED;
    }

    private void releaseResource(Resource<?> resource) {
        Engine.m11322a(resource);
        this.resource = null;
    }

    public final boolean isRunning() {
        if (this.status != Status.RUNNING) {
            if (this.status != Status.WAITING_FOR_SIZE) {
                return false;
            }
        }
        return true;
    }

    public final boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

    public final boolean isResourceSet() {
        return isComplete();
    }

    public final boolean isCancelled() {
        if (this.status != Status.CANCELLED) {
            if (this.status != Status.CLEARED) {
                return false;
            }
        }
        return true;
    }

    public final boolean isFailed() {
        return this.status == Status.FAILED;
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            this.errorDrawable = this.requestOptions.f3616d;
            if (this.errorDrawable == null && this.requestOptions.f3617e > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.f3617e);
            }
        }
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            this.placeholderDrawable = this.requestOptions.f3618f;
            if (this.placeholderDrawable == null && this.requestOptions.f3619g > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.f3619g);
            }
        }
        return this.placeholderDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            this.fallbackDrawable = this.requestOptions.f3626n;
            if (this.fallbackDrawable == null && this.requestOptions.f3627o > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.f3627o);
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable loadDrawable(int i) {
        Theme theme;
        if (this.requestOptions.f3631s != null) {
            theme = this.requestOptions.f3631s;
        } else {
            theme = this.context.getTheme();
        }
        return DrawableDecoderCompat.m3066a(this.glideContext, i, theme);
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable drawable = null;
            if (this.model == null) {
                drawable = getFallbackDrawable();
            }
            if (drawable == null) {
                drawable = getErrorDrawable();
            }
            if (drawable == null) {
                drawable = getPlaceholderDrawable();
            }
            this.target.mo3271c(drawable);
        }
    }

    public final void onSizeReady(int i, int i2) {
        this.stateVerifier.mo1031b();
        if (IS_VERBOSE_LOGGABLE) {
            StringBuilder stringBuilder = new StringBuilder("Got onSizeReady in ");
            stringBuilder.append(LogTime.m3212a(r0.startTime));
            logV(stringBuilder.toString());
        }
        if (r0.status == Status.WAITING_FOR_SIZE) {
            Engine engine;
            Resource resource;
            SingleRequest singleRequest;
            LoadStatus loadStatus;
            StringBuilder stringBuilder2;
            r0.status = Status.RUNNING;
            float f = r0.requestOptions.f3613a;
            r0.width = maybeApplySizeMultiplier(i, f);
            r0.height = maybeApplySizeMultiplier(i2, f);
            if (IS_VERBOSE_LOGGABLE) {
                stringBuilder = new StringBuilder("finished setup for calling load in ");
                stringBuilder.append(LogTime.m3212a(r0.startTime));
                logV(stringBuilder.toString());
            }
            Engine engine2 = r0.engine;
            GlideContext glideContext = r0.glideContext;
            Object obj = r0.model;
            Key key = r0.requestOptions.f3623k;
            int i3 = r0.width;
            int i4 = r0.height;
            Class cls = r0.requestOptions.f3630r;
            Class cls2 = r0.transcodeClass;
            Priority priority = r0.priority;
            DiskCacheStrategy diskCacheStrategy = r0.requestOptions.f3614b;
            Map map = r0.requestOptions.f3629q;
            boolean z = r0.requestOptions.f3624l;
            boolean z2 = r0.requestOptions.f3634v;
            Options options = r0.requestOptions.f3628p;
            boolean z3 = r0.requestOptions.f3620h;
            boolean z4 = r0.requestOptions.f3632t;
            boolean z5 = r0.requestOptions.f3635w;
            boolean z6 = r0.requestOptions.f3633u;
            Util.m3230a();
            Engine engine3 = engine2;
            long a = LogTime.m3213a();
            GlideContext glideContext2 = glideContext;
            boolean z7 = z6;
            boolean z8 = z3;
            boolean z9 = z4;
            boolean z10 = z5;
            Options options2 = options;
            boolean z11 = z2;
            boolean z12 = z;
            Map map2 = map;
            DiskCacheStrategy diskCacheStrategy2 = diskCacheStrategy;
            Priority priority2 = priority;
            Class cls3 = cls2;
            Key a2 = EngineKeyFactory.m2916a(obj, key, i3, i4, map, cls, cls2, options2);
            if (z8) {
                engine = engine3;
                ActiveResources activeResources = engine.f12389e;
                ResourceWeakReference resourceWeakReference = (ResourceWeakReference) activeResources.f3360b.get(a2);
                if (resourceWeakReference == null) {
                    resource = null;
                } else {
                    resource = (EngineResource) resourceWeakReference.get();
                    if (resource == null) {
                        activeResources.m2883a(resourceWeakReference);
                    }
                }
                if (resource != null) {
                    resource.m11342e();
                }
            } else {
                engine = engine3;
                resource = null;
            }
            long j;
            if (resource != null) {
                j = a;
                onResourceReady(resource, DataSource.MEMORY_CACHE);
                if (Log.isLoggable("Engine", 2)) {
                    Engine.m11323a("Loaded resource from active resources", j, a2);
                }
            } else {
                Resource remove;
                j = a;
                singleRequest = this;
                if (z8) {
                    remove = engine.f12386b.remove(a2);
                    if (remove == null) {
                        remove = null;
                    } else if (remove instanceof EngineResource) {
                        remove = (EngineResource) remove;
                    } else {
                        remove = new EngineResource(remove, true, true);
                    }
                    if (remove != null) {
                        remove.m11342e();
                        engine.f12389e.m2882a(a2, remove);
                    }
                } else {
                    remove = null;
                }
                if (remove != null) {
                    onResourceReady(remove, DataSource.MEMORY_CACHE);
                    if (Log.isLoggable("Engine", 2)) {
                        Engine.m11323a("Loaded resource from cache", j, a2);
                    }
                } else {
                    EngineJob engineJob = (EngineJob) engine.f12385a.m2926a(z7).get(a2);
                    if (engineJob != null) {
                        engineJob.m11332a((ResourceCallback) singleRequest);
                        if (Log.isLoggable("Engine", 2)) {
                            Engine.m11323a("Added to existing load", j, a2);
                        }
                        loadStatus = new LoadStatus(singleRequest, engineJob);
                    } else {
                        Object obj2;
                        GlideExecutor glideExecutor;
                        engineJob = (EngineJob) Preconditions.m3217a((EngineJob) engine.f12387c.f3423f.mo362a());
                        engineJob.f12399e = a2;
                        engineJob.f12400f = z8;
                        engineJob.f12401g = z9;
                        engineJob.f12402h = z10;
                        engineJob.f12403i = z7;
                        DecodeJobFactory decodeJobFactory = engine.f12388d;
                        DecodeJob decodeJob = (DecodeJob) Preconditions.m3217a((DecodeJob) decodeJobFactory.f3416b.mo362a());
                        int i5 = decodeJobFactory.f3417c;
                        decodeJobFactory.f3417c = i5 + 1;
                        DecodeHelper decodeHelper = decodeJob.f12355a;
                        DiskCacheProvider diskCacheProvider = decodeJob.f12356b;
                        long j2 = j;
                        GlideContext glideContext3 = glideContext2;
                        decodeHelper.f3369c = glideContext3;
                        decodeHelper.f3370d = obj;
                        decodeHelper.f3380n = key;
                        decodeHelper.f3371e = i3;
                        decodeHelper.f3372f = i4;
                        DiskCacheStrategy diskCacheStrategy3 = diskCacheStrategy2;
                        decodeHelper.f3382p = diskCacheStrategy3;
                        decodeHelper.f3373g = cls;
                        decodeHelper.f3374h = diskCacheProvider;
                        decodeHelper.f3377k = cls3;
                        Priority priority3 = priority2;
                        decodeHelper.f3381o = priority3;
                        Options options3 = options2;
                        decodeHelper.f3375i = options3;
                        decodeHelper.f3376j = map2;
                        decodeHelper.f3383q = z12;
                        decodeHelper.f3384r = z11;
                        decodeJob.f12359e = glideContext3;
                        decodeJob.f12360f = key;
                        decodeJob.f12361g = priority3;
                        decodeJob.f12362h = a2;
                        decodeJob.f12363i = i3;
                        decodeJob.f12364j = i4;
                        decodeJob.f12365k = diskCacheStrategy3;
                        decodeJob.f12370p = z7;
                        decodeJob.f12366l = options3;
                        decodeJob.f12367m = engineJob;
                        decodeJob.f12368n = i5;
                        decodeJob.f12369o = RunReason.INITIALIZE;
                        engine.f12385a.m2926a(engineJob.f12403i).put(a2, engineJob);
                        engineJob.m11332a((ResourceCallback) singleRequest);
                        engineJob.f12410p = decodeJob;
                        Stage a3 = decodeJob.m11294a(Stage.INITIALIZE);
                        if (a3 != Stage.RESOURCE_CACHE) {
                            if (a3 != Stage.DATA_CACHE) {
                                obj2 = null;
                                if (obj2 == null) {
                                    glideExecutor = engineJob.f12398d;
                                } else {
                                    glideExecutor = engineJob.m11328a();
                                }
                                glideExecutor.execute(decodeJob);
                                if (Log.isLoggable("Engine", 2)) {
                                    Engine.m11323a("Started new load", j2, a2);
                                }
                                loadStatus = new LoadStatus(singleRequest, engineJob);
                            }
                        }
                        obj2 = 1;
                        if (obj2 == null) {
                            glideExecutor = engineJob.m11328a();
                        } else {
                            glideExecutor = engineJob.f12398d;
                        }
                        glideExecutor.execute(decodeJob);
                        if (Log.isLoggable("Engine", 2)) {
                            Engine.m11323a("Started new load", j2, a2);
                        }
                        loadStatus = new LoadStatus(singleRequest, engineJob);
                    }
                    singleRequest.loadStatus = loadStatus;
                    if (singleRequest.status != Status.RUNNING) {
                        singleRequest.loadStatus = null;
                    }
                    if (IS_VERBOSE_LOGGABLE) {
                        stringBuilder2 = new StringBuilder("finished onSizeReady in ");
                        stringBuilder2.append(LogTime.m3212a(singleRequest.startTime));
                        singleRequest.logV(stringBuilder2.toString());
                    }
                }
            }
            loadStatus = null;
            singleRequest.loadStatus = loadStatus;
            if (singleRequest.status != Status.RUNNING) {
                singleRequest.loadStatus = null;
            }
            if (IS_VERBOSE_LOGGABLE) {
                stringBuilder2 = new StringBuilder("finished onSizeReady in ");
                stringBuilder2.append(LogTime.m3212a(singleRequest.startTime));
                singleRequest.logV(stringBuilder2.toString());
            }
        }
    }

    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * ((float) i));
    }

    private boolean canSetResource() {
        if (this.requestCoordinator != null) {
            if (!this.requestCoordinator.mo1008a(this)) {
                return false;
            }
        }
        return true;
    }

    private boolean canNotifyCleared() {
        if (this.requestCoordinator != null) {
            if (!this.requestCoordinator.mo1011c(this)) {
                return false;
            }
        }
        return true;
    }

    private boolean canNotifyStatusChanged() {
        if (this.requestCoordinator != null) {
            if (!this.requestCoordinator.mo1009b(this)) {
                return false;
            }
        }
        return true;
    }

    private boolean isFirstReadyResource() {
        if (this.requestCoordinator != null) {
            if (this.requestCoordinator.mo1007a()) {
                return false;
            }
        }
        return true;
    }

    private void notifyLoadSuccess() {
        if (this.requestCoordinator != null) {
            this.requestCoordinator.mo1013d(this);
        }
    }

    private void notifyLoadFailed() {
        if (this.requestCoordinator != null) {
            this.requestCoordinator.mo1014e(this);
        }
    }

    public final void onResourceReady(Resource<?> resource, DataSource dataSource) {
        this.stateVerifier.mo1031b();
        this.loadStatus = null;
        if (resource == null) {
            dataSource = new StringBuilder("Expected to receive a Resource<R> with an object of ");
            dataSource.append(this.transcodeClass);
            dataSource.append(" inside, but instead got null.");
            onLoadFailed(new GlideException(dataSource.toString()));
            return;
        }
        Object b = resource.mo926b();
        if (b != null) {
            if (this.transcodeClass.isAssignableFrom(b.getClass())) {
                if (canSetResource()) {
                    onResourceReady(resource, b, dataSource);
                    return;
                }
                releaseResource(resource);
                this.status = Status.COMPLETE;
                return;
            }
        }
        releaseResource(resource);
        StringBuilder stringBuilder = new StringBuilder("Expected to receive an object of ");
        stringBuilder.append(this.transcodeClass);
        stringBuilder.append(" but instead got ");
        stringBuilder.append(b != null ? b.getClass() : "");
        stringBuilder.append("{");
        stringBuilder.append(b);
        stringBuilder.append("} inside Resource{");
        stringBuilder.append(resource);
        stringBuilder.append("}.");
        stringBuilder.append(b != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
        onLoadFailed(new GlideException(stringBuilder.toString()));
    }

    private void onResourceReady(Resource<R> resource, R r, DataSource dataSource) {
        isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource;
        if (this.glideContext.f3225h <= 3) {
            resource = GLIDE_TAG;
            StringBuilder stringBuilder = new StringBuilder("Finished loading ");
            stringBuilder.append(r.getClass().getSimpleName());
            stringBuilder.append(" from ");
            stringBuilder.append(dataSource);
            stringBuilder.append(" for ");
            stringBuilder.append(this.model);
            stringBuilder.append(" with size [");
            stringBuilder.append(this.width);
            stringBuilder.append("x");
            stringBuilder.append(this.height);
            stringBuilder.append("] in ");
            stringBuilder.append(LogTime.m3212a(this.startTime));
            stringBuilder.append(" ms");
            Log.d(resource, stringBuilder.toString());
        }
        this.isCallingCallbacks = true;
        try {
            if (this.requestListener != null) {
                this.requestListener.mo3044a((Object) r);
            }
            if (this.targetListener != null) {
                this.targetListener.mo3044a((Object) r);
            }
            this.target.mo3858a(r, this.animationFactory.mo1027a(dataSource));
            notifyLoadSuccess();
        } finally {
            this.isCallingCallbacks = null;
        }
    }

    public final void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    private void onLoadFailed(GlideException glideException, int i) {
        this.stateVerifier.mo1031b();
        int i2 = this.glideContext.f3225h;
        if (i2 <= i) {
            i = GLIDE_TAG;
            StringBuilder stringBuilder = new StringBuilder("Load failed for ");
            stringBuilder.append(this.model);
            stringBuilder.append(" with size [");
            stringBuilder.append(this.width);
            stringBuilder.append("x");
            stringBuilder.append(this.height);
            stringBuilder.append("]");
            Log.w(i, stringBuilder.toString(), glideException);
            if (i2 <= 4) {
                glideException.m2924a(GLIDE_TAG);
            }
        }
        this.loadStatus = 0;
        this.status = Status.FAILED;
        this.isCallingCallbacks = true;
        try {
            RequestListener requestListener;
            if (this.requestListener != null) {
                requestListener = this.requestListener;
                isFirstReadyResource();
                requestListener.mo3043a(glideException);
            }
            if (this.targetListener != null) {
                requestListener = this.targetListener;
                isFirstReadyResource();
                requestListener.mo3043a(glideException);
            }
            setErrorPlaceholder();
            notifyLoadFailed();
        } finally {
            this.isCallingCallbacks = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isEquivalentTo(com.bumptech.glide.request.Request r4) {
        /*
        r3 = this;
        r0 = r4 instanceof com.bumptech.glide.request.SingleRequest;
        r1 = 0;
        if (r0 == 0) goto L_0x0047;
    L_0x0005:
        r4 = (com.bumptech.glide.request.SingleRequest) r4;
        r0 = r3.overrideWidth;
        r2 = r4.overrideWidth;
        if (r0 != r2) goto L_0x0046;
    L_0x000d:
        r0 = r3.overrideHeight;
        r2 = r4.overrideHeight;
        if (r0 != r2) goto L_0x0046;
    L_0x0013:
        r0 = r3.model;
        r2 = r4.model;
        r0 = com.bumptech.glide.util.Util.m3236b(r0, r2);
        if (r0 == 0) goto L_0x0046;
    L_0x001d:
        r0 = r3.transcodeClass;
        r2 = r4.transcodeClass;
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0046;
    L_0x0027:
        r0 = r3.requestOptions;
        r2 = r4.requestOptions;
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0046;
    L_0x0031:
        r0 = r3.priority;
        r2 = r4.priority;
        if (r0 != r2) goto L_0x0046;
    L_0x0037:
        r0 = r3.requestListener;
        if (r0 == 0) goto L_0x0040;
    L_0x003b:
        r4 = r4.requestListener;
        if (r4 == 0) goto L_0x0046;
    L_0x003f:
        goto L_0x0044;
    L_0x0040:
        r4 = r4.requestListener;
        if (r4 != 0) goto L_0x0046;
    L_0x0044:
        r4 = 1;
        return r4;
    L_0x0046:
        return r1;
    L_0x0047:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.isEquivalentTo(com.bumptech.glide.request.Request):boolean");
    }

    private void logV(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" this: ");
        stringBuilder.append(this.tag);
        Log.v(str2, stringBuilder.toString());
    }
}
