package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public abstract class zzawk extends zzev implements zzawj {
    public zzawk() {
        attachInterface(this, "com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo3484a((ProxyResponse) zzew.m5937a(parcel, ProxyResponse.CREATOR));
                break;
            case 2:
                parcel.readString();
                mo3483a();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
