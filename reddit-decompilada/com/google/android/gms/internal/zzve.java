package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzve extends zzev implements zzvd {
    public zzve() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo2196a();
                break;
            case 2:
                mo2201b();
                break;
            case 3:
                mo2197a(parcel.readInt());
                break;
            case 4:
                mo2202c();
                break;
            case 5:
                mo2203d();
                break;
            case 6:
                mo2204e();
                break;
            case 7:
                zzvg com_google_android_gms_internal_zzvg;
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    com_google_android_gms_internal_zzvg = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    com_google_android_gms_internal_zzvg = queryLocalInterface instanceof zzvg ? (zzvg) queryLocalInterface : new zzvi(readStrongBinder);
                }
                mo2199a(com_google_android_gms_internal_zzvg);
                break;
            case 8:
                mo2205f();
                break;
            case 9:
                mo2200a(parcel.readString(), parcel.readString());
                break;
            case 10:
                mo2198a(zzqn.m14209a(parcel.readStrongBinder()), parcel.readString());
                break;
            case 11:
                mo2206g();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
