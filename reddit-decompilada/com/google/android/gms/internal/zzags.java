package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzags extends zzahf {
    private /* synthetic */ Context f19140a;
    private /* synthetic */ zzahg f19141b;

    zzags(Context context, zzahg com_google_android_gms_internal_zzahg) {
        this.f19140a = context;
        this.f19141b = com_google_android_gms_internal_zzahg;
        super();
    }

    public final void mo3384a() {
        SharedPreferences sharedPreferences = this.f19140a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putString("native_advanced_settings", sharedPreferences.getString("native_advanced_settings", "{}"));
        if (this.f19141b != null) {
            this.f19141b.mo1715a(bundle);
        }
    }
}
