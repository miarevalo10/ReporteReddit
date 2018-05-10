package com.google.android.gms.internal;

import java.util.Map;

final class zzaob implements Runnable {
    private /* synthetic */ Map f6657a;
    private /* synthetic */ zzaoa f6658b;

    zzaob(zzaoa com_google_android_gms_internal_zzaoa, Map map) {
        this.f6658b = com_google_android_gms_internal_zzaoa;
        this.f6657a = map;
    }

    public final void run() {
        this.f6658b.f17580a.mo3462a("pubVideoCmd", this.f6657a);
    }
}
