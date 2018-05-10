package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzcel extends zzcem {
    private /* synthetic */ PendingIntent f19825a;

    zzcel(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        this.f19825a = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzcfk com_google_android_gms_internal_zzcfk = (zzcfk) com_google_android_gms_common_api_Api_zzb;
        zzceu com_google_android_gms_internal_zzcen = new zzcen(this);
        PendingIntent pendingIntent = this.f19825a;
        com_google_android_gms_common_api_Api_zzb = com_google_android_gms_internal_zzcfk.f19568i;
        com_google_android_gms_common_api_Api_zzb.f6781a.mo1779a();
        ((zzcez) com_google_android_gms_common_api_Api_zzb.f6781a.mo1780b()).mo1802a(new zzcfq(2, null, null, pendingIntent, null, com_google_android_gms_internal_zzcen.asBinder()));
    }
}
