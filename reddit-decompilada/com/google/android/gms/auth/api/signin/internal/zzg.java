package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

final class zzg extends zza {
    private /* synthetic */ zzf f19102a;

    zzg(zzf com_google_android_gms_auth_api_signin_internal_zzf) {
        this.f19102a = com_google_android_gms_auth_api_signin_internal_zzf;
    }

    public final void mo3399a(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            zzo.m4604a(this.f19102a.f19556a).m4607a(this.f19102a.f19557b, googleSignInAccount);
        }
        this.f19102a.m12826a(new GoogleSignInResult(googleSignInAccount, status));
    }
}
