package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract class zzpv extends zzev implements zzpu {
    public zzpv() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzpu m14165a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return queryLocalInterface instanceof zzpu ? (zzpu) queryLocalInterface : new zzpw(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo2101a(parcel.readString(), zza.m13115a(parcel.readStrongBinder()));
                break;
            case 2:
                IInterface a = mo2097a(parcel.readString());
                parcel2.writeNoException();
                zzew.m5938a(parcel2, a);
                return true;
            case 3:
                mo2099a(zza.m13115a(parcel.readStrongBinder()));
                break;
            case 4:
                mo2098a();
                break;
            case 5:
                mo2100a(zza.m13115a(parcel.readStrongBinder()), parcel.readInt());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
