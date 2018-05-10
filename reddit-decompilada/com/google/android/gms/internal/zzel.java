package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzel extends zzet {
    private final StackTraceElement[] f14417d;

    public zzel(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i, StackTraceElement[] stackTraceElementArr) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 45);
        this.f14417d = stackTraceElementArr;
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        if (this.f14417d != null) {
            zzdk com_google_android_gms_internal_zzdk = new zzdk((String) this.c.invoke(null, new Object[]{this.f14417d}));
            synchronized (this.b) {
                this.b.f17618B = com_google_android_gms_internal_zzdk.f14286a;
                if (com_google_android_gms_internal_zzdk.f14287b.booleanValue()) {
                    this.b.f17626J = Integer.valueOf(com_google_android_gms_internal_zzdk.f14288c.booleanValue() ^ 1);
                }
            }
        }
    }
}
