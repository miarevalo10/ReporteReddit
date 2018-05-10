package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.location.LocationServices.zza;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

final class zzcfw extends zza<LocationSettingsResult> {
    private /* synthetic */ LocationSettingsRequest f19569a;
    private /* synthetic */ String f19570b = null;

    zzcfw(GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest) {
        this.f19569a = locationSettingsRequest;
        super(googleApiClient);
    }

    public final /* synthetic */ Result mo3409a(Status status) {
        return new LocationSettingsResult(status);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).m20971a(this.f19569a, (zzn) this, this.f19570b);
    }
}
