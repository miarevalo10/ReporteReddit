package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzagy extends zzahf {
    private /* synthetic */ Context f19151a;
    private /* synthetic */ long f19152b;

    zzagy(Context context, long j) {
        this.f19151a = context;
        this.f19152b = j;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19151a.getSharedPreferences("admob", 0).edit();
        edit.putLong("first_ad_req_time_ms", this.f19152b);
        edit.apply();
    }
}
