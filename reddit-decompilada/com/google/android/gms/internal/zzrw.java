package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzrw extends zzeu implements zzrv {
    zzrw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final ParcelFileDescriptor mo2156a(zzrr com_google_android_gms_internal_zzrr) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzrr);
        Parcel a = m5934a(1, o_);
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzew.m5937a(a, ParcelFileDescriptor.CREATOR);
        a.recycle();
        return parcelFileDescriptor;
    }
}
