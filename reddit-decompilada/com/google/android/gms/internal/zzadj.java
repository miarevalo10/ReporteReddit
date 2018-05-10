package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzadj extends zzeu implements zzadh {
    zzadj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    public final String mo1659a() throws RemoteException {
        Parcel a = m5934a(1, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final int mo1660b() throws RemoteException {
        Parcel a = m5934a(2, o_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
