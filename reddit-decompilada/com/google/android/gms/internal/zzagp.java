package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzagp extends zzahf {
    private /* synthetic */ Context f19134a;
    private /* synthetic */ zzahg f19135b;

    zzagp(Context context, zzahg com_google_android_gms_internal_zzahg) {
        this.f19134a = context;
        this.f19135b = com_google_android_gms_internal_zzahg;
        super();
    }

    public final void mo3384a() {
        SharedPreferences sharedPreferences = this.f19134a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putString("app_settings_json", sharedPreferences.getString("app_settings_json", ""));
        bundle.putLong("app_settings_last_update_ms", sharedPreferences.getLong("app_settings_last_update_ms", 0));
        if (this.f19135b != null) {
            this.f19135b.mo1715a(bundle);
        }
    }
}
