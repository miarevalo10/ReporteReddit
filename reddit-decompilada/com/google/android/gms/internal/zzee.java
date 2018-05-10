package com.google.android.gms.internal;

import java.util.concurrent.Callable;

public final class zzee implements Callable {
    private final zzdm f7352a;
    private final zzaz f7353b;

    public zzee(zzdm com_google_android_gms_internal_zzdm, zzaz com_google_android_gms_internal_zzaz) {
        this.f7352a = com_google_android_gms_internal_zzdm;
        this.f7353b = com_google_android_gms_internal_zzaz;
    }

    public final /* synthetic */ Object call() throws Exception {
        return m5928a();
    }

    private final java.lang.Void m5928a() throws java.lang.Exception {
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
        r3 = this;
        r0 = r3.f7352a;
        r0 = r0.f7222g;
        if (r0 == 0) goto L_0x000d;
    L_0x0006:
        r0 = r3.f7352a;
        r0 = r0.f7222g;
        r0.get();
    L_0x000d:
        r0 = r3.f7352a;
        r0 = r0.f7221f;
        if (r0 == 0) goto L_0x0024;
    L_0x0013:
        r1 = r3.f7353b;	 Catch:{ zzfjr -> 0x0024 }
        monitor-enter(r1);	 Catch:{ zzfjr -> 0x0024 }
        r2 = r3.f7353b;	 Catch:{ all -> 0x0021 }
        r0 = com.google.android.gms.internal.zzfjs.m6205a(r0);	 Catch:{ all -> 0x0021 }
        com.google.android.gms.internal.zzfjs.m6203a(r2, r0);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        goto L_0x0024;	 Catch:{ all -> 0x0021 }
    L_0x0021:
        r0 = move-exception;	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        throw r0;	 Catch:{ zzfjr -> 0x0024 }
    L_0x0024:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzee.a():java.lang.Void");
    }
}
