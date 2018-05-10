package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zzc implements GoogleSignInApi {
    public final Intent getSignInIntent(GoogleApiClient googleApiClient) {
        return zze.m4598a(googleApiClient.mo1596b(), m12783a(googleApiClient));
    }

    public final GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        return zze.m4599a(intent);
    }

    public final PendingResult<Status> revokeAccess(GoogleApiClient googleApiClient) {
        return zze.m4603b(googleApiClient, googleApiClient.mo1596b());
    }

    public final PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return zze.m4601a(googleApiClient, googleApiClient.mo1596b());
    }

    public final OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient googleApiClient) {
        return zze.m4600a(googleApiClient, googleApiClient.mo1596b(), m12783a(googleApiClient));
    }

    private static GoogleSignInOptions m12783a(GoogleApiClient googleApiClient) {
        return ((zzd) googleApiClient.mo1587a(Auth.f5673b)).f19101a;
    }
}
