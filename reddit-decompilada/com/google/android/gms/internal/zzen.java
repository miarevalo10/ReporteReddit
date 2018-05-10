package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzen extends zzet {
    private final zzdt f14418d;

    public zzen(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i, zzdt com_google_android_gms_internal_zzdt) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 53);
        this.f14418d = com_google_android_gms_internal_zzdt;
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        if (this.f14418d != null) {
            zzaz com_google_android_gms_internal_zzaz = this.b;
            Method method = this.c;
            Object[] objArr = new Object[1];
            zzdt com_google_android_gms_internal_zzdt = this.f14418d;
            if (com_google_android_gms_internal_zzdt.f7287b == -2 && com_google_android_gms_internal_zzdt.f7286a.get() == null) {
                com_google_android_gms_internal_zzdt.f7287b = -3;
            }
            objArr[0] = Long.valueOf(com_google_android_gms_internal_zzdt.f7287b);
            com_google_android_gms_internal_zzaz.f17625I = (Long) method.invoke(null, objArr);
        }
    }
}
