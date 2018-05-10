package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

final class zzcec extends zzcem {
    private /* synthetic */ LocationRequest f19811a;
    private /* synthetic */ LocationListener f19812b;

    zzcec(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        this.f19811a = locationRequest;
        this.f19812b = locationListener;
        super(googleApiClient);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).m20970a(this.f19811a, zzcm.m4756a(this.f19812b, zzcgc.m5617a(), LocationListener.class.getSimpleName()), new zzcen(this));
    }
}
