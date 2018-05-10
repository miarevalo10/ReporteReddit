package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.zzbq;

public final class zzcib {
    final String f6932a;
    final String f6933b;
    final long f6934c;
    /* synthetic */ zzchx f6935d;
    private String f6936e;

    private zzcib(zzchx com_google_android_gms_internal_zzchx, String str, long j) {
        this.f6935d = com_google_android_gms_internal_zzchx;
        zzbq.m4810a(str);
        zzbq.m4817b(j > 0);
        this.f6936e = String.valueOf(str).concat(":start");
        this.f6932a = String.valueOf(str).concat(":count");
        this.f6933b = String.valueOf(str).concat(":value");
        this.f6934c = j;
    }

    final void m5704a() {
        this.f6935d.mo1811c();
        long a = this.f6935d.mo1819k().mo1632a();
        Editor edit = this.f6935d.m18211D().edit();
        edit.remove(this.f6932a);
        edit.remove(this.f6933b);
        edit.putLong(this.f6936e, a);
        edit.apply();
    }

    final long m5705b() {
        return this.f6935d.m18211D().getLong(this.f6936e, 0);
    }
}
