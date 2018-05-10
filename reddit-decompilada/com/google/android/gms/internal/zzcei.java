package com.google.android.gms.internal;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;

final class zzcei extends zzcem {
    private /* synthetic */ LocationRequest f19819a;
    private /* synthetic */ LocationCallback f19820b;
    private /* synthetic */ Looper f19821f;

    zzcei(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        this.f19819a = locationRequest;
        this.f19820b = locationCallback;
        this.f19821f = looper;
        super(googleApiClient);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzcfk com_google_android_gms_internal_zzcfk = (zzcfk) com_google_android_gms_common_api_Api_zzb;
        zzceu com_google_android_gms_internal_zzcen = new zzcen(this);
        zzcfo a = zzcfo.m17956a(this.f19819a);
        zzci a2 = zzcm.m4756a(this.f19820b, zzcgc.m5618a(this.f19821f), LocationCallback.class.getSimpleName());
        synchronized (com_google_android_gms_internal_zzcfk.f19568i) {
            com_google_android_gms_common_api_Api_zzb = com_google_android_gms_internal_zzcfk.f19568i;
            com_google_android_gms_common_api_Api_zzb.f6781a.mo1779a();
            ((zzcez) com_google_android_gms_common_api_Api_zzb.f6781a.mo1780b()).mo1802a(new zzcfq(1, a, null, null, com_google_android_gms_common_api_Api_zzb.m5614b(a2).asBinder(), com_google_android_gms_internal_zzcen.asBinder()));
        }
    }
}
