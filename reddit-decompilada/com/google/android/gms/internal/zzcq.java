package com.google.android.gms.internal;

final class zzcq implements Runnable {
    private /* synthetic */ zzcp f7185a;

    zzcq(zzcp com_google_android_gms_internal_zzcp) {
        this.f7185a = com_google_android_gms_internal_zzcp;
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
        r5 = this;
        r0 = r5.f7185a;
        r0 = r0.f7183b;
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = com.google.android.gms.internal.zzcp.f7181d;
        monitor-enter(r0);
        r1 = r5.f7185a;	 Catch:{ all -> 0x004a }
        r1 = r1.f7183b;	 Catch:{ all -> 0x004a }
        if (r1 == 0) goto L_0x0014;	 Catch:{ all -> 0x004a }
    L_0x0012:
        monitor-exit(r0);	 Catch:{ all -> 0x004a }
        return;	 Catch:{ all -> 0x004a }
    L_0x0014:
        r1 = com.google.android.gms.internal.zznh.bo;	 Catch:{ all -> 0x004a }
        r2 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x004a }
        r1 = r2.m6488a(r1);	 Catch:{ all -> 0x004a }
        r1 = (java.lang.Boolean) r1;	 Catch:{ all -> 0x004a }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x004a }
        if (r1 == 0) goto L_0x0039;
    L_0x0026:
        r2 = new com.google.android.gms.internal.zzix;	 Catch:{ Throwable -> 0x0038 }
        r3 = r5.f7185a;	 Catch:{ Throwable -> 0x0038 }
        r3 = r3.f7184c;	 Catch:{ Throwable -> 0x0038 }
        r3 = r3.f7216a;	 Catch:{ Throwable -> 0x0038 }
        r4 = "ADSHIELD";	 Catch:{ Throwable -> 0x0038 }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x0038 }
        com.google.android.gms.internal.zzcp.f7180a = r2;	 Catch:{ Throwable -> 0x0038 }
        goto L_0x0039;
    L_0x0038:
        r1 = 0;
    L_0x0039:
        r2 = r5.f7185a;	 Catch:{ all -> 0x004a }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x004a }
        r2.f7183b = r1;	 Catch:{ all -> 0x004a }
        r1 = com.google.android.gms.internal.zzcp.f7181d;	 Catch:{ all -> 0x004a }
        r1.open();	 Catch:{ all -> 0x004a }
        monitor-exit(r0);	 Catch:{ all -> 0x004a }
        return;	 Catch:{ all -> 0x004a }
    L_0x004a:
        r1 = move-exception;	 Catch:{ all -> 0x004a }
        monitor-exit(r0);	 Catch:{ all -> 0x004a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcq.run():void");
    }
}
