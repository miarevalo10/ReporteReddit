package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;

abstract class zzavw<R extends Result> extends zzm<R, zzavy> {
    zzavw(GoogleApiClient googleApiClient) {
        super(Auth.f5675d, googleApiClient);
    }

    protected abstract void mo4290a(zzawd com_google_android_gms_internal_zzawd) throws DeadObjectException, RemoteException;

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzavy com_google_android_gms_internal_zzavy = (zzavy) com_google_android_gms_common_api_Api_zzb;
        Context context = com_google_android_gms_internal_zzavy.f5913e;
        mo4290a((zzawd) com_google_android_gms_internal_zzavy.m4863r());
    }
}
