package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzcbu extends zzeu implements zzcbt {
    zzcbu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzcbr mo1777a(zzcbp com_google_android_gms_internal_zzcbp) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcbp);
        Parcel a = m5934a(1, o_);
        zzcbr com_google_android_gms_internal_zzcbr = (zzcbr) zzew.m5937a(a, zzcbr.CREATOR);
        a.recycle();
        return com_google_android_gms_internal_zzcbr;
    }
}
