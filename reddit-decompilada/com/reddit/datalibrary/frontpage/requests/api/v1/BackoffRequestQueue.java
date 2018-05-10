package com.reddit.datalibrary.frontpage.requests.api.v1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.util.LruCache;
import com.android.volley.Cache;
import com.android.volley.ExecutorDelivery;
import com.android.volley.Network;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.concurrent.atomic.AtomicInteger;
import timber.log.Timber;

public class BackoffRequestQueue extends RequestQueue {
    private static LruCache<String, AtomicInteger> f16327k = new LruCache(100);
    private static long f16328l;
    private final Handler f16329m;

    class C17021 extends ExecutorDelivery {
        C17021(Handler handler) {
            super(handler);
        }

        public final void mo774a(Request<?> request, Response<?> response) {
            super.mo774a((Request) request, (Response) response);
            BackoffRequestQueue.m16384e(request).set(0);
        }

        public final void mo775a(Request<?> request, Response<?> response, Runnable runnable) {
            super.mo775a(request, response, runnable);
            BackoffRequestQueue.m16384e(request).set(0);
        }

        public final void mo776a(Request<?> request, VolleyError volleyError) {
            super.mo776a((Request) request, volleyError);
            if ((volleyError instanceof NoConnectionError) == null) {
                BackoffRequestQueue.m16384e(request).incrementAndGet();
                BackoffRequestQueue.f16328l = System.currentTimeMillis();
            }
        }
    }

    public BackoffRequestQueue(Cache cache, Network network) {
        super(cache, network, new C17021(new Handler(Looper.getMainLooper())));
        cache = new HandlerThread("BackoffRequestQueue");
        cache.start();
        this.f16329m = new Handler(cache.getLooper());
    }

    final /* synthetic */ void m16387b(Request request) {
        if (!request.isCanceled()) {
            super.mo3040a(request);
        }
    }

    private static AtomicInteger m16384e(Request request) {
        request = m16385f(request);
        AtomicInteger atomicInteger = (AtomicInteger) f16327k.get(request);
        if (atomicInteger != null) {
            return atomicInteger;
        }
        atomicInteger = new AtomicInteger();
        f16327k.put(request, atomicInteger);
        return atomicInteger;
    }

    private static java.lang.String m16385f(com.android.volley.Request r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x001f, URISyntaxException -> 0x001f }
        r1 = r1.getUrl();	 Catch:{ URISyntaxException -> 0x001f, URISyntaxException -> 0x001f }
        r0.<init>(r1);	 Catch:{ URISyntaxException -> 0x001f, URISyntaxException -> 0x001f }
        r1 = r0.getHost();	 Catch:{ URISyntaxException -> 0x001f, URISyntaxException -> 0x001f }
        r0 = "www.";	 Catch:{ URISyntaxException -> 0x001f, URISyntaxException -> 0x001f }
        r0 = r1.startsWith(r0);	 Catch:{ URISyntaxException -> 0x001f, URISyntaxException -> 0x001f }
        if (r0 == 0) goto L_0x001a;	 Catch:{ URISyntaxException -> 0x001f, URISyntaxException -> 0x001f }
    L_0x0015:
        r0 = 4;	 Catch:{ URISyntaxException -> 0x001f, URISyntaxException -> 0x001f }
        r1 = r1.substring(r0);	 Catch:{ URISyntaxException -> 0x001f, URISyntaxException -> 0x001f }
    L_0x001a:
        r1 = r1.toLowerCase();	 Catch:{ URISyntaxException -> 0x001f, URISyntaxException -> 0x001f }
        return r1;
    L_0x001f:
        r1 = "unknown_domain";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.requests.api.v1.BackoffRequestQueue.f(com.android.volley.Request):java.lang.String");
    }

    public final <T> Request<T> mo3040a(Request<T> request) {
        int i;
        AtomicInteger atomicInteger = (AtomicInteger) f16327k.get(m16385f(request));
        if (atomicInteger == null) {
            i = 0;
        } else {
            i = atomicInteger.get();
        }
        if (i <= 0) {
            return super.mo3040a(request);
        }
        long pow = (((long) Math.pow(2.0d, (double) Math.min(i - 1, 3))) * 1000) - (System.currentTimeMillis() - f16328l);
        if (pow <= 0) {
            return super.mo3040a(request);
        }
        Timber.b("delaying request %d ms", new Object[]{Long.valueOf(pow)});
        this.f16329m.postDelayed(new BackoffRequestQueue$$Lambda$0(this, request), pow);
        return request;
    }
}
