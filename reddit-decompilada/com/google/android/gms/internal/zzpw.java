package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public final class zzpw extends zzeu implements zzpu {
    zzpw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public final IObjectWrapper mo2097a(String str) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        Parcel a = m5934a(2, o_);
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void mo2098a() throws RemoteException {
        m5935b(4, o_());
    }

    public final void mo2099a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(3, o_);
    }

    public final void mo2100a(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        o_.writeInt(i);
        m5935b(5, o_);
    }

    public final void mo2101a(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(1, o_);
    }
}
