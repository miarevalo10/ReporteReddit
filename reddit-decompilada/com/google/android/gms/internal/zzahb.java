package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;

final class zzahb extends zzahf {
    private /* synthetic */ Context f19157a;
    private /* synthetic */ boolean f19158b;

    zzahb(Context context, boolean z) {
        this.f19157a = context;
        this.f19158b = z;
        super();
    }

    public final void mo3384a() {
        Editor edit = this.f19157a.getSharedPreferences("admob", 0).edit();
        edit.putBoolean("content_url_opted_out", this.f19158b);
        edit.apply();
    }
}
