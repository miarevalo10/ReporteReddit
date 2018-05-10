package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzcja implements Callable<List<zzcgl>> {
    private /* synthetic */ String f7026a;
    private /* synthetic */ String f7027b;
    private /* synthetic */ String f7028c;
    private /* synthetic */ zzcir f7029d;

    zzcja(zzcir com_google_android_gms_internal_zzcir, String str, String str2, String str3) {
        this.f7029d = com_google_android_gms_internal_zzcir;
        this.f7026a = str;
        this.f7027b = str2;
        this.f7028c = str3;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f7029d.f17869a.m5772x();
        return this.f7029d.f17869a.m5760k().m18009b(this.f7026a, this.f7027b, this.f7028c);
    }
}
