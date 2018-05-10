package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzt extends zzev implements zzs {
    public zzt() {
        attachInterface(this, "com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 101:
                mo3399a((GoogleSignInAccount) zzew.m5937a(parcel, GoogleSignInAccount.CREATOR), (Status) zzew.m5937a(parcel, Status.CREATOR));
                break;
            case 102:
                mo3400a((Status) zzew.m5937a(parcel, Status.CREATOR));
                break;
            case 103:
                mo3401b((Status) zzew.m5937a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
