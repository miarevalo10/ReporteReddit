package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzki extends zzev implements zzkh {
    public zzki() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo1962a();
                break;
            case 2:
                mo1963a(parcel.readInt());
                break;
            case 3:
                mo1964b();
                break;
            case 4:
                mo1965c();
                break;
            case 5:
                mo1966d();
                break;
            case 6:
                mo1967e();
                break;
            case 7:
                mo1968f();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
