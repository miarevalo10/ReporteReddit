package com.google.android.gms.internal;

import android.content.Context;

@zzzv
public final class zzady extends zzagb implements zzaee, zzaeh {
    final zzuh f17509a;
    private final zzafp f17510b;
    private final Context f17511c;
    private final zzael f17512d;
    private final zzaeh f17513e;
    private final Object f17514f;
    private final String f17515g;
    private final String f17516h;
    private final long f17517i;
    private int f17518j = 0;
    private int f17519k = 3;
    private zzaeb f17520l;

    public zzady(Context context, String str, String str2, zzuh com_google_android_gms_internal_zzuh, zzafp com_google_android_gms_internal_zzafp, zzael com_google_android_gms_internal_zzael, zzaeh com_google_android_gms_internal_zzaeh, long j) {
        this.f17511c = context;
        this.f17515g = str;
        this.f17516h = str2;
        this.f17509a = com_google_android_gms_internal_zzuh;
        this.f17510b = com_google_android_gms_internal_zzafp;
        this.f17512d = com_google_android_gms_internal_zzael;
        this.f17514f = new Object();
        this.f17513e = com_google_android_gms_internal_zzaeh;
        this.f17517i = j;
    }

    private final boolean m17750a(long r5) {
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
        r0 = r4.f17517i;
        r2 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r2 = r2.mo1633b();
        r2 = r2 - r5;
        r0 = r0 - r2;
        r5 = 0;
        r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        r6 = 0;
        if (r5 > 0) goto L_0x0017;
    L_0x0013:
        r5 = 4;
    L_0x0014:
        r4.f17519k = r5;
        return r6;
    L_0x0017:
        r5 = r4.f17514f;	 Catch:{ InterruptedException -> 0x001e }
        r5.wait(r0);	 Catch:{ InterruptedException -> 0x001e }
        r5 = 1;
        return r5;
    L_0x001e:
        r5 = java.lang.Thread.currentThread();
        r5.interrupt();
        r5 = 5;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzady.a(long):boolean");
    }

    public final void mo3431a(int i) {
        synchronized (this.f17514f) {
            this.f17518j = 2;
            this.f17519k = i;
            this.f17514f.notify();
        }
    }

    public final void mo3432a(String str) {
        synchronized (this.f17514f) {
            this.f17518j = 1;
            this.f17514f.notify();
        }
    }

    public final void mo3385b() {
    }

    public final zzaeb m17757c() {
        zzaeb com_google_android_gms_internal_zzaeb;
        synchronized (this.f17514f) {
            com_google_android_gms_internal_zzaeb = this.f17520l;
        }
        return com_google_android_gms_internal_zzaeb;
    }

