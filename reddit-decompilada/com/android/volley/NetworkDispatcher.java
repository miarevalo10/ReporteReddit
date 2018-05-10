package com.android.volley;

import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher extends Thread {
    public volatile boolean f2772a = false;
    private final BlockingQueue<Request<?>> f2773b;
    private final Network f2774c;
    private final Cache f2775d;
    private final ResponseDelivery f2776e;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.f2773b = blockingQueue;
        this.f2774c = network;
        this.f2775d = cache;
        this.f2776e = responseDelivery;
    }

    public void run() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x0005:
        r0 = android.os.SystemClock.elapsedRealtime();
        r2 = r8.f2773b;	 Catch:{ InterruptedException -> 0x00ac }
        r2 = r2.take();	 Catch:{ InterruptedException -> 0x00ac }
        r2 = (com.android.volley.Request) r2;	 Catch:{ InterruptedException -> 0x00ac }
        r3 = "network-queue-take";	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r2.addMarker(r3);	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r3 = r2.isCanceled();	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        if (r3 == 0) goto L_0x0022;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
    L_0x001c:
        r3 = "network-discard-cancelled";	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r2.finish(r3);	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        goto L_0x0005;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
    L_0x0022:
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r4 = 14;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        if (r3 < r4) goto L_0x002f;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
    L_0x0028:
        r3 = r2.getTrafficStatsTag();	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        android.net.TrafficStats.setThreadStatsTag(r3);	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
    L_0x002f:
        r3 = r8.f2774c;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r3 = r3.mo777a(r2);	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r4 = "network-http-complete";	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r2.addMarker(r4);	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r4 = r3.f2780d;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        if (r4 == 0) goto L_0x004a;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
    L_0x003e:
        r4 = r2.hasHadResponseDelivered();	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        if (r4 == 0) goto L_0x004a;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
    L_0x0044:
        r3 = "not-modified";	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r2.finish(r3);	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        goto L_0x0005;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
    L_0x004a:
        r3 = r2.parseNetworkResponse(r3);	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r4 = "network-parse-complete";	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r2.addMarker(r4);	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r4 = r2.shouldCache();	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        if (r4 == 0) goto L_0x006d;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
    L_0x0059:
        r4 = r3.f2802b;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        if (r4 == 0) goto L_0x006d;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
    L_0x005d:
        r4 = r8.f2775d;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r5 = r2.getCacheKey();	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r6 = r3.f2802b;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r4.put(r5, r6);	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r4 = "network-cache-written";	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r2.addMarker(r4);	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
    L_0x006d:
        r2.markDelivered();	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r4 = r8.f2776e;	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        r4.mo774a(r2, r3);	 Catch:{ VolleyError -> 0x0099, Exception -> 0x0076 }
        goto L_0x0005;
    L_0x0076:
        r3 = move-exception;
        r4 = "Unhandled exception %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = r3.toString();
        r5[r6] = r7;
        com.android.volley.VolleyLog.m2455a(r3, r4, r5);
        r4 = new com.android.volley.VolleyError;
        r4.<init>(r3);
        r5 = android.os.SystemClock.elapsedRealtime();
        r5 = r5 - r0;
        r4.f2806b = r5;
        r0 = r8.f2776e;
        r0.mo776a(r2, r4);
        goto L_0x0005;
    L_0x0099:
        r3 = move-exception;
        r4 = android.os.SystemClock.elapsedRealtime();
        r4 = r4 - r0;
        r3.f2806b = r4;
        r0 = r2.parseNetworkError(r3);
        r1 = r8.f2776e;
        r1.mo776a(r2, r0);
        goto L_0x0005;
    L_0x00ac:
        r0 = r8.f2772a;
        if (r0 == 0) goto L_0x0005;
    L_0x00b0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.NetworkDispatcher.run():void");
    }
}
