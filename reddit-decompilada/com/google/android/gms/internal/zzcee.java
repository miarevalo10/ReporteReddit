package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzcee extends zzcem {
    private /* synthetic */ boolean f19814a;

    zzcee(GoogleApiClient googleApiClient, boolean z) {
        this.f19814a = z;
        super(googleApiClient);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzcfk com_google_android_gms_internal_zzcfk = (zzcfk) com_google_android_gms_common_api_Api_zzb;
        com_google_android_gms_internal_zzcfk.f19568i.m5613a(this.f19814a);
        m12826a(Status.f17263a);
    }
}
