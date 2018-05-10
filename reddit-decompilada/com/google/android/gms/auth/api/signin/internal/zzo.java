package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbq;

public final class zzo {
    private static zzo f5717a;
    private zzz f5718b;
    private GoogleSignInAccount f5719c = this.f5718b.m4624a();
    private GoogleSignInOptions f5720d = this.f5718b.m4628b();

    private zzo(Context context) {
        this.f5718b = zzz.m4620a(context);
    }

    public static synchronized zzo m4604a(Context context) {
        zzo b;
        synchronized (zzo.class) {
            b = m4605b(context.getApplicationContext());
        }
        return b;
    }

    private static synchronized zzo m4605b(Context context) {
        zzo com_google_android_gms_auth_api_signin_internal_zzo;
        synchronized (zzo.class) {
            if (f5717a == null) {
                f5717a = new zzo(context);
            }
            com_google_android_gms_auth_api_signin_internal_zzo = f5717a;
        }
        return com_google_android_gms_auth_api_signin_internal_zzo;
    }

    public final synchronized GoogleSignInAccount m4608b() {
        return this.f5719c;
    }

    public final synchronized GoogleSignInOptions m4609c() {
        return this.f5720d;
    }

    public final synchronized void m4606a() {
        zzz com_google_android_gms_auth_api_signin_internal_zzz = this.f5718b;
        com_google_android_gms_auth_api_signin_internal_zzz.f5725a.lock();
        try {
            com_google_android_gms_auth_api_signin_internal_zzz.f5726b.edit().clear().apply();
            this.f5719c = null;
            this.f5720d = null;
        } finally {
            com_google_android_gms_auth_api_signin_internal_zzz.f5725a.unlock();
        }
    }

    public final synchronized void m4607a(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        zzz com_google_android_gms_auth_api_signin_internal_zzz = this.f5718b;
        zzbq.m4808a((Object) googleSignInAccount);
        zzbq.m4808a((Object) googleSignInOptions);
        com_google_android_gms_auth_api_signin_internal_zzz.m4627a("defaultGoogleSignInAccount", googleSignInAccount.f17235e);
        com_google_android_gms_auth_api_signin_internal_zzz.m4626a(googleSignInAccount, googleSignInOptions);
        this.f5719c = googleSignInAccount;
        this.f5720d = googleSignInOptions;
    }
}
