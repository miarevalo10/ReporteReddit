package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzv extends zzeu implements zzu {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void mo1534a(zzs com_google_android_gms_auth_api_signin_internal_zzs, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_auth_api_signin_internal_zzs);
        zzew.m5939a(o_, (Parcelable) googleSignInOptions);
        m5935b(101, o_);
    }

    public final void mo1535b(zzs com_google_android_gms_auth_api_signin_internal_zzs, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_auth_api_signin_internal_zzs);
        zzew.m5939a(o_, (Parcelable) googleSignInOptions);
        m5935b(102, o_);
    }

    public final void mo1536c(zzs com_google_android_gms_auth_api_signin_internal_zzs, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_auth_api_signin_internal_zzs);
        zzew.m5939a(o_, (Parcelable) googleSignInOptions);
        m5935b(103, o_);
    }
}
