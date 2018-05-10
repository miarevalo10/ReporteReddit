package com.google.android.gms.internal;

import android.content.Context;

@zzzv
public final class zztq {
    private final Object f8033a = new Object();
    private zztx f8034b;

    public final zztx m6661a(Context context, zzakd com_google_android_gms_internal_zzakd) {
        zztx com_google_android_gms_internal_zztx;
        synchronized (this.f8033a) {
            if (this.f8034b == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                this.f8034b = new zztx(context, com_google_android_gms_internal_zzakd, (String) zzkb.m6350f().m6488a(zznh.f7891a));
            }
            com_google_android_gms_internal_zztx = this.f8034b;
        }
        return com_google_android_gms_internal_zztx;
    }
}
