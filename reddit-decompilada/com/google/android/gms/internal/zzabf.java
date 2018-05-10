package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzabf extends zzev implements zzabe {
    public zzabf() {
        attachInterface(this, "com.google.android.gms.ads.internal.request.IAdResponseListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        mo1653a((zzaax) zzew.m5937a(parcel, zzaax.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
