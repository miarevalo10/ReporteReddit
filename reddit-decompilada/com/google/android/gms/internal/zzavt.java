package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzavt extends zzavw<Status> {
    private /* synthetic */ Credential f19566a;

    zzavt(GoogleApiClient googleApiClient, Credential credential) {
        this.f19566a = credential;
        super(googleApiClient);
    }

    protected final /* synthetic */ Result mo3409a(Status status) {
        return status;
    }

    protected final void mo4290a(zzawd com_google_android_gms_internal_zzawd) throws RemoteException {
        com_google_android_gms_internal_zzawd.mo1764a(new zzavv(this), new zzavz(this.f19566a));
    }
}
