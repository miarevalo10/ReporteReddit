package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzagu extends zzahf {
    private /* synthetic */ Context f19143a;
    private /* synthetic */ long f19144b;

    zzagu(Context context, long j) {
        this.f19143a = context;
        this.f19144b = j;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19143a.getSharedPreferences("admob", 0).edit();
        edit.putLong("app_last_background_time_ms", this.f19144b);
        edit.apply();
    }
}
