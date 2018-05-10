package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzeb extends zzet {
    private static volatile Long f14408d;
    private static final Object f14409e = new Object();

    public zzeb(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 44);
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        if (f14408d == null) {
            synchronized (f14409e) {
                if (f14408d == null) {
                    f14408d = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.f17617A = f14408d;
        }
    }
}
