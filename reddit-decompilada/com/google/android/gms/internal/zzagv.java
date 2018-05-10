package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzagv extends zzahf {
    private /* synthetic */ Context f19145a;
    private /* synthetic */ zzahg f19146b;

    zzagv(Context context, zzahg com_google_android_gms_internal_zzahg) {
        this.f19145a = context;
        this.f19146b = com_google_android_gms_internal_zzahg;
        super();
    }

    public final void mo3384a() {
        SharedPreferences sharedPreferences = this.f19145a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putLong("app_last_background_time_ms", sharedPreferences.getLong("app_last_background_time_ms", 0));
        if (this.f19146b != null) {
            this.f19146b.mo1715a(bundle);
        }
    }
}
