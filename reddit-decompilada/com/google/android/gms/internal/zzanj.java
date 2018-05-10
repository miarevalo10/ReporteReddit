package com.google.android.gms.internal;

import android.view.View;

final class zzanj implements Runnable {
    private /* synthetic */ View f6638a;
    private /* synthetic */ zzafb f6639b;
    private /* synthetic */ int f6640c;
    private /* synthetic */ zzani f6641d;

    zzanj(zzani com_google_android_gms_internal_zzani, View view, zzafb com_google_android_gms_internal_zzafb, int i) {
        this.f6641d = com_google_android_gms_internal_zzani;
        this.f6638a = view;
        this.f6639b = com_google_android_gms_internal_zzafb;
        this.f6640c = i;
    }

    public final void run() {
        this.f6641d.m5437a(this.f6638a, this.f6639b, this.f6640c - 1);
    }
}
