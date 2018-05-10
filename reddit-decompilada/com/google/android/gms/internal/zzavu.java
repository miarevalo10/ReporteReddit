package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzavu extends zzavw<Status> {
    zzavu(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    protected final /* synthetic */ Result mo3409a(Status status) {
        return status;
    }

    protected final void mo4290a(zzawd com_google_android_gms_internal_zzawd) throws RemoteException {
        com_google_android_gms_internal_zzawd.mo1762a(new zzavv(this));
    }
}
