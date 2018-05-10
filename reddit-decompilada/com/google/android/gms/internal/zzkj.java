package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzkj extends zzeu implements zzkh {
    zzkj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void mo1962a() throws RemoteException {
        m5935b(1, o_());
    }

    public final void mo1963a(int i) throws RemoteException {
        Parcel o_ = o_();
        o_.writeInt(i);
        m5935b(2, o_);
    }

    public final void mo1964b() throws RemoteException {
        m5935b(3, o_());
    }

    public final void mo1965c() throws RemoteException {
        m5935b(4, o_());
    }

    public final void mo1966d() throws RemoteException {
        m5935b(5, o_());
    }

    public final void mo1967e() throws RemoteException {
        m5935b(6, o_());
    }

    public final void mo1968f() throws RemoteException {
        m5935b(7, o_());
    }
}
