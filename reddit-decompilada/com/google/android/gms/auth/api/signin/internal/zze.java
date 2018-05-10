package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.common.api.internal.zzco;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgg;
import java.util.HashSet;

public final class zze {
    private static zzbgg f5716a = new zzbgg("GoogleSignInCommon", new String[0]);

    public static Intent m4598a(Context context, GoogleSignInOptions googleSignInOptions) {
        f5716a.m5566a("getSignInIntent()");
        Parcelable signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static GoogleSignInResult m4599a(Intent intent) {
        if (intent != null) {
            if (intent.hasExtra("googleSignInStatus") || intent.hasExtra("googleSignInAccount")) {
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
                Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
                if (googleSignInAccount != null) {
                    status = Status.f17263a;
                }
                return new GoogleSignInResult(googleSignInAccount, status);
            }
        }
        return null;
    }

    public static PendingResult<Status> m4601a(GoogleApiClient googleApiClient, Context context) {
        f5716a.m5566a("Signing out");
        m4602a(context);
        return googleApiClient.mo1597b(new zzh(googleApiClient));
    }

    private static void m4602a(Context context) {
        zzo.m4604a(context).m4606a();
        for (GoogleApiClient d : GoogleApiClient.m4644a()) {
            d.mo1600d();
        }
        zzbm.m4713b();
    }

    public static PendingResult<Status> m4603b(GoogleApiClient googleApiClient, Context context) {
        f5716a.m5566a("Revoking access");
        m4602a(context);
        return googleApiClient.mo1597b(new zzj(googleApiClient));
    }

    public static OptionalPendingResult<GoogleSignInResult> m4600a(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions) {
        Result googleSignInResult;
        f5716a.m5566a("silentSignIn()");
        f5716a.m5566a("getEligibleSavedSignInResult()");
        zzbq.m4808a((Object) googleSignInOptions);
        GoogleSignInOptions c = zzo.m4604a(context).m4609c();
        if (c != null) {
            Account account = c.f19091h;
            Account account2 = googleSignInOptions.f19091h;
            Object obj = null;
            boolean equals = account == null ? account2 == null : account.equals(account2);
            if (equals && !googleSignInOptions.f19093j && ((!googleSignInOptions.f19092i || (c.f19092i && googleSignInOptions.f19094k.equals(c.f19094k))) && new HashSet(c.m20182a()).containsAll(new HashSet(googleSignInOptions.m20182a())))) {
                GoogleSignInAccount b = zzo.m4604a(context).m4608b();
                if (b != null) {
                    if (GoogleSignInAccount.f17231a.mo1632a() / 1000 >= b.f17234d - 300) {
                        obj = 1;
                    }
                    if (obj == null) {
                        googleSignInResult = new GoogleSignInResult(b, Status.f17263a);
                        if (googleSignInResult == null) {
                            f5716a.m5566a("Eligible saved sign in result found");
                            return PendingResults.m4674a(googleSignInResult, googleApiClient);
                        }
                        f5716a.m5566a("trySilentSignIn()");
                        return new zzco(googleApiClient.mo1588a(new zzf(googleApiClient, context, googleSignInOptions)));
                    }
                }
            }
        }
        googleSignInResult = null;
        if (googleSignInResult == null) {
            f5716a.m5566a("trySilentSignIn()");
            return new zzco(googleApiClient.mo1588a(new zzf(googleApiClient, context, googleSignInOptions)));
        }
        f5716a.m5566a("Eligible saved sign in result found");
        return PendingResults.m4674a(googleSignInResult, googleApiClient);
    }
}
