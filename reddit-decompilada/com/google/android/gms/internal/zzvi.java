package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzvi extends zzeu implements zzvg {
    zzvi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
    }

    public final int mo2207a() throws RemoteException {
        Parcel a = m5934a(1, o_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
