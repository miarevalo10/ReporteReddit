package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;

final class zzbd implements OnConnectionFailedListener {
    private /* synthetic */ zzda f13924a;

    zzbd(zzda com_google_android_gms_common_api_internal_zzda) {
        this.f13924a = com_google_android_gms_common_api_internal_zzda;
    }

    public final void mo1583a(ConnectionResult connectionResult) {
        this.f13924a.m12826a(new Status(8));
    }
}
