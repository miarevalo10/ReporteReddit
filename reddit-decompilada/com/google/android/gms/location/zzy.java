package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzcfk;

final class zzy extends zza<zzcfk, Object> {
    zzy() {
    }

    public final /* synthetic */ zze mo3407a(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzcfk(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices", com_google_android_gms_common_internal_zzr);
    }
}
