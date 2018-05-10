package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.LocationSettingsResult;

final class zzcfn extends zzcfc {
    private zzn<LocationSettingsResult> f17734a;

    public zzcfn(zzn<LocationSettingsResult> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult) {
        zzbq.m4818b(com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult != null, "listener can't be null.");
        this.f17734a = com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult;
    }

    public final void mo3489a(LocationSettingsResult locationSettingsResult) throws RemoteException {
        this.f17734a.mo3421a(locationSettingsResult);
        this.f17734a = null;
    }
}
