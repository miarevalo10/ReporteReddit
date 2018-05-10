package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public abstract class zzcxk extends zzev implements zzcxj {
    public zzcxk() {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        Creator creator;
        switch (i) {
            case 3:
                zzew.m5937a(parcel, ConnectionResult.CREATOR);
                creator = zzcxg.CREATOR;
                break;
            case 4:
            case 6:
                creator = Status.CREATOR;
                break;
            case 7:
                zzew.m5937a(parcel, Status.CREATOR);
                creator = GoogleSignInAccount.CREATOR;
                break;
            case 8:
                mo3496a((zzcxq) zzew.m5937a(parcel, zzcxq.CREATOR));
                break;
            default:
                return false;
        }
        zzew.m5937a(parcel, creator);
        parcel2.writeNoException();
        return true;
    }
}
