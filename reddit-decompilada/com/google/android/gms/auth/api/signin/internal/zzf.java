package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzf extends zzl<GoogleSignInResult> {
    final /* synthetic */ Context f19556a;
    final /* synthetic */ GoogleSignInOptions f19557b;

    zzf(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions) {
        this.f19556a = context;
        this.f19557b = googleSignInOptions;
        super(googleApiClient);
    }

    protected final /* synthetic */ Result mo3409a(Status status) {
        return new GoogleSignInResult(null, status);
    }

    protected final /* synthetic */ void mo4021a(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzu) ((zzd) com_google_android_gms_common_api_Api_zzb).m4863r()).mo1534a(new zzg(this), this.f19557b);
    }
}
