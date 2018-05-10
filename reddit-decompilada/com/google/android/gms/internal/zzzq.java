package com.google.android.gms.internal;

import java.lang.Thread.UncaughtExceptionHandler;

final class zzzq implements UncaughtExceptionHandler {
    private /* synthetic */ UncaughtExceptionHandler f8193a;
    private /* synthetic */ zzzp f8194b;

    zzzq(zzzp com_google_android_gms_internal_zzzp, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f8194b = com_google_android_gms_internal_zzzp;
        this.f8193a = uncaughtExceptionHandler;
    }

    public final void uncaughtException(java.lang.Thread r3, java.lang.Throwable r4) {
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
        r0 = r2.f8194b;	 Catch:{ Throwable -> 0x0011 }
        r0.m14487a(r4);	 Catch:{ Throwable -> 0x0011 }
        r0 = r2.f8193a;
        if (r0 == 0) goto L_0x001b;
    L_0x0009:
        r0 = r2.f8193a;
        r0.uncaughtException(r3, r4);
        return;
    L_0x000f:
        r0 = move-exception;
        goto L_0x001c;
    L_0x0011:
        r0 = "AdMob exception reporter failed reporting the exception.";	 Catch:{ all -> 0x000f }
        com.google.android.gms.internal.zzakb.m5368c(r0);	 Catch:{ all -> 0x000f }
        r0 = r2.f8193a;
        if (r0 == 0) goto L_0x001b;
    L_0x001a:
        goto L_0x0009;
    L_0x001b:
        return;
    L_0x001c:
        r1 = r2.f8193a;
        if (r1 == 0) goto L_0x0025;
    L_0x0020:
        r1 = r2.f8193a;
        r1.uncaughtException(r3, r4);
    L_0x0025:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzzq.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
