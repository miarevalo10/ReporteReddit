package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

public abstract class zzcfc extends zzev implements zzcfb {
    public zzcfc() {
        attachInterface(this, "com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        mo3489a((LocationSettingsResult) zzew.m5937a(parcel, LocationSettingsResult.CREATOR));
        return true;
    }
}
