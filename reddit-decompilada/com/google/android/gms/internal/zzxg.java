package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzxg extends zzeu implements zzxe {
    zzxg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final void mo2277a(int i, int i2, Intent intent) throws RemoteException {
        Parcel o_ = o_();
        o_.writeInt(i);
        o_.writeInt(i2);
        zzew.m5939a(o_, (Parcelable) intent);
        m5935b(12, o_);
    }

    public final void mo2278a(Bundle bundle) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) bundle);
        m5935b(1, o_);
    }

    public final void mo2279a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(13, o_);
    }

    public final void mo2280b(Bundle bundle) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) bundle);
        o_ = m5934a(6, o_);
        if (o_.readInt() != 0) {
            bundle.readFromParcel(o_);
        }
        o_.recycle();
    }

    public final void mo2281d() throws RemoteException {
        m5935b(10, o_());
    }

    public final boolean mo2282e() throws RemoteException {
        Parcel a = m5934a(11, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final void mo2283f() throws RemoteException {
        m5935b(2, o_());
    }

    public final void mo2284g() throws RemoteException {
        m5935b(3, o_());
    }

    public final void mo2285h() throws RemoteException {
        m5935b(4, o_());
    }

    public final void mo2286i() throws RemoteException {
        m5935b(5, o_());
    }

    public final void mo2287j() throws RemoteException {
        m5935b(7, o_());
    }

    public final void mo2288k() throws RemoteException {
        m5935b(8, o_());
    }

    public final void mo2289l() throws RemoteException {
        m5935b(9, o_());
    }
}
