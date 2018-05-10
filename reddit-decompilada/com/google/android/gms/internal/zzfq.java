package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzfq extends zzeu implements zzfo {
    zzfq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final String mo1938a() throws RemoteException {
        Parcel a = m5934a(1, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final boolean mo1939b() throws RemoteException {
        Parcel o_ = o_();
        zzew.m5940a(o_, true);
        o_ = m5934a(2, o_);
        boolean a = zzew.m5941a(o_);
        o_.recycle();
        return a;
    }

    public final boolean mo1940c() throws RemoteException {
        Parcel a = m5934a(6, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }
}
