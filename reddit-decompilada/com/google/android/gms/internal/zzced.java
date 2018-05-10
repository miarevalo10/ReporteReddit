package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.zzp;

final class zzced extends zzcem {
    private /* synthetic */ LocationCallback f19813a;

    zzced(GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        this.f19813a = locationCallback;
        super(googleApiClient);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzcfk com_google_android_gms_internal_zzcfk = (zzcfk) com_google_android_gms_common_api_Api_zzb;
        Object a = zzcm.m4757a(this.f19813a, LocationCallback.class.getSimpleName());
        zzceu com_google_android_gms_internal_zzcen = new zzcen(this);
        com_google_android_gms_common_api_Api_zzb = com_google_android_gms_internal_zzcfk.f19568i;
        com_google_android_gms_common_api_Api_zzb.f6781a.mo1779a();
        zzbq.m4809a(a, (Object) "Invalid null listener key");
        synchronized (com_google_android_gms_common_api_Api_zzb.f6786f) {
            zzp com_google_android_gms_location_zzp = (zzcfe) com_google_android_gms_common_api_Api_zzb.f6786f.remove(a);
            if (com_google_android_gms_location_zzp != null) {
                com_google_android_gms_location_zzp.m17943a();
                ((zzcez) com_google_android_gms_common_api_Api_zzb.f6781a.mo1780b()).mo1802a(zzcfq.m17957a(com_google_android_gms_location_zzp, com_google_android_gms_internal_zzcen));
            }
        }
    }
}
