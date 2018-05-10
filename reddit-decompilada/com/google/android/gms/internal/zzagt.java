package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzagt extends zzahf {
    private /* synthetic */ Context f19142a;

    zzagt(Context context) {
        this.f19142a = context;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19142a.getSharedPreferences("admob", 0).edit();
        edit.remove("native_advanced_settings");
        edit.apply();
    }
}
