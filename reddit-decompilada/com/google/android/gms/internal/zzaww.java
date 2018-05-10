package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.zzd;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;

abstract class zzaww extends zzm<ProxyResult, zzawi> {
    public zzaww(GoogleApiClient googleApiClient) {
        super(zzd.f5728a, googleApiClient);
    }

    protected final /* synthetic */ Result mo3409a(Status status) {
        return new zzaxa(status);
    }

    protected abstract void mo4291a(zzawl com_google_android_gms_internal_zzawl) throws RemoteException;

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzawi com_google_android_gms_internal_zzawi = (zzawi) com_google_android_gms_common_api_Api_zzb;
        Context context = com_google_android_gms_internal_zzawi.f5913e;
        mo4291a((zzawl) com_google_android_gms_internal_zzawi.m4863r());
    }
}
