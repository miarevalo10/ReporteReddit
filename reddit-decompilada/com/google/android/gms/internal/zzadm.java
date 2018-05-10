package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzadm extends zzeu implements zzadk {
    zzadm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public final void mo1661a() throws RemoteException {
        m5935b(2, o_());
    }

    public final void mo1662a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(9, o_);
    }

    public final void mo1663a(zzadp com_google_android_gms_internal_zzadp) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzadp);
        m5935b(3, o_);
    }

    public final void mo1664a(zzadv com_google_android_gms_internal_zzadv) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzadv);
        m5935b(1, o_);
    }

    public final void mo1665a(String str) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        m5935b(13, o_);
    }

    public final void mo1666a(boolean z) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5940a(o_, z);
        m5935b(34, o_);
    }

    public final void mo1667b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(10, o_);
    }

    public final boolean mo1668b() throws RemoteException {
        Parcel a = m5934a(5, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final void mo1669c() throws RemoteException {
        m5935b(6, o_());
    }

    public final void mo1670c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(11, o_);
    }

    public final void mo1671d() throws RemoteException {
        m5935b(7, o_());
    }

    public final void mo1672e() throws RemoteException {
        m5935b(8, o_());
    }

    public final String mo1673f() throws RemoteException {
        Parcel a = m5934a(12, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
