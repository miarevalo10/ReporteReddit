package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzep extends zzet {
    public zzep(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 48);
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        this.b.f17621E = Integer.valueOf(2);
        boolean booleanValue = ((Boolean) this.c.invoke(null, new Object[]{this.a.m5845a()})).booleanValue();
        synchronized (this.b) {
            zzaz com_google_android_gms_internal_zzaz;
            Integer valueOf;
            if (booleanValue) {
                com_google_android_gms_internal_zzaz = this.b;
                valueOf = Integer.valueOf(1);
            } else {
                com_google_android_gms_internal_zzaz = this.b;
                valueOf = Integer.valueOf(0);
            }
            com_google_android_gms_internal_zzaz.f17621E = valueOf;
        }
    }
}
