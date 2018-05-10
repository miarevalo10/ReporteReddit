package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzadr extends zzeu implements zzadp {
    zzadr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public final void mo1674a() throws RemoteException {
        m5935b(1, o_());
    }

    public final void mo1675a(int i) throws RemoteException {
        Parcel o_ = o_();
        o_.writeInt(i);
        m5935b(7, o_);
    }

    public final void mo1676a(zzadh com_google_android_gms_internal_zzadh) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzadh);
        m5935b(5, o_);
    }

    public final void mo1677b() throws RemoteException {
        m5935b(2, o_());
    }

    public final void mo1678c() throws RemoteException {
        m5935b(3, o_());
    }

    public final void mo1679d() throws RemoteException {
        m5935b(4, o_());
    }

    public final void mo1680e() throws RemoteException {
        m5935b(6, o_());
    }
}
