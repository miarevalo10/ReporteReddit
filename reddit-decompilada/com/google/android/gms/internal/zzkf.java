package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzkf extends zzev implements zzke {
    public zzkf() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        mo1961a();
        parcel2.writeNoException();
        return true;
    }
}
