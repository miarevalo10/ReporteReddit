package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzagw extends zzahf {
    private /* synthetic */ Context f19147a;
    private /* synthetic */ int f19148b;

    zzagw(Context context, int i) {
        this.f19147a = context;
        this.f19148b = i;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19147a.getSharedPreferences("admob", 0).edit();
        edit.putInt("request_in_session_count", this.f19148b);
        edit.apply();
    }
}
