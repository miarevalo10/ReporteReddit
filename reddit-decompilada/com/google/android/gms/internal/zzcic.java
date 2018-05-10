package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.zzbq;

public final class zzcic {
    final String f6937a;
    boolean f6938b;
    String f6939c;
    /* synthetic */ zzchx f6940d;
    private final String f6941e = null;

    public zzcic(zzchx com_google_android_gms_internal_zzchx, String str) {
        this.f6940d = com_google_android_gms_internal_zzchx;
        zzbq.m4810a(str);
        this.f6937a = str;
    }

    public final void m5706a(String str) {
        if (!zzclq.m18521b(str, this.f6939c)) {
            Editor edit = this.f6940d.m18211D().edit();
            edit.putString(this.f6937a, str);
            edit.apply();
            this.f6939c = str;
        }
    }
}
