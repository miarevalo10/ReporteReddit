package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzeu;

public final class zzav extends zzeu implements zzat {
    zzav(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final IObjectWrapper mo1626a() throws RemoteException {
        Parcel a = m5934a(1, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final int mo1627b() throws RemoteException {
        Parcel a = m5934a(2, o_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
