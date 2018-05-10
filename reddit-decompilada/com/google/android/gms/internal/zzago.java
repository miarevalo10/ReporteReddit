package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzago extends zzahf {
    private /* synthetic */ Context f19131a;
    private /* synthetic */ String f19132b;
    private /* synthetic */ long f19133c;

    zzago(Context context, String str, long j) {
        this.f19131a = context;
        this.f19132b = str;
        this.f19133c = j;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19131a.getSharedPreferences("admob", 0).edit();
        edit.putString("app_settings_json", this.f19132b);
        edit.putLong("app_settings_last_update_ms", this.f19133c);
        edit.apply();
    }
}
