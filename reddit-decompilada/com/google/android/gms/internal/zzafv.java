package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

public final class zzafv {
    public volatile int f6345a;
    private final Object f6346b;
    private volatile long f6347c;

    private zzafv() {
        this.f6346b = new Object();
        this.f6345a = zzafw.f6348a;
        this.f6347c = 0;
    }

    public final void m5114a() {
        long a = zzbs.m4492k().mo1632a();
        synchronized (this.f6346b) {
            if (this.f6345a == zzafw.f6350c) {
                if (this.f6347c + ((Long) zzkb.m6350f().m6488a(zznh.cM)).longValue() <= a) {
                    this.f6345a = zzafw.f6348a;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m5115a(int r5, int r6) {
        /*
        r4 = this;
        r4.m5114a();
        r0 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r0 = r0.mo1632a();
        r2 = r4.f6346b;
        monitor-enter(r2);
        r3 = r4.f6345a;	 Catch:{ all -> 0x0020 }
        if (r3 == r5) goto L_0x0014;
    L_0x0012:
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        return;
    L_0x0014:
        r4.f6345a = r6;	 Catch:{ all -> 0x0020 }
        r5 = r4.f6345a;	 Catch:{ all -> 0x0020 }
        r6 = com.google.android.gms.internal.zzafw.f6350c;	 Catch:{ all -> 0x0020 }
        if (r5 != r6) goto L_0x001e;
    L_0x001c:
        r4.f6347c = r0;	 Catch:{ all -> 0x0020 }
    L_0x001e:
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        return;
    L_0x0020:
        r5 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzafv.a(int, int):void");
    }
}
