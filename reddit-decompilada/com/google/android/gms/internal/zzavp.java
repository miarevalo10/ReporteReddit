package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;

public final class zzavp implements CredentialsApi {
    public final PendingResult<Status> delete(GoogleApiClient googleApiClient, Credential credential) {
        return googleApiClient.mo1597b(new zzavt(googleApiClient, credential));
    }

    public final PendingResult<Status> disableAutoSignIn(GoogleApiClient googleApiClient) {
        return googleApiClient.mo1597b(new zzavu(googleApiClient));
    }

    public final PendingResult<CredentialRequestResult> request(GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        return googleApiClient.mo1588a(new zzavq(googleApiClient, credentialRequest));
    }

    public final PendingResult<Status> save(GoogleApiClient googleApiClient, Credential credential) {
        return googleApiClient.mo1597b(new zzavs(googleApiClient, credential));
    }

    public final PendingIntent getHintPickerIntent(GoogleApiClient googleApiClient, HintRequest hintRequest) {
        zzbq.m4818b(googleApiClient.mo1594a(Auth.f5675d), "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
        return zzavx.m5492a(googleApiClient.mo1596b(), ((zzavy) googleApiClient.mo1587a(Auth.f5672a)).f19210a, hintRequest);
    }
}
