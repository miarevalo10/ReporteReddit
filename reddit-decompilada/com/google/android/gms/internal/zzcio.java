package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzcio implements Callable<String> {
    private /* synthetic */ String f7000a;
    private /* synthetic */ zzcim f7001b;

    zzcio(zzcim com_google_android_gms_internal_zzcim, String str) {
        this.f7001b = com_google_android_gms_internal_zzcim;
        this.f7000a = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzcgh b = this.f7001b.m5760k().m18008b(this.f7000a);
        if (b != null) {
            return b.m5623b();
        }
        this.f7001b.m5754e().f17818c.m5693a("App info was null when attempting to get app instance id");
        return null;
    }
}
