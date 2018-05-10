package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzr extends zzeu implements zzp {
    zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    public final void mo2297a(LocationAvailability locationAvailability) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) locationAvailability);
        m5936c(2, o_);
    }

    public final void mo2298a(LocationResult locationResult) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) locationResult);
        m5936c(1, o_);
    }
}
