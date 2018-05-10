package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzagl extends zzahf {
    private /* synthetic */ Context f19125a;
    private /* synthetic */ zzahg f19126b;

    zzagl(Context context, zzahg com_google_android_gms_internal_zzahg) {
        this.f19125a = context;
        this.f19126b = com_google_android_gms_internal_zzahg;
        super();
    }

    public final void mo3384a() {
        SharedPreferences sharedPreferences = this.f19125a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("auto_collect_location", sharedPreferences.getBoolean("auto_collect_location", false));
        if (this.f19126b != null) {
            this.f19126b.mo1715a(bundle);
        }
    }
}
