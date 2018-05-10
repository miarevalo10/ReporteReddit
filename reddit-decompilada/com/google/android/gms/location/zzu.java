package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzu extends zzeu implements zzs {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationListener");
    }

    public final void mo2299a(Location location) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) location);
        m5936c(1, o_);
    }
}
