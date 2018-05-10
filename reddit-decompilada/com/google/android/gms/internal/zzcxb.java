package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzr;

final class zzcxb extends zza<zzcxn, zzcxe> {
    zzcxb() {
    }

    public final /* synthetic */ zze mo3407a(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        if (((zzcxe) obj) == null) {
            zzcxe com_google_android_gms_internal_zzcxe = zzcxe.f19216a;
        }
        return new zzcxn(context, looper, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
    }
}
