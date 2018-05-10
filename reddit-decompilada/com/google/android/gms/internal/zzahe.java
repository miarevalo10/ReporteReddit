package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzahe extends zzahf {
    private /* synthetic */ Context f19163a;
    private /* synthetic */ zzahg f19164b;

    zzahe(Context context, zzahg com_google_android_gms_internal_zzahg) {
        this.f19163a = context;
        this.f19164b = com_google_android_gms_internal_zzahg;
        super();
    }

    public final void mo3384a() {
        SharedPreferences sharedPreferences = this.f19163a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putString("content_url_hashes", sharedPreferences.getString("content_url_hashes", ""));
        if (this.f19164b != null) {
            this.f19164b.mo1715a(bundle);
        }
    }
}
