package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

final class zzaix implements zzakg<Throwable, T> {
    private /* synthetic */ zzajb f14110a;

    zzaix(zzajb com_google_android_gms_internal_zzajb) {
        this.f14110a = com_google_android_gms_internal_zzajb;
    }

    public final /* synthetic */ zzakv mo1516a(Object obj) throws Exception {
        Throwable th = (Throwable) obj;
        zzakb.m5367b("Error occurred while dispatching http response in getter.", th);
        zzbs.m4490i().m13246a(th, "HttpGetter.deliverResponse.1");
        return zzakl.m5377a(this.f14110a.mo1724a());
    }
}
