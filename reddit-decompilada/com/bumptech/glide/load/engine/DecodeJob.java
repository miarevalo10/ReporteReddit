package com.bumptech.glide.load.engine;

import android.os.Build.VERSION;
import android.support.v4.os.TraceCompat;
import android.support.v4.util.Pools.Pool;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry.NoResultEncoderAvailableException;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;

public class DecodeJob<R> implements FetcherReadyCallback, Poolable, Comparable<DecodeJob<?>>, Runnable {
    private Object f12351A;
    private DataSource f12352B;
    private DataFetcher<?> f12353C;
    private volatile boolean f12354D;
    public final DecodeHelper<R> f12355a = new DecodeHelper();
    public final DiskCacheProvider f12356b;
    final DeferredEncodeManager<?> f12357c = new DeferredEncodeManager();
    final ReleaseManager f12358d = new ReleaseManager();
    public GlideContext f12359e;
    public Key f12360f;
    public Priority f12361g;
    public EngineKey f12362h;
    public int f12363i;
    public int f12364j;
    public DiskCacheStrategy f12365k;
    public Options f12366l;
    public Callback<R> f12367m;
    public int f12368n;
    public RunReason f12369o;
    public boolean f12370p;
    Key f12371q;
    public volatile DataFetcherGenerator f12372r;
    public volatile boolean f12373s;
    private final List<Throwable> f12374t = new ArrayList();
    private final StateVerifier f12375u = StateVerifier.m3247a();
    private final Pool<DecodeJob<?>> f12376v;
    private Stage f12377w;
    private long f12378x;
    private Thread f12379y;
    private Key f12380z;

    interface Callback<R> {
        void mo922a(DecodeJob<?> decodeJob);

        void mo923a(GlideException glideException);

        void mo924a(Resource<R> resource, DataSource dataSource);
    }

    private static class DeferredEncodeManager<Z> {
        Key f3388a;
        ResourceEncoder<Z> f3389b;
        LockedResource<Z> f3390c;

        DeferredEncodeManager() {
        }

        final boolean m2899a() {
            return this.f3390c != null;
        }
    }

    interface DiskCacheProvider {
        DiskCache mo917a();
    }

    private static class ReleaseManager {
        private boolean f3391a;
        private boolean f3392b;
        private boolean f3393c;

        ReleaseManager() {
        }

        final synchronized boolean m2902a() {
            this.f3391a = true;
            return m2901e();
        }

        final synchronized boolean m2903b() {
            this.f3392b = true;
            return m2901e();
        }

        final synchronized boolean m2904c() {
            this.f3393c = true;
            return m2901e();
        }

        final synchronized void m2905d() {
            this.f3392b = false;
            this.f3391a = false;
            this.f3393c = false;
        }

