package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzagx extends zzahf {
    private /* synthetic */ Context f19149a;
    private /* synthetic */ zzahg f19150b;

    zzagx(Context context, zzahg com_google_android_gms_internal_zzahg) {
        this.f19149a = context;
        this.f19150b = com_google_android_gms_internal_zzahg;
        super();
    }

    public final void mo3384a() {
        SharedPreferences sharedPreferences = this.f19149a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putInt("request_in_session_count", sharedPreferences.getInt("request_in_session_count", -1));
        if (this.f19150b != null) {
            this.f19150b.mo1715a(bundle);
        }
    }
}
