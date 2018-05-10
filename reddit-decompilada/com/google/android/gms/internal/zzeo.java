package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;

public final class zzeo extends zzet {
    private static volatile Long f14419d;
    private static final Object f14420e = new Object();

    public zzeo(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 33);
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        if (f14419d == null) {
            synchronized (f14420e) {
                if (f14419d == null) {
                    f14419d = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.f17658r = f14419d;
        }
    }
}
