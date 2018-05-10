package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zznz extends zzeu implements zznx {
    zznz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    public final String mo2060a() throws RemoteException {
        Parcel a = m5934a(1, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo2061a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(3, o_);
    }

    public final String mo2062b() throws RemoteException {
        Parcel a = m5934a(2, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo2063c() throws RemoteException {
        m5935b(4, o_());
    }

    public final void mo2064d() throws RemoteException {
        m5935b(5, o_());
    }
}
