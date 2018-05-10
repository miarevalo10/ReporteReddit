package com.google.android.gms.internal;

import android.content.Context;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;
import java.util.concurrent.LinkedBlockingQueue;

final class zzcbn implements zzf, zzg {
    private zzcbo f14214a;
    private final String f14215b;
    private final String f14216c;
    private final LinkedBlockingQueue<zzaz> f14217d;
    private final HandlerThread f14218e = new HandlerThread("GassClient");

    public zzcbn(Context context, String str, String str2) {
        this.f14215b = str;
        this.f14216c = str2;
        this.f14218e.start();
        this.f14214a = new zzcbo(context, this.f14218e.getLooper(), this, this);
        this.f14217d = new LinkedBlockingQueue();
        this.f14214a.m4860o();
    }

    private final com.google.android.gms.internal.zzcbt m13425c() {
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
        r1 = this;
        r0 = r1.f14214a;	 Catch:{ IllegalStateException -> 0x0007, IllegalStateException -> 0x0007 }
        r0 = r0.mo1649n();	 Catch:{ IllegalStateException -> 0x0007, IllegalStateException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcbn.c():com.google.android.gms.internal.zzcbt");
    }

    private final void m13426d() {
        if (this.f14214a == null) {
            return;
        }
        if (this.f14214a.m4853f() || this.f14214a.m4854g()) {
            this.f14214a.mo4292e();
        }
    }

    private static zzaz m13427e() {
        zzaz com_google_android_gms_internal_zzaz = new zzaz();
        com_google_android_gms_internal_zzaz.f17651k = Long.valueOf(32768);
        return com_google_android_gms_internal_zzaz;
    }

    public final void mo1620a() {
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
        r4 = this;
        r0 = r4.m13425c();
        if (r0 == 0) goto L_0x003a;
    L_0x0006:
        r1 = new com.google.android.gms.internal.zzcbp;	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r2 = r4.f14215b;	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r3 = r4.f14216c;	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r0 = r0.mo1777a(r1);	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r0 = r0.m17941a();	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r1 = r4.f14217d;	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r1.put(r0);	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
    L_0x001c:
        r4.m13426d();
        r0 = r4.f14218e;
        r0.quit();
        return;
    L_0x0025:
        r0 = move-exception;
        goto L_0x0031;
    L_0x0027:
        r0 = r4.f14217d;	 Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
        r1 = m13427e();	 Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
        r0.put(r1);	 Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
        goto L_0x001c;
    L_0x0031:
        r4.m13426d();
        r1 = r4.f14218e;
        r1.quit();
        throw r0;
    L_0x003a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcbn.a():void");
    }

    public final void mo1621a(int r2) {
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
        r1 = this;
        r2 = r1.f14217d;	 Catch:{ InterruptedException -> 0x0009 }
        r0 = m13427e();	 Catch:{ InterruptedException -> 0x0009 }
        r2.put(r0);	 Catch:{ InterruptedException -> 0x0009 }
    L_0x0009:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcbn.a(int):void");
    }

    public final void mo1622a(com.google.android.gms.common.ConnectionResult r2) {
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
        r1 = this;
        r2 = r1.f14217d;	 Catch:{ InterruptedException -> 0x0009 }
        r0 = m13427e();	 Catch:{ InterruptedException -> 0x0009 }
        r2.put(r0);	 Catch:{ InterruptedException -> 0x0009 }
    L_0x0009:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcbn.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public final com.google.android.gms.internal.zzaz m13431b() {
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
        r4 = this;
        r0 = r4.f14217d;	 Catch:{ InterruptedException -> 0x000d }
        r1 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;	 Catch:{ InterruptedException -> 0x000d }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x000d }
        r0 = r0.poll(r1, r3);	 Catch:{ InterruptedException -> 0x000d }
        r0 = (com.google.android.gms.internal.zzaz) r0;	 Catch:{ InterruptedException -> 0x000d }
        goto L_0x000e;
    L_0x000d:
        r0 = 0;
    L_0x000e:
        if (r0 != 0) goto L_0x0014;
    L_0x0010:
        r0 = m13427e();
    L_0x0014:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcbn.b():com.google.android.gms.internal.zzaz");
    }
}
