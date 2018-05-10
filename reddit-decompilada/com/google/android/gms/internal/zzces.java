package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.zzag;

final class zzces extends zzcet {
    private /* synthetic */ zzag f19828a;

    zzces(GoogleApiClient googleApiClient, zzag com_google_android_gms_location_zzag) {
        this.f19828a = com_google_android_gms_location_zzag;
        super(googleApiClient);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).m20972a(this.f19828a, this);
    }
}
