package com.google.android.gms.internal;

import java.util.concurrent.TimeoutException;

final /* synthetic */ class zzakp implements Runnable {
    private final zzalf f6495a;

    zzakp(zzalf com_google_android_gms_internal_zzalf) {
        this.f6495a = com_google_android_gms_internal_zzalf;
    }

    public final void run() {
        this.f6495a.m13329a(new TimeoutException());
    }
}
