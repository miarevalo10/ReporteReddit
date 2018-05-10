package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzau extends zzev implements zzat {
    public zzau() {
        attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }

    public static zzat m13098a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof zzat ? (zzat) queryLocalInterface : new zzav(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IInterface a = mo1626a();
                parcel2.writeNoException();
                zzew.m5938a(parcel2, a);
                return true;
            case 2:
                i = mo1627b();
                parcel2.writeNoException();
                parcel2.writeInt(i);
                return true;
            default:
                return false;
        }
    }
}
