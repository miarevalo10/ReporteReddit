package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzj extends zzeu implements zzi {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.iid.IMessengerCompat");
    }

    public final void mo1641a(Message message) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) message);
        m5936c(1, o_);
    }
}
