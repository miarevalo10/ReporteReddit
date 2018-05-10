package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

final class zzcej extends zzcem {
    private /* synthetic */ LocationRequest f19822a;
    private /* synthetic */ PendingIntent f19823b;

    zzcej(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        this.f19822a = locationRequest;
        this.f19823b = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzcfk com_google_android_gms_internal_zzcfk = (zzcfk) com_google_android_gms_common_api_Api_zzb;
        zzceu com_google_android_gms_internal_zzcen = new zzcen(this);
        LocationRequest locationRequest = this.f19822a;
        PendingIntent pendingIntent = this.f19823b;
        com_google_android_gms_common_api_Api_zzb = com_google_android_gms_internal_zzcfk.f19568i;
        com_google_android_gms_common_api_Api_zzb.f6781a.mo1779a();
        ((zzcez) com_google_android_gms_common_api_Api_zzb.f6781a.mo1780b()).mo1802a(new zzcfq(1, zzcfo.m17956a(locationRequest), null, pendingIntent, null, com_google_android_gms_internal_zzcen.asBinder()));
    }
}
