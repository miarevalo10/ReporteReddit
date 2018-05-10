package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzip extends zzeu implements zzio {
    zzip(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzii mo1957a(zzil com_google_android_gms_internal_zzil) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzil);
        Parcel a = m5934a(1, o_);
        zzii com_google_android_gms_internal_zzii = (zzii) zzew.m5937a(a, zzii.CREATOR);
        a.recycle();
        return com_google_android_gms_internal_zzii;
    }
}
