package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract class zzpn extends zzev implements zzpm {
    public zzpn() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzpm m14155a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        return queryLocalInterface instanceof zzpm ? (zzpm) queryLocalInterface : new zzpo(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 2:
                String a = mo2089a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 3:
                List b = mo2090b();
                parcel2.writeNoException();
                parcel2.writeList(b);
                return true;
            default:
                return false;
        }
    }
}
