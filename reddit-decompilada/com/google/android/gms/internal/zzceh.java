package com.google.android.gms.internal;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

final class zzceh extends zzcem {
    private /* synthetic */ LocationRequest f19816a;
    private /* synthetic */ LocationListener f19817b;
    private /* synthetic */ Looper f19818f;

    zzceh(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        this.f19816a = locationRequest;
        this.f19817b = locationListener;
        this.f19818f = looper;
        super(googleApiClient);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).m20970a(this.f19816a, zzcm.m4756a(this.f19817b, zzcgc.m5618a(this.f19818f), LocationListener.class.getSimpleName()), new zzcen(this));
    }
}