    public final void mo3434g() {
        mo3431a(0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo3384a() {
        /*
        r9 = this;
        r0 = r9.f17512d;
        if (r0 == 0) goto L_0x00cc;
    L_0x0004:
        r0 = r9.f17512d;
        r0 = r0.f6254b;
        if (r0 == 0) goto L_0x00cc;
    L_0x000a:
        r0 = r9.f17512d;
        r0 = r0.f6253a;
        if (r0 != 0) goto L_0x0012;
    L_0x0010:
        goto L_0x00cc;
    L_0x0012:
        r0 = r9.f17512d;
        r0 = r0.f6254b;
        r1 = 0;
        r0.f17522b = r1;
        r0.f17521a = r9;
        r2 = r9.f17510b;
        r2 = r2.f6314a;
        r2 = r2.f17396c;
        r3 = r9.f17512d;
        r3 = r3.f6253a;
        r4 = r3.mo2187g();	 Catch:{ RemoteException -> 0x003e }
        if (r4 == 0) goto L_0x0036;
    L_0x002b:
        r4 = com.google.android.gms.internal.zzajr.f6473a;	 Catch:{ RemoteException -> 0x003e }
        r5 = new com.google.android.gms.internal.zzadz;	 Catch:{ RemoteException -> 0x003e }
        r5.<init>(r9, r2, r3);	 Catch:{ RemoteException -> 0x003e }
    L_0x0032:
        r4.post(r5);	 Catch:{ RemoteException -> 0x003e }
        goto L_0x0048;
    L_0x0036:
        r4 = com.google.android.gms.internal.zzajr.f6473a;	 Catch:{ RemoteException -> 0x003e }
        r5 = new com.google.android.gms.internal.zzaea;	 Catch:{ RemoteException -> 0x003e }
        r5.<init>(r9, r3, r2, r0);	 Catch:{ RemoteException -> 0x003e }
        goto L_0x0032;
    L_0x003e:
        r2 = move-exception;
        r3 = "Fail to check if adapter is initialized.";
        com.google.android.gms.internal.zzakb.m5369c(r3, r2);
        r2 = 0;
        r9.mo3431a(r2);
    L_0x0048:
        r2 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r2 = r2.mo1633b();
    L_0x0050:
        r4 = r9.f17514f;
        monitor-enter(r4);
        r5 = r9.f17518j;	 Catch:{ all -> 0x00c9 }
        r6 = 1;
        if (r5 == 0) goto L_0x0084;
    L_0x0058:
        r5 = new com.google.android.gms.internal.zzaed;	 Catch:{ all -> 0x00c9 }
        r5.<init>();	 Catch:{ all -> 0x00c9 }
        r7 = com.google.android.gms.ads.internal.zzbs.m4492k();	 Catch:{ all -> 0x00c9 }
        r7 = r7.mo1633b();	 Catch:{ all -> 0x00c9 }
        r7 = r7 - r2;
        r5.f6248d = r7;	 Catch:{ all -> 0x00c9 }
        r2 = r9.f17518j;	 Catch:{ all -> 0x00c9 }
        if (r6 != r2) goto L_0x006e;
    L_0x006c:
        r2 = 6;
        goto L_0x0070;
    L_0x006e:
        r2 = r9.f17519k;	 Catch:{ all -> 0x00c9 }
    L_0x0070:
        r5.f6247c = r2;	 Catch:{ all -> 0x00c9 }
        r2 = r9.f17515g;	 Catch:{ all -> 0x00c9 }
        r5.f6245a = r2;	 Catch:{ all -> 0x00c9 }
        r2 = r9.f17509a;	 Catch:{ all -> 0x00c9 }
        r2 = r2.f8049d;	 Catch:{ all -> 0x00c9 }
        r5.f6246b = r2;	 Catch:{ all -> 0x00c9 }
        r2 = r5.m5050a();	 Catch:{ all -> 0x00c9 }
        r9.f17520l = r2;	 Catch:{ all -> 0x00c9 }
        monitor-exit(r4);	 Catch:{ all -> 0x00c9 }
        goto L_0x00af;
    L_0x0084:
        r5 = r9.m17750a(r2);	 Catch:{ all -> 0x00c9 }
        if (r5 != 0) goto L_0x00c7;
    L_0x008a:
        r5 = new com.google.android.gms.internal.zzaed;	 Catch:{ all -> 0x00c9 }
        r5.<init>();	 Catch:{ all -> 0x00c9 }
        r7 = r9.f17519k;	 Catch:{ all -> 0x00c9 }
        r5.f6247c = r7;	 Catch:{ all -> 0x00c9 }
        r7 = com.google.android.gms.ads.internal.zzbs.m4492k();	 Catch:{ all -> 0x00c9 }
        r7 = r7.mo1633b();	 Catch:{ all -> 0x00c9 }
        r7 = r7 - r2;
        r5.f6248d = r7;	 Catch:{ all -> 0x00c9 }
        r2 = r9.f17515g;	 Catch:{ all -> 0x00c9 }
        r5.f6245a = r2;	 Catch:{ all -> 0x00c9 }
        r2 = r9.f17509a;	 Catch:{ all -> 0x00c9 }
        r2 = r2.f8049d;	 Catch:{ all -> 0x00c9 }
        r5.f6246b = r2;	 Catch:{ all -> 0x00c9 }
        r2 = r5.m5050a();	 Catch:{ all -> 0x00c9 }
        r9.f17520l = r2;	 Catch:{ all -> 0x00c9 }
        monitor-exit(r4);	 Catch:{ all -> 0x00c9 }
    L_0x00af:
        r0.f17522b = r1;
        r0.f17521a = r1;
        r0 = r9.f17518j;
        if (r0 != r6) goto L_0x00bf;
    L_0x00b7:
        r0 = r9.f17513e;
        r1 = r9.f17515g;
        r0.mo3432a(r1);
        return;
    L_0x00bf:
        r0 = r9.f17513e;
        r1 = r9.f17519k;
        r0.mo3431a(r1);
        return;
    L_0x00c7:
        monitor-exit(r4);	 Catch:{ all -> 0x00c9 }
        goto L_0x0050;
    L_0x00c9:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00c9 }
        throw r0;
    L_0x00cc:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzady.a():void");
    }

    public final void mo3433f() {
        m17749a(this.f17510b.f6314a.f17396c, this.f17512d.f6253a);
    }

    private final void m17749a(zzjj com_google_android_gms_internal_zzjj, zzva com_google_android_gms_internal_zzva) {
        this.f17512d.f6254b.f17522b = this;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f17515g)) {
                com_google_android_gms_internal_zzva.mo2180a(com_google_android_gms_internal_zzjj, this.f17516h, this.f17509a.f8046a);
            } else {
                com_google_android_gms_internal_zzva.mo2179a(com_google_android_gms_internal_zzjj, this.f17516h);
            }
        } catch (zzjj com_google_android_gms_internal_zzjj2) {
            zzakb.m5369c("Fail to load ad from adapter.", com_google_android_gms_internal_zzjj2);
            mo3431a((int) null);
        }
    }
}
