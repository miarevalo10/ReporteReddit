package com.google.android.gms.internal;

import android.util.DisplayMetrics;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

public final class zzeq extends zzet {
    private final View f14421d;

    public zzeq(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i, View view) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 57);
        this.f14421d = view;
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        if (this.f14421d != null) {
            DisplayMetrics displayMetrics = this.a.m5845a().getResources().getDisplayMetrics();
            zzds com_google_android_gms_internal_zzds = new zzds((String) this.c.invoke(null, new Object[]{this.f14421d, displayMetrics}));
            zzbb com_google_android_gms_internal_zzbb = new zzbb();
            com_google_android_gms_internal_zzbb.f17689a = com_google_android_gms_internal_zzds.f14314a;
            com_google_android_gms_internal_zzbb.f17690b = com_google_android_gms_internal_zzds.f14315b;
            com_google_android_gms_internal_zzbb.f17691c = com_google_android_gms_internal_zzds.f14316c;
            this.b.f17629M = com_google_android_gms_internal_zzbb;
        }
    }
}
