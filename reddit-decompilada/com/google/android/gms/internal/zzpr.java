package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public abstract class zzpr extends zzev implements zzpq {
    public zzpr() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzpq m14158a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return queryLocalInterface instanceof zzpq ? (zzpq) queryLocalInterface : new zzps(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IInterface a = mo2091a();
                parcel2.writeNoException();
                zzew.m5938a(parcel2, a);
                return true;
            case 2:
                Parcelable b = mo2092b();
                parcel2.writeNoException();
                zzew.m5943b(parcel2, b);
                return true;
            case 3:
                double c = mo2093c();
                parcel2.writeNoException();
                parcel2.writeDouble(c);
                return true;
            default:
                return false;
        }
    }
}
