package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.zzbq;

public final class zzchz {
    final String f6922a;
    final boolean f6923b = true;
    boolean f6924c;
    boolean f6925d;
    /* synthetic */ zzchx f6926e;

    public zzchz(zzchx com_google_android_gms_internal_zzchx, String str) {
        this.f6926e = com_google_android_gms_internal_zzchx;
        zzbq.m4810a(str);
        this.f6922a = str;
    }

    public final void m5701a(boolean z) {
        Editor edit = this.f6926e.m18211D().edit();
        edit.putBoolean(this.f6922a, z);
        edit.apply();
        this.f6925d = z;
    }
}
