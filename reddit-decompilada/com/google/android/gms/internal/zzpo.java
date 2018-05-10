package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public final class zzpo extends zzeu implements zzpm {
    zzpo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public final String mo2089a() throws RemoteException {
        Parcel a = m5934a(2, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final List<zzpq> mo2090b() throws RemoteException {
        Parcel a = m5934a(3, o_());
        List b = zzew.m5942b(a);
        a.recycle();
        return b;
    }
}