        private boolean m2901e() {
            return (this.f3393c || this.f3392b) && this.f3391a;
        }
    }

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    private final class DecodeCallback<Z> implements DecodeCallback<Z> {
        final /* synthetic */ DecodeJob f12349a;
        private final DataSource f12350b;

        DecodeCallback(DecodeJob decodeJob, DataSource dataSource) {
            this.f12349a = decodeJob;
            this.f12350b = dataSource;
        }

        public final Resource<Z> mo907a(Resource<Z> resource) {
            Transformation transformation;
            Resource<Z> a;
            DecodeJob decodeJob = this.f12349a;
            DataSource dataSource = this.f12350b;
            Class cls = resource.mo926b().getClass();
            ResourceEncoder resourceEncoder = null;
            if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
                Transformation c = decodeJob.f12355a.m2894c(cls);
                transformation = c;
                a = c.mo3260a(decodeJob.f12359e, resource, decodeJob.f12363i, decodeJob.f12364j);
            } else {
                a = resource;
                transformation = null;
            }
            if (!resource.equals(a)) {
                resource.mo928d();
            }
            int i = 0;
            if ((decodeJob.f12355a.f3369c.f3221d.f3240d.m3118a(a.mo925a()) != null ? 1 : null) != null) {
                resourceEncoder = decodeJob.f12355a.f3369c.f3221d.f3240d.m3118a(a.mo925a());
                if (resourceEncoder != null) {
                    resource = resourceEncoder.mo3265a(decodeJob.f12366l);
                } else {
                    throw new NoResultEncoderAvailableException(a.mo925a());
                }
            }
            resource = EncodeStrategy.NONE;
            ResourceEncoder resourceEncoder2 = resourceEncoder;
            DecodeHelper decodeHelper = decodeJob.f12355a;
            Key key = decodeJob.f12371q;
            List b = decodeHelper.m2893b();
            int size = b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((LoadData) b.get(i2)).f3498a.equals(key)) {
                    i = 1;
                    break;
                }
            }
            if (!decodeJob.f12365k.mo914a(i ^ 1, dataSource, resource)) {
                return a;
            }
            if (resourceEncoder2 == null) {
                throw new NoResultEncoderAvailableException(a.mo926b().getClass());
            }
            switch (resource) {
                case SOURCE:
                    resource = new DataCacheKey(decodeJob.f12371q, decodeJob.f12360f);
                    break;
                case TRANSFORMED:
                    Resource<Z> resourceCacheKey = new ResourceCacheKey(decodeJob.f12355a.f3369c.f3220c, decodeJob.f12371q, decodeJob.f12360f, decodeJob.f12363i, decodeJob.f12364j, transformation, cls, decodeJob.f12366l);
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unknown strategy: ");
                    stringBuilder.append(resource);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
            Resource a2 = LockedResource.m11345a(a);
            DeferredEncodeManager deferredEncodeManager = decodeJob.f12357c;
            deferredEncodeManager.f3388a = resource;
            deferredEncodeManager.f3389b = resourceEncoder2;
            deferredEncodeManager.f3390c = a2;
            return a2;
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        DecodeJob decodeJob = (DecodeJob) obj;
        int ordinal = this.f12361g.ordinal() - decodeJob.f12361g.ordinal();
        return ordinal == 0 ? this.f12368n - decodeJob.f12368n : ordinal;
    }

    DecodeJob(DiskCacheProvider diskCacheProvider, Pool<DecodeJob<?>> pool) {
        this.f12356b = diskCacheProvider;
        this.f12376v = pool;
    }

    final void m11295a() {
        this.f12358d.m2905d();
        DeferredEncodeManager deferredEncodeManager = this.f12357c;
        deferredEncodeManager.f3388a = null;
        deferredEncodeManager.f3389b = null;
        deferredEncodeManager.f3390c = null;
        DecodeHelper decodeHelper = this.f12355a;
        decodeHelper.f3369c = null;
        decodeHelper.f3370d = null;
        decodeHelper.f3380n = null;
        decodeHelper.f3373g = null;
        decodeHelper.f3377k = null;
        decodeHelper.f3375i = null;
        decodeHelper.f3381o = null;
        decodeHelper.f3376j = null;
        decodeHelper.f3382p = null;
        decodeHelper.f3367a.clear();
        decodeHelper.f3378l = false;
        decodeHelper.f3368b.clear();
        decodeHelper.f3379m = false;
        this.f12354D = false;
        this.f12359e = null;
        this.f12360f = null;
        this.f12366l = null;
        this.f12361g = null;
        this.f12362h = null;
        this.f12367m = null;
        this.f12377w = null;
        this.f12372r = null;
        this.f12379y = null;
        this.f12371q = null;
        this.f12351A = null;
        this.f12352B = null;
        this.f12353C = null;
        this.f12378x = 0;
        this.f12373s = false;
        this.f12374t.clear();
        this.f12376v.mo363a(this);
    }

    public void run() {
        TraceCompat.m975a("DecodeJob#run");
        DataFetcher dataFetcher = this.f12353C;
        try {
            if (this.f12373s) {
                m11291e();
                return;
            }
            switch (this.f12369o) {
                case INITIALIZE:
                    this.f12377w = m11294a(Stage.INITIALIZE);
                    this.f12372r = m11289b();
                    m11290d();
                    break;
                case SWITCH_TO_SOURCE_SERVICE:
                    m11290d();
                    break;
                case DECODE_DATA:
                    m11293g();
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unrecognized run reason: ");
                    stringBuilder.append(this.f12369o);
                    throw new IllegalStateException(stringBuilder.toString());
            }
            if (dataFetcher != null) {
                dataFetcher.mo884a();
            }
            TraceCompat.m974a();
        } catch (Throwable th) {
            if (Log.isLoggable("DecodeJob", 3)) {
                StringBuilder stringBuilder2 = new StringBuilder("DecodeJob threw unexpectedly, isCancelled: ");
                stringBuilder2.append(this.f12373s);
                stringBuilder2.append(", stage: ");
                stringBuilder2.append(this.f12377w);
                Log.d("DecodeJob", stringBuilder2.toString(), th);
            }
            if (this.f12377w != Stage.ENCODE) {
                this.f12374t.add(th);
                m11291e();
            }
            if (this.f12373s) {
            }
        } finally {
            if (dataFetcher != null) {
                dataFetcher.mo884a();
            }
            TraceCompat.m974a();
        }
    }

    private DataFetcherGenerator m11289b() {
        switch (this.f12377w) {
            case RESOURCE_CACHE:
                return new ResourceCacheGenerator(this.f12355a, this);
            case DATA_CACHE:
                return new DataCacheGenerator(this.f12355a, this);
            case SOURCE:
                return new SourceGenerator(this.f12355a, this);
            case FINISHED:
                return null;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unrecognized stage: ");
                stringBuilder.append(this.f12377w);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private void m11290d() {
        this.f12379y = Thread.currentThread();
        this.f12378x = LogTime.m3213a();
        boolean z = false;
        while (!this.f12373s && this.f12372r != null) {
            z = this.f12372r.mo904a();
            if (z) {
                break;
            }
            this.f12377w = m11294a(this.f12377w);
            this.f12372r = m11289b();
            if (this.f12377w == Stage.SOURCE) {
                mo910c();
                return;
            }
        }
        if ((this.f12377w == Stage.FINISHED || this.f12373s) && !r0) {
            m11291e();
        }
    }

    private void m11291e() {
        m11292f();
        this.f12367m.mo923a(new GlideException("Failed to load resource", new ArrayList(this.f12374t)));
        if (this.f12358d.m2904c()) {
            m11295a();
        }
    }

    private void m11292f() {
        this.f12375u.mo1031b();
        if (this.f12354D) {
            throw new IllegalStateException("Already notified");
        }
        this.f12354D = true;
    }

    public final Stage m11294a(Stage stage) {
        while (true) {
            switch (stage) {
                case RESOURCE_CACHE:
                    if (this.f12365k.mo915b() == null) {
                        stage = Stage.DATA_CACHE;
                        break;
                    }
                    return Stage.DATA_CACHE;
                case DATA_CACHE:
                    return this.f12370p != null ? Stage.FINISHED : Stage.SOURCE;
                case SOURCE:
                case FINISHED:
                    return Stage.FINISHED;
                case INITIALIZE:
                    if (this.f12365k.mo912a() == null) {
                        stage = Stage.RESOURCE_CACHE;
                        break;
                    }
                    return Stage.RESOURCE_CACHE;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unrecognized stage: ");
                    stringBuilder.append(stage);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    public final void mo910c() {
        this.f12369o = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.f12367m.mo922a(this);
    }

    public final void mo909a(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f12371q = key;
        this.f12351A = obj;
        this.f12353C = dataFetcher;
        this.f12352B = dataSource;
        this.f12380z = key2;
        if (Thread.currentThread() != this.f12379y) {
            this.f12369o = RunReason.DECODE_DATA;
            this.f12367m.mo922a(this);
            return;
        }
        TraceCompat.m975a("DecodeJob.decodeFromRetrievedData");
        try {
            m11293g();
        } finally {
            TraceCompat.m974a();
        }
    }

    public final void mo908a(Key key, Exception exception, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.mo884a();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exception);
        glideException.m2923a(key, dataSource, dataFetcher.mo887c());
        this.f12374t.add(glideException);
        if (Thread.currentThread() != this.f12379y) {
            this.f12369o = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.f12367m.mo922a(this);
            return;
        }
        m11290d();
    }

    private void m11293g() {
        Resource a;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.f12378x;
            StringBuilder stringBuilder = new StringBuilder("data: ");
            stringBuilder.append(this.f12351A);
            stringBuilder.append(", cache key: ");
            stringBuilder.append(this.f12371q);
            stringBuilder.append(", fetcher: ");
            stringBuilder.append(this.f12353C);
            m11288a("Retrieved data", j, stringBuilder.toString());
        }
        try {
            a = m11286a(this.f12353C, this.f12351A, this.f12352B);
        } catch (GlideException e) {
            e.m2923a(this.f12380z, this.f12352B, null);
            this.f12374t.add(e);
            a = null;
        }
        if (a != null) {
            Resource a2;
            LockedResource lockedResource;
            DataSource dataSource = this.f12352B;
            if (a instanceof Initializable) {
                ((Initializable) a).mo981e();
            }
            if (this.f12357c.m2899a()) {
                a2 = LockedResource.m11345a(a);
                lockedResource = a2;
            } else {
                Resource resource = a;
                lockedResource = null;
                a2 = resource;
            }
            m11292f();
            this.f12367m.mo924a(a2, dataSource);
            this.f12377w = Stage.ENCODE;
            DeferredEncodeManager deferredEncodeManager;
            try {
                if (this.f12357c.m2899a()) {
                    deferredEncodeManager = this.f12357c;
                    DiskCacheProvider diskCacheProvider = this.f12356b;
                    Options options = this.f12366l;
                    TraceCompat.m975a("DecodeJob.encode");
                    diskCacheProvider.mo917a().put(deferredEncodeManager.f3388a, new DataCacheWriter(deferredEncodeManager.f3389b, deferredEncodeManager.f3390c, options));
                    deferredEncodeManager.f3390c.m11350e();
                    TraceCompat.m974a();
                }
                if (lockedResource != null) {
                    lockedResource.m11350e();
                }
                if (this.f12358d.m2903b()) {
                    m11295a();
                }
            } catch (Throwable th) {
                if (lockedResource != null) {
                    lockedResource.m11350e();
                }
            }
        } else {
            m11290d();
        }
    }

    private <Data> Resource<R> m11286a(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dataFetcher.mo884a();
            return null;
        }
        try {
            long a = LogTime.m3213a();
            data = m11287a((Object) data, dataSource, this.f12355a.m2892b(data.getClass()));
            if (Log.isLoggable("DecodeJob", 2) != null) {
                dataSource = new StringBuilder("Decoded result ");
                dataSource.append(data);
                m11288a(dataSource.toString(), a, null);
            }
            dataFetcher.mo884a();
            return data;
        } catch (Throwable th) {
            dataFetcher.mo884a();
        }
    }

    private Options m11285a(DataSource dataSource) {
        Options options = this.f12366l;
        if (VERSION.SDK_INT < 26 || options.m11235a(Downsampler.f3528d) != null) {
            return options;
        }
        if (dataSource == DataSource.RESOURCE_DISK_CACHE || this.f12355a.f3384r != null) {
            options = new Options();
            options.m11236a(this.f12366l);
            options.m11234a(Downsampler.f3528d, Boolean.valueOf(true));
        }
        return options;
    }

    private <Data, ResourceType> Resource<R> m11287a(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options a = m11285a(dataSource);
        data = this.f12359e.f3221d.f3241e.m2866a((Object) data);
        try {
            dataSource = loadPath.m2929a(data, a, this.f12363i, this.f12364j, new DecodeCallback(this, dataSource));
            return dataSource;
        } finally {
            data.mo899b();
        }
    }

    private void m11288a(String str, long j, String str2) {
        String str3 = "DecodeJob";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" in ");
        stringBuilder.append(LogTime.m3212a(j));
        stringBuilder.append(", load key: ");
        stringBuilder.append(this.f12362h);
        if (str2 != null) {
            str = new StringBuilder(", ");
            str.append(str2);
            str = str.toString();
        } else {
            str = "";
        }
        stringBuilder.append(str);
        stringBuilder.append(", thread: ");
        stringBuilder.append(Thread.currentThread().getName());
        Log.v(str3, stringBuilder.toString());
    }

    public StateVerifier getVerifier() {
        return this.f12375u;
    }
}
