package com.google.android.gms.internal;

import android.os.ConditionVariable;
import java.util.Random;

public class zzcp {
    protected static volatile zzix f7180a;
    private static final ConditionVariable f7181d = new ConditionVariable();
    private static volatile Random f7182e;
    protected volatile Boolean f7183b;
    private zzdm f7184c;

    public static int m5806a() {
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
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ RuntimeException -> 0x0018 }
        r1 = 21;	 Catch:{ RuntimeException -> 0x0018 }
        if (r0 < r1) goto L_0x000f;	 Catch:{ RuntimeException -> 0x0018 }
    L_0x0006:
        r0 = java.util.concurrent.ThreadLocalRandom.current();	 Catch:{ RuntimeException -> 0x0018 }
        r0 = r0.nextInt();	 Catch:{ RuntimeException -> 0x0018 }
        return r0;	 Catch:{ RuntimeException -> 0x0018 }
    L_0x000f:
        r0 = m5809c();	 Catch:{ RuntimeException -> 0x0018 }
        r0 = r0.nextInt();	 Catch:{ RuntimeException -> 0x0018 }
        return r0;
    L_0x0018:
        r0 = m5809c();
        r0 = r0.nextInt();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcp.a():int");
    }

    private static Random m5809c() {
        if (f7182e == null) {
            synchronized (zzcp.class) {
                if (f7182e == null) {
                    f7182e = new Random();
                }
            }
        }
        return f7182e;
    }

    public zzcp(zzdm com_google_android_gms_internal_zzdm) {
        this.f7184c = com_google_android_gms_internal_zzdm;
        com_google_android_gms_internal_zzdm.f7217b.execute(new zzcq(this));
    }

    public final void m5810a(int r3, int r4, long r5) throws java.io.IOException {
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
        r0 = f7181d;	 Catch:{ Exception -> 0x0037 }
        r0.block();	 Catch:{ Exception -> 0x0037 }
        r0 = r2.f7183b;	 Catch:{ Exception -> 0x0037 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0037 }
        if (r0 == 0) goto L_0x0037;	 Catch:{ Exception -> 0x0037 }
    L_0x000d:
        r0 = f7180a;	 Catch:{ Exception -> 0x0037 }
        if (r0 == 0) goto L_0x0037;	 Catch:{ Exception -> 0x0037 }
    L_0x0011:
        r0 = new com.google.android.gms.internal.zzav;	 Catch:{ Exception -> 0x0037 }
        r0.<init>();	 Catch:{ Exception -> 0x0037 }
        r1 = r2.f7184c;	 Catch:{ Exception -> 0x0037 }
        r1 = r1.f7216a;	 Catch:{ Exception -> 0x0037 }
        r1 = r1.getPackageName();	 Catch:{ Exception -> 0x0037 }
        r0.f17596a = r1;	 Catch:{ Exception -> 0x0037 }
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ Exception -> 0x0037 }
        r0.f17597b = r5;	 Catch:{ Exception -> 0x0037 }
        r5 = f7180a;	 Catch:{ Exception -> 0x0037 }
        r6 = com.google.android.gms.internal.zzfjs.m6205a(r0);	 Catch:{ Exception -> 0x0037 }
        r5 = r5.m6328a(r6);	 Catch:{ Exception -> 0x0037 }
        r5.f7733a = r4;	 Catch:{ Exception -> 0x0037 }
        r5.f7734b = r3;	 Catch:{ Exception -> 0x0037 }
        r5.m6329a();	 Catch:{ Exception -> 0x0037 }
    L_0x0037:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcp.a(int, int, long):void");
    }
}
