package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzagr extends zzahf {
    private /* synthetic */ Context f19138a;
    private /* synthetic */ zzahg f19139b;

    zzagr(Context context, zzahg com_google_android_gms_internal_zzahg) {
        this.f19138a = context;
        this.f19139b = com_google_android_gms_internal_zzahg;
        super();
    }

    public final void mo3384a() {
        SharedPreferences sharedPreferences = this.f19138a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("use_https", sharedPreferences.getBoolean("use_https", true));
        if (this.f19139b != null) {
            this.f19139b.mo1715a(bundle);
        }
    }
}
