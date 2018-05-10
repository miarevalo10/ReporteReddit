package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzagm extends zzahf {
    private /* synthetic */ Context f19127a;
    private /* synthetic */ int f19128b;

    zzagm(Context context, int i) {
        this.f19127a = context;
        this.f19128b = i;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19127a.getSharedPreferences("admob", 0).edit();
        edit.putInt("version_code", this.f19128b);
        edit.apply();
    }
}
