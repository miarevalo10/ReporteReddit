package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

final class zzafm implements Runnable {
    private /* synthetic */ Context f6273a;
    private /* synthetic */ zzalf f6274b;

    zzafm(Context context, zzalf com_google_android_gms_internal_zzalf) {
        this.f6273a = context;
        this.f6274b = com_google_android_gms_internal_zzalf;
    }

    public final void run() {
        try {
            this.f6274b.m13330b(AdvertisingIdClient.getAdvertisingIdInfo(this.f6273a));
        } catch (Throwable e) {
            this.f6274b.m13329a(e);
            zzakb.m5367b("Exception while getting advertising Id info", e);
        }
    }
}
