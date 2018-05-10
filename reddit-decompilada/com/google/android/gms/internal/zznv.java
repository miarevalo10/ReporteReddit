package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzae;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;

@zzzv
public final class zznv extends zzny {
    private final zzae f18174a;
    private final String f18175b;
    private final String f18176c;

    public zznv(zzae com_google_android_gms_ads_internal_zzae, String str, String str2) {
        this.f18174a = com_google_android_gms_ads_internal_zzae;
        this.f18175b = str;
        this.f18176c = str2;
    }

    public final String mo2060a() {
        return this.f18175b;
    }

    public final void mo2061a(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.f18174a.a_((View) zzn.m17693a(iObjectWrapper));
        }
    }

    public final String mo2062b() {
        return this.f18176c;
    }

    public final void mo2063c() {
        this.f18174a.e_();
    }

    public final void mo2064d() {
        this.f18174a.f_();
    }
}
