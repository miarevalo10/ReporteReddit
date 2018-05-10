package com.android.volley;

import java.util.concurrent.BlockingQueue;

public class CacheDispatcher extends Thread {
    private static final boolean f2759b = VolleyLog.f2814b;
    public volatile boolean f2760a = false;
    private final BlockingQueue<Request<?>> f2761c;
    private final BlockingQueue<Request<?>> f2762d;
    private final Cache f2763e;
    private final ResponseDelivery f2764f;

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.f2761c = blockingQueue;
        this.f2762d = blockingQueue2;
        this.f2763e = cache;
        this.f2764f = responseDelivery;
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
        r9 = this;
        r0 = f2759b;
        r1 = 0;
        if (r0 == 0) goto L_0x000c;
    L_0x0005:
        r0 = "start new dispatcher";
        r2 = new java.lang.Object[r1];
        com.android.volley.VolleyLog.m2454a(r0, r2);
    L_0x000c:
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
        r0 = r9.f2763e;
        r0.initialize();
    L_0x0016:
        r0 = r9.f2761c;	 Catch:{ InterruptedException -> 0x00b6 }
        r0 = r0.take();	 Catch:{ InterruptedException -> 0x00b6 }
        r0 = (com.android.volley.Request) r0;	 Catch:{ InterruptedException -> 0x00b6 }
        r2 = 1;
        r3 = "cache-queue-take";	 Catch:{ Exception -> 0x00a6 }
        r0.addMarker(r3);	 Catch:{ Exception -> 0x00a6 }
        r3 = r0.isCanceled();	 Catch:{ Exception -> 0x00a6 }
        if (r3 == 0) goto L_0x0030;	 Catch:{ Exception -> 0x00a6 }
    L_0x002a:
        r3 = "cache-discard-canceled";	 Catch:{ Exception -> 0x00a6 }
        r0.finish(r3);	 Catch:{ Exception -> 0x00a6 }
        goto L_0x0016;	 Catch:{ Exception -> 0x00a6 }
    L_0x0030:
        r3 = r9.f2763e;	 Catch:{ Exception -> 0x00a6 }
        r4 = r0.getCacheKey();	 Catch:{ Exception -> 0x00a6 }
        r3 = r3.get(r4);	 Catch:{ Exception -> 0x00a6 }
        if (r3 != 0) goto L_0x0047;	 Catch:{ Exception -> 0x00a6 }
    L_0x003c:
        r3 = "cache-miss";	 Catch:{ Exception -> 0x00a6 }
        r0.addMarker(r3);	 Catch:{ Exception -> 0x00a6 }
        r3 = r9.f2762d;	 Catch:{ Exception -> 0x00a6 }
        r3.put(r0);	 Catch:{ Exception -> 0x00a6 }
        goto L_0x0016;	 Catch:{ Exception -> 0x00a6 }
    L_0x0047:
        r4 = r3.f2754e;	 Catch:{ Exception -> 0x00a6 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00a6 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ Exception -> 0x00a6 }
        if (r4 >= 0) goto L_0x0053;	 Catch:{ Exception -> 0x00a6 }
    L_0x0051:
        r4 = r2;	 Catch:{ Exception -> 0x00a6 }
        goto L_0x0054;	 Catch:{ Exception -> 0x00a6 }
    L_0x0053:
        r4 = r1;	 Catch:{ Exception -> 0x00a6 }
    L_0x0054:
        if (r4 == 0) goto L_0x0064;	 Catch:{ Exception -> 0x00a6 }
    L_0x0056:
        r4 = "cache-hit-expired";	 Catch:{ Exception -> 0x00a6 }
        r0.addMarker(r4);	 Catch:{ Exception -> 0x00a6 }
        r0.setCacheEntry(r3);	 Catch:{ Exception -> 0x00a6 }
        r3 = r9.f2762d;	 Catch:{ Exception -> 0x00a6 }
        r3.put(r0);	 Catch:{ Exception -> 0x00a6 }
        goto L_0x0016;	 Catch:{ Exception -> 0x00a6 }
    L_0x0064:
        r4 = "cache-hit";	 Catch:{ Exception -> 0x00a6 }
        r0.addMarker(r4);	 Catch:{ Exception -> 0x00a6 }
        r4 = new com.android.volley.NetworkResponse;	 Catch:{ Exception -> 0x00a6 }
        r5 = r3.f2750a;	 Catch:{ Exception -> 0x00a6 }
        r6 = r3.f2756g;	 Catch:{ Exception -> 0x00a6 }
        r4.<init>(r5, r6);	 Catch:{ Exception -> 0x00a6 }
        r4 = r0.parseNetworkResponse(r4);	 Catch:{ Exception -> 0x00a6 }
        r5 = "cache-hit-parsed";	 Catch:{ Exception -> 0x00a6 }
        r0.addMarker(r5);	 Catch:{ Exception -> 0x00a6 }
        r5 = r3.f2755f;	 Catch:{ Exception -> 0x00a6 }
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00a6 }
        r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));	 Catch:{ Exception -> 0x00a6 }
        if (r5 >= 0) goto L_0x0087;	 Catch:{ Exception -> 0x00a6 }
    L_0x0085:
        r5 = r2;	 Catch:{ Exception -> 0x00a6 }
        goto L_0x0088;	 Catch:{ Exception -> 0x00a6 }
    L_0x0087:
        r5 = r1;	 Catch:{ Exception -> 0x00a6 }
    L_0x0088:
        if (r5 != 0) goto L_0x0090;	 Catch:{ Exception -> 0x00a6 }
    L_0x008a:
        r3 = r9.f2764f;	 Catch:{ Exception -> 0x00a6 }
        r3.mo774a(r0, r4);	 Catch:{ Exception -> 0x00a6 }
        goto L_0x0016;	 Catch:{ Exception -> 0x00a6 }
    L_0x0090:
        r5 = "cache-hit-refresh-needed";	 Catch:{ Exception -> 0x00a6 }
        r0.addMarker(r5);	 Catch:{ Exception -> 0x00a6 }
        r0.setCacheEntry(r3);	 Catch:{ Exception -> 0x00a6 }
        r4.f2804d = r2;	 Catch:{ Exception -> 0x00a6 }
        r3 = r9.f2764f;	 Catch:{ Exception -> 0x00a6 }
        r5 = new com.android.volley.CacheDispatcher$1;	 Catch:{ Exception -> 0x00a6 }
        r5.<init>(r9, r0);	 Catch:{ Exception -> 0x00a6 }
        r3.mo775a(r0, r4, r5);	 Catch:{ Exception -> 0x00a6 }
        goto L_0x0016;
    L_0x00a6:
        r0 = move-exception;
        r3 = "Unhandled exception %s";
        r2 = new java.lang.Object[r2];
        r4 = r0.toString();
        r2[r1] = r4;
        com.android.volley.VolleyLog.m2455a(r0, r3, r2);
        goto L_0x0016;
    L_0x00b6:
        r0 = r9.f2760a;
        if (r0 == 0) goto L_0x0016;
    L_0x00ba:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.CacheDispatcher.run():void");
    }
}
