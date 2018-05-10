package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.location.GeofencingRequest;

final class zzcer extends zzcet {
    private /* synthetic */ GeofencingRequest f19826a;
    private /* synthetic */ PendingIntent f19827b;

    zzcer(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        this.f19826a = geofencingRequest;
        this.f19827b = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).m20969a(this.f19826a, this.f19827b, (zzn) this);
    }
}
