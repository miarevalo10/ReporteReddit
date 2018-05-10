package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzeh extends zzet {
    private static volatile String f14414d;
    private static final Object f14415e = new Object();

    public zzeh(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 1);
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        this.b.f17641a = "E";
        if (f14414d == null) {
            synchronized (f14415e) {
                if (f14414d == null) {
                    f14414d = (String) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.f17641a = f14414d;
        }
    }
}
