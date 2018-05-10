package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzlp extends zzev implements zzlo {
    public zzlp() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo2050a();
                break;
            case 2:
                mo2052b();
                break;
            case 3:
                mo2053c();
                break;
            case 4:
                mo2054d();
                break;
            case 5:
                mo2051a(zzew.m5941a(parcel));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
