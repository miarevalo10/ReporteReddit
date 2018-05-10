package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzrb extends zzeu implements zzqz {
    zzrb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public final void mo2154a(zzqm com_google_android_gms_internal_zzqm) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzqm);
        m5935b(1, o_);
    }
}
