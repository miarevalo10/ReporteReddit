package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.lang.Thread.UncaughtExceptionHandler;

final class zzcij implements UncaughtExceptionHandler {
    private final String f6949a;
    private /* synthetic */ zzcih f6950b;

    public zzcij(zzcih com_google_android_gms_internal_zzcih, String str) {
        this.f6950b = com_google_android_gms_internal_zzcih;
        zzbq.m4808a((Object) str);
        this.f6949a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f6950b.mo1828t().f17816a.m5694a(this.f6949a, th);
    }
}
