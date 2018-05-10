package com.google.android.gms.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

final class zzavr extends zzavn {
    private /* synthetic */ zzavq f19208a;

    zzavr(zzavq com_google_android_gms_internal_zzavq) {
        this.f19208a = com_google_android_gms_internal_zzavq;
    }

    public final void mo3480a(Status status) {
        this.f19208a.m12826a(zzavo.m17903a(status));
    }

    public final void mo3481a(Status status, Credential credential) {
        this.f19208a.m12826a(new zzavo(status, credential));
    }
}
