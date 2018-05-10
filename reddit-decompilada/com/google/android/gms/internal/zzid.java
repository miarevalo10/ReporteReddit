package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;

@zzzv
public final class zzid {
    public final Runnable f7721a = new zzie(this);
    public final Object f7722b = new Object();
    private zzik f7723c;
    private Context f7724d;
    private zzio f7725e;

    public final zzii m6317a(zzil com_google_android_gms_internal_zzil) {
        synchronized (this.f7722b) {
            if (this.f7725e == null) {
                zzii com_google_android_gms_internal_zzii = new zzii();
                return com_google_android_gms_internal_zzii;
            }
            try {
                com_google_android_gms_internal_zzii = this.f7725e.mo1957a(com_google_android_gms_internal_zzil);
                return com_google_android_gms_internal_zzii;
            } catch (Throwable e) {
                zzakb.m5367b("Unable to call into cache service.", e);
                return new zzii();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m6318a() {
        /*
        r6 = this;
        r0 = r6.f7722b;
        monitor-enter(r0);
        r1 = r6.f7724d;	 Catch:{ all -> 0x0030 }
        if (r1 == 0) goto L_0x002e;
    L_0x0007:
        r1 = r6.f7723c;	 Catch:{ all -> 0x0030 }
        if (r1 == 0) goto L_0x000c;
    L_0x000b:
        goto L_0x002e;
    L_0x000c:
        r1 = new com.google.android.gms.internal.zzig;	 Catch:{ all -> 0x0030 }
        r1.<init>(r6);	 Catch:{ all -> 0x0030 }
        r2 = new com.google.android.gms.internal.zzih;	 Catch:{ all -> 0x0030 }
        r2.<init>(r6);	 Catch:{ all -> 0x0030 }
        r3 = new com.google.android.gms.internal.zzik;	 Catch:{ all -> 0x0030 }
        r4 = r6.f7724d;	 Catch:{ all -> 0x0030 }
        r5 = com.google.android.gms.ads.internal.zzbs.m4500s();	 Catch:{ all -> 0x0030 }
        r5 = r5.m5300a();	 Catch:{ all -> 0x0030 }
        r3.<init>(r4, r5, r1, r2);	 Catch:{ all -> 0x0030 }
        r6.f7723c = r3;	 Catch:{ all -> 0x0030 }
        r1 = r6.f7723c;	 Catch:{ all -> 0x0030 }
        r1.m4860o();	 Catch:{ all -> 0x0030 }
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        return;
    L_0x002e:
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        return;
    L_0x0030:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzid.a():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m6319a(android.content.Context r3) {
        /*
        r2 = this;
        if (r3 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r2.f7722b;
        monitor-enter(r0);
        r1 = r2.f7724d;	 Catch:{ all -> 0x0048 }
        if (r1 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r0);	 Catch:{ all -> 0x0048 }
        return;
    L_0x000c:
        r3 = r3.getApplicationContext();	 Catch:{ all -> 0x0048 }
        r2.f7724d = r3;	 Catch:{ all -> 0x0048 }
        r3 = com.google.android.gms.internal.zznh.co;	 Catch:{ all -> 0x0048 }
        r1 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x0048 }
        r3 = r1.m6488a(r3);	 Catch:{ all -> 0x0048 }
        r3 = (java.lang.Boolean) r3;	 Catch:{ all -> 0x0048 }
        r3 = r3.booleanValue();	 Catch:{ all -> 0x0048 }
        if (r3 == 0) goto L_0x0028;
    L_0x0024:
        r2.m6318a();	 Catch:{ all -> 0x0048 }
        goto L_0x0046;
    L_0x0028:
        r3 = com.google.android.gms.internal.zznh.cn;	 Catch:{ all -> 0x0048 }
        r1 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x0048 }
        r3 = r1.m6488a(r3);	 Catch:{ all -> 0x0048 }
        r3 = (java.lang.Boolean) r3;	 Catch:{ all -> 0x0048 }
        r3 = r3.booleanValue();	 Catch:{ all -> 0x0048 }
        if (r3 == 0) goto L_0x0046;
    L_0x003a:
        r3 = new com.google.android.gms.internal.zzif;	 Catch:{ all -> 0x0048 }
        r3.<init>(r2);	 Catch:{ all -> 0x0048 }
        r1 = com.google.android.gms.ads.internal.zzbs.m4489h();	 Catch:{ all -> 0x0048 }
        r1.m6283a(r3);	 Catch:{ all -> 0x0048 }
    L_0x0046:
        monitor-exit(r0);	 Catch:{ all -> 0x0048 }
        return;
    L_0x0048:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0048 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzid.a(android.content.Context):void");
    }

    static /* synthetic */ void m6312a(zzid com_google_android_gms_internal_zzid) {
        synchronized (com_google_android_gms_internal_zzid.f7722b) {
            if (com_google_android_gms_internal_zzid.f7723c == null) {
                return;
            }
            if (com_google_android_gms_internal_zzid.f7723c.m4853f() || com_google_android_gms_internal_zzid.f7723c.m4854g()) {
                com_google_android_gms_internal_zzid.f7723c.mo4292e();
            }
            com_google_android_gms_internal_zzid.f7723c = null;
            com_google_android_gms_internal_zzid.f7725e = null;
            Binder.flushPendingCommands();
        }
    }
}
