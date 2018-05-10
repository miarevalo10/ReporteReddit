package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;

final class zzfw extends ContentObserver {
    private /* synthetic */ zzft f7603a;

    public zzfw(zzft com_google_android_gms_internal_zzft, Handler handler) {
        this.f7603a = com_google_android_gms_internal_zzft;
        super(handler);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        this.f7603a.m6236a();
    }
}
