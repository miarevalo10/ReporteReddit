package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzagn extends zzahf {
    private /* synthetic */ Context f19129a;
    private /* synthetic */ zzahg f19130b;

    zzagn(Context context, zzahg com_google_android_gms_internal_zzahg) {
        this.f19129a = context;
        this.f19130b = com_google_android_gms_internal_zzahg;
        super();
    }

    public final void mo3384a() {
        SharedPreferences sharedPreferences = this.f19129a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putInt("version_code", sharedPreferences.getInt("version_code", 0));
        if (this.f19130b != null) {
            this.f19130b.mo1715a(bundle);
        }
    }
}
