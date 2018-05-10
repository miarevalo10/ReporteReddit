package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzciz implements Callable<List<zzcgl>> {
    private /* synthetic */ zzcgi f7022a;
    private /* synthetic */ String f7023b;
    private /* synthetic */ String f7024c;
    private /* synthetic */ zzcir f7025d;

    zzciz(zzcir com_google_android_gms_internal_zzcir, zzcgi com_google_android_gms_internal_zzcgi, String str, String str2) {
        this.f7025d = com_google_android_gms_internal_zzcir;
        this.f7022a = com_google_android_gms_internal_zzcgi;
        this.f7023b = str;
        this.f7024c = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f7025d.f17869a.m5772x();
        return this.f7025d.f17869a.m5760k().m18009b(this.f7022a.f17759a, this.f7023b, this.f7024c);
    }
}
