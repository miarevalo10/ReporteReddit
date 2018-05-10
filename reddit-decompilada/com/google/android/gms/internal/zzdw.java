package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

public final class zzdw extends zzet {
    private final Activity f14401d;
    private final View f14402e;

    public zzdw(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i, View view, Activity activity) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 62);
        this.f14402e = view;
        this.f14401d = activity;
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        if (this.f14402e != null) {
            long[] jArr = (long[]) this.c.invoke(null, new Object[]{this.f14402e, this.f14401d});
            synchronized (this.b) {
                this.b.f17633Q = Long.valueOf(jArr[0]);
                this.b.f17634R = Long.valueOf(jArr[1]);
            }
        }
    }
}
