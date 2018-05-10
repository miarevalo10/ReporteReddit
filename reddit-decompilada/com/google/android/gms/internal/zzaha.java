package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzaha extends zzahf {
    private /* synthetic */ Context f19155a;
    private /* synthetic */ zzahg f19156b;

    zzaha(Context context, zzahg com_google_android_gms_internal_zzahg) {
        this.f19155a = context;
        this.f19156b = com_google_android_gms_internal_zzahg;
        super();
    }

    public final void mo3384a() {
        SharedPreferences sharedPreferences = this.f19155a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putInt("webview_cache_version", sharedPreferences.getInt("webview_cache_version", 0));
        if (this.f19156b != null) {
            this.f19156b.mo1715a(bundle);
        }
    }
}
