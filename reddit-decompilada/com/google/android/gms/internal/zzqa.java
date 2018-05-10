package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract class zzqa extends zzev implements zzpz {
    public zzqa() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public static zzpz m14172a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        return queryLocalInterface instanceof zzpz ? (zzpz) queryLocalInterface : new zzqb(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo2104a(zza.m13115a(parcel.readStrongBinder()));
                break;
            case 2:
                mo2103a();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
