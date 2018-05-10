package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzagz extends zzahf {
    private /* synthetic */ Context f19153a;
    private /* synthetic */ zzahg f19154b;

    zzagz(Context context, zzahg com_google_android_gms_internal_zzahg) {
        this.f19153a = context;
        this.f19154b = com_google_android_gms_internal_zzahg;
        super();
    }

    public final void mo3384a() {
        SharedPreferences sharedPreferences = this.f19153a.getSharedPreferences("admob", 0);
        Bundle bundle = new Bundle();
        bundle.putLong("first_ad_req_time_ms", sharedPreferences.getLong("first_ad_req_time_ms", 0));
        if (this.f19154b != null) {
            this.f19154b.mo1715a(bundle);
        }
    }
}
