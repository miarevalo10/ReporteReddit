package com.google.android.gms.internal;

import android.content.Intent;

public final /* synthetic */ class zzclb implements Runnable {
    private final zzcla f7160a;
    private final int f7161b;
    private final zzchm f7162c;
    private final Intent f7163d;

    public zzclb(zzcla com_google_android_gms_internal_zzcla, int i, zzchm com_google_android_gms_internal_zzchm, Intent intent) {
        this.f7160a = com_google_android_gms_internal_zzcla;
        this.f7161b = i;
        this.f7162c = com_google_android_gms_internal_zzchm;
        this.f7163d = intent;
    }

    public final void run() {
        zzcla com_google_android_gms_internal_zzcla = this.f7160a;
        int i = this.f7161b;
        zzchm com_google_android_gms_internal_zzchm = this.f7162c;
        Intent intent = this.f7163d;
        if (((zzcle) com_google_android_gms_internal_zzcla.f7159a).mo2304a(i)) {
            com_google_android_gms_internal_zzchm.f17822g.m5694a("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            com_google_android_gms_internal_zzcla.m5801c().f17822g.m5693a("Completed wakeful intent.");
            ((zzcle) com_google_android_gms_internal_zzcla.f7159a).mo2303a(intent);
        }
    }
}
