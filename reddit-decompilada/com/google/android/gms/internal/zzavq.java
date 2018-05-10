package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzavq extends zzavw<CredentialRequestResult> {
    private /* synthetic */ CredentialRequest f19564a;

    zzavq(GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        this.f19564a = credentialRequest;
        super(googleApiClient);
    }

    protected final /* synthetic */ Result mo3409a(Status status) {
        return zzavo.m17903a(status);
    }

    protected final void mo4290a(zzawd com_google_android_gms_internal_zzawd) throws RemoteException {
        com_google_android_gms_internal_zzawd.mo1763a(new zzavr(this), this.f19564a);
    }
}
