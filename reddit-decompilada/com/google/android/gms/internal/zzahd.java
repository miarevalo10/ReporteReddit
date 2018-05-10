package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzahd extends zzahf {
    private /* synthetic */ Context f19161a;
    private /* synthetic */ String f19162b;

    zzahd(Context context, String str) {
        this.f19161a = context;
        this.f19162b = str;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19161a.getSharedPreferences("admob", 0).edit();
        edit.putString("content_url_hashes", this.f19162b);
        edit.apply();
    }
}
