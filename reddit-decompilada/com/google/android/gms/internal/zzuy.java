package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzuy extends zzev implements zzux {
    public zzuy() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzux m14316a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof zzux ? (zzux) queryLocalInterface : new zzuz(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IInterface a = mo2168a(parcel.readString());
                parcel2.writeNoException();
                zzew.m5938a(parcel2, a);
                return true;
            case 2:
                boolean b = mo2169b(parcel.readString());
                parcel2.writeNoException();
                zzew.m5940a(parcel2, b);
                return true;
            default:
                return false;
        }
    }
}
