package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzef extends zzet {
    private static volatile Long f14411d;
    private static final Object f14412e = new Object();

    public zzef(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 22);
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        if (f14411d == null) {
            synchronized (f14412e) {
                if (f14411d == null) {
                    f14411d = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.f17652l = f14411d;
        }
    }
}
