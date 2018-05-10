package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzt;

final class zzcfi extends zzt {
    private final zzci<LocationListener> f17731a;

    zzcfi(zzci<LocationListener> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener) {
        this.f17731a = com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener;
    }

    public final synchronized void mo2299a(Location location) {
        this.f17731a.m4755a(new zzcfj(location));
    }

    public final synchronized void m17946a() {
        this.f17731a.f5810a = null;
    }
}
