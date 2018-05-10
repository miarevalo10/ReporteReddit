package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract class zzaen extends zzev implements zzaem {
    public zzaen() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzaem m13196a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        return queryLocalInterface instanceof zzaem ? (zzaem) queryLocalInterface : new zzaeo(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo1684a(zza.m13115a(parcel.readStrongBinder()));
                break;
            case 2:
                mo1685a(zza.m13115a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                mo1687b(zza.m13115a(parcel.readStrongBinder()));
                break;
            case 4:
                mo1689c(zza.m13115a(parcel.readStrongBinder()));
                break;
            case 5:
                mo1690d(zza.m13115a(parcel.readStrongBinder()));
                break;
            case 6:
                mo1691e(zza.m13115a(parcel.readStrongBinder()));
                break;
            case 7:
                mo1686a(zza.m13115a(parcel.readStrongBinder()), (zzaeq) zzew.m5937a(parcel, zzaeq.CREATOR));
                break;
            case 8:
                mo1692f(zza.m13115a(parcel.readStrongBinder()));
                break;
            case 9:
                mo1688b(zza.m13115a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                mo1693g(zza.m13115a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
