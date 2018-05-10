package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;

public final class zzn extends Thread {
    volatile boolean f7850a = false;
    private final BlockingQueue<zzr<?>> f7851b;
    private final zzm f7852c;
    private final zzb f7853d;
    private final zzz f7854e;

    public zzn(BlockingQueue<zzr<?>> blockingQueue, zzm com_google_android_gms_internal_zzm, zzb com_google_android_gms_internal_zzb, zzz com_google_android_gms_internal_zzz) {
        this.f7851b = blockingQueue;
        this.f7852c = com_google_android_gms_internal_zzm;
        this.f7853d = com_google_android_gms_internal_zzb;
        this.f7854e = com_google_android_gms_internal_zzz;
    }

    public final void run() {
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
        r2 = r8.f7851b;	 Catch:{ InterruptedException -> 0x00a6 }
        r2 = r2.take();	 Catch:{ InterruptedException -> 0x00a6 }
        r2 = (com.google.android.gms.internal.zzr) r2;	 Catch:{ InterruptedException -> 0x00a6 }
        r3 = 1;
        r4 = "network-queue-take";	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r2.m6628b(r4);	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r4 = r2.f7968c;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        android.net.TrafficStats.setThreadStatsTag(r4);	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r4 = r8.f7852c;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r4 = r4.mo1723a(r2);	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r5 = "network-http-complete";	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r2.m6628b(r5);	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r5 = r4.f7960e;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        if (r5 == 0) goto L_0x0038;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
    L_0x002b:
        r5 = r2.f7973h;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        if (r5 == 0) goto L_0x0038;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
    L_0x002f:
        r4 = "not-modified";	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r2.m6630c(r4);	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r2.m6631d();	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        goto L_0x0005;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
    L_0x0038:
        r4 = r2.mo1727a(r4);	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r5 = "network-parse-complete";	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r2.m6628b(r5);	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r5 = r2.f7972g;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        if (r5 == 0) goto L_0x0057;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
    L_0x0045:
        r5 = r4.f8109b;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        if (r5 == 0) goto L_0x0057;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
    L_0x0049:
        r5 = r8.f7853d;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r6 = r2.f7967b;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r7 = r4.f8109b;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r5.mo1735a(r6, r7);	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r5 = "network-cache-written";	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r2.m6628b(r5);	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
    L_0x0057:
        r2.f7973h = r3;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r5 = r8.f7854e;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r5.mo1955a(r2, r4);	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r5 = r2.f7977l;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        monitor-enter(r5);	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
        r6 = r2.f7976k;	 Catch:{ all -> 0x006c }
        if (r6 == 0) goto L_0x006a;	 Catch:{ all -> 0x006c }
    L_0x0065:
        r6 = r2.f7976k;	 Catch:{ all -> 0x006c }
        r6.mo1874a(r2, r4);	 Catch:{ all -> 0x006c }
    L_0x006a:
        monitor-exit(r5);	 Catch:{ all -> 0x006c }
        goto L_0x0005;	 Catch:{ all -> 0x006c }
    L_0x006c:
        r4 = move-exception;	 Catch:{ all -> 0x006c }
        monitor-exit(r5);	 Catch:{ all -> 0x006c }
        throw r4;	 Catch:{ zzad -> 0x0094, Exception -> 0x006f }
    L_0x006f:
        r4 = move-exception;
        r5 = "Unhandled exception %s";
        r3 = new java.lang.Object[r3];
        r6 = 0;
        r7 = r4.toString();
        r3[r6] = r7;
        com.google.android.gms.internal.zzae.m5042a(r4, r5, r3);
        r3 = new com.google.android.gms.internal.zzad;
        r3.<init>(r4);
        r4 = android.os.SystemClock.elapsedRealtime();
        r4 = r4 - r0;
        r3.f6224a = r4;
        r0 = r8.f7854e;
        r0.mo1954a(r2, r3);
        r2.m6631d();
        goto L_0x0005;
    L_0x0094:
        r3 = move-exception;
        r4 = android.os.SystemClock.elapsedRealtime();
        r4 = r4 - r0;
        r3.f6224a = r4;
        r0 = r8.f7854e;
        r0.mo1954a(r2, r3);
        r2.m6631d();
        goto L_0x0005;
    L_0x00a6:
        r0 = r8.f7850a;
        if (r0 == 0) goto L_0x0005;
    L_0x00aa:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzn.run():void");
    }
}
