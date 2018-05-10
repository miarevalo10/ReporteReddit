package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzxi extends zzeu implements zzxh {
    zzxi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
    }

    public final IBinder mo2290a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        Parcel a = m5934a(1, o_);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
