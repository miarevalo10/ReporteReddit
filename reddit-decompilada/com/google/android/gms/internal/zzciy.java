package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzciy implements Callable<List<zzclp>> {
    private /* synthetic */ String f7018a;
    private /* synthetic */ String f7019b;
    private /* synthetic */ String f7020c;
    private /* synthetic */ zzcir f7021d;

    zzciy(zzcir com_google_android_gms_internal_zzcir, String str, String str2, String str3) {
        this.f7021d = com_google_android_gms_internal_zzcir;
        this.f7018a = str;
        this.f7019b = str2;
        this.f7020c = str3;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f7021d.f17869a.m5772x();
        return this.f7021d.f17869a.m5760k().m17999a(this.f7018a, this.f7019b, this.f7020c);
    }
}
