package com.google.android.gms.internal;

import java.util.concurrent.Executor;

final /* synthetic */ class zzakr implements Runnable {
    private final zzalf f6497a;
    private final zzakv f6498b;
    private final Class f6499c;
    private final zzakg f6500d;
    private final Executor f6501e;

    zzakr(zzalf com_google_android_gms_internal_zzalf, zzakv com_google_android_gms_internal_zzakv, Class cls, zzakg com_google_android_gms_internal_zzakg, Executor executor) {
        this.f6497a = com_google_android_gms_internal_zzalf;
        this.f6498b = com_google_android_gms_internal_zzakv;
        this.f6499c = cls;
        this.f6500d = com_google_android_gms_internal_zzakg;
        this.f6501e = executor;
    }

    public final void run() {
        zzakl.m5388a(this.f6497a, this.f6498b, this.f6499c, this.f6500d, this.f6501e);
    }
}
