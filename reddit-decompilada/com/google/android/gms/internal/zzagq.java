package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzagq extends zzahf {
    private /* synthetic */ Context f19136a;
    private /* synthetic */ String f19137b;

    zzagq(Context context, String str) {
        this.f19136a = context;
        this.f19137b = str;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19136a.getSharedPreferences("admob", 0).edit();
        edit.putString("native_advanced_settings", this.f19137b);
        edit.apply();
    }
}
