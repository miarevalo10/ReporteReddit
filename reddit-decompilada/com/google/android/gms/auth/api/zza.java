package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzavy;

final class zza extends com.google.android.gms.common.api.Api.zza<zzavy, AuthCredentialsOptions> {
    zza() {
    }

    public final /* synthetic */ zze mo3407a(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzavy(context, looper, com_google_android_gms_common_internal_zzr, (AuthCredentialsOptions) obj, connectionCallbacks, onConnectionFailedListener);
    }
}
