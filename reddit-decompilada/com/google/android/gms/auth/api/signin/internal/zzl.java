package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;

abstract class zzl<R extends Result> extends zzm<R, zzd> {
    public zzl(GoogleApiClient googleApiClient) {
        super(Auth.f5676e, googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void mo3421a(Object obj) {
        super.m12826a((Result) obj);
    }
}
