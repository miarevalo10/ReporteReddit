package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public final class zzawe extends zzeu implements zzawd {
    zzawe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    public final void mo1762a(zzawb com_google_android_gms_internal_zzawb) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzawb);
        m5935b(4, o_);
    }

    public final void mo1763a(zzawb com_google_android_gms_internal_zzawb, CredentialRequest credentialRequest) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzawb);
        zzew.m5939a(o_, (Parcelable) credentialRequest);
        m5935b(1, o_);
    }

    public final void mo1764a(zzawb com_google_android_gms_internal_zzawb, zzavz com_google_android_gms_internal_zzavz) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzawb);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzavz);
        m5935b(3, o_);
    }

    public final void mo1765a(zzawb com_google_android_gms_internal_zzawb, zzawf com_google_android_gms_internal_zzawf) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzawb);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzawf);
        m5935b(2, o_);
    }
}
