package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.location.LocationStatusCodes;

final class zzcfm extends zzcey {
    private zzn<Status> f17733a;

    public zzcfm(zzn<Status> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status) {
        this.f17733a = com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status;
    }

    private final void m17951d(int i) {
        if (this.f17733a == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
            return;
        }
        this.f17733a.mo3421a(LocationStatusCodes.m6842b(LocationStatusCodes.m6841a(i)));
        this.f17733a = null;
    }

    public final void mo3486a(int i) {
        Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
    }

    public final void mo3487b(int i) {
        m17951d(i);
    }

    public final void mo3488c(int i) {
        m17951d(i);
    }
}
