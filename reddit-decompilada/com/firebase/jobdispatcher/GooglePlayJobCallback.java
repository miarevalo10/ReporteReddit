package com.firebase.jobdispatcher;

import android.os.IBinder;
import android.os.Parcel;

final class GooglePlayJobCallback implements JobCallback {
    private final IBinder f12701a;

    public GooglePlayJobCallback(IBinder iBinder) {
        this.f12701a = iBinder;
    }

    public final void mo1243a(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.gcm.INetworkTaskCallback");
            obtain.writeInt(i);
            this.f12701a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            obtain.recycle();
            obtain2.recycle();
        } catch (int i2) {
            throw new RuntimeException(i2);
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
