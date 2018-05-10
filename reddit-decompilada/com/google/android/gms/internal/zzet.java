package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzet implements Callable {
    protected final zzdm f7363a;
    protected final zzaz f7364b;
    protected Method f7365c;
    private String f7366d = getClass().getSimpleName();
    private String f7367e;
    private String f7368f;
    private int f7369g;
    private int f7370h;

    public zzet(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i, int i2) {
        this.f7363a = com_google_android_gms_internal_zzdm;
        this.f7367e = str;
        this.f7368f = str2;
        this.f7364b = com_google_android_gms_internal_zzaz;
        this.f7369g = i;
        this.f7370h = i2;
    }

    protected abstract void mo1870a() throws IllegalAccessException, InvocationTargetException;

    public /* synthetic */ Object call() throws Exception {
        return mo1871b();
    }

    public java.lang.Void mo1871b() throws java.lang.Exception {
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
        r0 = 0;
        r1 = java.lang.System.nanoTime();	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r3 = r8.f7363a;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r4 = r8.f7367e;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r5 = r8.f7368f;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r3 = r3.m5846a(r4, r5);	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r8.f7365c = r3;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r3 = r8.f7365c;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        if (r3 != 0) goto L_0x0016;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
    L_0x0015:
        return r0;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
    L_0x0016:
        r8.mo1870a();	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r3 = r8.f7363a;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r3 = r3.f7223h;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        if (r3 == 0) goto L_0x0034;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
    L_0x001f:
        r4 = r8.f7369g;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r5 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        if (r4 == r5) goto L_0x0034;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
    L_0x0025:
        r4 = r8.f7370h;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r5 = r8.f7369g;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r6 = java.lang.System.nanoTime();	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r6 = r6 - r1;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r6 = r6 / r1;	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
        r3.m5810a(r4, r5, r6);	 Catch:{ IllegalAccessException -> 0x0034, IllegalAccessException -> 0x0034 }
    L_0x0034:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzet.b():java.lang.Void");
    }
}
