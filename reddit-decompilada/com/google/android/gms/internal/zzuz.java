package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzuz extends zzeu implements zzux {
    zzuz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public final zzva mo2168a(String str) throws RemoteException {
        zzva com_google_android_gms_internal_zzva;
        Parcel o_ = o_();
        o_.writeString(str);
        Parcel a = m5934a(1, o_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzva = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            com_google_android_gms_internal_zzva = queryLocalInterface instanceof zzva ? (zzva) queryLocalInterface : new zzvc(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzva;
    }

    public final boolean mo2169b(String str) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        Parcel a = m5934a(2, o_);
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }
}
