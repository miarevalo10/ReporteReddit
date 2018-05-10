package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzadi extends zzev implements zzadh {
    public zzadi() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                String a = mo1659a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                i = mo1660b();
                parcel2.writeNoException();
                parcel2.writeInt(i);
                return true;
            default:
                return false;
        }
    }
}
