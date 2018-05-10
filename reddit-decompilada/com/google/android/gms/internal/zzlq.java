package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzlq extends zzeu implements zzlo {
    zzlq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void mo2050a() throws RemoteException {
        m5935b(1, o_());
    }

    public final void mo2051a(boolean z) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5940a(o_, z);
        m5935b(5, o_);
    }

    public final void mo2052b() throws RemoteException {
        m5935b(2, o_());
    }

    public final void mo2053c() throws RemoteException {
        m5935b(3, o_());
    }

    public final void mo2054d() throws RemoteException {
        m5935b(4, o_());
    }
}
