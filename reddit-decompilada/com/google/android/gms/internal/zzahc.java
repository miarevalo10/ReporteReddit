package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzahc extends zzahf {
    private /* synthetic */ Context f19159a;
    private /* synthetic */ zzahg f19160b;

    zzahc(Context context, zzahg com_google_android_gms_internal_zzahg) {
        this.f19159a = context;
        this.f19160b = com_google_android_gms_internal_zzahg;
        super();
    }

    public final void mo3384a() {
        SharedPreferences sharedPreferences = this.f19159a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("content_url_opted_out", sharedPreferences.getBoolean("content_url_opted_out", true));
        if (this.f19160b != null) {
            this.f19160b.mo1715a(bundle);
        }
    }
}
