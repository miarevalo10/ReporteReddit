package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzec extends zzet {
    private long f14410d;

    public zzec(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, long j, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 25);
        this.f14410d = j;
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.c.invoke(null, new Object[0])).longValue();
        synchronized (this.b) {
            this.b.f17638V = Long.valueOf(longValue);
            if (this.f14410d != 0) {
                this.b.f17650j = Long.valueOf(longValue - this.f14410d);
                this.b.f17653m = Long.valueOf(this.f14410d);
            }
        }
    }
}
