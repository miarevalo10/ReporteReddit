package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzei extends zzet {
    public zzei(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 3);
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.b) {
            zzcz com_google_android_gms_internal_zzcz = new zzcz((String) this.c.invoke(null, new Object[]{this.a.m5845a()}));
            synchronized (this.b) {
                this.b.f17643c = Long.valueOf(com_google_android_gms_internal_zzcz.f14275a);
                this.b.f17631O = Long.valueOf(com_google_android_gms_internal_zzcz.f14276b);
            }
        }
    }
}
