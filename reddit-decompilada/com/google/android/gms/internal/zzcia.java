package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.zzbq;

public final class zzcia {
    private final String f6927a;
    private final long f6928b;
    private boolean f6929c;
    private long f6930d;
    private /* synthetic */ zzchx f6931e;

    public zzcia(zzchx com_google_android_gms_internal_zzchx, String str, long j) {
        this.f6931e = com_google_android_gms_internal_zzchx;
        zzbq.m4810a(str);
        this.f6927a = str;
        this.f6928b = j;
    }

    public final long m5702a() {
        if (!this.f6929c) {
            this.f6929c = true;
            this.f6930d = this.f6931e.m18211D().getLong(this.f6927a, this.f6928b);
        }
        return this.f6930d;
    }

    public final void m5703a(long j) {
        Editor edit = this.f6931e.m18211D().edit();
        edit.putLong(this.f6927a, j);
        edit.apply();
        this.f6930d = j;
    }
}
