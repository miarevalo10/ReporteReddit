package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzcey extends zzev implements zzcex {
    public zzcey() {
        attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                i = parcel.readInt();
                parcel.createStringArray();
                mo3486a(i);
                return true;
            case 2:
                i = parcel.readInt();
                parcel.createStringArray();
                mo3487b(i);
                return true;
            case 3:
                i = parcel.readInt();
                zzew.m5937a(parcel, PendingIntent.CREATOR);
                mo3488c(i);
                return true;
            default:
                return false;
        }
    }
}
