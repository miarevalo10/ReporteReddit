package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzcix implements Callable<List<zzclp>> {
    private /* synthetic */ zzcgi f7014a;
    private /* synthetic */ String f7015b;
    private /* synthetic */ String f7016c;
    private /* synthetic */ zzcir f7017d;

    zzcix(zzcir com_google_android_gms_internal_zzcir, zzcgi com_google_android_gms_internal_zzcgi, String str, String str2) {
        this.f7017d = com_google_android_gms_internal_zzcir;
        this.f7014a = com_google_android_gms_internal_zzcgi;
        this.f7015b = str;
        this.f7016c = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f7017d.f17869a.m5772x();
        return this.f7017d.f17869a.m5760k().m17999a(this.f7014a.f17759a, this.f7015b, this.f7016c);
    }
}
