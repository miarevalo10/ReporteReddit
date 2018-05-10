package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.view.View;

final class zzpi implements zzoq {
    private /* synthetic */ View f14598a;
    private /* synthetic */ zzpg f14599b;

    zzpi(zzpg com_google_android_gms_internal_zzpg, View view) {
        this.f14599b = com_google_android_gms_internal_zzpg;
        this.f14598a = view;
    }

    public final void mo2068a() {
        this.f14599b.onClick(this.f14598a);
    }

    public final void mo2069a(MotionEvent motionEvent) {
        this.f14599b.onTouch(null, motionEvent);
    }
}
