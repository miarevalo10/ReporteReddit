package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzagi extends zzahf {
    private /* synthetic */ Context f19119a;
    private /* synthetic */ boolean f19120b;

    zzagi(Context context, boolean z) {
        this.f19119a = context;
        this.f19120b = z;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19119a.getSharedPreferences("admob", 0).edit();
        edit.putBoolean("use_https", this.f19120b);
        edit.apply();
    }
}
