package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzfn extends zzeu implements zzfl {
    zzfn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    public final void mo1931a() throws RemoteException {
        m5935b(3, o_());
    }

    public final void mo1932a(int i) throws RemoteException {
        Parcel o_ = o_();
        o_.writeInt(i);
        m5935b(6, o_);
    }

    public final void mo1933a(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        o_.writeString(str);
        m5935b(2, o_);
    }

    public final void mo1934a(byte[] bArr) throws RemoteException {
        Parcel o_ = o_();
        o_.writeByteArray(bArr);
        m5935b(5, o_);
    }

    public final void mo1935b() throws RemoteException {
        Parcel o_ = o_();
        o_.writeIntArray(null);
        m5935b(4, o_);
    }

    public final void mo1936b(int i) throws RemoteException {
        Parcel o_ = o_();
        o_.writeInt(i);
        m5935b(7, o_);
    }

    public final void mo1937b(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        o_.writeString(str);
        o_.writeString(null);
        m5935b(8, o_);
    }
}
