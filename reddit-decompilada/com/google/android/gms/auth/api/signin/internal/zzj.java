package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzj extends zzl<Status> {
    zzj(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    protected final /* synthetic */ Result mo3409a(Status status) {
        return status;
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzd com_google_android_gms_auth_api_signin_internal_zzd = (zzd) com_google_android_gms_common_api_Api_zzb;
        ((zzu) com_google_android_gms_auth_api_signin_internal_zzd.m4863r()).mo1536c(new zzk(this), com_google_android_gms_auth_api_signin_internal_zzd.f19101a);
    }
}
