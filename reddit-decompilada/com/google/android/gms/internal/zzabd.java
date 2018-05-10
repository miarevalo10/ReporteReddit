package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzabd extends zzeu implements zzabb {
    zzabd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final zzaax mo1650a(zzaat com_google_android_gms_internal_zzaat) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzaat);
        Parcel a = m5934a(1, o_);
        zzaax com_google_android_gms_internal_zzaax = (zzaax) zzew.m5937a(a, zzaax.CREATOR);
        a.recycle();
        return com_google_android_gms_internal_zzaax;
    }

    public final void mo1651a(zzaat com_google_android_gms_internal_zzaat, zzabe com_google_android_gms_internal_zzabe) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzaat);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzabe);
        m5935b(2, o_);
    }

    public final void mo1652a(zzabm com_google_android_gms_internal_zzabm, zzabh com_google_android_gms_internal_zzabh) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzabm);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzabh);
        m5935b(4, o_);
    }
}
