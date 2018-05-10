package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzq;

final class zzcfe extends zzq {
    private final zzci<LocationCallback> f17730a;

    zzcfe(zzci<LocationCallback> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback) {
        this.f17730a = com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback;
    }

    public final void mo2297a(LocationAvailability locationAvailability) {
        this.f17730a.m4755a(new zzcfg(locationAvailability));
    }

    public final void mo2298a(LocationResult locationResult) {
        this.f17730a.m4755a(new zzcff(locationResult));
    }

    public final synchronized void m17943a() {
        this.f17730a.f5810a = null;
    }
}
