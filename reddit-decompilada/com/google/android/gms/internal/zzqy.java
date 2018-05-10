package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzqy extends zzeu implements zzqw {
    zzqy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void mo2153a(zzqm com_google_android_gms_internal_zzqm, String str) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzqm);
        o_.writeString(str);
        m5935b(1, o_);
    }
}
