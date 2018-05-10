package com.google.android.gms.internal;

final class zze implements Runnable {
    private /* synthetic */ zzr f7350a;
    private /* synthetic */ zzd f7351b;

    zze(zzd com_google_android_gms_internal_zzd, zzr com_google_android_gms_internal_zzr) {
        this.f7351b = com_google_android_gms_internal_zzd;
        this.f7350a = com_google_android_gms_internal_zzr;
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
        r2 = this;
        r0 = r2.f7351b;	 Catch:{ InterruptedException -> 0x000c }
        r0 = r0.f7206c;	 Catch:{ InterruptedException -> 0x000c }
        r1 = r2.f7350a;	 Catch:{ InterruptedException -> 0x000c }
        r0.put(r1);	 Catch:{ InterruptedException -> 0x000c }
        return;
    L_0x000c:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zze.run():void");
    }
}
