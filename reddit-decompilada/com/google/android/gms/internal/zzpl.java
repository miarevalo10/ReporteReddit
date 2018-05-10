package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.view.View;

final class zzpl implements zzoq {
    private /* synthetic */ View f14600a;
    private /* synthetic */ zzpj f14601b;

    zzpl(zzpj com_google_android_gms_internal_zzpj, View view) {
        this.f14601b = com_google_android_gms_internal_zzpj;
        this.f14600a = view;
    }

    public final void mo2068a() {
        if (zzpj.m18948a(this.f14601b, zzpj.f18257a)) {
            this.f14601b.onClick(this.f14600a);
        }
    }

    public final void mo2069a(MotionEvent motionEvent) {
        this.f14601b.onTouch(null, motionEvent);
    }
}
