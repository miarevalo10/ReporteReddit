package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzea extends zzet {
    public zzea(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 5);
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        this.b.f17644d = Long.valueOf(-1);
        this.b.f17645e = Long.valueOf(-1);
        int[] iArr = (int[]) this.c.invoke(null, new Object[]{this.a.m5845a()});
        synchronized (this.b) {
            this.b.f17644d = Long.valueOf((long) iArr[0]);
            this.b.f17645e = Long.valueOf((long) iArr[1]);
            if (((Boolean) zzkb.m6350f().m6488a(zznh.bq)).booleanValue() && iArr[2] != Integer.MIN_VALUE) {
                this.b.f17630N = Long.valueOf((long) iArr[2]);
            }
        }
    }
}
