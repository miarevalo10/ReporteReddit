package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

public class zzer {
    private static String f7354a = "zzer";
    private final zzdm f7355b;
    private final String f7356c;
    private final String f7357d;
    private final int f7358e = 2;
    private volatile Method f7359f = null;
    private final Class<?>[] f7360g;
    private CountDownLatch f7361h = new CountDownLatch(1);

    public final java.lang.reflect.Method m5931a() {
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
        r5 = this;
        r0 = r5.f7359f;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0 = r5.f7359f;
        return r0;
    L_0x0007:
        r0 = 0;
        r1 = r5.f7361h;	 Catch:{ InterruptedException -> 0x0018 }
        r2 = 2;	 Catch:{ InterruptedException -> 0x0018 }
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0018 }
        r1 = r1.await(r2, r4);	 Catch:{ InterruptedException -> 0x0018 }
        if (r1 != 0) goto L_0x0015;	 Catch:{ InterruptedException -> 0x0018 }
    L_0x0014:
        return r0;	 Catch:{ InterruptedException -> 0x0018 }
    L_0x0015:
        r1 = r5.f7359f;	 Catch:{ InterruptedException -> 0x0018 }
        return r1;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzer.a():java.lang.reflect.Method");
    }

    public zzer(zzdm com_google_android_gms_internal_zzdm, String str, String str2, Class<?>... clsArr) {
        this.f7355b = com_google_android_gms_internal_zzdm;
        this.f7356c = str;
        this.f7357d = str2;
        this.f7360g = clsArr;
        this.f7355b.f7217b.submit(new zzes(this));
    }

    private final String m5929a(byte[] bArr, String str) throws zzcy, UnsupportedEncodingException {
        zzcx com_google_android_gms_internal_zzcx = this.f7355b.f7219d;
        return new String(zzcx.m5825a(bArr, str), "UTF-8");
    }

    static /* synthetic */ void m5930a(com.google.android.gms.internal.zzer r3) {
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
        r0 = r3.f7355b;	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r0 = r0.f7218c;	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r1 = r3.f7355b;	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r1 = r1.f7220e;	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r2 = r3.f7356c;	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r1 = r3.m5929a(r1, r2);	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r0 = r0.loadClass(r1);	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        if (r0 != 0) goto L_0x001a;
    L_0x0014:
        r3 = r3.f7361h;
        r3.countDown();
        return;
    L_0x001a:
        r1 = r3.f7355b;	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r1 = r1.f7220e;	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r2 = r3.f7357d;	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r1 = r3.m5929a(r1, r2);	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r2 = r3.f7360g;	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r0 = r0.getMethod(r1, r2);	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r3.f7359f = r0;	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        r0 = r3.f7359f;	 Catch:{ zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, zzcy -> 0x0014, all -> 0x002f }
        goto L_0x0014;
    L_0x002f:
        r0 = move-exception;
        r3 = r3.f7361h;
        r3.countDown();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzer.a(com.google.android.gms.internal.zzer):void");
    }
}
