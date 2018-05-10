package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzagj extends zzahf {
    private /* synthetic */ Context f19121a;
    private /* synthetic */ String f19122b;

    zzagj(Context context, String str) {
        this.f19121a = context;
        this.f19122b = str;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19121a.getSharedPreferences("admob", 0).edit();
        edit.putString("content_vertical_hashes", this.f19122b);
        edit.apply();
    }
}
