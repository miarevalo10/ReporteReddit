package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

final class zzaz implements zzay {
    private final IBinder f14001a;

    zzaz(IBinder iBinder) {
        this.f14001a = iBinder;
    }

    public final void mo1628a(zzaw com_google_android_gms_common_internal_zzaw, zzz com_google_android_gms_common_internal_zzz) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(com_google_android_gms_common_internal_zzaw.asBinder());
            obtain.writeInt(1);
            com_google_android_gms_common_internal_zzz.writeToParcel(obtain, 0);
            this.f14001a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f14001a;
    }
}
