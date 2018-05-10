package com.google.android.gms.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzavo implements CredentialRequestResult {
    private final Status f17606a;
    private final Credential f17607b;

    public zzavo(Status status, Credential credential) {
        this.f17606a = status;
        this.f17607b = credential;
    }

    public static zzavo m17903a(Status status) {
        return new zzavo(status, null);
    }

    public final Credential mo3482a() {
        return this.f17607b;
    }

    public final Status k_() {
        return this.f17606a;
    }
}
