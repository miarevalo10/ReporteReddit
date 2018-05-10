package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzlf extends zzeu implements zzld {
    zzlf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }

    public final long mo2029a() throws RemoteException {
        Parcel a = m5934a(1, o_());
        long readLong = a.readLong();
        a.recycle();
        return readLong;
    }
}
