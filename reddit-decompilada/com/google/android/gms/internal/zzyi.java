package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzba;
import java.util.concurrent.Future;

@zzzv
public final class zzyi extends zzagb {
    private final zzyb f18344a;
    private final zzaax f18345b;
    private final zzafp f18346c;
    private final zzym f18347d;
    private final Object f18348e;
    private Future<zzafo> f18349f;

    public zzyi(Context context, zzba com_google_android_gms_ads_internal_zzba, zzafp com_google_android_gms_internal_zzafp, zzcv com_google_android_gms_internal_zzcv, zzyb com_google_android_gms_internal_zzyb, zznu com_google_android_gms_internal_zznu) {
        this(com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zzyb, new zzym(context, com_google_android_gms_ads_internal_zzba, new zzaiv(context), com_google_android_gms_internal_zzcv, com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zznu));
    }

    private zzyi(zzafp com_google_android_gms_internal_zzafp, zzyb com_google_android_gms_internal_zzyb, zzym com_google_android_gms_internal_zzym) {
        this.f18348e = new Object();
        this.f18346c = com_google_android_gms_internal_zzafp;
        this.f18345b = com_google_android_gms_internal_zzafp.f6315b;
        this.f18344a = com_google_android_gms_internal_zzyb;
        this.f18347d = com_google_android_gms_internal_zzym;
    }

    public final void mo3384a() {
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
        r53 = this;
        r1 = r53;
        r2 = 0;
        r3 = 0;
        r4 = r1.f18348e;	 Catch:{ TimeoutException -> 0x0027, ExecutionException -> 0x0033, ExecutionException -> 0x0033, ExecutionException -> 0x0033 }
        monitor-enter(r4);	 Catch:{ TimeoutException -> 0x0027, ExecutionException -> 0x0033, ExecutionException -> 0x0033, ExecutionException -> 0x0033 }
        r5 = r1.f18347d;	 Catch:{ all -> 0x0023 }
        r6 = com.google.android.gms.internal.zzahh.f6369a;	 Catch:{ all -> 0x0023 }
        r5 = com.google.android.gms.internal.zzahh.m5149a(r6, r5);	 Catch:{ all -> 0x0023 }
        r1.f18349f = r5;	 Catch:{ all -> 0x0023 }
        monitor-exit(r4);	 Catch:{ all -> 0x0023 }
        r4 = r1.f18349f;	 Catch:{ TimeoutException -> 0x0027, ExecutionException -> 0x0033, ExecutionException -> 0x0033, ExecutionException -> 0x0033 }
        r5 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;	 Catch:{ TimeoutException -> 0x0027, ExecutionException -> 0x0033, ExecutionException -> 0x0033, ExecutionException -> 0x0033 }
        r7 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ TimeoutException -> 0x0027, ExecutionException -> 0x0033, ExecutionException -> 0x0033, ExecutionException -> 0x0033 }
        r4 = r4.get(r5, r7);	 Catch:{ TimeoutException -> 0x0027, ExecutionException -> 0x0033, ExecutionException -> 0x0033, ExecutionException -> 0x0033 }
        r4 = (com.google.android.gms.internal.zzafo) r4;	 Catch:{ TimeoutException -> 0x0027, ExecutionException -> 0x0033, ExecutionException -> 0x0033, ExecutionException -> 0x0033 }
        r2 = -2;
        r8 = r2;
        r3 = r4;
        goto L_0x0034;
    L_0x0023:
        r0 = move-exception;
        r5 = r0;
        monitor-exit(r4);	 Catch:{ all -> 0x0023 }
        throw r5;	 Catch:{ TimeoutException -> 0x0027, ExecutionException -> 0x0033, ExecutionException -> 0x0033, ExecutionException -> 0x0033 }
    L_0x0027:
        r2 = "Timed out waiting for native ad.";
        com.google.android.gms.internal.zzakb.m5371e(r2);
        r2 = 2;
        r4 = r1.f18349f;
        r5 = 1;
        r4.cancel(r5);
    L_0x0033:
        r8 = r2;
    L_0x0034:
        if (r3 == 0) goto L_0x0039;
    L_0x0036:
        r2 = r3;
        goto L_0x00cc;
    L_0x0039:
        r2 = new com.google.android.gms.internal.zzafo;
        r3 = r1.f18346c;
        r3 = r3.f6314a;
        r5 = r3.f17396c;
        r3 = r1.f18345b;
        r11 = r3.f17451k;
        r3 = r1.f18345b;
        r12 = r3.f17450j;
        r3 = r1.f18346c;
        r3 = r3.f6314a;
        r14 = r3.f17402i;
        r16 = 0;
        r17 = 0;
        r18 = 0;
        r19 = 0;
        r20 = 0;
        r3 = r1.f18345b;
        r3 = r3.f17448h;
        r15 = r1.f18346c;
        r15 = r15.f6317d;
        r10 = r1.f18345b;
        r44 = r11;
        r10 = r10.f17446f;
        r9 = r1.f18346c;
        r45 = r10;
        r10 = r9.f6319f;
        r9 = r1.f18345b;
        r47 = r10;
        r10 = r9.f17453m;
        r9 = r1.f18345b;
        r9 = r9.f17454n;
        r7 = r1.f18346c;
        r7 = r7.f6321h;
        r32 = 0;
        r33 = 0;
        r34 = 0;
        r35 = 0;
        r6 = r1.f18346c;
        r6 = r6.f6315b;
        r6 = r6.f17424D;
        r49 = r3;
        r3 = r1.f18346c;
        r3 = r3.f6315b;
        r3 = r3.f17425E;
        r38 = 0;
        r39 = 0;
        r4 = r1.f18345b;
        r4 = r4.f17432L;
        r51 = r4;
        r4 = r1.f18346c;
        r4 = r4.f6322i;
        r52 = r4;
        r4 = r1.f18346c;
        r4 = r4.f6315b;
        r4 = r4.f17435O;
        r43 = 0;
        r42 = r4;
        r21 = r49;
        r40 = r51;
        r41 = r52;
        r4 = r2;
        r36 = r6;
        r6 = 0;
        r31 = r7;
        r7 = 0;
        r30 = r9;
        r9 = 0;
        r28 = r10;
        r24 = r45;
        r26 = r47;
        r10 = 0;
        r11 = r44;
        r23 = r15;
        r15 = 0;
        r37 = r3;
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r26, r28, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43);
    L_0x00cc:
        r3 = com.google.android.gms.internal.zzahn.f6379a;
        r4 = new com.google.android.gms.internal.zzyj;
        r4.<init>(r1, r2);
        r3.post(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzyi.a():void");
    }

    public final void mo3385b() {
        synchronized (this.f18348e) {
            if (this.f18349f != null) {
                this.f18349f.cancel(true);
            }
        }
    }
}
