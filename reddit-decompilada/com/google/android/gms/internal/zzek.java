package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzek extends zzet {
    public zzek(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 61);
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.c.invoke(null, new Object[]{this.a.m5845a(), Boolean.valueOf(this.a.f7227l)})).longValue();
        synchronized (this.b) {
            this.b.f17632P = Long.valueOf(longValue);
        }
    }
}
