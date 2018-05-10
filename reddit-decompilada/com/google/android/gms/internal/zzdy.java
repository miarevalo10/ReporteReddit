package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzdy extends zzet {
    private static volatile String f14403d;
    private static final Object f14404e = new Object();

    public zzdy(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 29);
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        this.b.f17655o = "E";
        if (f14403d == null) {
            synchronized (f14404e) {
                if (f14403d == null) {
                    f14403d = (String) this.c.invoke(null, new Object[]{this.a.m5845a()});
                }
            }
        }
        synchronized (this.b) {
            this.b.f17655o = zzbu.m5579a(f14403d.getBytes(), true);
        }
    }
}
