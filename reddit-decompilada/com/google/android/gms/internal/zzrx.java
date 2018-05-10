package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;
import java.util.concurrent.Future;

@zzzv
public final class zzrx implements zzm {
    private zzrq f14613a;
    private boolean f14614b;
    private final Context f14615c;
    private final Object f14616d = new Object();

    public zzrx(Context context) {
        this.f14615c = context;
    }

    private final Future<ParcelFileDescriptor> m14242a(zzrr com_google_android_gms_internal_zzrr) {
        Future com_google_android_gms_internal_zzry = new zzry(this);
        zzf com_google_android_gms_internal_zzrz = new zzrz(this, com_google_android_gms_internal_zzry, com_google_android_gms_internal_zzrr);
        zzg com_google_android_gms_internal_zzsc = new zzsc(this, com_google_android_gms_internal_zzry);
        synchronized (this.f14616d) {
            this.f14613a = new zzrq(this.f14615c, zzbs.m4500s().m5300a(), com_google_android_gms_internal_zzrz, com_google_android_gms_internal_zzsc);
            this.f14613a.m4860o();
        }
        return com_google_android_gms_internal_zzry;
    }

    public final com.google.android.gms.internal.zzp mo1723a(com.google.android.gms.internal.zzr<?> r14) throws com.google.android.gms.internal.zzad {
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
        r13 = this;
        r14 = com.google.android.gms.internal.zzrr.m18978a(r14);
        r0 = com.google.android.gms.internal.zznh.cu;
        r1 = com.google.android.gms.internal.zzkb.m6350f();
        r0 = r1.m6488a(r0);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r0 = (long) r0;
        r2 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r2 = r2.mo1633b();
        r4 = 0;
        r5 = 52;
        r14 = r13.m14242a(r14);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r6 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = r14.get(r0, r6);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = (android.os.ParcelFileDescriptor) r14;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0 = new com.google.android.gms.internal.zzabj;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0.<init>(r14);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = com.google.android.gms.internal.zzrt.CREATOR;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = r0.m17705a(r14);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = (com.google.android.gms.internal.zzrt) r14;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0 = r14.f18285a;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        if (r0 == 0) goto L_0x0045;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x003d:
        r0 = new com.google.android.gms.internal.zzad;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r14 = r14.f18286b;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0.<init>(r14);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        throw r0;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x0045:
        r0 = r14.f18289e;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0 = r0.length;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r1 = r14.f18290f;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r1 = r1.length;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        if (r0 == r1) goto L_0x004f;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x004d:
        r0 = r4;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        goto L_0x0076;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x004f:
        r9 = new java.util.HashMap;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r9.<init>();	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0 = 0;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x0055:
        r1 = r14.f18289e;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r1 = r1.length;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        if (r0 >= r1) goto L_0x0068;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x005a:
        r1 = r14.f18289e;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r1 = r1[r0];	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r6 = r14.f18290f;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r6 = r6[r0];	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r9.put(r1, r6);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r0 = r0 + 1;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        goto L_0x0055;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x0068:
        r0 = new com.google.android.gms.internal.zzp;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r7 = r14.f18287c;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r8 = r14.f18288d;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r10 = r14.f18291g;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r11 = r14.f18292h;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r6 = r0;	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
        r6.<init>(r7, r8, r9, r10, r11);	 Catch:{ InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, InterruptedException -> 0x00bd, all -> 0x0099 }
    L_0x0076:
        r14 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r6 = r14.mo1633b();
        r6 = r6 - r2;
        r14 = new java.lang.StringBuilder;
        r14.<init>(r5);
        r1 = "Http assets remote cache took ";
        r14.append(r1);
        r14.append(r6);
        r1 = "ms";
        r14.append(r1);
        r14 = r14.toString();
        com.google.android.gms.internal.zzagf.m13278a(r14);
        return r0;
    L_0x0099:
        r14 = move-exception;
        r0 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r0 = r0.mo1633b();
        r0 = r0 - r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r5);
        r3 = "Http assets remote cache took ";
        r2.append(r3);
        r2.append(r0);
        r0 = "ms";
        r2.append(r0);
        r0 = r2.toString();
        com.google.android.gms.internal.zzagf.m13278a(r0);
        throw r14;
    L_0x00bd:
        r14 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r0 = r14.mo1633b();
        r0 = r0 - r2;
        r14 = new java.lang.StringBuilder;
        r14.<init>(r5);
        r2 = "Http assets remote cache took ";
        r14.append(r2);
        r14.append(r0);
        r0 = "ms";
        r14.append(r0);
        r14 = r14.toString();
        com.google.android.gms.internal.zzagf.m13278a(r14);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrx.a(com.google.android.gms.internal.zzr):com.google.android.gms.internal.zzp");
    }

    static /* synthetic */ void m14243a(zzrx com_google_android_gms_internal_zzrx) {
        synchronized (com_google_android_gms_internal_zzrx.f14616d) {
            if (com_google_android_gms_internal_zzrx.f14613a == null) {
                return;
            }
            com_google_android_gms_internal_zzrx.f14613a.mo4292e();
            com_google_android_gms_internal_zzrx.f14613a = null;
            Binder.flushPendingCommands();
        }
    }
}
