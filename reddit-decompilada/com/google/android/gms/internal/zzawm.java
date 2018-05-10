package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

public final class zzawm extends zzeu implements zzawl {
    zzawm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.internal.IAuthService");
    }

    public final void mo1766a(zzawj com_google_android_gms_internal_zzawj, ProxyRequest proxyRequest) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzawj);
        zzew.m5939a(o_, (Parcelable) proxyRequest);
        m5935b(1, o_);
    }
}
