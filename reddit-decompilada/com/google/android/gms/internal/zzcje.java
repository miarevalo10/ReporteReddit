package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzcje implements Callable<byte[]> {
    private /* synthetic */ zzcha f7038a;
    private /* synthetic */ String f7039b;
    private /* synthetic */ zzcir f7040c;

    zzcje(zzcir com_google_android_gms_internal_zzcir, zzcha com_google_android_gms_internal_zzcha, String str) {
        this.f7040c = com_google_android_gms_internal_zzcir;
        this.f7038a = com_google_android_gms_internal_zzcha;
        this.f7039b = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f7040c.f17869a.m5772x();
        return this.f7040c.f17869a.m5750b(this.f7038a, this.f7039b);
    }
}
