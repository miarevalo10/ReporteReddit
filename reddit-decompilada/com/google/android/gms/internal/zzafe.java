package com.google.android.gms.internal;

import android.content.Context;

@zzzv
public final class zzafe implements zzgt {
    String f14061a;
    private final Context f14062b;
    private final Object f14063c;
    private boolean f14064d;

    public zzafe(Context context, String str) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f14062b = context;
        this.f14061a = str;
        this.f14064d = false;
        this.f14063c = new Object();
    }

    public final void mo1711a(zzgs com_google_android_gms_internal_zzgs) {
        m13229a(com_google_android_gms_internal_zzgs.f7621a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m13229a(boolean r5) {
        /*
        r4 = this;
        r0 = com.google.android.gms.ads.internal.zzbs.m4507z();
        r1 = r4.f14062b;
        r0 = r0.m5090a(r1);
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r4.f14063c;
        monitor-enter(r0);
        r1 = r4.f14064d;	 Catch:{ all -> 0x004f }
        if (r1 != r5) goto L_0x0016;
    L_0x0014:
        monitor-exit(r0);	 Catch:{ all -> 0x004f }
        return;
    L_0x0016:
        r4.f14064d = r5;	 Catch:{ all -> 0x004f }
        r5 = r4.f14061a;	 Catch:{ all -> 0x004f }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x004f }
        if (r5 == 0) goto L_0x0022;
    L_0x0020:
        monitor-exit(r0);	 Catch:{ all -> 0x004f }
        return;
    L_0x0022:
        r5 = r4.f14064d;	 Catch:{ all -> 0x004f }
        if (r5 == 0) goto L_0x003a;
    L_0x0026:
        r5 = com.google.android.gms.ads.internal.zzbs.m4507z();	 Catch:{ all -> 0x004f }
        r1 = r4.f14062b;	 Catch:{ all -> 0x004f }
        r2 = r4.f14061a;	 Catch:{ all -> 0x004f }
        r3 = r5.m5090a(r1);	 Catch:{ all -> 0x004f }
        if (r3 == 0) goto L_0x004d;
    L_0x0034:
        r3 = "beginAdUnitExposure";
        r5.m5093b(r1, r2, r3);	 Catch:{ all -> 0x004f }
        goto L_0x004d;
    L_0x003a:
        r5 = com.google.android.gms.ads.internal.zzbs.m4507z();	 Catch:{ all -> 0x004f }
        r1 = r4.f14062b;	 Catch:{ all -> 0x004f }
        r2 = r4.f14061a;	 Catch:{ all -> 0x004f }
        r3 = r5.m5090a(r1);	 Catch:{ all -> 0x004f }
        if (r3 == 0) goto L_0x004d;
    L_0x0048:
        r3 = "endAdUnitExposure";
        r5.m5093b(r1, r2, r3);	 Catch:{ all -> 0x004f }
    L_0x004d:
        monitor-exit(r0);	 Catch:{ all -> 0x004f }
        return;
    L_0x004f:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x004f }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzafe.a(boolean):void");
    }
}
