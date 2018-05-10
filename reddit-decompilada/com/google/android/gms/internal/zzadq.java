package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzadq extends zzev implements zzadp {
    public zzadq() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public static zzadp m13185a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
        return queryLocalInterface instanceof zzadp ? (zzadp) queryLocalInterface : new zzadr(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo1674a();
                break;
            case 2:
                mo1677b();
                break;
            case 3:
                mo1678c();
                break;
            case 4:
                mo1679d();
                break;
            case 5:
                zzadh com_google_android_gms_internal_zzadh;
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    com_google_android_gms_internal_zzadh = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardItem");
                    com_google_android_gms_internal_zzadh = queryLocalInterface instanceof zzadh ? (zzadh) queryLocalInterface : new zzadj(readStrongBinder);
                }
                mo1676a(com_google_android_gms_internal_zzadh);
                break;
            case 6:
                mo1680e();
                break;
            case 7:
                mo1675a(parcel.readInt());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
