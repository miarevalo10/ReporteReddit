package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class zzej extends zzet {
    private List<Long> f14416d = null;

    public zzej(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 31);
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        this.b.f17656p = Long.valueOf(-1);
        this.b.f17657q = Long.valueOf(-1);
        if (this.f14416d == null) {
            this.f14416d = (List) this.c.invoke(null, new Object[]{this.a.m5845a()});
        }
        if (this.f14416d != null && this.f14416d.size() == 2) {
            synchronized (this.b) {
                this.b.f17656p = Long.valueOf(((Long) this.f14416d.get(0)).longValue());
                this.b.f17657q = Long.valueOf(((Long) this.f14416d.get(1)).longValue());
            }
        }
    }
}
