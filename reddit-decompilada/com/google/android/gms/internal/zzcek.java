package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzs;

final class zzcek extends zzcem {
    private /* synthetic */ LocationListener f19824a;

    zzcek(GoogleApiClient googleApiClient, LocationListener locationListener) {
        this.f19824a = locationListener;
        super(googleApiClient);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzcfk com_google_android_gms_internal_zzcfk = (zzcfk) com_google_android_gms_common_api_Api_zzb;
        Object a = zzcm.m4757a(this.f19824a, LocationListener.class.getSimpleName());
        zzceu com_google_android_gms_internal_zzcen = new zzcen(this);
        com_google_android_gms_common_api_Api_zzb = com_google_android_gms_internal_zzcfk.f19568i;
        com_google_android_gms_common_api_Api_zzb.f6781a.mo1779a();
        zzbq.m4809a(a, (Object) "Invalid null listener key");
        synchronized (com_google_android_gms_common_api_Api_zzb.f6784d) {
            zzs com_google_android_gms_location_zzs = (zzcfi) com_google_android_gms_common_api_Api_zzb.f6784d.remove(a);
            if (com_google_android_gms_location_zzs != null) {
                com_google_android_gms_location_zzs.m17946a();
                ((zzcez) com_google_android_gms_common_api_Api_zzb.f6781a.mo1780b()).mo1802a(zzcfq.m17958a(com_google_android_gms_location_zzs, com_google_android_gms_internal_zzcen));
            }
        }
    }
}
