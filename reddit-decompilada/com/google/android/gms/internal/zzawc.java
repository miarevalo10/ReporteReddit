package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public abstract class zzawc extends zzev implements zzawb {
    public zzawc() {
        attachInterface(this, "com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo3481a((Status) zzew.m5937a(parcel, Status.CREATOR), (Credential) zzew.m5937a(parcel, Credential.CREATOR));
                break;
            case 2:
                mo3480a((Status) zzew.m5937a(parcel, Status.CREATOR));
                break;
            case 3:
                zzew.m5937a(parcel, Status.CREATOR);
                parcel.readString();
                mo3479a();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
