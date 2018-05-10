package com.google.android.gms.internal;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzcef extends zzcem {
    private /* synthetic */ Location f19815a;

    zzcef(GoogleApiClient googleApiClient, Location location) {
        this.f19815a = location;
        super(googleApiClient);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzcfk com_google_android_gms_internal_zzcfk = (zzcfk) com_google_android_gms_common_api_Api_zzb;
        Location location = this.f19815a;
        com_google_android_gms_common_api_Api_zzb = com_google_android_gms_internal_zzcfk.f19568i;
        com_google_android_gms_common_api_Api_zzb.f6781a.mo1779a();
        ((zzcez) com_google_android_gms_common_api_Api_zzb.f6781a.mo1780b()).mo1799a(location);
        m12826a(Status.f17263a);
    }
}
