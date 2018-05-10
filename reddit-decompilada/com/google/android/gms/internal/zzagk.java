package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzagk extends zzahf {
    private /* synthetic */ Context f19123a;
    private /* synthetic */ boolean f19124b;

    zzagk(Context context, boolean z) {
        this.f19123a = context;
        this.f19124b = z;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19123a.getSharedPreferences("admob", 0).edit();
        edit.putBoolean("auto_collect_location", this.f19124b);
        edit.apply();
    }
}
